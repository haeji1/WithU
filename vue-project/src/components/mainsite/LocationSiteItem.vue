<script setup>
import { ref } from 'vue';

const sites = ref([
  {
    name: "한밭수목원",
    content: "대전광역시한밭수목원은 대전광역시의 도심 내의 생물서식 공간 확보 및 학술적·환경교육적 기능수행과 시민휴게공간 기능을 부여하고, 공원시설의 관리운영,도시녹화 및 가로화단 확충사업 추진 등을 위하여 대전광역시청 산하에 설치된 사업소이다.",
    image: "assets/img/site/hanbat.jpg"
  },
  {
    name: "장태산 자연휴양림",
    content: "장태산 자연휴양림은 장태산에 있는 넓이 82.644628 m²의 자연휴양림으로서 대전팔경 중의 하나다. 전국 최초로 민간인이 조성하고 운영되어 왔으나, 2002년 2월 대전광역시에서 인수하고 새로 리모델링해서 2006년 4월 25일 재개장했다.",
    image: "assets/img/site/hanbat.jpg"
  },
  {
    name: "국립중앙과학관",
    content:"국립중앙과학관은 이공학·산업기술·과학기술사 및 자연사에 관한 자료의 수집·보존·연구·전시 및 교육에 관한 사무를 관장하는 대한민국 과학기술정보통신부의 소속기관이다. 1990년 10월 9일에 발족하였으며, 대전광역시 유성구 대덕대로 481에 위치하고 있다",
    image: "assets/img/site/hanbat.jpg"
  },
  {
    name: "국립중앙과학관",
    content:"국립중앙과학관은 이공학·산업기술·과학기술사 및 자연사에 관한 자료의 수집·보존·연구·전시 및 교육에 관한 사무를 관장하는 대한민국 과학기술정보통신부의 소속기관이다. 1990년 10월 9일에 발족하였으며, 대전광역시 유성구 대덕대로 481에 위치하고 있다",
    image: "assets/img/site/hanbat.jpg"
  }
])
</script>
<!-- @click="redirectToLink('/')" -->
<template>
  <div class="col-md-3" v-for="(site, index) in sites" :key="index">
    <div
      class="card mb-3" >
      <img
        v-bind:src="site.image"
        class="card-img-top"
        alt="Image 1"
      />
      <div class="card-body">
        <h5 class="card-title">{{ site.name }}</h5>
        <p class="card-text">{{ site.content }}</p>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
