<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
// import BoardDetail from "../BoardDetail.vue";

const route = useRoute();
const router = useRouter();

const followurl = import.meta.env.VITE_FOLLOW_FOLLOW_API_URL;
const user = JSON.parse(sessionStorage.getItem("user"));
const props = defineProps({ follower: Object });
onMounted(() => {
  console.log("----");
  console.log("item: " + props.follower.userId);
  // console.log(props.article.userId);
});

const follow = ref({
  userId: "",
  followId: "",
});

function onFollowUser() {
  if (user === props.follower.userId) {
    alert("자기자신을 팔로우 할 수 없습니다")
  }
  else {
    alert(`${props.follower.userId} 님을 팔로우합니다.`);
    follow.value.userId = user;
    follow.value.followId = props.follower.userId;
    console.log(follow.value.length);
    axios
      .post(followurl, follow.value)
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  }

}
</script>

<template>
  <div class="mb-3 d-flex justify-content-center">
    <div class="card w-50">
      <div class="card-body" style="text-align: center">
        <img src="@/assets/profile.png" alt="로고" width="150" height="150" class="d-inline-block align-top"
          style="border-radius: 50%" />
        <h5 class="card-title">{{ props.follower.userId }}</h5>
        <p class="card-text"></p>
        <button class="btn btn-pink" @click="onFollowUser">팔로우하기</button>
        <!-- <a href="#" class="btn btn-primary">Button</a> -->
      </div>
    </div>
  </div>
</template>

<style scoped>
a {
  text-decoration: none;
}

.card {
  width: 300px;
  margin: 0 auto;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s;
  /* 마우스 호버 시 부드러운 효과를 위한 CSS 속성 추가 */
}

.card:hover {
  transform: scale(1.05);
  /* 마우스 호버 시 크기를 약간 확대하는 효과 */
}

.card-body {
  text-align: center;
}

.card img {
  border-radius: 50%;
  margin-bottom: 10px;
}

.card-title {
  font-size: 1.5em;
  margin-bottom: 10px;
}

.btn-pink {
  background-color: #ff69b4;
  color: #fff;
  border: none;
  transition: background-color 0.3s;
  /* 마우스 호버 시 부드러운 색상 전환을 위한 효과 */
}

.btn-pink:hover {
  background-color: #ff4f9e;
}
</style>
