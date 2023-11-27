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
    <!-- <div class="col-md-3" v-for="(site, index) in sites" :key="index">
      <div class="card mb-3">
        <img v-bind:src="site.image" class="card-img-top" alt="Image 1" />
        <div class="card-body">
          <h5 class="card-title">{{ site.name }}</h5>
          <p class="card-text">{{ site.content }}</p>
        </div>
      </div>
    </div> -->
    <div id="map" class="map"></div>
    <br />
    <br />

    <div class="row">
      <div v-for="spot in touristSpotData" :key="spot.id" class="col-md-3">
        <a :href="spot.place_url" target="_blank">
          <div class="card mb-3">
            <div class="card-body">
              <h3 class="card-title">{{ spot.place_name }}</h3>
              <p class="card-text">{{ spot.address_name }}</p>
            </div>
          </div>
        </a>
      </div>
    </div>
  </div>
</template>
<style>
.map {
  width: 100%;
  height: 400px;
}

.row a {
  text-decoration: none;
  color: inherit;
  cursor: pointer;
}

.tourist-spot-container {
  display: flex;
  flex-wrap: wrap;
}

.tourist-spot-card {
  width: 100%;
  border: 1px solid #ccc;
  /* Add styling as needed */
  padding: 16px;
  box-sizing: border-box;
}
</style>
<script setup>
import { ref, onMounted, onUnmounted } from "vue";
import { listSido, listGugun } from "@/api/map";
import VSelect from "@/components/common/VSelect.vue";
const touristSpotData = ref([]);
const initMap = (initialCenter) => {
  var infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
  var mapContainer = document.getElementById("map");
  console.log(initialCenter);
  var y = 37.566826;
  var x = 126.9786567;
  if (initialCenter) {
    x = initialCenter.La;
    y = initialCenter.Ma;
  }
  if (!initialCenter) {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function (position) {
        (x = position.coords.latitude), (y = position.coords.longitude);
      });
    } else {
      console.log("bbb");
      x = 37.566826;
      y = 126.9786567;
    }
  }
  var mapOption = {
    center: new kakao.maps.LatLng(y, x),
    level: 3,
  };

  var map = new kakao.maps.Map(mapContainer, mapOption);
  var ps = new kakao.maps.services.Places(map);

  function placesSearchCB(data, status, pagination) {
    touristSpotData.value = [];
    if (status === kakao.maps.services.Status.OK) {
      for (var i = 0; i < data.length; i++) {
        touristSpotData.value.push(data[i]);
        // console.log(touristSpotData);
        // console.log(touristSpotData.value.x);
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
        '<div style="padding:5px;font-size:12px;">' + place.place_name + "</div>"
      );
      infowindow.open(map, marker);
    });
  }
  // Function to update the marker when a card is clicked

  ps.categorySearch("AT4", placesSearchCB, { useMapBounds: true, size: 3 });
  kakao.maps.event.addListener(map, "idle", function () {
    ps.categorySearch("AT4", placesSearchCB, { useMapBounds: true, size: 15 });
  });

  // var mapTypeControl = new kakao.maps.MapTypeControl();
  // map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

  // var zoomControl = new kakao.maps.ZoomControl();
  // map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
};
onMounted(() => {
  // window.kakao && window.kakao.maps ? initMap() : addKakaoMapScript();
  addKakaoMapScript();
  getSidoList();
});

// app key 넣기
const addKakaoMapScript = () => {
  const script = document.createElement("script");
  script.onload = () => kakao.maps.load(initMap);
  script.src =
    "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=???";
  document.head.appendChild(script);
};

// const serviceKey = import.meta.env.VITE_OPEN_API_SERVICE_KEY;
const param = ref({
  zscode: "", // or provide default values as needed
});

const sidoList = ref([]);
const gugunList = ref([{ text: "구군선택", value: "" }]);
const totalsidogugun = ref("");

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
    var tmp = totalsidogugun.value + " " + selectedGugun.text;
    // totalsidogugun.value += " " + selectedGugun.text;
    // 주소 검색을 통해 좌표 획득
    console.log(totalsidogugun);
    var geocoder = new window.kakao.maps.services.Geocoder();
    // geocoder.addressSearch(totalsidogugun.value, function (result, status) {
    geocoder.addressSearch(tmp, function (result, status) {
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
