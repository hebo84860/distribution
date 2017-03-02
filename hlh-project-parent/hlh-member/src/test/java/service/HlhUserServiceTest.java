package service;

import com.joyous.common.entity.member.HlhUserEntity;
import com.joyous.distribution.service.HlhUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by hebo on 2017/3/1.
 */
public class HlhUserServiceTest extends BaseTest{

    @Autowired
    HlhUserService hlhUserService;


    @Test
    public void testSaveUser(){
        HlhUserEntity userEntity = new HlhUserEntity();
        userEntity.setUsername("test");
        userEntity.setPassword("asddsa");
        userEntity.setNickname("sb2");
        hlhUserService.saveUserEntity(userEntity);

    }
}
