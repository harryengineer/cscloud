package com.cscloud.auth.server.runner;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import com.cscloud.auth.server.config.SecretConfiguration;
import com.cscloud.common.base.util.RSAUtils;
import org.springframework.stereotype.Component;

/**
 * 项目启动的时候自动将自动生成对应的公私钥
 * @author Administrator
 *
 */
@Component
@Slf4j
public class AuthServerRunner implements CommandLineRunner {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private static final String REDIS_USER_PRI_KEY = "AG:AUTH:JWT:PRI";
    private static final String REDIS_USER_PUB_KEY = "AG:AUTH:JWT:PUB";
    private static final String REDIS_SERVICE_PRI_KEY = "AG:AUTH:CLIENT:PRI";
    private static final String REDIS_SERVICE_PUB_KEY = "AG:AUTH:CLIENT:PUB";

    @Autowired
    private SecretConfiguration keyConfiguration;

    @Override
    public void run(String... args) throws Exception {
        log.info("正常的启动------------------------");
        if (redisTemplate.hasKey(REDIS_USER_PRI_KEY) && redisTemplate.hasKey(REDIS_USER_PUB_KEY) && redisTemplate.hasKey(REDIS_SERVICE_PRI_KEY) && redisTemplate.hasKey(REDIS_SERVICE_PUB_KEY)) {
            keyConfiguration.setUserPriKey(RSAUtils.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PRI_KEY).toString()));
            keyConfiguration.setUserPubKey(RSAUtils.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PUB_KEY).toString()));
            keyConfiguration.setServicePriKey(RSAUtils.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PRI_KEY).toString()));
            keyConfiguration.setServicePubKey(RSAUtils.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PUB_KEY).toString()));
        } else {
            Map<String, byte[]> keyMap = RSAUtils.generateKey(keyConfiguration.getUserSecret());
            keyConfiguration.setUserPriKey(keyMap.get("pri"));
            keyConfiguration.setUserPubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(REDIS_USER_PRI_KEY, RSAUtils.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(REDIS_USER_PUB_KEY, RSAUtils.toHexString(keyMap.get("pub")));
            
            keyMap = RSAUtils.generateKey(keyConfiguration.getServiceSecret());
            keyConfiguration.setServicePriKey(keyMap.get("pri"));
            keyConfiguration.setServicePubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(REDIS_SERVICE_PRI_KEY, RSAUtils.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(REDIS_SERVICE_PUB_KEY, RSAUtils.toHexString(keyMap.get("pub")));

        }
    }
}
