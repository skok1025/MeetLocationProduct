package com.cafe24.meet.repository;

import com.cafe24.meet.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public Long save(MemberVo memberVo) {
        em.persist(memberVo);

        return memberVo.getNo();
    }
}
