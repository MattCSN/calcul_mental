package calcul.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

    @Configuration
    @ComponentScan(basePackages = { "calcul.core.service" })
    public class AppConfig {

        @Bean
        public Properties dbProperties() {
            Properties props = new Properties();
            props.setProperty("driverClass", "com.mysql.jdbc.Driver");
            props.setProperty("jdbcUrl", "jdbc:mysql://localhost:3306/yncrea_pw03");
            props.setProperty("username", "root");
            props.setProperty("password", "root");
            return props;
        }
    }
}
