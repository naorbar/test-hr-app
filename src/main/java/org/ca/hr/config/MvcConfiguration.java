package org.ca.hr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages= {"org.ca.hr"})
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

		
}
