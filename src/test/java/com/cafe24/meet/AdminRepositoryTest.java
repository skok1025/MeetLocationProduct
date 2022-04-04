package com.cafe24.meet;

import com.cafe24.meet.repository.AdminRepository;
import com.cafe24.meet.vo.HotPlaceVo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;

    @Test
    public void test() {
        Assertions.assertThat(1).isEqualTo(1);
    }

    @Test
    @Transactional
    public void testHotPlaceSave() throws Exception {
        HotPlaceVo hotplace = new HotPlaceVo();
        hotplace.setName("카카오 본사");
        hotplace.setCenterX("126.56997358762227");
        hotplace.setCenterY("33.450554122218605");
        hotplace.setEPointX("126.57167877775417");
        hotplace.setEPointY("33.45199538410955");
        hotplace.setSPointX("126.57167877775417");
        hotplace.setSPointY("33.45199538410955");
        hotplace.setRadius("159.20113064923262");
        hotplace.setColor("#39f");

        Long saveNo = adminRepository.hotplaceSave(hotplace);

        HotPlaceVo findHotPlace = adminRepository.findHotPlace(saveNo);

        Assertions.assertThat(findHotPlace.getNo()).isEqualTo(hotplace.getNo());
    }
}
