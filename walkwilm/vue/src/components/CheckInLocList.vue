<template>
    <div>

        <div class="catBox">
        
            <div class="byCat" v-for="(item) in artCat" :key="item.locationId" >{{ item.locationName }}&nbsp;<button class="red" v-show="!item.checkedIn" v-on:click="checkIn.locationId=item.locationId, changeCheckedIn(item)">Check In</button>
            <div class="space" v-show="item.checkedIn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></div>
            
            <br>

            <div class="byCat" v-for="(item) in foodCat" :key="item.locationId">{{ item.locationName }}&nbsp;<button class="orange" v-show="!item.checkedIn" v-on:click="checkIn.locationId=item.locationId, changeCheckedIn(item)">Check In</button></div>

            <br>

            <div class="byCat" v-for="(item) in entCat" :key="item.locationId">{{ item.locationName }}&nbsp;<button class="yellow" v-show="!item.checkedIn" v-on:click="checkIn.locationId=item.locationId, changeCheckedIn(item)">Check In</button></div>

            <br>

            <div class="byCat" v-for="(item) in outCat" :key="item.locationId">{{ item.locationName }}&nbsp;<button class="green" v-show="!item.checkedIn" v-on:click="checkIn.locationId=item.locationId, changeCheckedIn(item)">Check In</button>
            <div class="green" v-show="item.checkedIn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></div>

            <br>

            <div class="byCat" v-for="(item) in edCat" :key="item.locationId">{{ item.locationName }}&nbsp;<button class="blue" v-show="!item.checkedIn" v-on:click="checkIn.locationId=item.locationId, changeCheckedIn(item)">Check In</button></div>
        </div>

    </div>

</template>

<script>
// import locService from "../services/LocService";
import accountService from "@/services/AccountService";

export default {
    name: "check-in-loc-list",
    data() {
        return {
          checkIn: {
            userId: this.$store.state.user.id,
            locationId: null,
          }
        };
    },
   created() {
     accountService.getLocationsWithCheckins(this.$store.state.user.id)
              .then((response) => {
                if (response.status == 200) {
                  this.$store.state.userLocations = [];
                  this.$store.commit("ADD_USER_LOCATIONS", response.data);
                }
              })

    },

  methods: {
    changeCheckedIn(item){
     accountService.createCheckIn(this.$store.state.user.id, this.checkIn)
     .then((response) =>{
       if (response.status == 200){
         this.$store.commit('ADD_CHECK_IN', item);
       }
     });
    }

  },
  
  
  computed: {
      artCat() {
        return this.$store.state.userLocations.filter( location => {
            return location.categoryId == 1;
        });
      },  
      foodCat() {
        return this.$store.state.userLocations.filter( location => {
            return location.categoryId == 2;
        });
      },
      entCat() {
        return this.$store.state.userLocations.filter( location => {
            return location.categoryId == 3;
        });
      },
      outCat() {
        return this.$store.state.userLocations.filter( location => {
            return location.categoryId == 4;
        });
      },
      edCat() {
        return this.$store.state.userLocations.filter( location => {
            return location.categoryId == 5;
        });
      }        
  }

}
</script>

<style>
.red {
  display: flex;
  align-items: center;
  font-family: inherit;
  font-weight: 500;
  font-size: 12px;
  padding: 0.7em 1.4em 0.7em 1.1em;
  color: white;
  background: #ad5389;
  background: linear-gradient(0deg, rgb(167, 20, 20) 0%, rgb(247, 102, 102) 100%);
  border: none;
  box-shadow: 0 0.7em 1.5em -0.5em #a7141498;
  letter-spacing: 0.05em;
  border-radius: 20em;
  cursor: pointer;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  width: 84px;
  height: 15px;
}

.orange {
  display: flex;
  align-items: center;
  font-family: inherit;
  font-weight: 500;
  font-size: 12px;
  padding: 0.7em 1.4em 0.7em 1.1em;
  color: white;
  background: #ad5389;
  background: linear-gradient(0deg, rgb(167, 74, 20) 0%, rgb(247, 155, 102) 100%);
  border: none;
  box-shadow: 0 0.7em 1.5em -0.5em #a74f1498;
  letter-spacing: 0.05em;
  border-radius: 20em;
  cursor: pointer;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  width: 84px;
  height: 15px;
}

.yellow {
  display: flex;
  align-items: center;
  font-family: inherit;
  font-weight: 500;
  font-size: 12px;
  padding: 0.7em 1.4em 0.7em 1.1em;
  color: white;
  background: #ad5389;
  background: linear-gradient(0deg, rgb(165, 167, 20) 0%, rgb(245, 247, 102) 100%);
  border: none;
  box-shadow: 0 0.7em 1.5em -0.5em #a7a51498;
  letter-spacing: 0.05em;
  border-radius: 20em;
  cursor: pointer;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  width: 84px;
  height: 15px;
}

.green {
  display: flex;
  align-items: center;
  font-family: inherit;
  font-weight: 500;
  font-size: 12px;
  padding: 0.7em 1.4em 0.7em 1.1em;
  color: white;
  background: #ad5389;
  background: linear-gradient(0deg, rgba(20,167,62,1) 0%, rgba(102,247,113,1) 100%);
  border: none;
  box-shadow: 0 0.7em 1.5em -0.5em #14a73e98;
  letter-spacing: 0.05em;
  border-radius: 20em;
  cursor: pointer;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  width: 84px;
  height: 15px;
}

.blue {
  display: flex;
  align-items: center;
  font-family: inherit;
  font-weight: 500;
  font-size: 12px;
  padding: 0.7em 1.4em 0.7em 1.1em;
  color: white;
  background: #ad5389;
  background: linear-gradient(0deg, rgb(20, 35, 167) 0%, rgb(102, 148, 247) 100%);
  border: none;
  box-shadow: 0 0.7em 1.5em -0.5em #1443a798;
  letter-spacing: 0.05em;
  border-radius: 20em;
  cursor: pointer;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  width: 84px;
  height: 15px;
}

/* .green:hover {
  box-shadow: 0 0.5em 1.5em -0.5em #14a73e98;
}

.green:active {
  box-shadow: 0 0.3em 1em -0.5em #14a73e98;
} */


/* catbox {
    display:flex;
    
}
.catbox>* {
    display: flex-row; */
/* } */
/* .byCat {
    
} */
</style>