<script setup>
import { ref } from "vue";
const boards = ref([
  {
    name: "이예진",
    subject: "여행같이할 사람 구해요",
    regiterday: "2023-11-03",
    startday: "2023-03-13",
    arrivalday: "2023-03-14",
    content: "11111safsfasdfsadfsdafasdfsadfsadfsadfasdadghfffffffffffffffsdasssssssssssssssssssssssssssssssssssssss11111safsfasdfsadfsdafasdfsadfsadfsadfasdadghfffffffffffffffsdasssssssssssssssssssssssssssssssssssssss11111safsfasdfsadfsdafasdfsadfsadfsadfasdadghfffffffffffffffsdasssssssssssssssssssssssssssssssssssssss",
    image: "/",
  },
  {
    name: "이예진",
    subject: "월미도",
    regiterday: "2023-11-03",
    startday: "2023-03-13",
    arrivalday: "2023-03-14",
    content: "11111",
    image: "/",
  },
  {
    name: "이예진",
    subject: "월미도",
    regiterday: "2023-11-03",
    startday: "2023-03-13",
    arrivalday: "2023-03-14",
    content: "11111",
    image: "/",
  },
]);
</script>

<template>
  <div class="col-md-3" v-for="(board, index) in boards" :key="index">
    <div class="card mb-3">
      <img v-bind:src="board.image" class="card-img-top" alt="Image 1" />
      <div class="card-body">
        <h5 class="card-title">{{ board.name }}</h5>
        <p class = "card-text" style="font-size: 15px;">{{ board.regiterday }}</p>
        <p class="card-text">{{ board.content }}</p>
      </div>
    </div>
  </div>
</template>

<style scoped>
  .card-text {
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 1; /* 두 줄만 표시하도록 설정 */
    -webkit-box-orient: vertical;
}
</style>
