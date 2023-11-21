<script setup>
import Footer from "../components/common/Footer.vue";
import Top from "../components/mainsite/Top.vue";
import LocationSite from "../components/mainsite/LocationSite.vue";
import MyItinerary from "../components/mainsite/MyItinerary.vue";
import PopularPost from "../components/mainsite/PopularPost.vue";
import NoticeSite from "../components/mainsite/NoticeSite.vue";
</script>

<template>
  <div>
    <!-- <head></head> -->
    <Top></Top>
    <NoticeSite></NoticeSite>
    <LocationSite></LocationSite>
    <MyItinerary></MyItinerary>
    <PopularPost></PopularPost>
    <Footer></Footer>
  </div>
</template>

<style scoped></style>
