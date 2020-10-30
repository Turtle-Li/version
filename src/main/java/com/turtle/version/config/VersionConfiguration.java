package com.turtle.version.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author lijiayu
 * @date 2020/10/30
 * @description
 */
@Configuration
public class VersionConfiguration implements WebMvcRegistrations {

    @Bean
    protected RequestMappingHandlerMapping customRequestMappingHandlerMapping(){
        return new ApiVersionHandlerMapping();
    }

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        ApiVersionHandlerMapping handlerMapping = new ApiVersionHandlerMapping();
        handlerMapping.setOrder(0);
        return handlerMapping;
    }

}
