package com.cafe24.meet.controller;

import com.cafe24.meet.vo.HotPlaceVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/hotplace")
    public String hotPlace(Model model) {
        model.addAttribute("hotplace", new HotPlaceVo());
        return "admin/hotplacesave2";
    }
}
