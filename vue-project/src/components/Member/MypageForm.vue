<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";

const router = useRouter();
const route = useRoute();

function moveHome() {
  router.push({ name: "index" });
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
            <input type="text" class="form-control" />
          </div>
          <div class="mb-3">
            <label for="inputId" class="form-label">아이디</label>
            <input type="text" class="form-control" />
          </div>
          <div class="mb-3">
            <label for="inputPassword" class="form-label">비밀번호</label>
            <input type="password" class="form-control" />
          </div>
          <div class="mb-3">
            <label for="inputEmail" class="form-label">이메일</label>
            <input type="email" class="form-control" />
          </div>
          <div class="text-center">
            <button id="btn" type="submit" class="btn btn-primary" @click="moveHome">홈으로</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
