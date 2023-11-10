<script setup>
import Heading from "./components/common/Heading.vue";
// import BoardList from "./components/Board/BoardList.vue";
// import IndexView from "./views/IndexView.vue";
// import RegisterForm from "./components/Member/RegisterForm.vue";
import LocalMapView from "./views/LocalMapView.vue";
</script>

<template>
  <div>
    <Heading></Heading>
    <div>
      <!-- <IndexView></IndexView> -->
      <!-- <RegisterForm></RegisterForm> -->
      <BoardList></BoardList>
      <LocalMapView></LocalMapView>
    </div>
  </div>
</template>

<style scoped></style>