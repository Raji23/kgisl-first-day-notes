package com.kgisl;

import org.springframework.web.servlet.support.
AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer {

@Override
protected Class<?>[] getRootConfigClasses() {
return new Class[]{SpringMVCConfiguration.class};
}

@Override
protected Class<?>[] getServletConfigClasses() {
return null;
}

@Override
protected String[] getServletMappings() {
return new String[]{"/"};
}

}