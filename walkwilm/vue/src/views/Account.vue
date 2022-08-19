<template>
  <div class="account">
    <div class="badge-list">
      <div id="locations">
        <check-in-loc-list />
      </div>

      <div id="badges">
        <img
          class="badge badge-unearned"
          v-show="!redBadgeEarned && !noArtCheckInsRemaining"
          id="red"
          src="@/assets/badges/redbadgeunearned.png"
        />
        <img
          class="badge badge-earned"
          v-show="redBadgeEarned || noArtCheckInsRemaining"
          id="red"
          src="@/assets/badges/redbadge.png"
        />
        <img
          class="badge badge-unearned"
          v-show="!orangeBadgeEarned && !noFoodCheckInsRemaining"
          id="orange"
          src="@/assets/badges/orangebadgeunearned.png"
        />
        <img
          class="badge badge-earned"
          v-show="orangeBadgeEarned || noFoodCheckInsRemaining"
          id="orange"
          src="@/assets/badges/orangebadge.png"
        />
        <img
          class="badge badge-unearned"
          v-show="!yellowBadgeEarned && !noEntCheckInsRemaining"
          id="yellow"
          src="@/assets/badges/yellowbadgeunearned.png"
        />
        <img
          class="badge badge-earned"
          v-show="yellowBadgeEarned || noEntCheckInsRemaining"
          id="yellow"
          src="@/assets/badges/yellowbadge.png"
        />
        <img
          class="badge badge-unearned"
          v-show="!greenBadgeEarned && !noOutdoorCheckInsRemaining"
          id="green"
          src="@/assets/badges/greenbadgeunearned.png"
        />
        <img
          class="badge badge-earned"
          v-show="greenBadgeEarned || noOutdoorCheckInsRemaining"
          id="green"
          src="@/assets/badges/greenbadge.png"
        />
        <img
          class="badge badge-unearned"
          v-show="!blueBadgeEarned && !noEducationCheckInsRemaining"
          id="blue"
          src="@/assets/badges/bluebadgeunearned.png"
        />
        <img
          class="badge badge-earned"
          v-show="blueBadgeEarned || noEducationCheckInsRemaining"
          id="blue"
          src="@/assets/badges/bluebadge.png"
        />
        <!-- <img class="badge badge-earned" v-if=" ! purpleBadgeEarned" id="purple" src="@/assets/badges/purplebadgeunearned.png" />
        <img class="badge badge-earned" v-if=" purpleBadgeEarned" id="purple" src="@/assets/badges/purplebadge.png" /> -->
      </div>

      <div class="defender-of-land" id="defender-of-land">
        <!-- <img
          class="badge-badge-earned"
          v-show="!purpleBadgeEarned && !noArtCheckInsRemaining && !noFoodCheckInsRemaining && !noEntCheckInsRemaining && !noOutdoorCheckInsRemaining && !noEducationCheckInsRemaining"
          id="purple"
          src="@/assets/badges/purplebadgeunearned.png" -->
        <!-- /> -->
        <img
          class="badge-badge-earned"
          v-show="purpleBadgeEarned || (noArtCheckInsRemaining && noFoodCheckInsRemaining && noEntCheckInsRemaining && noOutdoorCheckInsRemaining && noEducationCheckInsRemaining)"
          id="purple"
          src="@/assets/badges/purplebadge.png"
        />
      </div>
    </div>
  </div>
</template>

<script>
import CheckInLocList from "@/components/CheckInLocList";
import AccountService from "@/services/AccountService";

export default {
  name: "account",
  data() {
    return {
      locs: [],
      checkins: [],
      redBadgeEarned: false, //not connected to DB yet//
      orangeBadgeEarned: false, //not connected to DB yet//
      yellowBadgeEarned: false, //not connected to DB yet//
      greenBadgeEarned: false, //not connected to DB yet//
      blueBadgeEarned: false, //not connected to DB yet//
      purpleBadgeEarned: false, //not connected to DB yet//
      
    }
    
  },
  computed:{
     noArtCheckInsRemaining(){
        const checkInsleft =
        this.$store.state.userLocations.filter( location => {
            return location.categoryId == 1 && location.checkedIn == false;
        });
        return checkInsleft.length == 0;
      },

  noFoodCheckInsRemaining(){
        const checkInsleft =
        this.$store.state.userLocations.filter( location => {
            return location.categoryId == 2 && location.checkedIn == false;
        });
        return checkInsleft.length == 0;
      },
    
    noEntCheckInsRemaining(){
        const checkInsleft =
        this.$store.state.userLocations.filter( location => {
            return location.categoryId == 3 && location.checkedIn == false;
        });
        return checkInsleft.length == 0;
      },

    noOutdoorCheckInsRemaining(){
        const checkInsleft =
        this.$store.state.userLocations.filter( location => {
            return location.categoryId == 4 && location.checkedIn == false;
        });
        return checkInsleft.length == 0;
      },

      noEducationCheckInsRemaining(){
        const checkInsleft =
        this.$store.state.userLocations.filter( location => {
            return location.categoryId == 5 && location.checkedIn == false;
        });
        return checkInsleft.length == 0;
      },
  },
  components: {
    CheckInLocList,
  },
  created() {
    AccountService.getBadges(this.$store.state.user.id)
    .then((response) => {
      if(response.status == 200){
        this.$store.state.userBadges = [];
        this.$store.commit("ADD_USER_BADGES", response.data);
      
      this.$store.state.userBadges.filter( badge => {
        if(badge.badgeId == 1){
         this.redBadgeEarned = true;
        }
        if(badge.badgeId == 2){
         this.orangeBadgeEarned = true;
        }
         if(badge.badgeId == 3){
         this.yellowBadgeEarned = true;
        }
         if(badge.badgeId == 4){
         this.greenBadgeEarned = true;
        }
         if(badge.badgeId == 5){
         this.blueBadgeEarned = true;
        }
         if(badge.badgeId == 6){
         this.purpleBadgeEarned = true;
        }
      })
      }
    })
  }
}
</script>

<style scoped >
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");

* {
  font-family: Raleway;
}
.account {
  background-image: linear-gradient(
    to bottom right,
    #9ad8e7,
    rgb(226, 120, 240)
  );
}

.badge {
  flex-flow: row;
  height: 218px;
  width: auto;
  margin-top: 26px;
}

.badge-list {
  display: grid;
  grid-template-columns: 1.5fr 3fr 1.5fr;

  grid-template-areas: "badge location defender";
}

#locations {
  grid-area: location;
  margin-top: 30px;
  margin-left: 10px;
  font-weight: bold;
  font-size: 22px;
}

#badges {
  grid-area: badge;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.badge-badge-earned {
  grid-area: defender;
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-right: 60px;
  margin-top: 420px;
  padding-right: 100px;
}
#purple {
  height: 45%;
  width: auto;
}
</style>