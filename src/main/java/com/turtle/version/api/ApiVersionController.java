package com.turtle.version.api;

import com.turtle.version.aop.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijiayu
 * @date 2020/10/29
 * @description
 */
@RestController
public class ApiVersionController {
    @GetMapping("/test")
    public String v0(){
        return "0";
    }

    @GetMapping("/test")
    @ApiVersion(1.0)
    public String v1(){
        return "1";
    }

    @GetMapping("/test")
    @ApiVersion(1.1)
    public String v2(){
        return "1.1";
    }
    @GetMapping("/test")
    @ApiVersion(1.5)
    public String v3(){
        return "1.5";
    }
}
