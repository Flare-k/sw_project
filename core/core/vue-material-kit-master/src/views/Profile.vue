<template>
  <div class="wrapper">
    <parallax
      class="section page-header header-filter"
      :style="headerStyle"
    ></parallax>
    <div class="main main-raised">
      <div class="section profile-content">
        <div class="container">
          <div class="md-layout">
            <div class="md-layout-item md-size-50 mx-auto">
              <div class="profile">
                <div class="avatar">
                  <img
                    :src="img"
                    alt="Circle Image"
                    class="img-raised rounded-circle img-fluid"
                  />
                </div>
                <div class="name">
                  <h3 class="title">{{ $route.query.name }}</h3>

                </div>
              </div>
            </div>
          </div>

          <div v-if="'youtube' === this.$route.query.platform">
            <iframe  class="ifa" width="2500" height="800" :src="youtubeUrl+$route.query.videoId.split('/')[4]" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
          </div>
          <div v-else-if="'twitch' === this.$route.query.platform">
            <iframe class="ifa"  :src="twitchFront+$route.query.videoId.split('/')[4]+twitchBack" frameborder="0" allowfullscreen="true" scrolling="no" height="800" width="2500"></iframe>
<!--            <iframe  class="ifa" width="2500" height="800" :src="twitchUrl+$route.query.videoId.split('/')[4]" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>-->
          </div>
          <div class="profile-tabs">
            <tabs
              :tab-name="['Twitch', 'Afreeca', 'Youtube']"
              :tab-icon="['camera', 'palette', 'favorite']"
              plain
              nav-pills-icons
              color-button="success"
            >
              <!-- here you can add your content for tab-content -->
              <template slot="tab-pane-1">
                <div class="md-layout">
                  <div class="md-layout-item md-size-25 ml-auto">
                    <img :src="tabPane1[0].image" class="rounded" />
                    <img :src="tabPane1[1].image" class="rounded" />
                  </div>
                  <div class="md-layout-item md-size-25 mr-auto">
                    <img :src="tabPane1[3].image" class="rounded" />
                    <img :src="tabPane1[2].image" class="rounded" />
                  </div>
                </div>
              </template>
              <template slot="tab-pane-2">
                <div class="md-layout">
                  <div class="md-layout-item md-size-25 ml-auto">
                    <img :src="tabPane2[0].image" class="rounded" />
                    <img :src="tabPane2[1].image" class="rounded" />
                    <img :src="tabPane2[2].image" class="rounded" />
                  </div>
                  <div class="md-layout-item md-size-25 mr-auto">
                    <img :src="tabPane2[3].image" class="rounded" />
                    <img :src="tabPane2[4].image" class="rounded" />
                  </div>
                </div>
              </template>
              <template slot="tab-pane-3">
                <div class="md-layout">
                  <div class="md-layout-item md-size-25 ml-auto">
                    <img :src="tabPane3[0].image" class="rounded" />
                    <img :src="tabPane3[1].image" class="rounded" />
                  </div>
                  <div class="md-layout-item md-size-25 mr-auto">
                    <img :src="tabPane3[2].image" class="rounded" />
                    <img :src="tabPane3[3].image" class="rounded" />
                    <img :src="tabPane3[4].image" class="rounded" />
                  </div>
                </div>
              </template>
            </tabs>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
import { Tabs } from "@/components";

export default {
  name:'profile',
  components: {
    Tabs
  },
  bodyClass: "profile-page",
  data() {
    return {

      twitchFront:"https://player.twitch.tv/?video="
      ,
      twitchBack:"&parent=localhost",
      you:"youtube",
      twi:"twitch",
      youtubeUrl:"https://www.youtube.com/embed/"
      ,
      twitchUrl:"https://www.twitch.tv/videos/"
      ,
      tabPane1: [
        { image: require("@/assets/img/twitch1.png") },
        { image: require("@/assets/img/twitch2.png") },
        { image: require("@/assets/img/twitch3.png") },
        { image: require("@/assets/img/twitch4.png") }
      ],
      tabPane2: [
        { image: require("@/assets/img/afreeca1.png") },
        { image: require("@/assets/img/afreeca2.png") },
        { image: require("@/assets/img/afreeca3.png") },
        { image: require("@/assets/img/afreeca1.png") },
        { image: require("@/assets/img/afreeca2.png") }
      ],
      tabPane3: [
        { image: require("@/assets/img/you1.png") },
        { image: require("@/assets/img/you2.png") },
        { image: require("@/assets/img/you3.png") },
        { image: require("@/assets/img/you1.png") },
        { image: require("@/assets/img/you1.png") }
      ]
    };
  },
  props: {
    header: {
      type: String,
      default: require("@/assets/img/city-profile.jpg")
    },
    img: {
      type: String,
      default: require("@/assets/img/faces/raloPic.webp")
    }
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`
      };
    }
  },methods:{
    voidTest(){
      console.log("+++++++++++++++"+this.$route.query.platform);
    }

  }
};
</script>

<style lang="scss" scoped>
.ifa{
  min-height:750px;
}
.section {
  padding: 0;
}

.profile-tabs::v-deep {
  .md-card-tabs .md-list {
    justify-content: center;
  }

  [class*="tab-pane-"] {
    margin-top: 3.213rem;
    padding-bottom: 50px;

    img {
      margin-bottom: 2.142rem;
    }
  }
}
</style>
