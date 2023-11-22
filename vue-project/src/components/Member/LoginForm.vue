<script setup>
import { ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router"; // Vue Router 추가
const userid = ref("");
const userpwd = ref("");
const userInfo = ref(null);
const router = useRouter(); // Vue Router 추가
const url = import.meta.env.VITE_MEMBER_LOGIN_ALI_URL;

const login = async function () {
  try {
    const response = await axios.post(url, {
      userId: userid.value,
      userPwd: userpwd.value,
    });
    // 서버 응답에서 회원 정보를 userInfo 변수에 저장
    userInfo.value = response.data.resdata;
    // 로그인이 성공한 경우에만 index 페이지로 이동
    if (response.data.resmsg === "입력 성공") {
      console.log("bbb");
      sessionStorage.setItem("user", JSON.stringify(userInfo.value.userId));
      router.push({ name: "index" }).then(() => {
        window.location.reload();
      });
    } else {
      console.log(response.data.resmsg);
    }

    // 여기서 필요한 추가 작업을 수행할 수 있습니다.
  } catch (error) {
    console.error("Error during login:", error.response);
  }
};

const register = () => {
  router.push({ name: "register" });
};
</script>

<template>
  <div class="row justify-content-center">
    <div class="col-lg-8 col-md-10 col-sm-12">
      <h2 class="my-3 py-3 shadow-sm bg-light text-center">
        <mark class="sky">로그인</mark>
      </h2>
    </div>
    <div class="col-lg-8 col-md-10 col-sm-12">
      <form id="form-login" method="POST" action="">
        <!-- <input type="hidden" name="action" value="login"> -->
        <div class="form-check mb-3 float-end">
          <input class="form-check-input" type="checkbox" value="ok" id="saveid" name="saveid" />
          <label class="form-check-label" for="saveid"> 아이디저장 </label>
        </div>
        <div class="mb-3">
          <label for="userid" class="form-label">아이디 : </label>
          <input
            type="text"
            v-model="userid"
            class="form-control"
            id="userid"
            name="userId"
            placeholder="아이디..."
          />
        </div>
        <div class="mb-3">
          <label for="userpwd" class="form-label">비밀번호 : </label>
          <input
            type="password"
            v-model="userpwd"
            class="form-control"
            id="userpwd"
            name="userPwd"
            placeholder="비밀번호..."
          />
        </div>
        <div class="text-danger mb-2"></div>
        <div class="col-auto text-center">
          <button
            @click="login()"
            type="button"
            id="btn-login"
            class="btn btn-outline-primary mb-3"
          >
            로그인
          </button>
          <button
            @click="register()"
            type="button"
            id="btn-mv-join"
            class="btn btn-outline-success mb-3"
          >
            회원가입
          </button>
          <button
            @click="findpwd()"
            type="button"
            id="btn-get-pw"
            class="btn btn-outline-success mb-3"
          >
            비밀번호 찾기
          </button>
        </div>
      </form>
    </div>
    <!-- 추가: userInfo를 출력하는 부분 -->
    <div v-if="userInfo">
      <h3>회원 정보</h3>
      <p>아이디: {{ userInfo.userId }}</p>
      <p>이름: {{ userInfo.userName }}</p>
      <!-- 원하는 다른 정보도 동일한 방식으로 출력 가능 -->
    </div>
  </div>
</template>

<style scoped></style>
