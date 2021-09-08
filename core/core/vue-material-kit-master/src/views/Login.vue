<template>
  <div class="wrapper">
    <div class="section page-header header-filter" :style="headerStyle">
      <div class="container">
        <div class="md-layout">
          <div
            class="md-layout-item md-size-33 md-small-size-66 md-xsmall-size-100 md-medium-size-40 mx-auto"
          >
            <login-card header-color="green">
                <h4 slot="title" class="card-title">Login</h4>
                <md-button
                  slot="buttons"
                  href="javascript:void(0)"
                  class="md-just-icon md-simple md-white"
                >
                  <i class="fab fa-facebook-square"></i>
                </md-button>
                <md-button
                  slot="buttons"
                  href="javascript:void(0)"
                  class="md-just-icon md-simple md-white"
                >
                  <img
                  :src="kakao"
                  alt="Rounded Image"
                  class="img-raised rounded img-fluid"
                />
                </md-button>
                <md-button
                  slot="buttons"
                  href="javascript:void(0)"
                  class="md-just-icon md-simple md-white"
                >
                  <i class="fab fa-google-plus-g"></i>
                </md-button>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>email</md-icon>
                  <label>Email...</label>
                  <md-input v-model="username" type="email"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>lock_outline</md-icon>
                  <label>Password...</label>
                  <md-input v-model="password" type="password"></md-input>
                </md-field>
                <md-button v-on:click="loginUser" slot="footer" class="md-simple md-success md-lg">
                  Login
                </md-button>
              </login-card>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { LoginCard } from "@/components";
import * as types from '../store/mutation-types'
import store from "../store"
import axios from 'axios'

export default {
  components: {
    LoginCard
  },
  bodyClass: "login-page",
  data() {
    return {
      username: null,
      password: null
    };
  },
  props: {
    header: {
      type: String,
      default: require("@/assets/img/profile_city.jpg")
    },
    kakao: {
      type: String,
      default: require("@/assets/img/kakao_icon.jpg")
    }
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`
      };
    }
  },
  methods:{
    loginUser(){
          const formdata={
            "username": this.username,
            "password": this.password
          }
          
          axios.post('/auth/login', formdata)
            .then(response => {
                if (response.status === 200) {
                  store.dispatch(types.LOGIN, {
                    username: this.username,
                    password: this.password
                  });
                  store.commit(types.LOGIN_SUCCESS, {
                    token: response.data.accessToken,
                    username: this.username,
                  });
                  console.log(response.data)
                  this.$router.push('/').catch(()=>{});
                  location.reload();
                } else if (response.status === 401) {
                  this.log = 401
                  response.json().then(json => {
                    this.error = json
                  })
                  store.commit(types.LOGIN_WRONG_CREDENTIALS)
                  this.$router.push('/')
                } else {
                  this.log = 'else: ' + response.status
                  response.json().then(json => {
                    this.error = json
                  })
                  this.$router.push('/')
                  store.commit(types.LOGIN_ERROR)
                }
              })
            .catch(error =>this.error = 'Unable to connect server.')
        }
      }
};
</script>

<style lang="css"></style>
