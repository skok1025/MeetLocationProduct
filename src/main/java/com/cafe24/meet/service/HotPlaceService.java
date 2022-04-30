package com.cafe24.meet.service;

import com.cafe24.meet.repository.AdminRepository;
import com.cafe24.meet.vo.HotPlaceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HotPlaceService {

    private final AdminRepository adminRepository;

    @Transactional
    public Long saveHotplace(HotPlaceVo vo) {
        return adminRepository.hotplaceSave(vo);
    }

    public List<HotPlaceVo> getHotPlaceList() {
        return adminRepository.selectHotPlaceList();
    }
}
