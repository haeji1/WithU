<script setup>
import { RouterView } from "vue-router";
import Heading from "./components/common/Heading.vue";
import BoardWriteVue from "./components/Board/BoardWrite.vue";
// import BoardList from "@/components/Board/BoardList.vue";
// import IndexView from "./views/IndexView.vue";
// import RegisterForm from "./components/Member/RegisterForm.vue";

</script>

<template>
  
  <div>
   
    <Heading></Heading>
    <router-view></router-view>
    <div>
      <!-- <BoardWriteVue/> -->
      <!-- <IndexView></IndexView> -->
      <!-- <RegisterForm></RegisterForm> -->
    </div>
  </div>
</template>

<style scoped>

</style>