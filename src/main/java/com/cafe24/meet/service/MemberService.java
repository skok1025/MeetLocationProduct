package com.cafe24.meet.service;

import com.cafe24.meet.library.libEncrypt;
import com.cafe24.meet.repository.MemberRepository;
import com.cafe24.meet.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(MemberVo memberVo) {
        String passwordEncrypted = libEncrypt.getSHA512(memberVo.getPassword());

        memberVo.setPassword(passwordEncrypted);
        Long memberNo = memberRepository.save(memberVo);

        return memberNo;
    }
}
