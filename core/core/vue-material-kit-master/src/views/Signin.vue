<template>
  <div class="wrapper">
    <div class="section page-header header-filter" :style="headerStyle">
      <div class="container">
        <div class="md-layout">
          <div
            class="md-layout-item md-size-33 md-small-size-66 md-xsmall-size-100 md-medium-size-40 mx-auto"
          >
            <login-card header-color="green">
              <h4 slot="title" class="card-title">Sign-in</h4>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>face</md-icon>
                  <label>ID...</label>
                  <md-input v-model="username"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>email</md-icon>
                  <label>Email...</label>
                  <md-input v-model="email" type="email"></md-input>
                  <md-button v-on:click="loginaa" class="md-form-group md-dense">CHECK</md-button>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>lock_outline</md-icon>
                  <label>Password...</label>
                  <md-input v-model="password" type="password"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>lock_outline</md-icon>
                  <label>Password Again...</label>
                  <md-input v-model="password_Again" type="password"></md-input>
                </md-field>
                <md-button slot="footer" v-on:click="checkPassword" class="md-simple md-success md-lg">
                  Sign in
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
import axios from 'axios'
import {isEmail, isPassword} from "../plugins/check"

//let baseUrl='http://127.0.0.1:8080/auth/login'
export default {
  components: {
    LoginCard
  },
  bodyClass: "signin-page",
  data() {
    return {
      username: null,
      email: null,
      password: null,
      password_Again: null
    };
  },
  props: {
    header: {
      type: String,
      default: require("@/assets/img/profile_city.jpg")
    }
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`
      };
    }
  },
  methods: {
    loginaa(){
      if(!isEmail(this.email)){
        alert("�̸��� �������� �Է����ּ���");
      }
      else{

      }
    },
    checkPassword(){
          const formdata={
            "username": this.username,
            "email": this.email,
            "password": this.password,
          }
          if(this.password != this.password_Again){
            alert("��й��? ����ġ")
          }
          else{
            axios.post('/auth/join', formdata)
              .then(response => {
                console.log(response);
                this.$router.push('/').catch(()=>{});
                
              })
          .catch(response => { console.log(response) })
          }
        }
      }
};
</script>

<style lang="css"></style>
