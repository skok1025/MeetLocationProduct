package com.cafe24.meet.controller;

import com.cafe24.meet.service.HotPlaceService;
import com.cafe24.meet.vo.HotPlaceVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final HotPlaceService adminService;

    @GetMapping("/hotplace")
    public String hotPlace(Model model) {
        List<HotPlaceVo> hotplaceList = adminService.getHotPlaceList();
        System.out.println(hotplaceList);
        model.addAttribute("hotplace", new HotPlaceVo());
        model.addAttribute("hotplaceList", hotplaceList);
        return "admin/hotplacesave";
    }

    @PostMapping("/hotplace")
    public String saveHotPlace(@Validated @ModelAttribute("hotplace") HotPlaceVo hotplace, BindingResult bindingResult) {
        log.info("bindingResult={}", bindingResult);

        if (bindingResult.hasErrors()) {
            return "admin/hotplacesave";
        }
        adminService.saveHotplace(hotplace);
        return "redirect:/";
    }
}
