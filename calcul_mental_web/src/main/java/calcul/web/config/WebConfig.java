package calcul.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "calcul.web.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean
    public VelocityConfigurer configurer(){
        VelocityConfigurer configurer = new VelocityConfigurer();
        configurer.setResourceLoaderPath("/WEB-INF/velocity");
        return configurer;
    }

    @Bean
    public VelocityViewResolver resolver(){
        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setSuffix(".vm");
        return resolver;
    }
}
