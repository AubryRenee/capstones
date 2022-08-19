<template>

  <div class="home">
    <!-- <img class="logo" src="@/assets/Logo.png" /> -->

    <div class="introduction">

      <!-- <img class="logo" src="@/assets/Logo.png" /> -->

      <section class="badges">
        
        <img class="badge" id="purple" src="@/assets/badges/purplebadge.png">
      </section>

      <section class="welcome">
        <p>Welcome to Explore Wilmington, your sightseeing companion.</p>
        <p>Explore Wilmington is a fun, interactive way to see all the great things there are to see in Wilmington, earning badges along the way.</p>
        <p>Visit all the places in each category to earn a category badge. Collect badges from every category to earn the Defender of the Land badge!</p>
      </section>

      <section class="links">
        
        <router-link id="about" v-bind:to="{ name: 'about' }">
            <button class="button" role="button">About</button>
        </router-link>

        <router-link id="account" v-bind:to="{ name: 'account' }">
          <button class="button" role="button">View Account</button>
        </router-link>
        
        <router-link id="login" v-bind:to="{ name: 'login' }"
         v-if="$store.state.token == ''">
          <button class="button" role="button">Login</button>
        </router-link>

        <!-- <router-link v-bind:to="{ name: 'account', params: { id: user.id } }">View Account</router-link> -->
        

        <!-- <router-link id="logout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">
            Logout
        </router-link> -->
      </section>

    </div>
    
    <walk-wilm-map class="map" />

  </div>
</template>


<script>
import WalkWilmMap from '@/components/WalkWilmMap'

export default {
  name: "home",
  components: {
    WalkWilmMap    
  }
};
</script>


<style>
  @import url('https://fonts.googleapis.com/css2?family=Raleway&display=swap');

  *{
    font-family: Raleway;
  }

  .home {
    background-image: linear-gradient(to bottom right, #9ad8e7, rgb(226, 120, 240));
    bottom: 50%;
    
  }
  .container {
    grid-area: header;
  }
  
  .map {
    grid-area: map;
  }

  .introduction {
    
    text-align: center;
    grid-area: intro;
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 10px;
    grid-template-areas:
      "welcome welcome badges"
      "links links links"
  }
  
  .badges {
    grid-area: badges;
    /* height: 200px;
    width: auto; */
    margin-top: 10%;
  }

  #purple {
    size: 20px;
    /* height: 200px;
    width: auto; */
    
  }

  .welcome {
    grid-area: welcome;
    margin-top: 50px;
    text-decoration: darkblue;
    font-weight: bold;
    font-size: 20px;
  }

  .links {
    grid-area: links;
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    grid-template-areas: 
      "about account login ";
      align-items: center;
  }

/* .links: #login, #about, #account, #logout */
  #login {
    grid-area: login;
  }
  #about {
    grid-area: about;
  }
  #account {
    grid-area: account;
  }
  /* #logout {
    grid-area: logout;
  } */
  
  

.button {
  align-items: center;
  background-image: linear-gradient(144deg,#AF40FF, #5B42F3 50%,#00DDEB);
  border: 0;
  border-radius: 8px;
  box-shadow: rgba(151, 65, 252, 0.2) 0 15px 30px -5px;
  box-sizing: border-box;
  color: #FFFFFF;
  font-family: Phantomsans, sans-serif;
  font-size: 20px;
  justify-content: space-between;
  line-height: .1em;
  max-width: 100%;
  min-width: 140px;
  padding: 19px 24px;
  text-decoration: none;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  white-space: nowrap;
  cursor: pointer;
  margin-bottom: 30px;
}

.button:active,
.button:hover {
  outline: 0;
}

@media (min-width: 768px) {
  .button {
    font-size: 15px;
    min-width: 90px;
  }
}


</style>