package com.crowdfunding.core.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
/**
 * 用于持有spring的applicationContext,一个系统只能有一个ApplicationContextHolder 
 * 
 * 
 * <br />
 * <pre>
 * 使用方法:
 * 
 * 在java代码中则可以如此使用: 
 * BlogDao dao = (BlogDao)ApplicationContextHolder.getBean("blogDao");
 * </pre>
 * @author up72
 */

public class ApplicationContextHolder implements ApplicationContextAware{
	
	private static Log log = LogFactory.getLog(ApplicationContextHolder.class);
	
	private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		if(this.applicationContext != null) {
			throw new IllegalStateException("ApplicationContextHolder already holded 'applicationContext'.");
		}
		this.applicationContext = context;
		log.info("holded applicationContext,displayName:"+applicationContext.getDisplayName());
	}
	
	public static ApplicationContext getApplicationContext() {
		if(applicationContext == null)
			throw new IllegalStateException("'applicationContext' property is null,ApplicationContextHolder not yet init.");
		return applicationContext;
	}
	
	public static Object getBean(String beanName) {
		return getApplicationContext().getBean(beanName);
	}
	
	public static void cleanHolder() {
		applicationContext = null;
	}
}
