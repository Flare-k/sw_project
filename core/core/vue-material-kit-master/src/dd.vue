<template>
  <div class="wrapper">
    <parallax
      class="section page-header header-filter"
      :style="headerStyle"
    ></parallax>
    <div class="main main-raised">
      <div class="player">
        <div class="container1">
          <div class="md-layout1">
            <div class="md-layout-item1">
              <div class="profile" id="test">
                <div class="avatar1">
                  <img
                    :src="img"
                    alt="Circle Image"
                    class="img-raised rounded-circle img-fluid"
                  />
                </div>
                <div class="name">
                  <h3 class="title">Ralo</h3>
                </div>
              </div>
            </div>
          </div>
      </div>
           <div class="player">
            <iframe width="1000" height="1000" src="https://www.youtube.com/embed/CNvN9wPx2Ag" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
          </div>
    </div>
        </div>
             

  </div>
</template>

<script>
import { Tabs } from "@/components";
export default {
  components: {
   
  },
  bodyClass: "profile-page",

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
  }
};
</script>

<style lang="scss" scoped>
#test{
  max-height: 1000px;
}
.player{
  max-height: 500px;
}

</style>
