<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!-- 관광지 검색 start -->
<div class="container">
    <form class="d-flex m-3" role="search">
      <select id="search-area-sido" class="form-select" aria-label="Default select example">
        <option value="0" selected>전체 시도</option>
      </select>
      <select id="search-area-gugun" class="form-select" aria-label="Default select example">
        <option value="0" selected>전체 구군</option>
      </select>
      <select id="search-content-id" class="form-select" aria-label="Default select example">
        <option value="0" selected>모든 관광명소 유형</option>
        <option value="12">관광지</option>
        <option value="14">문화시설</option>
        <option value="15">축제공연행사</option>
        <option value="25">여행코스</option>
        <option value="28">레포츠</option>
        <option value="32">숙박</option>
        <option value="38">쇼핑</option>
        <option value="39">음식점</option>
      </select>
      <input
        id="search-keyword"
        class="form-control me-2"
        type="search"
        placeholder="검색어"
        aria-label="검색어"
      />
      <button id="btn-search" class="col-2 btn btn-outline-success" type="submit">검색</button>
    </form>
</div>

<div class="container">
       <div id="map" class="mt-4" style="width: 100%; height: 700px"></div>
</div>

<script type="text/javascript">

   	/*
	    시도, 구군, 관광지 유형, 키워드에 따른 선택박스 로직 
	*/
   	createSidoSelectBox();
	
	// DB sido table에서 데이터를 json으로 받아 시도 selectBox option을 만들어 줌.
	function createSidoSelectBox(){
		let sidoUrl ="${root}/area/sidosearch";
		fetch(sidoUrl, { method: "GET" })
		    .then((response) => response.json())
		    .then((data) => makeSelectBoxOptions(data, "search-area-sido", "sidoCode", "sidoName"));
	    
		// 시도 selectBox Option 선택이 있다면 선택값으로 구군 옵션을 만들어줌 
	    let sidoSelectBox = document.getElementById("search-area-sido");
	    sidoSelectBox.addEventListener("change", (e) => {
		    e.preventDefault();
		    let sidoCode = e.target.value;
		    createGugunSelectBox(sidoCode);
	    
	    	}
    	)
	}
	
	// DB sgugun table에서 데이터를 json으로 받아 구군  selectBox option을 만들어 줌.  
    function createGugunSelectBox(sidoCode){
		let gugunUrl ="${root}/area/gugunsearch";
		gugunUrl += "?sido="+sidoCode;
		fetch(gugunUrl, { method: "GET" })
		    .then((response) => response.json())
		    .then((data) => makeSelectBoxOptions(data, "search-area-gugun", "gugunCode", "gugunName"));
	}
    
    // selectBox 목록 JSON인 areas 를 selectBox에 넣어주는 함수 
	function makeSelectBoxOptions(areas, selectBoxId, areaCodeKey, areaNameKey) {
		let selectBox = document.getElementById(selectBoxId);
		if(selectBoxId==="search-area-gugun") _initOptions(selectBox);
		
		// JSON으로 받아 목록을 돌며 option을 추가 
	    areas.forEach((area) => {
	        let option = document.createElement("option");
	        option.setAttribute("value", area[areaCodeKey]);
	        option.appendChild(document.createTextNode(area[areaNameKey]));
	        selectBox.appendChild(option);
	    });
		
	 	// selectBox 목록을 index 0 제외 초기화. 전체 옵션 제외 초기화. 초기화하지 않으면 계속 그대로 쌓임. 
		function _initOptions(selectBox){
			let options = selectBox.getElementsByTagName("option");

			for (let i = options.length; i--;) {
				if(i!=0) selectBox.removeChild(options[i]);
			}
		}
	}
    
	/*
    	시도, 구군, 관광지 유형, 키워드에 따른 데이터 조회 이벤트 추가 
	*/
	// 검색 버튼을 누르면
	// 지역, 유형, 검색어 얻기.
	// 위 데이터를 가지고 DB에 요청.
	// 받은 데이터를 이용하여 화면 구성.
	document.getElementById("btn-search").addEventListener("click", (e) => {
	    e.preventDefault();
	    let searchUrl ="${root}/attraction/search";
	
	    let sidoCode = document.getElementById("search-area-sido").value;
	   	let gugunCode = document.getElementById("search-area-gugun").value;
	    let contentTypeId = document.getElementById("search-content-id").value;
	    let keyword = document.getElementById("search-keyword").value;
	
	    searchUrl += "?sidoCode="+sidoCode;
	    searchUrl += "&gugunCode="+gugunCode;
	    searchUrl += "&contentTypeId="+contentTypeId;
	    
	    
	    if (!keyword) {
	        alert("검색어 입력 필수!!!");
	        return;
	    } else searchUrl += "&keyword="+keyword;
	
	  	// console.log(searchUrl);
	    fetch(searchUrl)
	        .then((response) => response.json())
	        .then((data) => {
	            makeList(data);
	        });
	});
	
	// 필요한 데이터만 뽑아 냅니다.
	function makeList(trips) {
	    let infos=[];
	    trips.forEach((area, index) => {
	        infos[index] = {
	            title: area.title,
	            latlng: new kakao.maps.LatLng(area.latitude, area.longitude),
	            firstimage: area.firstImage,
	            addr1: area.addr1,
	            addr2: area.addr2
	        }
	    });
	    drawMap(infos);
	}
	
	
	/*
	    검색에 따른 카카오맵 재생성
	*/
	
	function drawMap(infos) { 
	    // 카카오지도
	    var mapContainer = document.getElementById("map"), // 지도를 표시할 div
	    mapOption = {
	        center: new kakao.maps.LatLng(36.3550449502, 127.3454325546), // 지도의 중심좌표
	        level: 7, // 지도의 확대 레벨
	    };
	    // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	    var map = new kakao.maps.Map(mapContainer, mapOption);
	    // 마커를 표시할 위치와 title 객체 배열입니다 
	
	    // 마커 이미지의 이미지 주소입니다
	    var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
	    
	    let positions = [];
	    
	    var bounds = new kakao.maps.LatLngBounds();    
	    
	    for (let i = 0; i < infos.length; i ++) {
	        
	        // 마커 이미지의 이미지 크기 입니다
	        let imageSize = new kakao.maps.Size(24, 35); 
	        
	        // 마커 이미지를 생성합니다    
	        let markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
	        
	        // 마커를 생성합니다
	        let marker = new kakao.maps.Marker({
	            map: map, // 마커를 표시할 지도
	            position: infos[i].latlng, // 마커를 표시할 위치
	            title : infos[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
	            image: markerImage, // 마커 이미지,
	            clickable: true
	        });
	        bounds.extend(infos[i].latlng);
	        marker.setMap(map);
	    
	        let iwContent = `
		        <div style =\"display: flex; width:600px; height:200px;">
		            <div style=\"float: left; margin: 10px 20px;">
		                <h5>\${infos[i].title}</h5>
		                <img src=\${infos[i].firstimage} style=\"float: left; width:100px; height:100px;" alt=\"">
		            </div>
		            <div style=\"float: left; margin: 10px 20px;">
		                <p>\${infos[i].addr1}</p>
		                <p>\${infos[i].addr2}</p>
		            </div>
		        </div>
	        `; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
	
	        // 인포윈도우를 생성합니다
	        let infowindow = new kakao.maps.InfoWindow({
	            content: iwContent,
	            removable: true
	        });
	        
	        // 마커에 마우스 클릭  이벤트를 등록합니다
	        kakao.maps.event.addListener(marker, 'click', function() {
	        // 마커에 마우스 클릭  이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
	            infowindow.open(map, marker);
	        });   
	    }
	    map.setBounds(bounds);
	}
	
	
	/*
	    카카오맵 초기맵
	*/
	var mapContainer = document.getElementById("map"), // 지도를 표시할 div
	mapOption = {
	    center: new kakao.maps.LatLng(36.3550449502, 127.3454325546), // 지도의 중심좌표
	    level: 7, // 지도의 확대 레벨
	};
	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption);
</script>
