<script setup></script>

<template>
  <div>
  <div id="wrapper" class="container row" style="float: none; margin: 100 auto">
    <!-- <div class="col-md-3" style="float: none; margin: 0 auto">
      <div class="col-lg-8 col-md-10 col-sm-12"> -->
    <h2 class="my-3 py-3 shadow-sm bg-light text-center">
      <mark class="orange">회원가입</mark>
    </h2>
  </div>
  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-2 col-form-label">닉네임</label>
    <div class="col-sm-10">
      <input type="id" class="form-control" id="inputEmail3" />
    </div>
  </div>
  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-10">
      <input type="id" class="form-control" id="inputEmail3" />
    </div>
  </div>
  <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" />
    </div>
  </div>

  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-2 col-form-label">이메일</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="inputEmail3" />
    </div>
  </div>

  <div class="col-auto text-center">
    <button id="btn" type="submit" class="btn btn-primary">Sign in</button>
    <!-- </div>
  </div> -->
  </div>
</div>
</template>

<style scoped>
/* * {
  text-align: center;
} */
#wrapper {
  width: 300px;
  margin: auto;
}
#btn {
  display: inline-block;
}
.form-control {
  border: 1px round aliceblue;
  width: 25%;
}
.row {
  text-align: center;
}
</style>