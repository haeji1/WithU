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
      alert("다시하세요;;");
      window.location.reload();
      // console.log(response.data.resmsg);
    }

    // 여기서 필요한 추가 작업을 수행할 수 있습니다.
  } catch (error) {
    console.error("Error during login:", error.response);
  }
};
</script>

<template>
  <div class="container">
    <div class="login-left">
      <div class="login-header">
        <h1 class="welcom-message">WithU</h1>
      </div>
      <form class="login-form">
        <div class="login-form-content">
          <div class="form-item">
            <label for="email">Id</label>
            <input type="text" v-model="userid" id="userid" name="userId" />
          </div>
          <div class="form-item">
            <label for="password">Password</label>
            <input type="password" v-model="userpwd" id="userpwd" name="userPwd" />
          </div>
          <div class="form-item">
            <div class="checkbox">
              <input type="checkbox" id="rememberMeCheckbox" checked />
              <label for="rememberMeCheckbox" class="checkboxLabel">Remember Me</label>
            </div>
          </div>
          <button type="submit" @click="login()">로그인</button>
        </div>
      </form>
    </div>
    <div class="login-right">
      <img class="login-image" src="../../img/city/berlin.jpg" alt="" />
      <img class="login-image" src="../../img/city/london.jpg" alt="" />
      <img class="login-image" src="../../img/city/paris2.jpg" alt="" />
    </div>
  </div>
</template>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  height: 100vh;
  padding: 0;
  margin: 0;
  font-family: "Inter" sans-serif;
  background: linear-gradient(45deg, #f9f5d5, #ffab73);
  padding: 40px;
  background-repeat: no-repeat;
}

.container {
  margin-top: 110px;
  display: flex;
  justify-content: center;
  overflow: hidden;
}

.login-left {
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding-left: 150px;
  border-top-left-radius: 30px;
  border-bottom-left-radius: 30px;
  background-color: white;
  padding: 50px !important;
}

.login-left .welcom-message {
  font-weight: bold;
}
.login-right {
  background-color: #eee;
  display: flex;
  border-top-right-radius: 30px;
  border-bottom-right-radius: 30px;
  justify-content: center;
  position: relative;
  width: 400px;
}

.login-image {
  position: absolute;
  border-top-right-radius: 30px;
  border-bottom-right-radius: 30px;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  opacity: 1;
  transition: opacity 1s ease-in-out;
}

.login-header {
  margin-bottom: 50px;
}

.welcome-message {
  font-size: 40px;
  margin-bottom: 10px;
}

.login-form {
  width: 450px;
  width: 100%;
}

.login-form-content {
  display: flex;
  flex-direction: column;
  gap: 35px;
}

.login-header {
  text-align: center;
}

.login-form-footer {
  display: flex;
  gap: 30px;
  margin-top: 70px;
  flex-direction: column;
}

.login-form-footer > a {
  flex: 6;
  border: 1px solid black;
  justify-content: center;
  display: flex;
  align-items: center;
  color: black;
  text-decoration: none;
  padding: 10px;
}

.login-form-footer > a:hover {
  background-color: #eee;
}

.form-item label:not(.checkboxLabel) {
  display: inline-block;
  background-color: white;
  margin-bottom: 10px;
  position: absolute;
  padding: 0 10px;
  transform: translate(30px, -10px);
  font-size: 14px;
}

input[type="text"],
input[type="password"] {
  border: 1px solid black;
  height: 55px;
  padding: 0 2rem;
  outline: none;
  font-size: 18px;
}

.checkbox {
  display: flex;
  align-items: center;
  gap: 7px;
}

input[type="checkbox"] {
  width: 20px;
  height: 20px;
  accent-color: #131086;
}

button {
  border: none;
  background: linear-gradient(45deg, #f9f5d5, #ffab73);
  color: black;
  padding: 1rem;
  text-align: center;
  text-transform: uppercase;
  font-size: 18px;
  height: 55px;
  cursor: pointer;
}

@media (max-width: 768px) {
  body {
    padding: 20px;
  }

  .container {
    grid-template-columns: auto;
  }

  .login-left {
    border-top-right-radius: 30px;
    border-bottom-right-radius: 30px;
  }

  .login-right {
    display: none;
  }
}
</style>
