package com.sourya.PaymentProject;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.sourya.PaymentProject")
public class ProjectConfig {

}
