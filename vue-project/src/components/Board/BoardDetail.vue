<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import CommentWrite from "../comment/CommentWrite.vue";
// import BoardFormItem from "./item/BoardFormItem.vue";

const route = useRoute();
const router = useRouter();
// const props = defineProps(["article"]);
// const props = defineProps({ article: Object });

const url = import.meta.env.VITE_BOARD_VIEW_API_URL;
const followurl = import.meta.env.VITE_FOLLOW_FOLLOW_API_URL;
const user = JSON.parse(sessionStorage.getItem("user"));
// const durl = import.meta.env.VITE_BOARD_DELETE_API_URL;

const comment = ref({});

// follow 유저 아이디 세팅
const follow = ref({
  userId: "",
  followId: "",
});

const articles = ref({});
const comments = ref({});
// const comment = ref({});

onMounted(() => {
  getArticles();
  getComment();
  console.log(comment.value.articleno);
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
      console.log(articles.value.articleNo);
      comment.value.articleNo = route.params.articleno;
      comment.value.userId = user;
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
  if (user === articles.value.userId) {
    alert("자기 자신을 팔로우 할 수 없습니다.");
  } else {
    alert(`${articles.value.userId} 님을 팔로우합니다.`);
    follow.value.userId = user;
    follow.value.followId = articles.value.userId;
    console.log(follow.value.length);
    axios
      .post(followurl, follow.value)
      .then((response) => {
        console.log(response);
        router.push({ name: "following" });
      })
      .catch((error) => {
        console.log(error);
      });
  }
}

function onDeleteArticle(userId) {
  if (user !== userId) {
    alert("자기 자신의 글만 삭제할 수 있습니다.");
  } else {
    console.log(route.params.articleno + "번글 삭제하러 가자!!!");
    axios
      .delete(`http://192.168.205.82:8080/spring/resboard/delete/${route.params.articleno}`)
      .then((response) => {
        console.log(`Deleted post with ID ${route.params.articleno}`);
        alert("삭제되었습니다");
        router.push({ name: "article-list" });
      })
      .catch((error) => {
        console.error(error);
      });
  }
}
function getComment() {
  axios
    .get(
      `http://192.168.205.82:8080/spring/resboard/clist/${route.params.articleno}`
    )
    .then((data) => {
      comments.value = data.data.resdata;
      console.log(`${route.params.articleno}번 댓글 불러오기`);
      // console.log(data.data.resdata);
      console.log(comments.value[0]);
      // router.push({ name: "article-list" });
    })
    .catch((error) => {
      console.error(error);
    });
}

function WriteComment() {
  if (user === null) {
    alert("로그인 해주세요");
    router.push({ name: "login" });
  } else {
    axios
      .post(`http://192.168.205.82:8080/spring/resboard/cwrite`, comment.value)
      .then(({ data }) => {
        console.log(comment.value);
        alert("댓글이 등록되었습니다.");
        router
          .push({
            name: "article-view",
            params: { articleno: route.params.articleno },
          })
          // router.push({ name: "article-view" });
          .then(() => {
            window.location.reload();
          });
        // router.push({ name: "article-view", params: { articleno: route.params.articleno } });
      })
      .catch((error) => {
        console.log(error);
      });
  }
}

function DeleteComment(commentNo, commentUser) {
  console.log(commentNo);
  if (user === commentUser) {
    axios
      // .delete(http://192.168.205.83:8080/spring/resboard/cdelete/${commentNo})
      .delete(`http://192.168.205.82:8080/spring/resboard/cdelete/${commentNo}`)
      .then((response) => {
        console.log(`Deleted post with ID ${commentNo}`);
        alert("댓글이 삭제되었습니다");
        window.location.reload();
      })
      .catch((error) => {
        console.error(error);
      });
  } else {
    alert("자신의 댓글만 삭제할 수 있습니다.");
  }
}
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-lg-12">
              <div class="border rounded p-4">
                <h2>{{ articles.subject }}</h2>
                <div class="d-flex justify-content-end">
                  <strong>작성자:</strong>
                  <span class="text-end">{{ articles.userId }}</span>
                </div>
                <div class="d-flex justify-content-end">
                  <strong>작성일:</strong>
                  <span class="text-end">{{ articles.registerTime }}</span>
                </div>
                <div class="d-flex justify-content-end">
                  조회수 : {{ articles.hit }}<br />
                </div>
                <p>{{ articles.content }}</p>
              </div>
            </div>
          </div>
        </div>
        <div class="divider mt-3 mb-3"></div>
        <div class="d-flex justify-content-end">
          <button type="button" class="btn btn-outline-primary mb-3" @click="moveList">
            글목록
          </button>
          <button type="button" class="btn btn-outline-success mb-3 ms-1" @click="moveModify">
            글수정
          </button>
          <button type="button" class="btn btn-outline-danger mb-3 ms-1" @click="() => onDeleteArticle(articles.userId)">
            글삭제
          </button>
          <button type="button" class="btn btn-outline-danger mb-3 ms-1" @click="onFollowUser">
            팔로우하기
          </button>
        </div>
      </div>
      <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">댓글 등록</label>

        <textarea class="form-control" v-model="comment.content" rows="3"></textarea>
        <button type="button" class="btn btn-outline-danger mb-3 ms-1" @click="WriteComment">
          댓글쓰기
        </button>
      </div>
    </div>
    <div class="mb-3"></div>
    <div class="card" v-for="comment in comments" :key="comment.articleNo">
      <h5 class="card-header">{{ comment.userId }}</h5>
      <div class="card-body">
        <h5 class="card-title">{{ comment.content }}</h5>
        <a class="btn btn-primary" @click="() => DeleteComment(comment.commentNo, comment.userId)">댓글 삭제</a>
      </div>
    </div>
  </div>
</template>
