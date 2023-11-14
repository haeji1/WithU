<script setup>
import axios from "axios";
import { ref, watch } from "vue";
import { useRouter } from "vue-router";

const props = defineProps({ type: String });

const isUseId = ref(false);
const router = useRouter();

const url = import.meta.env.VITE_BOARD_WRITE_API_URL;

const article = ref({
  articleNo: 0,
  subject: "",
  content: "",
  userId: "",
  userName: "",
  hit: 0,
  registerDate: "",
});

if (props.type === "modify") {
  // route에서 글번호 얻어오자
  let articleno = 10;
  console.log(articleno + "번글 얻어와서 수정할거야");
  article.value = {
    articleNo: articleno,
    subject: "안녕하세요 뷰테스트 중입니다.",
    content:
      "뷰테스트 중입니다. 컴포넌트 연습하고 있으며, 앞으로 props와 custom event를 처리 할 예정입니다!!!",
    userId: "ssafy",
    userName: "김싸피",
    hit: 123,
    registerDate: "25.01.01",
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
