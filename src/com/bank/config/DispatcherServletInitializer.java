/**
 * 
 */
package com.bank.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Arnaud
 *
 */

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer { 

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {PersistenceJPAConfig.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {
			WebApplicationContextConfig.class	
		};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
}
