<template>
  <div class="about">

    <div class="header"></div>

    <div class="badge-list">
      <p id="header">Earn these badges by visiting these places</p>

      <div id="locations">
        <location-list />
      </div>

      <div id="badges">
        <img class="badge" id="red" src="@/assets/badges/redbadge.png" />
        <img class="badge" id="orange" src="@/assets/badges/orangebadge.png" />
        <img class="badge" id="yellow" src="@/assets/badges/yellowbadge.png" />
        <img class="badge" id="green" src="@/assets/badges/greenbadge.png" />
        <img class="badge" id="blue" src="@/assets/badges/bluebadge.png" />
      </div>

      <div class="purple">
        <img class="badge" id="purple" src="@/assets/badges/purplebadge.png" />
      </div>

      <div>
        <p id="defender">The Defender of the Land</p>
      </div>

    </div>

    <walk-wilm-map />

  </div>

</template>


<script>
import WalkWilmMap from "@/components/WalkWilmMap";

import LocationList from "@/components/LocationList";

export default {
  name: "about",
  components: {
    WalkWilmMap,
    LocationList,
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");

* {
  font-family: Raleway;
}

.about {
  background-image: linear-gradient(
    to bottom right,
    #9ad8e7,
    rgb(226, 120, 240)
  );
}

.badge {
  /* flex-flow: row; */
  height: 180px;
  width: auto;
  margin-top: 20px;
}

.badge-list {
  display: grid;
  grid-template-columns: 2fr 4fr;

  grid-template-areas:
    "header header"
    "badge location"
    "purple1 defender";
}

#header {
  grid-area: header;
  justify-content: center;
  font-size: 30px;
  font-weight: bold;
  margin-left: 80px;
}
#purple {
  grid-area: purple1;
  height: 200px;
  width: auto;
  margin-bottom: 20px;
}
.purple {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

#defender {
  grid-area: defender;
  /* margin-left: 10px; */
  font-weight: bold;
  font-size: 25px;
  margin-top: 100px;
}

#locations {
  grid-area: location;
  margin-top: 60px;
  margin-left: 0px;
  font-weight: bold;
  font-size: 22px;
}

#badges {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
