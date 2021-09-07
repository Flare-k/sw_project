<template>
  <div class="wrapper">
    <parallax class="page-header header-filter" :style="headerStyle">
      <div class="md-layout">
        <div class="md-layout-item">
          <div class="image-wrapper">
            <div class="brand">
              <h1>Video Danawa</h1>
              <div class="md-layout">
                       <md-field class="has-green">
                          <label>검색</label>
                          <md-input v-model="search_input" md-size-100></md-input>
                            <div class="md-layout-item text-center">
                                <md-button href="#/Search" class="md-primary" @click="submitForm()" md-alignment="left">Search</md-button>
                      </div>
                    </md-field>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </parallax>
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
        console.log("twitch length"+this.Twitch.length)
        window.location.href = '#/Search';
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
