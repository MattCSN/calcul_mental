package calcul.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import yncrea.pw04.config.AppConfig;
import yncrea.pw04.config.DBConfig;
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
