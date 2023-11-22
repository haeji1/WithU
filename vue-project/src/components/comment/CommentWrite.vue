<script setup>
import axios from "axios";
import { ref, watch, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";

const props = defineProps({ articles: Object });
// const props = defineProps(["articles"]);
const user = JSON.parse(sessionStorage.getItem("user"));

const comment = ref({
  articleno: props.articles.articleno,
  userId: user,
  content: "",
});

onMounted(() => {
  // console.log("item: " + props.article.content);
  // console.log(props.article.userId);
  console.log(props.articles.articleno);
  console.log(comment.value);
  console.log(props.articles);
});

function WriteComment() {
  axios
    .post(`http://192.168.205.83:8080/spring/resboard/cwrite`, comment.value)
    .then(({ data }) => {
      console.log(comment.value);
      alert("댓글이 등록되었습니다.");
      // router.push({ name: "article-list" });
    })
    .catch((error) => {
      console.log(error);
    });
}
</script>

<template>
  <div class="mb-3"></div>
  <div class="mb-3">
    <label for="exampleFormControlTextarea1" class="form-label">댓글</label>
    <textarea class="form-control" v-model="comment.content" rows="3"></textarea>
  </div>
  <button type="button" class="btn btn-outline-danger mb-3 ms-1" @click="WriteComment">
    댓글쓰기
  </button>
</template>

<style scoped></style>
