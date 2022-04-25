package com.cafe24.meet.controller;

import com.cafe24.meet.service.AdminService;
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

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/hotplace")
    public String hotPlace(Model model) {
        model.addAttribute("hotplace", new HotPlaceVo());
        return "admin/hotplacesave2";
    }

    @PostMapping("/hotplace")
    public String saveHotPlace(@Validated @ModelAttribute("hotplace") HotPlaceVo hotplace, BindingResult bindingResult) {
        log.info("bindingResult={}", bindingResult);

        if (bindingResult.hasErrors()) {
            return "admin/hotplacesave2";
        }
        adminService.saveHotplace(hotplace);
        return "redirect:/";
    }
}
