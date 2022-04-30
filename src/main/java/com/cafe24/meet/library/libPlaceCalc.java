package com.cafe24.meet.library;

import com.cafe24.meet.vo.HotPlaceDTO;
import com.cafe24.meet.vo.HotPlaceVo;
import com.cafe24.meet.vo.MarkerVo;

import java.util.List;

public class libPlaceCalc {

    /**
     * 인스턴스 변수
     */
    private static libPlaceCalc instance;

    /**
     * 클래스 외부에서 생성자를 통해 인스턴스 생성하지 못하도록 작업
     */
    private libPlaceCalc() {}
    /**
     * 하나의 인스턴스 (싱글톤 객체) 만 리턴하는 함수
     * @return 싱글톤 객체
     */
    public static libPlaceCalc getInstance() {
        if (instance == null) {
            instance = new libPlaceCalc();
        }

        return instance;
    }

    public MarkerVo centerMarker(List<MarkerVo> selectedMarkerList) {
        Float centerXTotal = 0f;
        Float centerYTotal = 0f;

        int cnt = 0;
        for (MarkerVo vo : selectedMarkerList) {
            centerXTotal += Float.parseFloat(vo.getX());
            centerYTotal += Float.parseFloat(vo.getY());
            cnt++;
        }

        Float centerX = centerXTotal / cnt;
        Float centerY = centerYTotal / cnt;

        MarkerVo result = new MarkerVo();
        result.setX(String.valueOf(centerX));
        result.setY(String.valueOf(centerY));

        return result;
    }

    public HotPlaceDTO getBaseHotPlace(List<HotPlaceVo> hotplaceList, MarkerVo centerMarker) {
        HotPlaceDTO result = new HotPlaceDTO();
        double shortestDistance = 9999999999d;

        for (HotPlaceVo hotplace : hotplaceList) {
            double checkDistance =
            distance(Double.parseDouble(hotplace.getCenterX()),
                    Double.parseDouble(hotplace.getCenterY()),
                    Double.parseDouble(centerMarker.getX()),
                    Double.parseDouble(centerMarker.getY()), "kilometer");

            if (shortestDistance >= checkDistance) {
                shortestDistance = checkDistance;
                result.setName(hotplace.getName());
                result.setCenterX(hotplace.getCenterX());
                result.setCenterY(hotplace.getCenterY());
            }
        }

        return result;
    }

    /**
     * 두 지점간의 거리 계산
     *
     * @param lat1 지점 1 위도
     * @param lon1 지점 1 경도
     * @param lat2 지점 2 위도
     * @param lon2 지점 2 경도
     * @param unit 거리 표출단위
     * @return
     */
    private double distance(double lat1, double lon1, double lat2, double lon2, String unit) {

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        if (unit == "kilometer") {
            dist = dist * 1.609344;
        } else if(unit == "meter"){
            dist = dist * 1609.344;
        }

        return (dist);
    }

    // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
