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
      map: null
    }
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
      // 해당 앱키의 값은 추후 변경해야할것(현재 테스트용으로 개인키 입력)
      script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=535a433c3c050386816ac3b2426f18ce&autoload=false"
      script.onload = () => window.kakao.maps.load(this.loadMap);

      document.head.appendChild(script);
    },
    loadMap() {
      const container = document.getElementById("map");
      const options = {
        //좌표값 설정
        center: new window.kakao.maps.LatLng(this.latitude, this.longitude),
        level: 4
      };

      this.map = new window.kakao.maps.Map(container, options);
      this.loadMaker();
    },
    loadMaker() {
      const markerPosition = new window.kakao.maps.LatLng(this.latitude, this.longitude);

      const marker = new window.kakao.maps.Marker({
        position: markerPosition
      });

      marker.setMap(this.map);
    }
  }
};
</script>

<template>
  <div>
    <div id="map"></div>
  </div>
</template>

<style scoped>
#map {
  width: 80%;
  height: 500px;
}
</style>