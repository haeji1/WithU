<script setup>
import {ref} from 'vue';
const travels = ref([
    {
        name: "이예진",
        subject: "월미도",
        regiterday: "2023-11-03",
        startday: "2023-03-13",
        arrivalday: "2023-03-14",
        content: "11111",
        image: "/"
    },
    {
        name: "이예진",
        subject: "월미도",
        regiterday: "2023-11-03",
        startday: "2023-03-13",
        arrivalday: "2023-03-14",
        content: "11111",
        image: "/"
    },
    {
        name: "이예진",
        subject: "월미도",
        regiterday: "2023-11-03",
        startday: "2023-03-13",
        arrivalday: "2023-03-14",
        content: "11111",
        image: "/"
    },
])
</script>

<template>
      <div class="col-md-3" v-for="(travel, index) in travels" :key="index">
    <div
      class="card mb-3" >
      <img
        v-bind:src="travel.image"
        class="card-img-top"
        alt="Image 1"
      />
      <div class="card-body">
        <h5 class="card-title">{{ travel.name }}</h5>
        <p class="card-text">{{ travel.content }}</p>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>