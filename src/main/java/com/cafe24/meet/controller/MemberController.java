package com.cafe24.meet.controller;

import com.cafe24.meet.service.MemberService;
import com.cafe24.meet.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입 페이지 렌더링
     */
    @GetMapping("/join")
    public String joinPage(Model model) {
        model.addAttribute("member", new MemberVo());
        return "member/join";
    }

    /**
     * 회원가입 액션
     * @param member 회원가입 데이터
     * @return 성공유무에 따른 redirect
     */
    @PostMapping("/join")
    public String joinAction(@Valid @ModelAttribute("member") MemberVo member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("bindResult: {}", bindingResult);
            return "member/join";
        }

        Long userNo = memberService.save(member);

        return "redirect:/meet/member/login";
    }

    /**
     * 로그인 페이지 렌더링
     * @return 로그인페이지
     */
    @GetMapping("/login")
    public String loginPage() {
        return "member/login";
    }
}
