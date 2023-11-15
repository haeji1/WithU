<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
// import BoardFormItem from "./item/BoardFormItem.vue";

const route = useRoute();
const router = useRouter();
// const props = defineProps(["article"]);
// const props = defineProps({ article: Object });

const url = import.meta.env.VITE_BOARD_VIEW_API_URL;
// const durl = import.meta.env.VITE_BOARD_DELETE_API_URL;

onMounted(() => {
  getArticle();
  // console.log("article:" + route.params.subject);
});

const getArticle = () => {
  console.log(route.params.articleno + "번글 얻으러 가자!!!");
};

const articles = ref([]);

onMounted(() => {
  getArticles();
});

const getArticles = () => {
  axios
    .get(url, {
      params: {
        articleNo: route.params.articleno,
      },
    })
    .then(({ data }) => {
      console.log(data.resdata);
      articles.value = data.resdata;
      console.log(articles.value);
    })
    .catch((error) => {
      console.log(error);
    });
};

function moveList() {
  router.push({ name: "article-list" });
}

function moveModify() {
  router.push({
    name: "article-modify",
    // params: { articles: route.params.articles },
    // params: { content: articles.content, subject: articles.subject },
  });
}

function onDeleteArticle() {
  console.log(route.params.articleno + "번글 삭제하러 가자!!!");
  router.push({ name: "article-list" });
  axios
    .delete(`http://localhost:8080/spring/resboard/delete/${route.params.articleno}`)
    .then((response) => {
      console.log(`Deleted post with ID ${route.params.articleno}`);
    })
    .catch((error) => {
      console.error(error);
    });
}
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <mark class="sky">글보기</mark>
        </h2>
      </div>
      <div class="col-lg-10 text-start">
        <div class="row my-2">
          <h2 class="text-secondary px-5">
            제목 : {{ articles.subject }} 내용 : {{ articles.content }}
          </h2>
        </div>
      </div>

      <div class="row">
        <div class="col-md-8">
          <div class="clearfix align-content-center">
            <!-- (생략) -->
          </div>
        </div>

        <div class="col-md-4">
          <div class="d-flex justify-content-center">
            <button type="button" class="btn btn-primary me-2" @click="moveList">글목록</button>
            <!-- 
            <router-link
              :to="{
                path: `/board/article-modify/${route.params.articleno}`,
                params: { subject: articles.subject, content: articles.content },
              }"
            > -->

            <button type="button" class="btn btn-success me-2" @click="moveModify">글수정</button>
            <!-- </router-link> -->

            <button type="button" class="btn btn-danger" @click="onDeleteArticle">글삭제</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
