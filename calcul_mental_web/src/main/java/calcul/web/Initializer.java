package calcul.web;

import calcul.core.config.AppConfig;
import calcul.core.config.DBConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import calcul.web.config.WebConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ AppConfig.class, DBConfig.class};
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ WebConfig.class};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
