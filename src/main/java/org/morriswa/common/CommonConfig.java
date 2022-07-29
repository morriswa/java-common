package org.morriswa.common;

import org.morriswa.common.control.CustomErrorController;
import org.morriswa.common.control.HealthCheckController;
import org.morriswa.common.security.WebSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    WebSecurityConfig.class,
    HealthCheckController.class,
    CustomErrorController.class
}) @Configuration
public class CommonConfig {
    // ANY FILE YOU WOULD LIKE TO BE IMPORTED BY SERVICES MUST BE ADDED IN IMPORTS ^^^
}
