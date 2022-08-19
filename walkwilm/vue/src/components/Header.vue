<template>
  <div class="header">
    <header>
      <router-link v-bind:to="{ name: 'home' }">Home </router-link>&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'login' }"
        v-if="$store.state.token === ''"
        >Login</router-link
      >
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      <div class="container">
        <img
          class="banner-img"
          id="panorama"
          src="@/assets/skyline-panorama-2.png"
          alt="Panorama of Wilmington skyline"
        />

        <section>
          <img
            class="logo"
            id="explorers"
            src="@/assets/Logo.png"
            alt="Explore's Logo"
          />
          <img
            class="banner-text"
            id="title"
            src="@/assets/title.png"
            alt="banner"
          />
        </section>
      </div>
    </header>
  </div>
</template>

<script>
export default {
  name: "header",
};
</script>

<style >
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");

* {
  font-family: Raleway;
}
#explorers {
  width: 10vw;
  height: auto;
}

#title {
  width: 40%;
  height: auto;
}

.header {
  background-image: linear-gradient(
    to bottom right,
    #9ad8e7,
    rgb(226, 120, 240)
  );
}

.container {
  position: relative;
  text-align: center;
  color: white;
  display: flex;
  justify-content: center;
}

.banner-text {
  position: absolute;
  top: 22%;
  left: 50%;
  transform: translate(-50%, -50%);
  /* font-size: 64px; */
}

.banner-img {
  opacity: 0.9;
  width: 100%;
  height: 100%;
}

.logo {
  box-sizing: border-box;
  top: 4%;
  left: 1%;
  position: absolute;
  width: 150px;
  height: 150px;
}
</style>