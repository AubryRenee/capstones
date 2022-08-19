<template>
  <div class="container">
    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">


        <div class="flex-container">
        <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>
        <label for="username" class="sr-only">Username</label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <label for="password" class="sr-only">Password</label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <router-link :to="{ name: 'register' }">Need an account?</router-link>
        <button class="sign-in" type="submit">Sign in</button>
        </div>


      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
<style>
.form-control {
  border: thin solid blueviolet;
  border-radius: 4px;
}
.flex-container {
  display: flex;
  flex-direction: column;
  height: 300px;
  width: 275px;
  align-items: center;
  background: linear-gradient(to bottom right, #9ad8e7, rgb(226, 120, 240));
  color: blue;
  border: thick solid blueviolet;
  border-radius: 5%;
  justify-content: space-between;
  padding: 10px;
  top: 10%;
  bottom: 10px;
  margin: 100px;
}

.container {
  background-image: linear-gradient(
    to bottom right,
    #9ad8e7,
    rgb(226, 120, 240)
  );
  display: flex;
  justify-content: center;
  align-content: center;
  
  /* align-items: center; */
  /* top:50% */
  /* margin: 20px; */
}

.sign-in {
  margin-top: 15px;
  margin-bottom: 15px;
  padding: 0.6em 2em;
  border: none;
  outline: none;
  color: rgb(255, 255, 255);
  background: #111;
  cursor: pointer;
  position: relative;
  z-index: 0;
  border-radius: 10px;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.sign-in:before {
  content: "";
  background: linear-gradient(
    45deg,
    #ff0000,
    #ff7300,
    #fffb00,
    #48ff00,
    #00ffd5,
    #002bff,
    #7a00ff,
    #ff00c8,
    #ff0000
  );
  position: absolute;
  top: -2px;
  left: -2px;
  background-size: 400%;
  z-index: -1;
  filter: blur(5px);
  -webkit-filter: blur(5px);
  width: calc(100% + 4px);
  height: calc(100% + 4px);
  animation: glowing-button-85 30s linear infinite;
  transition: opacity 0.5s ease-in-out;
  border-radius: 10px;
}

@keyframes glowing-button-85 {
  0% {
    background-position: 0 0;
  }
  50% {
    background-position: 400% 0;
  }
  100% {
    background-position: 0 0;
  }
}

.sign-in:after {
  z-index: -1;
  content: "";
  position: absolute;
  width: 100%;
  height: 100%;
  background:  linear-gradient(144deg,#AF40FF, #5B42F3 50%,#00DDEB);
  left: 0;
  top: 0;
  border-radius: 10px;
}


</style>