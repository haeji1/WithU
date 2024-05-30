<script setup>
import MyItineraryItem from './MyItineraryItem.vue';


</script>

<template>
    <section>
        <div id = "Myitinerary" style="padding-top: 2%; padding-bottom: 2%;">
          <span style="font-size: 20px;margin-left: 1%">나의 여행계획</span>
          <br>
          <span style="font-size: 15px; margin-left: 1%">나의 여행계획을 소개합니다.  </span>
          <br>
          <a class="btn btn-light" href="/plan/plan-list" role="button" style="font-size: 15px; margin-left: 1%; margin-top: 1%; color: #e18aaa;">더보기</a>
        </div>
        <div class="container-fluid">
          <div class="row">
            <MyItineraryItem></MyItineraryItem>
            
          </div>
        </div>
    </section>
</template>

<style scoped>
  .row{
    padding-left: 20px;
    padding-right: 20px;
  }
  section{
    background-color: #efcfd4;
    padding-bottom: 1%;
  }
</style>