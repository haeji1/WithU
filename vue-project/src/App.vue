<script setup>
import { RouterView } from "vue-router";
import Heading from "./components/common/Heading.vue";
<<<<<<< HEAD
import BoardWriteVue from "./components/Board/BoardWrite.vue";
// import BoardList from "@/components/Board/BoardList.vue";
=======
// import BoardList from "./components/Board/BoardList.vue";
>>>>>>> b6cd7dcbd6271688dffa5cae7c118a35e0a921dc
// import IndexView from "./views/IndexView.vue";
// import RegisterForm from "./components/Member/RegisterForm.vue";
import LocalMapView from "./views/LocalMapView.vue";
</script>

<template>
<<<<<<< HEAD
  
  <div>
   
    <Heading></Heading>
    <router-view></router-view>
    <div>
      <!-- <BoardWriteVue/> -->
      <!-- <IndexView></IndexView> -->
      <!-- <RegisterForm></RegisterForm> -->
=======
  <div>
    <Heading></Heading>
    <div>
      <!-- <IndexView></IndexView> -->
      <!-- <RegisterForm></RegisterForm> -->
      <BoardList></BoardList>
      <LocalMapView></LocalMapView>
>>>>>>> b6cd7dcbd6271688dffa5cae7c118a35e0a921dc
    </div>
  </div>
</template>

<style scoped></style>