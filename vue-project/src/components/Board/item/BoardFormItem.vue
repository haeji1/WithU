<script setup>
import axios from "axios";
import { ref, watch, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import BoardDetail from "../BoardDetail.vue";

const props = defineProps({ type: String });

const isUseId = ref(false);
const router = useRouter();
const route = useRoute();

const url = import.meta.env.VITE_BOARD_WRITE_API_URL;
const geturl = import.meta.env.VITE_BOARD_VIEW_API_URL;
const updateurl = import.meta.env.VITE_BOARD_UPDATE_API_URL;

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

onMounted(() => {
  getArticles();
  console.log("dfgfds" + articles.value);
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
      console.log(articles.value);
    })
    .catch((error) => {
      console.log(error);
    });
};

if (props.type === "modify") {
  // route에서 글번호 얻어오자
  let articleno = route.params.articleno;
  console.log(articleno + "번글 얻어와서 수정할거야");
  console.log(articles.value.content);
  // console.log(route.parmas.subject);
  // console.log(route.parmas.content);
  article.value = {
    articleNo: articleno,
    subject: articles.value.subject,
    content: articles.value.content,
    userId: articles.value.userId,
    hit: articles.value.hit,
    registerDate: articles.value.registerDate,
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
  router.push({ name: "article-list" });
  console.log("글등록하자!!", article.value);
  // console.log(article.value.subject);
  // console.log(article.value.content);
  axios
    .post(url, article.value)
    .then((response) => {
      console.log(response);
    })
    .catch((error) => {
      console.log(error);
    });
}

function updateArticle() {
  router.push({ name: "article-list" });
  console.log(article.value.articleNo + "번글 수정하자!!");
  axios
    .put(`http://localhost:8080/spring/resboard/modify/${article.value.articleNo}`, articles.value)
    .then(({ data }) => {
      console.log(data.value);
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
      <input type="text" class="form-control" v-model="articles.subject" placeholder="제목..." />
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용 : </label>
      <textarea class="form-control" v-model="articles.content" rows="10"></textarea>
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
