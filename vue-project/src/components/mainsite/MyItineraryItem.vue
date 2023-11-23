<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";

const router = useRouter();
const travels = ref([]);
const user = JSON.parse(sessionStorage.getItem("user"));
const url = import.meta.env.VITE_PLAN_API_URL;
onMounted(() => {
  getArticles();
});
const getArticles = () => {
  axios
    .get(url)
    .then(({ data }) => {
      // console.log(data.resdata);
      // console.log(data);
      travels.value = data.resdata;
      console.log(travels.value);
    })
    .catch((error) => {
      console.log(error);
    });
};
// const travels = ref([
//     {
//         name: "이예진",
//         subject: "월미도",
//         regiterday: "2023-11-03",
//         startday: "2023-03-13",
//         arrivalday: "2023-03-14",
//         content: "11111",
//         image: "/"
//     },
//     {
//         name: "이예진",
//         subject: "월미도",
//         regiterday: "2023-11-03",
//         startday: "2023-03-13",
//         arrivalday: "2023-03-14",
//         content: "11111",
//         image: "/"
//     },
//     {
//         name: "이예진",
//         subject: "월미도",
//         regiterday: "2023-11-03",
//         startday: "2023-03-13",
//         arrivalday: "2023-03-14",
//         content: "11111",
//         image: "/"
//     },
// ])
</script>

<template>
  <div class="col-md-3" v-for="travel in travels.slice(1,5)">
    <div class="card mb-3">
      <div class="card-body">
        <router-link
          :to="{
            name: 'plan-view',
            params: { articleno: travel.planNo },
          }"
          class="article-title link-dark"
        >
          <h5 class="card-title text-center">{{ travel.subject }}</h5>
        </router-link>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
