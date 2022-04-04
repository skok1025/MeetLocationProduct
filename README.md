# 미팅 위치 알림이 
- 여러개의 위치를 마커로 등록하면 해당 마커들의 중심좌표를 알아내어 미리 등록되어 있는
- "핫플레이스" 중 가장 가까운 "핫플레이스" 를 제안합니다. 

## 작업할 내용
1. 핫플레이스 등록 
   1. 핫플레이스를 "원" 형태로 위치등록
      1. https://apis.map.kakao.com/web/sample/drawingGetData/
      2. Drawing Library 에서 데이터 얻기 > 원
2. 미팅할 사람들의 위치를 찍는 페이지
   1. https://apis.map.kakao.com/web/sample/drawingGetData/
   2. Drawing Library 에서 데이터 얻기 > 마커
3. 최종적으로 미팅할 사람들의 위치와 그 중심좌표 및 가장 가까운 "핫플레이스" 를 알려주는 페이지
   1. 중심좌표 - 미리 등록된 "핫플레이스" 들과의 거리를 계산하여 가장 가까운 "핫플레이스"를 알려준다.
      1. https://fruitdev.tistory.com/189