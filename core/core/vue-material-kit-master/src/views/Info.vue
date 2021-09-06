<template>
    <div id="user-detail">
        <div id="user-info">
            <h2>Me</h2>
            <div>
                <h3>User Info:</h3>
                <h4>{{data.username}}</h4>
                
            </div>
        </div>
        <div id="user-fav">
            <h2>Video List</h2>
            <b-row>
                <b-card-group class="col-md-2" :key="idx" v-for="(video, idx) in data.videos">
                    <a :href=video.fileUrl style="color: black; text-decoration: none; height: 100%; width: 100%;">
                        <b-card :title=video.title
                        :img-src=video.thumbnailUrl
                        img-alt="Image"
                        tag="article"
                        style="height: 100%;"
                        >
                        <!-- <b-card-text>{{video.description}}</b-card-text> -->
                        </b-card>
                    </a>
                </b-card-group>
            </b-row>
        </div>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    data() {
        return {
            data : {
                username: null,
                videos: null
            }
        }
    },
    computed: {
      formattedCards() {
          return this.data.cards.reduce((c, n, i) => {
              if (i % 4 === 0) c.push([]);
              c[c.length - 1].push(n);
              return c;
          }, []);
      }
    },
    methods: {
        getUserInfo() {
            axios.get("http://localhost:8080/user/me")
            .then(res => {
                this.data = res.data.data;
                this.username = res.data.username;
                this.videos = res.data.videos;
            })
            .catch(err => {
                console.log(err);
            });
        }
        
    }

};
</script>