package com.jdc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.jdc.dto","com.jdc.aspect"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
