<script setup></script>

<template>
  <header>
    <div>
      <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <!-- <div class="container"> -->
        <div class="container-fluid">
          <router-link :to="{ name: 'index' }" class="navbar-brand">NavBar</router-link>
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
          <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
            <ul class="navbar-nav">
              <li class="nav-item">
                <router-link to="/map"> 지지지지역별 </router-link>

                <a href="/map" class="nav-link active" aria-current="page">지역별여행지</a>
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
                    <a href="/notice" router-link to="{ name: 'notice'}" class="dropdown-item"
                      >공지사항</a
                    >
                  </li>
                  <!-- <li><a class="dropdown-item">게시판</a></li> -->
                  <li>
                    <a href="/board" router-link to="{ name: 'board' }" class="dropdown-item"
                      >게시판</a
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
                    <a href="/member/login" router-link to="{name: 'login'}" class="dropdown-item"
                      >로그인</a
                    >
                  </li>
                  <li>
                    <a
                      href="/member/mypage"
                      router-link
                      to="{ name: 'member'}"
                      class="dropdown-item"
                      >개인정보</a
                    >
                  </li>
                  <li>
                    <a
                      href="/member/register"
                      router-link
                      to="{ name: 'member'}"
                      class="dropdown-item"
                      >회원가입</a
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
</style>
