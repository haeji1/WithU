<script setup>
import axios from "axios";
import { ref, watch, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import BoardDetail from "../BoardDetail.vue";

const props = defineProps({ type: String });

const isUseId = ref(false);
const router = useRouter();
const route = useRoute();

const user = JSON.parse(sessionStorage.getItem("user"));

const url = import.meta.env.VITE_BOARD_WRITE_API_URL;
const geturl = import.meta.env.VITE_BOARD_VIEW_API_URL;

const article = ref({
  articleNo: 0,
  subject: "",
  content: "",
  userId: "",
  userName: "",
  hit: 0,
  registerDate: "",
});
const articles = ref([]);
// const user = JSON.parse(sessionStorage.getItem("user"));

onMounted(() => {
  getArticles();
  console.log("mounted");
  console.log(articles.value);
  // console.log("dfgfds" + articles.value);
});

const getArticles = () => {
  axios
    .get(geturl, {
      params: {
        articleNo: route.params.articleno,
      },
    })
    .then(({ data }) => {
      console.log("form" + data.resdata);
      articles.value = data.resdata;
      console.log("===getarticle===");
      console.log(articles);
      article.value.content = articles.value.content;
      article.value.subject = articles.value.subject;
      if (user !== null) article.value.userId = user;
      console.log("===" + article.value.userId);
      console.log(article.value.userId);
    })
    .catch((error) => {
      console.log(error);
    });
};

if (props.type === "modify") {
  console.log(articles.value.userId);
  // route에서 글번호 얻어오자
  let articleno = route.params.articleno;
  console.log(articleno + "번글 얻어와서 수정할거야==");
  console.log(articles.value);

  // console.log(route.parmas.subject);
  // console.log(route.parmas.content);
  article.value = {
    articleNo: articleno,
    subject: article.value.subject,
    content: article.value.content,
    userId: article.value.userId,
    hit: article.value.hit,
    registerDate: article.value.registerDate,
  };
  isUseId.value = true;
}

const subjectErrMsg = ref("");
const contentErrMsg = ref("");
watch(
  () => article.value.subject,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 30) {
      subjectErrMsg.value = "제목을 확인해 주세요!!!";
    } else subjectErrMsg.value = "";
  }
);
watch(
  () => article.value.content,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 500) {
      contentErrMsg.value = "내용을 확인해 주세요!!!";
    } else contentErrMsg.value = "";
  }
);

function onSubmit() {
  // event.preventDefault();

  if (subjectErrMsg.value) {
    alert(subjectErrMsg.value);
  } else if (contentErrMsg.value) {
    alert(contentErrMsg.value);
  } else {
    props.type === "regist" ? writeArticle() : updateArticle();
  }
}

function writeArticle() {
  if (user != null && article.value.length != 0 && article.value.content != 0) {
    console.log("글등록하자!!");
    article.value.userId = user;
    console.log(article.value.userId);
    axios
      .post(url, article.value)
      .then((response) => {
        console.log(response);
        router.push({ name: "article-list" });
      })
      .catch((error) => {
        console.log(error);
      });
  }
  else if ((article.value.length === 0 || article.value.subject.length === 0) && user != null) {
    alert("빈글은 올릴 수 없습니다.")
    router.push({ name: "article-list" });
  }

  else {
    router.push({ name: "login" });
    alert("로그인하세요");
  }
}

function updateArticle() {
  console.log(articles.value.articleNo + "번글 수정하자!!");
  axios
    .put(
      // `http://192.168.205.83:8080/spring/resboard/modify/${articles.value.articleNo}`,
      `http://192.168.205.82:8080/spring/resboard/modify/${articles.value.articleNo}`,
      article.value
    )
    .then(({ data }) => {
      console.log(data.value);
      router.push({ name: "article-list" });
    })
    .catch((error) => {
      console.log(error);
    });
}

const moveList = () => {
  router.push({ name: "article-list" });
};
</script>

<template>
  <form @submit.prevent="onSubmit">
    <div class="mb-3">
      <label for="subject" class="form-label">제목 : </label>
      <input type="text" class="form-control" v-model="article.subject" placeholder="제목..." />
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용 : </label>
      <textarea class="form-control" v-model="article.content" rows="10"></textarea>
    </div>
    <div class="col-auto text-center">
      <button type="submit" class="btn btn-outline-primary mb-3" v-if="type === 'regist'">
        글작성
      </button>
      <button type="submit" class="btn btn-outline-success mb-3" v-else @click="updateArticle">
        글수정
      </button>
      <button type="button" class="btn btn-outline-danger mb-3 ms-1" @click="moveList">
        목록으로이동...
      </button>
    </div>
  </form>
</template>

<style scoped></style>
