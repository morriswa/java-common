package org.morriswa.common;

import org.springframework.boot.Banner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import java.io.FileReader;
import java.io.PrintStream;

@Import(
        WebSecurityConfig.class
) @Configuration
public class CommonConfig {
    
}
