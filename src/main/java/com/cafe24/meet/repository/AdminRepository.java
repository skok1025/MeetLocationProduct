package com.cafe24.meet.repository;

import com.cafe24.meet.vo.HotPlaceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class AdminRepository {
    private final EntityManager em;

    public Long hotplaceSave(HotPlaceVo vo) {
        em.persist(vo);

        return vo.getNo();
    }

    public HotPlaceVo findHotPlace(Long id) {
        return em.find(HotPlaceVo.class, id);
    }
}
