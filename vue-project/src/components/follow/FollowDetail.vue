<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import FollowDetailItem from "./item/FollowDetailItem.vue";

const route = useRoute();
const router = useRouter();

onMounted(() => {
  console.log(route.params.followId);
  getArticles();
  console.log(articles);
});

const articles = ref([]);

const getArticles = () => {
  axios
    .get(`http://localhost:8080/spring/resboard/followdetail/${route.params.followId}`)
    .then(({ data }) => {
      console.log(data);
      articles.value = data.resdata;
      console.log(articles.value);
      console.log(articles.value.userId);
    })
    .catch((error) => {
      console.log(error);
    });
};
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <mark class="sky">글목록</mark>
        </h2>
      </div>
      <table class="table table-hover">
        <thead>
          <tr class="text-center">
            <th scope="col">글번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">작성일</th>
          </tr>
        </thead>
        <tbody>
          <template v-for="article in articles">
            <FollowDetailItem :article="article"> </FollowDetailItem>
          </template>
        </tbody>
      </table>
    </div>
    <!-- <PageNavigation
          :current-page="currentPage"
          :total-page="totalPage"
          @pageChange="onPageChange"
        ></PageNavigation> -->
  </div>
</template>

<style scoped></style>
