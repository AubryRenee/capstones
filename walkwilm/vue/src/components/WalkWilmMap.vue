<template>
  <div>

    <!-- <div>
      <h3>Search for a Location:</h3>
      <GmapAutocomplete
        @place_changed='setPlace'
      />
    </div> -->

    <iframe src="https://www.google.com/maps/d/embed?mid=1WZOy1JeYD0MvGSfuoagEFPNjR5DGQi8&ehbc=2E312F" width=100% height="480"></iframe>


    <!-- <h2>The new map is up above</h2>

    <br>

    <GmapMap id='map'
      :center = 'center'
      :zoom = '12'
      style='width:100%; height: 400px;'
    >
      <GmapMarker
        :key="index"
        v-for="(marker, index) in markers"
        :position="marker.position"
        :icon="getIcon(marker.category)"
        :icon-size="[40, 40]"
        
        @click="center=marker.position"
      />
    </GmapMap> -->


  </div>
</template>

<script>
export default {
    name: 'WalkWilmMap',

   computed: {
     
     redMarker(){
       return require('@/assets/red-pin.png');

     }
   }
,

    data() {
        return {
            center: { lat: 39.74411, lng: -75.54803},
            currentPlace: null,
            markers: [],
            places: [],
        }
    },
    mounted() {
      this.geolocate();
      this.setMarkers();
  },
    // created(){
    //   this.setMarkers();
  // },
  methods: {

    getIcon(category){
      if(category == 'food'){
       return require('@/assets/blue-pin.png')
      } else {
        return require('@/assets/red-pin.png')
      }

    },

    setPlace(place) {
      this.currentPlace = place;
    },
    setMarkers(){
      const ourMarkers = {
        lat: 39.73387158667072,
        lng: -75.56038416146238
      };
      const data ={
        marker:    
        {lat: 39.73387158667072,
        lng: -75.56038416146238
      },
        category: 'food'
      }
      
      this.markers.push({position: ourMarkers, category: data.category});


    },
    addMarker() {
      if (this.currentPlace) {
        const marker = {
          lat: this.currentPlace.geometry.location.lat(),
          lng: this.currentPlace.geometry.location.lng(),
        };
        this.markers.push({ position: marker });

        this.markers.push({ position: {
        lat: -39.73387158667072,
        lng: -75.56038416146238
      } })

        this.places.push(this.currentPlace);
        this.center = marker;
        this.currentPlace = null;
      }
    },
    
    geolocate: function() {
      navigator.geolocation.getCurrentPosition(position => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });
    },
  }, 
};
</script>


<style>
    div {
        box-sizing: border-box;
        font-size: 100%;
    }

</style>