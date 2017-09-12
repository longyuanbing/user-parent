package com.yuandu.user.service.test;

import com.yuandu.TestApp;
import com.yuandu.common.date.DateUtils;
import com.yuandu.common.exceptions.YuanduBaseException;
import com.yuandu.common.exceptions.YuanduExceptionCode;
import com.yuandu.common.json.JsonUtils;
import com.yuandu.user.dao.model.UserEntity;
import com.yuandu.redis.repository.RedisObjectRepository;
import com.yuandu.user.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApp.class)
public class TestUser {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisObjectRepository redisObjectRepository;

    private Logger logger = LogManager.getLogger(TestUser.class);

    @Test
    public void test() throws Exception {
        UserEntity user = new UserEntity();
        user.setId(9L);
        user.setName("龙");
        user.setSex(new Byte("1"));
        user.setYuanduId("yuandu1");
        user.setMobeile("18476030086");
        user.setBirthday(DateUtils.getAfterDate(new Date(), 1));
        userService.save(user);

        redisObjectRepository.add("user_redis", user, 600L);

        //YuanduBaseException.throwException(YuanduExceptionCode.IO_WRONG);
    }

    @Test
    public void test2(){
        Object user = redisObjectRepository.get("user_redis");
        if(user != null){
            UserEntity userEntity = (UserEntity)user;
            logger.info(JsonUtils.toJson(userEntity));
        }
    }



}
