<script setup></script>

<template>
  <div>
    <h2 class="my-3 py-3 text-center">
      <mark class="orange">회원가입</mark>
    </h2>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <div class="mb-3">
            <label for="inputNickname" class="form-label">닉네임</label>
            <input type="text" class="form-control" id="inputNickname" />
          </div>
          <div class="mb-3">
            <label for="inputId" class="form-label">아이디</label>
            <input type="text" class="form-control" id="inputId" />
          </div>
          <div class="mb-3">
            <label for="inputPassword" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="inputPassword" />
          </div>
          <div class="mb-3">
            <label for="inputEmail" class="form-label">이메일</label>
            <input type="email" class="form-control" id="inputEmail" />
          </div>
          <div class="text-center">
            <button id="btn" type="submit" class="btn btn-primary">Sign in</button>
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