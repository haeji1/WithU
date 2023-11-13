<script setup></script>

<template>
  <header>
    <div>
      <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <!-- <div class="container"> -->
        <div class="container-fluid">
          <router-link :to="{ name: 'index' }" class="navbar-brand"
            >NavBar</router-link
          >
          <!-- <a>Navbar</a> -->

          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div
            class="collapse navbar-collapse justify-content-end"
            id="navbarNavDropdown"
          >
            <ul class="navbar-nav">
              <li class="nav-item">
                <!-- <router-link to="/map"> 지역별여행지 </router-link> -->

                <a class="nav-link active" aria-current="page"
                  ><router-link to="/map">지역별여행지</router-link></a
                >
              </li>
              <li class="nav-item dropdown">
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
                    <a class="dropdown-item">
                      <router-link to="/notice">공지사항</router-link></a
                    >
                  </li>
                  <!-- <li><a class="dropdown-item">게시판</a></li> -->
                  <li>
                    <a class="dropdown-item">
                      <router-link to="/board">게시판</router-link></a
                    >
                  </li>
                </ul>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">여행계획</a>
              </li>
              <li class="nav-item dropdown">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  개인정보관리
                </a>
                <ul class="dropdown-menu">
                  <li>
                    <a class="dropdown-item"
                      ><router-link to="/member/login">로그인</router-link></a
                    >
                  </li>
                  <li>
                    <a class="dropdown-item"
                      ><router-link to="/member/mypage"
                        >개인정보</router-link
                      ></a
                    >
                  </li>
                  <li>
                    <a class="dropdown-item"
                      ><router-link to="/member/register"
                        >회원가입</router-link
                      ></a
                    >
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
</style>
