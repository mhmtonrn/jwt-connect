package com.softengine.jwttest.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.softengine.jwttest")
@ConditionalOnClass
public class AutoConfigure {
}
