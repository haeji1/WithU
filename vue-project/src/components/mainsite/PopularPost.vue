<script setup>
import PopularPostItem from './PopularPostItem.vue';


</script>

<template>
  <section>
    <div id="Ourlocation" style="padding-top: 2%;">
      <span style="font-size: 20px;margin-left: 1%">인기글</span>
      <br>
    </div>
    <br />
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-3">
            <a>제목</a>
        </div>
        <div class="col-md-3">
            <a>HITS</a>
        </div>
        <div class="col-md-3">
            <a>아이디</a>
        </div>
        <div class="col-md-3">
            <a>등록일</a>
        </div>
    </div>
    <br>
      <div class="row">
        <PopularPostItem></PopularPostItem>
      </div>
    </div>
    <a class="btn btn-light" href="/board/article-list" role="button"
      style="font-size: 15px; margin-left: 1%; margin-top: 1%; color: #e18aaa;">더보기</a>
  </section>
</template>

<style scoped>
.row {
  padding-left: 20px;
  padding-right: 20px;
}

section {
  background-color: #ecbdc4;
  padding-bottom: 1%;
}
</style>