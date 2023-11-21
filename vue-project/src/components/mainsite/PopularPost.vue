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
        <PopularPostItem></PopularPostItem>
      </div>
    </div>
    <a class="btn btn-primary" href="/board/artcle-list" role="button"
      style="font-size: 15px; margin-left: 1%; margin-top: 1%;">더보기</a>
  </section>
</template>

<style scoped>
.row {
  padding-left: 20px;
  padding-right: 20px;
}

section {
  background-color: thistle;
  padding-bottom: 1%;
}
</style>