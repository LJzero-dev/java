<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#map { width:500px; height:400px; border:1px solid black; }
#infoWin { width:150px; text-align:center; padding:5px 0; }
</style>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=726a382352a05a67444bcf2b3eced22e&libraries=services"></script>
<!-- &libraries=services -->
<script>
var mapObj;		//	파일 전체에서 사용하기 위해 전역번수로 선언함
function showMap(){
	var mapBox = document.getElementById("map");
	var mapOpt = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),	//	위도와 경도로 지도의 중심좌표값
			level: 3												//	지도의 크기 레벨로 최대 확대(1) 부터 최대 축소(14)까지 설정 가능
																	//	현재 level값 추출 : getLevel();	/	새로운 level지정 : setLevel(lvl);
	};
	mapObj = new kakao.maps.Map(mapBox, mapOpt);					//	지도 객체 생성
	
	//	지도 컨트롤 추가
	var zoomCtrl = new kakao.maps.ZoomControl();
	mapObj.addControl(zoomCtrl, kakao.maps.ControlPosition.RIGHT);	//	지도 확대 축소 제어 줌 컨트롤 추가 및 위치 지정
	
	var mapCtrl = new kakao.maps.MapTypeControl();
	mapObj.addControl(mapCtrl, kakao.maps.ControlPosition.TOPRIGHT);//	일반 지도와 스카이뷰로 타입 전환이 가능한 컨트롤 추가 및 컨트롤 위치 지정
}
function zoom(val){
	var level = mapObj.getLevel();
	mapObj.setLevel(eval(level + val));
}
function setDraggable(chk){
	mapObj.setDraggable(chk);
}
function addr2Geo(){
	var geocoder = new kakao.maps.services.Geocoder();				//	주소를 좌표로 변경해 주는 객체 생성
	var addr = document.getElementById("addr").value;
	geocoder.addressSearch(addr, function(result, status){
		if (status == kakao.maps.services.Status.OK){
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			var marker = new kakao.maps.Marker({
				map: mapObj, position: coords						// 결과값을 받은 위치를 마커로 생성
			});
			var infowindow = new kakao.maps.InfoWindow({
				content: "<div id='infoWin'>우리 학원</div>"
			});
			infowindow.open(mapObj, marker);			
			mapObj.setCenter(coords);
		}
	});
}
</script>
</head>
<body>
<h2>Kakao Map 활용</h2>
<input type="button" value="지도 보기" onclick="showMap();"/>
<input type="button" value="지도 축소" onclick="zoom('+1');" />
<input type="button" value="지도 확대" onclick="zoom('-1');" />
<input type="button" value="지도 이동 불가" onclick="setDraggable(false);" />
<input type="button" value="지도 이동 가능" onclick="setDraggable(true);" />
<br />
주소 : <input type="text" name="addr" id="addr" />
<input type="button" value="지도 위치 변경" onclick="addr2Geo();" />
<hr />
<div id="map"></div>
</body>
</html>
