<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import CommentWrite from "../comment/CommentWrite.vue";
// import BoardFormItem from "./item/BoardFormItem.vue";

const route = useRoute();
const router = useRouter();

const url = import.meta.env.VITE_PLAN_VIEW_API_URL;
const followurl = import.meta.env.VITE_FOLLOW_FOLLOW_API_URL;
const user = JSON.parse(sessionStorage.getItem("user"));
// const durl = import.meta.env.VITE_BOARD_DELETE_API_URL;
let tripsmemo = ref([]);
// follow 유저 아이디 세팅
const follow = ref({
    userId: "",
    followId: "",
});
const spotdatas = [{
    planNo: 0,
    travelNo: 0,
    address_name: '',
    phone: '',
    place_name: '',
    place_url: '',
    x: '',
    y: '',
}];
const articles = ref({});
const trips = ref([]);
// const comment = ref({});
const selectSpotData = ref([]);
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
}
onMounted(() => {
    getArticles();
});
var points = [];
const getArticles = () => {
    axios
        .get(url, {
            params: {
                planNo: route.params.articleno,
            },
        })
        .then(({ data }) => {
            console.log(data.resdata);
            articles.value = data.resdata;
            trips.value = data.restravel;

            for (let i = 0; i < trips.value.length; i++) {
                points.push(new kakao.maps.LatLng(trips.value[i].y, trips.value[i].x));
                var tmp = trips.value[i];
                spotdatas.push({
                    planNo: tmp.planNo,
                    travelNo: tmp.travelNo,
                    phone: tmp.phone,
                    address_name: tmp.address_name,
                    place_name: tmp.place_name,
                    place_url: tmp.place_url,
                    x: tmp.x,
                    y: tmp.y
                })
            }

            // 마커 생성 및 LatLngBounds에 추가
            initMap(points, spotdatas);
            // comment.value.articleNo = route.params.articleno;
            // comment.value.userId = user;
        })
        .catch((error) => {
            console.log(error);
        });
};
function moveList() {
    router.push({ name: "plan-list" });
}

// function moveModify() {
//     router.push({
//         name: "article-modify",
//     });
// }

function onFollowUser() {
    if (user === articles.value.userId) {
        alert("자기자신을 팔로우 할 수 없습니다.")
    }
    else {
        alert(`${articles.value.userId} 님을 팔로우합니다.`);
        follow.value.userId = user;
        follow.value.followId = articles.value.userId;
        axios
            .post(followurl, follow.value)
            .then((response) => {
                console.log(response);
                router.push({ name: "following" });
            })
            .catch((error) => {
                console.log(error);
            });
    }

}

// function onDeleteArticle() {
//     console.log(route.params.articleno + "번글 삭제하러 가자!!!");
//     axios
//         .delete(`http://localhost:8080/spring/resboard/delete/${route.params.articleno}`)
//         .then((response) => {
//             console.log(`Deleted post with ID ${route.params.articleno}`);
//             alert("삭제되었습니다");
//             router.push({ name: "article-list" });
//         })
//         .catch((error) => {
//             console.error(error);
//         });
// }


// coordinates 배열 출력
console.log(tripsmemo);

// // for 문을 사용하여 x 및 y 값을 추출하고 coordinates 배열에 저장
// for (let i = 0; i < tripsmemo.value.length; i++) {
//     const tmp = tripsmemo.value[i];
//     const { x, y } = tmp;
//     coordinates.push({ x, y });
// }

// // coordinates 배열 출력
// console.log(coordinates);
// // coordinates 배열 출력

let polyline; // Polyline 객체를 저장할 변수
let map; // Map 객체를 저장할 변수
let ps;

const initMap = (points, spotdatas) => {
    console.log("tripe")
    var infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
    var mapContainer = document.getElementById('map');
    var mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3
    };

    map = new kakao.maps.Map(mapContainer, mapOption);

    var bounds = new kakao.maps.LatLngBounds();
    // 지도에 표시할 선을 생성합니다
    polyline = new kakao.maps.Polyline({
        path: points, // 선을 구성하는 좌표배열 입니다
        strokeWeight: 5, // 선의 두께 입니다
        strokeColor: "#800080", // 선의 색깔입니다
        strokeOpacity: 1.0, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
        strokeStyle: "solid", // 선의 스타일입니다
    });

    // 지도에 선을 표시합니다
    polyline.setMap(map);
    for (var i = 0; i < points.length; i++) {
        var marker = new kakao.maps.Marker({
            map: map,
            position: points[i]
        });

        console.log(spotdatas[i + 1]);
        var tmp = spotdatas[i + 1];
        console.log(tmp.place_name)
        // var iwContent = '<div style="padding:5px;">' + tmp.place_name
        //     + '<br>' + tmp.address_name + '</div>',
        var iwContent = '<div class="wrap" style="width: 200px; height: 50px;"><div class="info"><strong>' + (i + 1) + '</strong><div class="title">' +
            tmp.place_name +
            '</div><div class="body"><div class="desc"></div ></div ></div ></div > ',
            // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
            iwPosition = points[i], //인포윈도우 표시 위치입니다
            iwRemoveable = false; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

        // 인포윈도우를 생성하고 지도에 표시합니다
        infowindow = new kakao.maps.InfoWindow({
            map: map, // 인포윈도우가 표시될 지도
            position: iwPosition,
            content: iwContent,
            removable: iwRemoveable
        });
        infowindow.open(map, marker);
        marker.setMap(map);
        bounds.extend(points[i]);
    }

    // setBounds 함수 내에서 LatLngBounds 인스턴스 활용
    function setBounds() {
        map.setBounds(bounds);
    }
    setBounds();
};

</script>

<template>
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-lg-12">
                <div class="border rounded p-4">
                    <h2>{{ articles.subject }}</h2>
                    <div class="d-flex justify-content-between">
                        <p>
                            <strong>작성자:</strong>
                            <span class="text-end">{{ articles.userId }}</span>
                        </p>
                        <p>
                            <strong>작성일:</strong>
                            <span class="text-end">{{ articles.registerTime }}</span>
                        </p>
                    </div>
                    <div id="map" style="width: auto; height: 500px"></div>
                    <p>{{ articles.content }}</p>
                    <div class="mt-3 d-flex justify-content-end">
                        <button type="button" class="btn btn-outline-primary me-2" @click="moveList">글 목록</button>
                        <!-- <button type="button" class="btn btn-outline-danger me-2" @click="onDeleteArticle">글 삭제</button> -->
                        <button type="button" class="btn btn-outline-danger" @click="onFollowUser">팔로우하기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
