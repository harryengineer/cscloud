package com.cscloud.auth.api.service.server.hystrix;

import com.cscloud.auth.api.service.server.ClientAuthFeignApi;
import com.cscloud.common.base.wrapper.Wrapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientAuthFeignApiHystrix implements ClientAuthFeignApi {
    @Override
    public Wrapper<String> getClientToken(String clientId, String secret) {
        return null;
    }

    @Override
    public Wrapper<List<String>> getAllowClient(String clientId, String secret) {
        return null;
    }

    @Override
    public Wrapper<byte[]> getClientPublicKey(String clientId, String secret) {
        return null;
    }

    @Override
    public Wrapper<byte[]> getUserPublicKey(String clientId, String secret) {
        return null;
    }
}
