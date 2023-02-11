package com.ugrong.framework.robot.autoconfigure;

import com.ugrong.framework.robot.api.DingTalkApi;
import com.ugrong.framework.robot.properties.DingTalkProperties;
import com.ugrong.framework.robot.service.DingTalkRobotService;
import com.ugrong.framework.robot.service.impl.DingTalkRobotServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@AutoConfiguration
@ConditionalOnProperty(prefix = "com.ugrong.dingtalk", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(DingTalkProperties.class)
public class DingTalkAutoConfiguration {

    private final DingTalkProperties dingTalkProperties;

    public DingTalkAutoConfiguration(DingTalkProperties dingTalkProperties) {
        this.dingTalkProperties = dingTalkProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    WebClient dingTalkWebClient() {
        return WebClient.builder().baseUrl(dingTalkProperties.getUrl()).build();
    }

    @Bean
    @ConditionalOnMissingBean
    DingTalkApi dingTalkApi(WebClient webClient) {
        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build().createClient(DingTalkApi.class);
    }

    @Bean
    @ConditionalOnMissingBean
    public DingTalkRobotService dingTalkRobotService(DingTalkApi dingTalkApi) {
        return new DingTalkRobotServiceImpl(dingTalkProperties, dingTalkApi);
    }
}
