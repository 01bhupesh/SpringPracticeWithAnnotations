package com.intialConfiguration;

import java.util.List;

import org.springframework.web.method.annotation.AbstractWebArgumentResolverAdapter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

public class SpringConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseRegisteredSuffixPatternMatch(true);
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");//".jsp"
		registry.viewResolver(viewResolver);
		super.configureViewResolvers(registry);
	}
}
