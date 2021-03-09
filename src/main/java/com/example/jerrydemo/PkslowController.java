package com.example.jerrydemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
public class PkslowController {
    @Value("${pkslow.age:0}")
    private Integer age;

    @Value("${pkslow.email:null}")
    private String email;

    @Value("${pkslow.webSite:null}")
    private String webSite;

    @GetMapping("/pkslow")
    public Map<String, String> getConfig() {
        Map<String, String> map = new HashMap<>();
        map.put("age", age.toString());
        map.put("email", email);
        map.put("webSite", webSite);
        return map;
    }
}