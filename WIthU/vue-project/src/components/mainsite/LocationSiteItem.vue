<script setup>
import { ref, onMounted } from "vue";
const touristSpotData = ref([]);
const location = ref([]);
const lat2 = ref();
const lon2 = ref();
const initMap = () => {
  var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
      center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
      level: 11 // 지도의 확대 레벨 
    };

  var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
  var ps = new kakao.maps.services.Places(map);
  // HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
  if (navigator.geolocation) {

    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.getCurrentPosition(function (position) {

      var lat = position.coords.latitude, // 위도
        lon = position.coords.longitude; // 경도
      location.value.push(lat, lon);
      lat2.value = lat;
      lon2.value = lon;
      var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
        message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다

      // 마커와 인포윈도우를 표시합니다
      displayMarker(locPosition, message);
      ps.categorySearch('AT4', placesSearchCB, { useMapBounds: true });
    });

  } else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다

    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),
      message = 'geolocation을 사용할수 없어요..'
    lat2.value = 33.450701;
    lon2.value = 126.570667;
    displayMarker(locPosition, message);
    ps.categorySearch('AT4', placesSearchCB, { useMapBounds: true });
  }

  // 지도에 마커와 인포윈도우를 표시하는 함수입니다
  function displayMarker(locPosition, message) {

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
      map: map,
      position: locPosition
    });

    var iwContent = message, // 인포윈도우에 표시할 내용
      iwRemoveable = true;

    // 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow({
      content: iwContent,
      removable: iwRemoveable
    });

    // 인포윈도우를 마커위에 표시합니다 
    infowindow.open(map, marker);

    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);
  }
  // 카테고리로 은행을 검색합니다


  // 키워드 검색 완료 시 호출되는 콜백함수 입니다
  function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {
      for (var i = 0; i < data.length; i++) {
        console.log(data[i])
        touristSpotData.value.push(data[i]);
      }
    }
  }
};
onMounted(() => {
  addKakaoMapScript();
});

// app key 넣기
const addKakaoMapScript = () => {
  const script = document.createElement("script");
  script.onload = () => kakao.maps.load(initMap);
  script.src =
    "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=???";
  document.head.appendChild(script);
};

</script>
<template>
  <div id="map"></div>
  <div class="col-md-3" v-for="(site, index) in touristSpotData.slice(0, 8)" :key="index">
    <div class="card mb-3">
      <a :href="site.place_url" target="_blank">
        <!-- <img v-bind:src="site.image" class="card-img-top" alt="Image 1" /> -->
        <div class="card-body">
          <h5 class="card-title text-center">{{ site.place_name }}</h5>
          <!-- <p class="card-text">{{ site.address_name }}</p> -->
        </div>
      </a>
    </div>
  </div>
</template>

<style scoped>
#map {
  height: 0px;
}
.card-body{
  color: #222222;
}
</style>
