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
  });
}

function onFollowUser() {
  alert(`${articles.value.userId} 님을 팔로우합니다.`);
}

function onDeleteArticle() {
  console.log(route.params.articleno + "번글 삭제하러 가자!!!");
  axios
    .delete(`http://localhost:8080/spring/resboard/delete/${route.params.articleno}`)
    .then((response) => {
      console.log(`Deleted post with ID ${route.params.articleno}`);
      alert("삭제되었습니다");
      router.push({ name: "article-list" });
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
          <h2 class="text-secondary px-5">{{ articles.articleNo }}. {{ articles.subject }}</h2>
        </div>
        <div class="row">
          <!-- <div class="col-md-8">
            <div class="clearfix align-content-center">
              <img
                class="avatar me-2 float-md-start bg-light p-2"
                src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg"
              />
              <p>
                <span class="fw-bold">안효인</span> <br />
                <span class="text-secondary fw-light">
                  {{ article.registerTime }}1 조회 : {{ article.hit }}
                </span>
              </p>
            </div>
          </div>
          <div class="col-md-4 align-self-center text-end">댓글 : 17</div>
          <div class="divider mb-3"></div>
          <div class="text-secondary">
            {{ article.content }}
          </div> -->
          <div class="divider mt-3 mb-3"></div>
          <div class="d-flex justify-content-end">
            <button type="button" class="btn btn-outline-primary mb-3" @click="moveList">
              글목록
            </button>
            <button type="button" class="btn btn-outline-success mb-3 ms-1" @click="moveModify">
              글수정
            </button>
            <button type="button" class="btn btn-outline-danger mb-3 ms-1" @click="onDeleteArticle">
              글삭제
            </button>
            <button type="button" class="btn btn-outline-danger mb-3 ms-1" @click="onFollowUser">
              팔로우하기
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
