<template>
  <div class="container-fluid">
    <div class="row mb-2">
      <div class="col d-flex flex-row-reverse">
        <VSelect :selectOption="sidoList" @onKeySelect="onChangeSido" />
      </div>
      <div class="col">
        <VSelect :selectOption="gugunList" @onKeySelect="onChangeGugun" />
      </div>
    </div>
    <div id="map" class="map"></div>
  </div>
</template>
<!-- <script>
export default {
  mounted() {
    window.kakao && window.kakao.maps
      ? this.initMap()
      : this.addKakaoMapScript();
  },
  methods: {
    addKakaoMapScript() {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=8a44173e88d925b5f5defa1a5db14942";
      document.head.appendChild(script);
    },
    initMap() {
      var infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
          level: 3, // 지도의 확대 레벨
        };

      // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
      var map = new kakao.maps.Map(mapContainer, mapOption);
      // 장소 검색 객체를 생성합니다
      var ps = new kakao.maps.services.Places(map);

      // // 카테고리로 은행을 검색합니다
      // ps.categorySearch("BK9", placesSearchCB, { useMapBounds: true });

      // 키워드 검색 완료 시 호출되는 콜백함수 입니다
      function placesSearchCB(data, status, pagination) {
        if (status === kakao.maps.services.Status.OK) {
          for (var i = 0; i < data.length; i++) {
            console.log(data[i]);
            displayMarker(data[i]);
          }
        }
      }
      // 지도에 마커를 표시하는 함수입니다
      function displayMarker(place) {
        // 마커를 생성하고 지도에 표시합니다
        var marker = new kakao.maps.Marker({
          map: map,
          position: new kakao.maps.LatLng(place.y, place.x),
        });

        // 마커에 클릭이벤트를 등록합니다
        kakao.maps.event.addListener(marker, "click", function () {
          // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
          infowindow.setContent(
            '<div style="padding:5px;font-size:12px;">' +
              place.place_name +
              "</div>"
          );
          infowindow.open(map, marker);
        });
      }
      // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
      var mapTypeControl = new kakao.maps.MapTypeControl();

      // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
      // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
      map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

      // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
      var zoomControl = new kakao.maps.ZoomControl();
      map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
      // 확대하거나 중심 이동할 때
      kakao.maps.event.addListener(map, "idle", function () {
        // 카테고리로 은행을 검색합니다
        ps.categorySearch("AT4", placesSearchCB, { useMapBounds: true });
      });

      // 개별적인 주소의 좌표 출력
      // var geocoder = new kakao.maps.services.Geocoder();

      // geocoder.addressSearch("서울시 동대문구", callback);
    },
  },
};
</script> -->

<style>
.map {
  width: 100%;
  height: 400px;
}
</style>
<!-- <script setup>
import { ref, onMounted } from "vue";
import { listSido, listGugun } from "@/api/map";
import VSelect from "@/components/common/VSelect.vue";

// const serviceKey = import.meta.env.VITE_OPEN_API_SERVICE_KEY;
const param = ref({
  zscode: "", // or provide default values as needed
});

const sidoList = ref([]);
const gugunList = ref([{ text: "구군선택", value: "" }]);
const totalsidogugun = ref("");
onMounted(() => {
  getSidoList();
});

const getSidoList = () => {
  listSido(
    ({ data }) => {
      let options = [];
      options.push({ text: "시도선택", value: "" });
      data.forEach((sido) => {
        options.push({ text: sido.sidoName, value: sido.sidoCode });
      });
      sidoList.value = options;
    },
    (err) => {
      console.log(err);
    }
  );
};
const onChangeSido = (val) => {
  // 찾고자 하는 시/도의 객체를 찾음
  const selectedSido = sidoList.value.find((item) => item.value === val);
  listGugun(
    { sido: val },
    ({ data }) => {
      let options = [];
      options.push({ text: "구군선택", value: "" });
      data.forEach((gugun) => {
        options.push({ text: gugun.gugunName, value: gugun.gugunCode });
        // 선택된 시/도의 text를 가져와서 출력
        totalsidogugun.value = selectedSido.text;
      });
      // console.log(sidoList.value);
      gugunList.value = options;
    },
    (err) => {
      console.log(err);
    }
  );
};

const onChangeGugun = (val) => {
  // param.value.zscode = val;
  // console.log(param.value);
  const selectedGugun = gugunList.value.find((item) => item.value === val);
  if (selectedGugun) {
    totalsidogugun.value += " " + selectedGugun.text;
    // 주소 검색을 통해 좌표 획득
    var geocoder = new window.kakao.maps.services.Geocoder();
    // geocoder.addressSearch(totalsidogugun.value, function (result, status) {
    // });

    
  }
};
</script> -->
<script setup>
import { ref, onMounted } from "vue";
import { listSido, listGugun } from "@/api/map";
import VSelect from "@/components/common/VSelect.vue";
// var infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
//   var mapContainer = document.getElementById("map");
//   var mapOption = {
//     center: new kakao.maps.LatLng(37.566826, 126.9786567),
//     level: 3,
//   };

//   var map = new kakao.maps.Map(mapContainer, mapOption);
//   var ps = new kakao.maps.services.Places(map);

//   function placesSearchCB(data, status, pagination) {
//     if (status === kakao.maps.services.Status.OK) {
//       for (var i = 0; i < data.length; i++) {
//         console.log(data[i]);
//         displayMarker(data[i]);
//       }
//     }
//   }

//   function displayMarker(place) {
//     var marker = new kakao.maps.Marker({
//       map: map,
//       position: new kakao.maps.LatLng(place.y, place.x),
//     });

//     kakao.maps.event.addListener(marker, "click", function () {
//       infowindow.setContent(
//         '<div style="padding:5px;font-size:12px;">' +
//           place.place_name +
//           "</div>"
//       );
//       infowindow.open(map, marker);
//     });
//   }

//   var mapTypeControl = new kakao.maps.MapTypeControl();
//   map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

//   var zoomControl = new kakao.maps.ZoomControl();
//   map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

//   kakao.maps.event.addListener(map, "idle", function () {
//     ps.categorySearch("AT4", placesSearchCB, { useMapBounds: true });
//   });
const initMap = (initialCenter) => {
  var infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
  var mapContainer = document.getElementById("map");
  console.log(initialCenter);
  var y = 37.566826;
  var x = 126.9786567;
  if(initialCenter){
    x = initialCenter.La;
    y = initialCenter.Ma;
  }
  if(!initialCenter){
    if (navigator.geolocation){
      navigator.geolocation.getCurrentPosition(function(position){
        x = position.coords.latitude,
        y = position.coords.longitude
      }
      )
    }
    else{
      x = 37.566826;
      y = 126.9786567;
    }
  }
  console.log(x,y)
  var mapOption = {
    center: new kakao.maps.LatLng(y, x),
    level: 3,
  };

  var map = new kakao.maps.Map(mapContainer, mapOption);
  var ps = new kakao.maps.services.Places(map);

  function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {
      for (var i = 0; i < data.length; i++) {
        console.log(data[i]);
        displayMarker(data[i]);
      }
    }
  }

  function displayMarker(place) {
    var marker = new kakao.maps.Marker({
      map: map,
      position: new kakao.maps.LatLng(place.y, place.x),
    });

    kakao.maps.event.addListener(marker, "click", function () {
      infowindow.setContent(
        '<div style="padding:5px;font-size:12px;">' +
          place.place_name +
          "</div>"
      );
      infowindow.open(map, marker);
    });
  }

  var mapTypeControl = new kakao.maps.MapTypeControl();
  map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

  var zoomControl = new kakao.maps.ZoomControl();
  map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

  kakao.maps.event.addListener(map, "idle", function () {
    ps.categorySearch("AT4", placesSearchCB, { useMapBounds: true });
  });
};

onMounted(() => {
  window.kakao && window.kakao.maps ? initMap() : addKakaoMapScript();
});

const addKakaoMapScript = () => {
  const script = document.createElement("script");
  script.onload = () => kakao.maps.load(initMap);
  script.src =
    "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=8a44173e88d925b5f5defa1a5db14942";
  document.head.appendChild(script);
};


// const serviceKey = import.meta.env.VITE_OPEN_API_SERVICE_KEY;
const param = ref({
  zscode: "", // or provide default values as needed
});

const sidoList = ref([]);
const gugunList = ref([{ text: "구군선택", value: "" }]);
const totalsidogugun = ref("");
onMounted(() => {
  getSidoList();
});

const getSidoList = () => {
  listSido(
    ({ data }) => {
      let options = [];
      options.push({ text: "시도선택", value: "" });
      data.forEach((sido) => {
        options.push({ text: sido.sidoName, value: sido.sidoCode });
      });
      sidoList.value = options;
    },
    (err) => {
      console.log(err);
    }
  );
};
const onChangeSido = (val) => {
  // 찾고자 하는 시/도의 객체를 찾음
  const selectedSido = sidoList.value.find((item) => item.value === val);
  listGugun(
    { sido: val },
    ({ data }) => {
      let options = [];
      options.push({ text: "구군선택", value: "" });
      data.forEach((gugun) => {
        options.push({ text: gugun.gugunName, value: gugun.gugunCode });
        // 선택된 시/도의 text를 가져와서 출력
        totalsidogugun.value = selectedSido.text;
      });
      // console.log(sidoList.value);
      gugunList.value = options;
    },
    (err) => {
      console.log(err);
    }
  );
};

const onChangeGugun = (val) => {
  // param.value.zscode = val;
  // console.log(param.value);
  const selectedGugun = gugunList.value.find((item) => item.value === val);
  if (selectedGugun) {
    totalsidogugun.value += " " + selectedGugun.text;
    // 주소 검색을 통해 좌표 획득
    var geocoder = new window.kakao.maps.services.Geocoder();
    // geocoder.addressSearch(totalsidogugun.value, function (result, status) {
          geocoder.addressSearch(totalsidogugun.value, function (result, status) {
      if (status === window.kakao.maps.services.Status.OK) {
        // 좌표를 획득한 경우, 지도 이동
        var coords = new window.kakao.maps.LatLng(result[0].y, result[0].x);
        initMap(coords);
      } else {
        console.log("Geocoder failed due to: " + status);
      }
    });

    
  }
};
</script>
