<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import axios from "axios";

const router = useRouter();
const route = useRoute();
const url = import.meta.env.VITE_MEMBER_GET_API_URL;
const user = JSON.parse(sessionStorage.getItem("user"));

onMounted(() => {
  getMember();
});

const member = ref({
  userId: 0,
  userName: "",
  userPwd: "",
  emailDomain: "",
  joinDate: "",
  eamilId: 0,
});

const getMember = () => {
  axios
    .get(`http://localhost:8080/spring/resmem/mypage/${user}`)
    .then(({ data }) => {
      member.value = data.resdata;
      console.log(member.value);
    })
    .catch((error) => {
      console.log(error);
    });
};

function moveHome() {
  router.push({ name: "index" });
}

function moveFollower() {
  router.push({ name: "follower" });
}

function moveFollowing() {
  router.push({ name: "following" });
}
</script>

<template>
  <div class="row justify-content-center">
    <div class="col-lg-8 col-md-10 col-sm-12">
      <h2 class="my-3 py-3 shadow-sm bg-light text-center">
        <mark class="sky">마이페이지</mark>
      </h2>
    </div>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <div class="mb-3">
            <label for="inputNickname" class="form-label">닉네임</label>
            <input v-model="member.userName" type="text" class="form-control" />
          </div>
          <div class="mb-3">
            <label for="inputId" class="form-label">아이디</label>
            <input v-model="member.userId" type="text" class="form-control" />
          </div>
          <div class="mb-3">
            <label for="inputPassword" class="form-label">비밀번호</label>
            <input v-model="member.userPwd" type="password" class="form-control" :readonly="true" />
          </div>
          <div class="mb-3">
            <label for="inputEmail" class="form-label">이메일</label>
            <input v-model="member.emailId" type="email" class="form-control" />
          </div>

          <div class="text-center mt-3">
            <button type="submit" class="btn btn-primary me-2" @click="moveHome">홈으로</button>
            <button type="submit" class="btn btn-primary me-2" @click="moveFollower">팔로워</button>
            <button type="submit" class="btn btn-primary" @click="moveFollowing">팔로잉</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
