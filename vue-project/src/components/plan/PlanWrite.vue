<script setup>
import axios from "axios";
import { useRoute, useRouter } from "vue-router";

import { ref, onMounted, onUnmounted, watch } from "vue";
import { listSido, listGugun } from "@/api/map";
import VSelect from "@/components/common/VSelect.vue";

const isUseId = ref(false);
const router = useRouter();

const user = JSON.parse(sessionStorage.getItem("user"));
const url = import.meta.env.VITE_PLAN_WRITE_API_URL;
const url2 = import.meta.env.VITE_PLAN_TWRITE_API_URL;

const article = ref({
  planNo: 0,
  subject: "",
  content: "",
  userId: "",
  userName: "",
  hit: 0,
  startDate: "",
  endDate: "",
  registerDate: "",
});
const travellist = ref([]);
const articles = ref([]);

const subjectErrMsg = ref("");
const contentErrMsg = ref("");
watch(
  () => article.value.subject,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 30) {
      subjectErrMsg.value = "제목을 확인해 주세요!!!";
    } else subjectErrMsg.value = "";
  }
);
watch(
  () => article.value.content,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 500) {
      contentErrMsg.value = "내용을 확인해 주세요!!!";
    } else contentErrMsg.value = "";
  }
);

function onSubmit() {
  // event.preventDefault();

  if (subjectErrMsg.value) {
    alert(subjectErrMsg.value);
  } else if (contentErrMsg.value) {
    alert(contentErrMsg.value);
  } else {
    writeArticle();
  }
}

async function writeArticle() {
  if (user !== null) {
    console.log("글등록하자!!");
    article.value.userId = user;
    console.log(article.value.userId);
    travellist.value = selectSpotData.value;
    console.log(article);
    console.log("selectSpotData.value : " + selectSpotData.value)
    console.log("travellist.value : " + travellist.value);
    await axios
      .post(url, article.value)
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
    await axios
    .post(url2, travellist.value)
    .then((response) => {
    console.log(response);
    router.push({ name: "plan-list" });
    })
    .catch((error) => {
    console.log(error);
    });
  } else {
    router.push({ name: "login" });
    alert("로그인하세요");
  }
}

const moveList = () => {
  router.push({ name: "plan-list" });
};

const touristSpotData = ref([]);
const selectSpotData = ref([]);
let polyline; // Polyline 객체를 저장할 변수
let map; // Map 객체를 저장할 변수

function drawPath() {
    // 선을 구성하는 좌표 배열입니다. 이 좌표들을 이어서 선을 표시합니다
    var linePath = selectSpotData.value.map(
        (spot) => new kakao.maps.LatLng(spot.y, spot.x)
    );
    console.log(linePath);
    // 기존에 그려진 선이 있다면 지우기
    if (polyline) {
        polyline.setMap(null);
    }

    // 지도에 표시할 선을 생성합니다
    polyline = new kakao.maps.Polyline({
        path: linePath, // 선을 구성하는 좌표배열 입니다
        strokeWeight: 5, // 선의 두께 입니다
        strokeColor: "#800080", // 선의 색깔입니다
        strokeOpacity: 1.0, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
        strokeStyle: "solid", // 선의 스타일입니다
    });

    // 지도에 선을 표시합니다
    polyline.setMap(map);
    getTimeHTML(polyline.getLength());
}
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
    var mapOption = {
        center: new kakao.maps.LatLng(y, x),
        level: 3,
    };

    map = new kakao.maps.Map(mapContainer, mapOption);
    var ps = new kakao.maps.services.Places(map);

    function placesSearchCB(data, status, pagination) {
        touristSpotData.value = [];
        if (status === kakao.maps.services.Status.OK) {
            for (var i = 0; i < data.length; i++) {
                console.log(data[i]);
                touristSpotData.value.push(data[i]);
                displayMarker(data[i]);
            }
        }
    }
    function displayMarker(place) {
        var marker = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(place.y, place.x),
        });

        console.log(marker);
        kakao.maps.event.addListener(marker, "click", function () {
            infowindow.setContent(
                '<div class="wrap" style = "width : 300px; height: 100px;"><div class="info"><div class="title">' +
                place.place_name +
                '</div > <div class="body"><div class="desc"><div class="ellipsis">' +
                place.address_name +
                '</div ><div class="jibun ellipsis">' +
                "전화번호 :" +
                place.phone +
                '<div class="text-right me-2"><button type="button" id = "add-to-trip" class="btn btn-link btn-sm">' +
                "여행경로추가" +
                '</button > <button type="button"id = "close-info" class="btn btn-link btn-sm ms-2">' +
                "닫기" +
                "</button ></div ></div ></div ></div ></div >"
            );
            infowindow.open(map, marker);
            // 이벤트가 바인딩 될 수 있도록 setTimeout을 사용
            setTimeout(() => {
                const addToTripBtn = document.getElementById("add-to-trip");
                const closeInfoBtn = document.getElementById("close-info");

                addToTripBtn.addEventListener("click", function () {
                    // 여행경로추가 버튼을 클릭했을 때의 동작을 여기에 작성
                    console.log("aaa");
                    selectSpotData.value.push(place);
                    console.log("ccc");
                    console.log(place)
                    console.log("ddd")
                    console.log(selectSpotData);
                    drawPath();
                    infowindow.close();
                });

                closeInfoBtn.addEventListener("click", function () {
                    // 닫기 버튼을 클릭했을 때의 동작을 여기에 작성
                    infowindow.close();
                });
            }, 0);
        });
    }
    // Function to update the marker when a card is clicked

    ps.categorySearch("AT4", placesSearchCB, { useMapBounds: true });
    kakao.maps.event.addListener(map, "idle", function () {
        ps.categorySearch("AT4", placesSearchCB, { useMapBounds: true });
    });
>>>>>>> c08282b68a91f6670e6e5191515d9bf5e3cb4dbd
};
onMounted(() => {
  // window.kakao && window.kakao.maps ? initMap() : addKakaoMapScript();
  addKakaoMapScript();
  getSidoList();
});
const addKakaoMapScript = () => {
  const script = document.createElement("script");
  script.onload = () => kakao.maps.load(initMap);
  script.src =
    "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=8a44173e88d925b5f5defa1a5db14942";
  document.head.appendChild(script);
};


watch(selectSpotData, () => {
    drawPath();
});

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
function deleteSpot(id) {
    const index = selectSpotData.value.findIndex((spot) => spot.id === id);
    if (index !== -1) {
        selectSpotData.value.splice(index, 1);
    }
    console.log(selectSpotData);
    drawPath();
}

// 마우스 우클릭 하여 선 그리기가 종료됐을 때 호출하여
// 그려진 선의 총거리 정보와 거리에 대한 도보, 자전거 시간을 계산하여
// HTML Content를 만들어 리턴하는 함수입니다
function getTimeHTML(distance) {
    // 도보의 시속은 평균 4km/h 이고 도보의 분속은 67m/min입니다
    var walkkTime = (distance / 67) | 0;
    var walkHour = "",
        walkMin = "";

    // 계산한 도보 시간이 60분 보다 크면 시간으로 표시합니다
    if (walkkTime > 60) {
        walkHour =
            '<span class="number">' + Math.floor(walkkTime / 60) + "</span>시간 ";
    }
    walkMin = '<span class="number">' + (walkkTime % 60) + "</span>분";

    // 자전거의 평균 시속은 16km/h 이고 이것을 기준으로 자전거의 분속은 267m/min입니다
    var bycicleTime = (distance / 227) | 0;
    var bycicleHour = "",
        bycicleMin = "";

    // 계산한 자전거 시간이 60분 보다 크면 시간으로 표출합니다
    if (bycicleTime > 60) {
        bycicleHour =
            '<span class="number">' + Math.floor(bycicleTime / 60) + "</span>시간 ";
    }
    bycicleMin = '<span class="number">' + (bycicleTime % 60) + "</span>분";

    // 거리와 도보 시간, 자전거 시간을 가지고 HTML Content를 만들어 리턴합니다
    var content = '<ul class="dotOverlay distanceInfo">';
    content += "    <li>";
    content +=
        '        <span class="label">총거리</span><span class="number">' +
        distance +
        "</span>m";
    content += "    </li>";
    content += "    <li>";
    content += '        <span class="label">도보</span>' + walkHour + walkMin;
    content += "    </li>";
    content += "    <li>";
    content +=
        '        <span class="label">자전거</span>' + bycicleHour + bycicleMin;
    content += "    </li>";
    content += "</ul>";

    return content;
}
</script>

<template>
<<<<<<< HEAD
  <div class="pt-4 container-fluid">
    <div class="text-center mb-4 col">
      <h2 class="text-secondary">나의 여행계획</h2>
      <div class="mt-4 container-fluid">
        <div class="row">
          <div class="border col-sm-12 col-md-12 col-lg-2 col-2">
            <div class="row text-center mb-1 mt-3">
              <div class="font-weight-bold col">관광지를 추가하세요!!!</div>
=======
    <div class="pt-4 container-fluid">
        <div class="text-center mb-4 col">
            <h2 class="text-secondary">나의 여행계획</h2>
            <div class="mt-4 container-fluid">
                <div class="row">
                    <!-- <div class="border col-sm-12 col-md-12 col-lg-2 col-2">                                                                                                                                                                                                                                                                                                                                                                               </div> -->
                    <div class="col-sm-12 col-md-12 col-lg-8 col-8">
                        <div class="row mb-6">
                            <div class="col d-flex flex-row-reverse">
                                <VSelect :selectOption="sidoList" @onKeySelect="onChangeSido" />
                            </div>
                            <div class="col">
                                <VSelect :selectOption="gugunList" @onKeySelect="onChangeGugun" />
                            </div>
                        </div>
                        <div id="map" class="map"></div>
                    </div>
                    <div id="attraction-list" class="border pt-3 font-weight-bold col-sm-12 col-md-12 col-lg-2 col-2">
                        <h5>나의 여행 코스!!!</h5>
                        <h6>원하는 장소를 검색해 주가하세요</h6>
                        <div v-for="spot in selectSpotData" :key="spot.id">
                            <div>
                                <div class="card-body">
                                    <div style="overflow: hidden">
                                        <h4 class="card-title">{{ spot.place_name }}</h4>
                                        <p class="card-text">{{ spot.address_name }}</p>
                                        <div style="float: right; margin-bottom: 20px">
                                            <a :href="spot.place_url" target="_blank">
                                                <button type="button" class="btn btn-secondary btn-sm"
                                                    style="float: left; font-size: 13px">
                                                    더보기
                                                </button>
                                            </a>
                                            <button type="button" class="btn btn-danger btn-sm"
                                                style="float: left; font-size: 13px; margin-left: 5px"
                                                @click="deleteSpot(spot.id)">
                                                삭제
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
>>>>>>> c08282b68a91f6670e6e5191515d9bf5e3cb4dbd
            </div>
            <div class="alist overflow-auto" style="max-height: 400px; overflow-y: auto">
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
          <div class="col-sm-12 col-md-12 col-lg-8 col-8">
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
          <div
            id="attraction-list"
            class="border pt-3 font-weight-bold col-sm-12 col-md-12 col-lg-2 col-2"
          >
            <h5>나의 여행 코스!!!</h5>
            <h6>원하는 장소를 검색해 주가하세요</h6>
          </div>
        </div>
<<<<<<< HEAD
      </div>
=======
        <form @submit.prevent="onSubmit">
        <div class="col">
            <div role="group" class="form-group" id="__BVID__270">
                <label for="plan-name" class="d-block" id="__BVID__270__BV_label_">계획 이름:</label>
                <div>
                    <input id="plan-name" type="text" v-model = "article.subject" placeholder="계획 이름" class="form-control" />
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <div role="group" class="form-group" id="__BVID__272">
                        <label for="start-date" class="d-block" id="__BVID__272__BV_label_">출발일:</label>
                        <div>
                            <input id="start-date" v-model="article.startDate" type="date" class="form-control" />
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <div role="group" class="form-group" id="__BVID__274">
                        <label for="end-date" class="d-block" id="__BVID__274__BV_label_">도착일:</label>
                        <div>
                            <input id="end-date" v-model="article.endDate" type="date" class="form-control" />
                        </div>
                    </div>
                </div>
            </div>
            <div role="group" class="form-group" id="__BVID__276">
                <label for="plan-detail" class="d-block" id="__BVID__276__BV_label_">계획 상세:</label>
                <div>
                    <textarea id="plan-detail" v-model="article.content" placeholder="계획 상세 설명..." wrap="soft" class="form-control"
                        style="resize: none; overflow-y: scroll; height: 86px"></textarea>
                </div>
            </div>
            <div class="row">
                <div class="text-center col-12">
                    <button type="button" class="btn mr-1 btn-primary" @click = "writeArticle">
                        여행계획등록</button>
                    <button type="button" class="btn btn-outline-primary" @click = "moveList">
                        여행계획목록
                    </button>
                </div>
            </div>
        </div>
    </form>
>>>>>>> c08282b68a91f6670e6e5191515d9bf5e3cb4dbd
    </div>
  </div>
</template>

<style scoped>
.map {
<<<<<<< HEAD
  width: 100%;
  height: 400px;
}

alist .card-title {
  font-size: 18px;
  /* 원하는 크기로 조절 */
}

.alist .card-text {
  font-size: 14px;
  /* 원하는 크기로 조절 */
}
=======
    width: 100%;
    height: 700px;
}

.row {
    display: flex;
    flex-wrap: wrap;
}

.btn-circle[data-v-21adef22] {
    width: 23px;
    height: 23px;
    text-align: center;
    padding: 0;
    font-size: 11px;
    border-radius: 20px;
    margin-right: 5px;
    margin-bottom: 5px;
    float: right;
}

.btn:not(:disabled):not(.disabled) {
    cursor: pointer;
}
>>>>>>> c08282b68a91f6670e6e5191515d9bf5e3cb4dbd
</style>
