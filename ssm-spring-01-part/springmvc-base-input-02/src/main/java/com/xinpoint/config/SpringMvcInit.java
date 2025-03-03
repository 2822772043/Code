package com.xinpoint.config;

import com.xinpoint.cookie.CookieController;
import com.xinpoint.json.JsonController;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{CookieController.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
