package com.xbird.security.core;

import com.xbird.security.core.properties.SecurityPerproties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SecurityPerproties.class)
public class SecurityCoreConfig {
}
