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
        <div style="margin-top: 30px; font-size: 20px; margin-left: 13%">우리지역의</div>
        <div id="cultural_font" style="margin-left: 13%">관광지.</div>
        <br />
        <div class="container">
          <div class="row">
            <LocationSiteItem></LocationSiteItem>
          </div>
        </div>

      </section>

</template>

<style scoped>

</style>