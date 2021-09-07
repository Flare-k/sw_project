<template>
  <div class="wrapper">
    <parallax class="page-header header-filter" :style="headerStyle">
      <div class="md-layout">
        <div class="md-layout-item">
          <div class="image-wrapper">
            <div class="brand">
              <h1>Video Danawa</h1>
            </div>
          </div>
        </div>
      </div>
    </parallax>
    <div class="main main-raised">
      <div class="section">
        <div class="container text-center">
        </div>
      </div>
      <div class="md-layout">
          <md-field class="has-green">
            <label>검색</label>
                <md-input v-model="search_input" md-size-100></md-input>
                <div class="md-layout-item text-center">
                    <md-button href="#/Search" class="md-primary" @click="submitForm()" md-alignment="left">Search</md-button>
                </div>
          </md-field>
      </div>

      <div class="md-layout">
        <div class="md-layout-item md-size-100">
          <nav-tabs-card no-label>
            <template slot="content">
              <md-tabs md-sync-route class="md-primary" md-alignment="left">
                <md-tab id="tab-home" md-label="Youtube" md-icon="tv">
                </md-tab>
              </md-tabs>
            </template>
          </nav-tabs-card>
        </div>
      </div>

      <div class="section section-youtube-video">
        <div class="container-fluid text-center">
          <div class="md-layout">

            <tr v-for="(item, index) in TubeUrl" :key="TubeUrl[index].id" >
              <div class="md-layout-item">
                <a href="#/profile" target="_blank">
                  <img
                    :src="item.thumbnails"
                    alt="Rounded Image"
                    class="img-raised rounded img-fluid"
                  />
                  <md-button href="#/profile" class="md-simple md-success md-lg">{{ item.title }}</md-button>
                </a>
              </div>
            </tr>

          </div>
        </div>
      </div>
      <div class="md-layout">
      <div class="md-layout-item md-size-100">
        <nav-tabs-card no-label>
          <template slot="content">
            <md-tabs md-sync-route class="md-primary" md-alignment="left">
              <md-tab id="tab-home" md-label="Twitch" md-icon="chat">
              </md-tab>
            </md-tabs>
          </template>
        </nav-tabs-card>
      </div>
    </div>
      <div class="section section-twitch-video">
        <div class="container-fluid text-center">
          <div class="md-layout">

            <tr v-for="(item, index) in Twitch" :key="Twitch[index].id" >
              <div class="md-layout-item">
                <a href="#/profile" target="_blank">
                  <img
                      :src="item.thumbnails"
                      alt="Rounded Image"
                      class="img-raised rounded img-fluid"
                  />
                  <md-button href="#/profile" class="md-simple md-success md-lg">{{ item.title }}</md-button>
                </a>
              </div>
            </tr>




          </div>
        </div>
      </div>
      <div class="md-layout">
      <div class="md-layout-item md-size-100">
        <nav-tabs-card no-label>
          <template slot="content">
            <md-tabs md-sync-route class="md-primary" md-alignment="left">
              <md-tab id="tab-home" md-label="Afreeca Tv" md-icon="face">
              </md-tab>
            </md-tabs>
          </template>
        </nav-tabs-card>
      </div>
    </div>
      <div class="section section-afreecatv-video">
        <div class="container-fluid text-center">
          <div class="md-layout">
            <div class="md-layout-item">
              <a href="#/profile" target="_blank">
                <img
                  :src="profile"
                  alt="Rounded Image"
                  class="img-raised rounded img-fluid"
                />
              </a>
              <md-button href="#/profile" class="md-simple md-success md-lg"
                >Afreecatv-Video1</md-button>
            </div>
            <div class="md-layout-item">
              <a href="#/profile" target="_blank">
                <img
                  :src="profile"
                  alt="Rounded Image"
                  class="img-raised rounded img-fluid"
                />
              </a>
              <md-button href="#/profile" class="md-simple md-success md-lg"
                >Afreecatv-Video2</md-button>
            </div>
            <div class="md-layout-item">
              <a href="#/profile" target="_blank">
                <img
                  :src="profile"
                  alt="Rounded Image"
                  class="img-raised rounded img-fluid"
                />
              </a>
              <md-button href="#/profile" class="md-simple md-success md-lg"
                >Afreecatv-Video3</md-button>
            </div>
            <div class="md-layout-item">
              <a href="#/profile" target="_blank">
                <img
                  :src="profile"
                  alt="Rounded Image"
                  class="img-raised rounded img-fluid"
                />
              </a>
              <md-button href="#/profile" class="md-simple md-success md-lg"
                >Afreecatv-Video4</md-button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { LoginCard } from "@/components";
import { NavTabsCard } from '@/components';
import axios from 'axios'
export default {
  components: {
    NavTabsCard
  },
  name: "index",
  bodyClass: "index-page",

  data() {
    return {
      Tube:[],
      Twitch:[],
      TubeUrl:[],
      firstname: null,
      email: null,
      password: null,
      leafShow: false,
      search_input: null,
    };
  },
  methods: {
    submitForm(){
      axios.post('/video/search',{
        "query": this.search_input
      }).then(function( response ){
        this.Tube = response.data;
        for (var i=0;i<this.Tube.length;i+=1){
          console.log(this.Tube[i].platform)
          if (this.Tube[i].platform==='twitch'){
            this.Twitch.push(this.Tube[i])
          }else{
            this.TubeUrl.push(this.Tube[i])
          }
        }
        console.log("twitch lengh"+this.Twitch.length)
      }.bind(this));
    }
  ,
    leafActive() {
      if (window.innerWidth < 768) {
        this.leafShow = false;
      } else {
        this.leafShow = true;
      }
    }
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.image})`
      };
    },
    signupImage() {
      return {
        backgroundImage: `url(${this.signup})`
      };
    }
  },
  mounted() {
    this.leafActive();
    window.addEventListener("resize", this.leafActive);
  },
  beforeDestroy() {
    window.removeEventListener("resize", this.leafActive);
  }
};
</script>
<style lang="scss">
.section-download {
  .md-button + .md-button {
    margin-left: 5px;
  }
}
.nav-tabs-card{
  color: blue;
}
.search {
    min-height:750px;
}
@media all and (min-width: 991px) {
  .btn-container {
    display: flex;
  }
}
</style>
