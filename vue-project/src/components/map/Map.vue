<script>
export default {
  name: "MapKakao",
  props: {
    latitude: {
      type: Number,
      required: true,
    },
    longitude: {
      type: Number,
      required: true,
    },
  },
  data() {
    return {
      map: null,
    };
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.loadMap();
    } else {
      this.loadScript();
    }
  },
  methods: {
    loadScript() {
      const script = document.createElement("script");
      script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=535a433c3c050386816ac3b2426f18ce&autoload=false";
      script.onload = () => window.kakao.maps.load(this.loadMap);
      document.head.appendChild(script);
    },
    loadMap() {
      // 현재 위치를 가져오기
      navigator.geolocation.getCurrentPosition(
        (position) => {
          const lat = position.coords.latitude;
          const lon = position.coords.longitude;

          const locPosition = new window.kakao.maps.LatLng(lat, lon);

          // 지도 생성
          this.map = new window.kakao.maps.Map(document.getElementById("map"), {
            center: locPosition,
            level: 13,
          });

          // 마커 생성 및 표시
          const marker = new window.kakao.maps.Marker({
            position: locPosition,
            map: this.map,
          });

          // 인포윈도우 생성 및 표시
          const infowindow = new window.kakao.maps.InfoWindow({
            content: "현재 위치",
          });
          infowindow.open(this.map, marker);
        },
        (error) => {
          console.error("Error getting geolocation:", error);

          // 현재 위치 정보를 가져오지 못하면 서울의 좌표로 기본값 설정
          const defaultPosition = new window.kakao.maps.LatLng(37.5665, 126.9780);

          // 지도 생성
          this.map = new window.kakao.maps.Map(document.getElementById("map"), {
            center: defaultPosition,
            level: 10,  // 레벨을 조정하여 디폴트 위치의 지도를 확대/축소할 수 있습니다.
          });
        }
      );
    },
  },
};

</script>

<template>
  <div>
    <div id="map"></div>
  </div>
</template>

<style scoped>
#map {
  width: 90%;
  height: 500px;
}
</style>