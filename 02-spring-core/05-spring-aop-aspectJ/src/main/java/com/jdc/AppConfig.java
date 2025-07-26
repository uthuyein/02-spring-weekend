package com.jdc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = {"com.jdc.dto","com.jdc.aspect"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportResource("context-custom-advice.xml")
public class AppConfig {

}
