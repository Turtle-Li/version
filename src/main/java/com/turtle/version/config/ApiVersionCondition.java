package com.turtle.version.config;

import lombok.Getter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lijiayu
 * @date 2020/10/29
 * @description
 */

/**
 * 版本号匹配筛选条件
 *
 * @author 凌封
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    /**
     * OAS0.6标准协议指定 请求header头需带上版本号api-version
     */
    private static final String HEADER_VERSION = "API-VERSION";
    /**
     * 为了兼容旧版本无请求头,默认从1.0版本开始
     */
    private static final double DEFAULT_VERSION = 1.0;
    private final Double apiVersion;

    public ApiVersionCondition(double apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition other) {
        //如果已有定义，返回原先的即可。
        if (this.apiVersion == other.getApiVersion()) {
            return this;
        }
        return other;
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        String v = request.getHeader(HEADER_VERSION);
        //匹配所有符合条件的版本
        if (!StringUtils.isEmpty(v) && Double.parseDouble(v) >= this.apiVersion ) {
            return this;
        }

        return null;
    }

    /**
     * 如果匹配到两个都符合版本需求的
     */
    @Override
    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        // 优先匹配最新的版本号
        return Double.compare(other.getApiVersion(), this.apiVersion);
    }

    public double getApiVersion() {
        return apiVersion;
    }

    /**
     * 用于对比条件是否已存在这样的条件，Spring容器存放requestMapping里的mapping用到方法各注解的条件hash值合作为mapping key
     */
    @Override
    public int hashCode() {
        return this.apiVersion.hashCode();
    }
    /**
     * 同hasCode用处
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ApiVersionCondition)) {
            return false;
        }
        ApiVersionCondition avc = (ApiVersionCondition)obj;
        return this.apiVersion ==avc.getApiVersion();
    }
}
