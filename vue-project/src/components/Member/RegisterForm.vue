<script setup>
import axios from "axios";
// import { LottiAnimation } from "lottie-web-vue";
import { ref, watch, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";

const router = useRouter();
const route = useRoute();

const url = import.meta.env.VITE_MEMBER_REGISTER_API_URL;

const member = ref({
  userId: "",
  userName: "",
  userPwd: "",
  emailId: "",
  emailDomain: "",
  joinDate: "",
});

function memberRegist() {
  console.log("회원등록");
  axios
    .post(url, member.value)
    .then((response) => {
      console.log(response);
      router.push({ name: "index" });
    })
    .catch((error) => {
      console.log(error);
    });
}
</script>

<template>
  <div class="row justify-content-center">
    <div class="col-lg-8 col-md-10 col-sm-12">
      <h2 class="my-3 py-3 shadow-sm bg-light text-center">
        <mark class="sky">회원가입</mark>
      </h2>
    </div>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <div class="mb-3">
            <label for="inputNickname" class="form-label">닉네임</label>
            <input type="text" class="form-control" v-model="member.userName" />
          </div>
          <div class="mb-3">
            <label for="inputId" class="form-label">아이디</label>
            <input type="text" class="form-control" v-model="member.userId" />
          </div>
          <div class="mb-3">
            <label for="inputPassword" class="form-label">비밀번호</label>
            <input type="password" class="form-control" v-model="member.userPwd" />
          </div>
          <div class="mb-3">
            <label for="inputEmail" class="form-label">이메일</label>
            <input type="email" class="form-control" v-model="member.emailId" />
          </div>
          <div class="text-center">
            <button id="btn" type="submit" class="btn btn-primary" @click="memberRegist">
              Sign in
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.form-control {
  width: 100%;
}

#btn {
  display: inline-block;
  margin-top: 10px;
}
</style>
