<!-- <script setup>
        // <script>
        //   function redirectToLink(link) {
        //     window.location.href = link; // 클릭한 카드에 설정된 링크로 이동합니다.
        //   }
        // </script>


</script> -->
<script setup>
import LocationSiteItem from './LocationSiteItem.vue';
</script>
<template>
  <section>

    <div id="Ourlocation" style="padding-top: 2%;">
      <span style="font-size: 20px;margin-left: 1%">우리 지역의</span>
      <br>
      <span style="font-size: 18px; margin-left: 1%">추천 관광지.</span>
      <br>
      <a class="btn btn-primary" href="/map" role="button"
        style="font-size: 15px; margin-left: 1%; margin-top: 1%;">더보기</a>
    </div>
    <br />
    <div class="container-fluid">
      <div class="row">
        <LocationSiteItem></LocationSiteItem>
      </div>
    </div>
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

a {
  text-decoration: none;
  color: white;
  cursor: pointer;
}
</style>