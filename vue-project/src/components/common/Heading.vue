<script setup>
import { onMounted, ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

const userInfo = ref(null);
const router = useRouter(); // Vue Router 추가

// const storedUserInfo = sessionStorage.getItem("userinfo");
const user = JSON.parse(sessionStorage.getItem("user"));
// const user = localStorage.setItem("user");
// console.log(localStorage.getItem("user"));
console.log(user);
// console.log(userinfo.userId);
// const username = userinfo.userId;

// console.log(userinfo);
// if (storedUserInfo) {
//   userInfo.value = JSON.parse(storedUserInfo);
// }

const logout = async function () {
  try {
    // 로그아웃을 서버로 요청
    await axios.get("http://192.168.205.82:8080/spring/resmem/logout");
    console.log("logout성공");
    // 로그아웃 후 로그인 페이지로 리다이렉트
    sessionStorage.clear();
    router.push({ name: "login" }).then(() => {
      window.location.reload();
    });
  } catch (error) {
    console.error("Error during logout:", error);
  }
};

function sharePage() {
  window.Kakao.Share.sendCustom({
    templateId: 101114,
    // 카카오톡이 설치 되지 않았을때 마켓으로 이동
    installTalk: true,
  });
}

onMounted(() => {
  const KAKAKO_API_KEY = "768f3c11c8418faef2861489f9b4b0eb";
  window.Kakao.init(KAKAKO_API_KEY);
});
</script>

<template>
  <header>
  <div>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <!-- <div class="container"> -->
      <div class="container-fluid">
        <router-link :to="{ name: 'index' }" class="navbar-brand">
          <img src="@/assets/logo3.png" alt="로고" width="30" height="30" class="d-inline-block align-top" />
        </router-link>
        <!-- <a>Navbar</a> -->

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
          aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
            <ul class="navbar-nav">
              <li class="nav-item dropdown" v-if="user !== null">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                  aria-expanded="false">
                  {{ user }}님 안녕하세요
                </a>
                <ul class="dropdown-menu">
                  <li>
                    <a class="dropdown-item"> <router-link to="/follower">팔로워</router-link></a>
                  </li>
                  <!-- <li><a class="dropdown-item">게시판</a></li> -->
                  <li>
                    <a class="dropdown-item"> <router-link to="/follwing">팔로잉</router-link></a>
                  </li>
                </ul>
              </li>

              <li class="nav-item">
                <a class="nav-link" href="#" @click="sharePage()">페이지 공유하기 </a>
              </li>

              <li class="nav-item">
                <!-- <router-link to="/map"> 지역별여행지 </router-link> -->
                <a class="nav-link active" aria-current="page"><router-link to="/map">지역별여행지</router-link></a>
              </li>
              <li class="nav-item">
                <!-- <router-link to="/map"> 지역별여행지 </router-link> -->
                <a class="nav-link active" aria-current="page"> <router-link to="/board">Q&A</router-link></a>
              </li>
              <!-- <li class="nav-item dropdown">
                  <a
                    class="nav-link dropdown-toggle"
                    href="#"
                    role="button"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                  >
                    게시판
                  </a>
                  <ul class="dropdown-menu">
                    <li>
                      <a class="dropdown-item"> <router-link to="/notice">공지사항</router-link></a>
                    </li>
                    <li>
                      <a class="dropdown-item"> <router-link to="/board">게시판</router-link></a>
                    </li>
                  </ul>
                </li> -->
              <li class="nav-item">
                <a class="nav-link active" aria-current="page"><router-link to="/plan/plan-list">여행계획</router-link></a>
                <!-- <a class="nav-link" href="#">여행계획</a> -->
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                  aria-expanded="false">
                  개인정보관리
                </a>
                <ul class="dropdown-menu">
                  <li>
                    <a class="dropdown-item" v-if="user === null"><router-link to="/member/login">로그인</router-link></a>
                  </li>
                  <li>
                    <a class="dropdown-item" v-if="user !== null" @click="logout()">로그아웃</a>
                  </li>
                  <li>
                    <a class="dropdown-item"><router-link to="/member/mypage">개인정보</router-link></a>
                  </li>
                  <li>
                    <a class="dropdown-item" v-if="user === null"><router-link
                        to="/member/register">회원가입</router-link></a>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  </header>
</template>

<style scoped>
.dropdown:hover .dropdown-menu {
  display: block;
  margin-top: 0;
}

a {
  text-decoration: none;
  color: black;
}

.navbar-brand img {
  width: 80px;
  height: auto;
}
</style>
