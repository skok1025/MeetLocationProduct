package com.cafe24.meet.controller;

import com.cafe24.meet.library.libPlaceCalc;
import com.cafe24.meet.service.HotPlaceService;
import com.cafe24.meet.vo.HotPlaceDTO;
import com.cafe24.meet.vo.HotPlaceVo;
import com.cafe24.meet.vo.MarkerListDTO;
import com.cafe24.meet.vo.MarkerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FrontController {

    private final HotPlaceService hotPlaceService;

    @GetMapping("marker")
    public String markerSelect() {
        return "front/marker_select";
    }

    @PostMapping("result")
    public String result(@ModelAttribute("MarkerListDTO") MarkerListDTO markerListDTO, Model model) {
        List<HotPlaceVo> hotplaceList = hotPlaceService.getHotPlaceList();
        List<MarkerVo> selectedMarkerList = markerListDTO.getMarkerList();

        MarkerVo centerMarker = libPlaceCalc.getInstance().centerMarker(selectedMarkerList);
        HotPlaceDTO baseHotPlace = libPlaceCalc.getInstance().getBaseHotPlace(hotplaceList, centerMarker);

        model.addAttribute("selectedMarkerList", selectedMarkerList);
        model.addAttribute("hotplaceList", hotplaceList);
        model.addAttribute("centerMarker", centerMarker);
        model.addAttribute("baseHotPlace", baseHotPlace);

        return "front/marker_result";
    }
}
