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
        <div class="md-layout-item text-center">
          <md-button href="#/login" class="md-simple md-success md-lg"
            >Go Join Page</md-button>
        </div>
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
            
            
            <div class="md-layout-item">
              <a router :to="{
                name: 'profile',
                params: {
                  videoId: 'kijWPYLkvmk',
                  name: 'ralo'
                }
              }
              " target="_blank">
                <img
                  :src="profile"
                  alt="Rounded Image"
                  class="img-raised rounded img-fluid"
                />
              </a>
              <md-button class="md-simple md-success md-lg" v-on:click=axiosGet
                >Youtube-Video1</md-button>
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
                >Youtube-Video2</md-button>
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
                >Youtube-Video3</md-button>
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
                >Youtube-Video4</md-button>
            </div>
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
            <div class="md-layout-item">
              <a href="#/profile" target="_blank">
                <img
                  :src="profile"
                  alt="Rounded Image"
                  class="img-raised rounded img-fluid"
                />
              </a>
              <md-button href="#/profile" class="md-simple md-success md-lg"
                >Twitch-Video1</md-button>
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
                >Twitch-Video2</md-button>
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
                >Twitch-Video3</md-button>
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
                >Twitch-Video4</md-button>
            </div>
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
  props: {
    image: {
      type: String,
      default: require("@/assets/img/vue-mk-header.jpg")
    },
    profile: {
      type: String,
      default: require("@/assets/img/profile.jpg")
    }
  },
  data() {
    return {
      firstname: null,
      email: null,
      password: null,
      leafShow: false,
    };
  },
  methods: {
    axiosGet(){
      axios.get('http://172.30.1.2:8080/video/search').then(res => { console.log(res.data) })
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

@media all and (min-width: 991px) {
  .btn-container {
    display: flex;
  }
}
</style>
