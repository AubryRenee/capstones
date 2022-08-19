<template>
    <div>

        <div class="catBox">
            <div class="byCat" v-for="(item, index) in artCat" :key="index">{{ item.locationName }}</div> 

            <br>

            <br>

           

            <div class="byCat" v-for="(item, index) in foodCat" :key="index">{{ item.locationName }}</div>

            <br>

            <br>

            <br>

            <div class="byCat" v-for="(item, index) in entCat" :key="index">{{ item.locationName }}</div>

            <br>

            <br>

            <br>

            <div class="byCat" v-for="(item, index) in outCat" :key="index">{{ item.locationName }}</div>

            <br>

            <br>

            

            <div class="byCat" v-for="(item, index) in edCat" :key="index">{{ item.locationName }}</div>
        </div>

    </div>

</template>

<script>
import locService from "../services/LocService";

export default {
    name: "location-list",
    data() {
        return {
            locs: []
        };
    },
   created() {
    locService.listLocations().then((response) => {
      this.locs = response.data;
    });
  },
  computed: {
      artCat() {
        return this.locs.filter( location => {
            return location.categoryId == 1;
        });
      },  
      foodCat() {
        return this.locs.filter( location => {
            return location.categoryId == 2;
        });
      },
      entCat() {
        return this.locs.filter( location => {
            return location.categoryId == 3;
        });
      },
      outCat() {
        return this.locs.filter( location => {
            return location.categoryId == 4;
        });
      },
      edCat() {
        return this.locs.filter( location => {
            return location.categoryId == 5;
        });
      }        
  }

}
</script>

<style>

/* catbox {
    display:flex;
    
}
.catbox>* {
    display: flex-row; */
/* } */
/* .byCat {
    
} */
</style>

/*
  <!-- <table>
      <thead>
          <tr>
              <th>&nbsp;</th>
              <th>Location Name</th>
              <th>Category</th>
          </tr>
      </thead>
      <tbody>

          <tr v-for="loc in locs" :key="loc.locationId">
              <td>
                  {{ loc.locationName }}
    
              </td>
              <td>
                  {{ loc.categoryId }}
    
              </td>

          </tr>

      </tbody>
  </table> -->
*/