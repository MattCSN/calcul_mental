package core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

    @Configuration
    @ComponentScan(basePackages = { "core.service" })
    public class MainConfig {

        @Bean
        public Properties dbProperties() throws IOException, URISyntaxException {

            Properties props = new Properties();
            props.setProperty("driverClass", "com.mysql.jdbc.Driver");
            props.setProperty("jdbcUrl", "jdbc:mysql://localhost:3306/calcul_mental");
            props.setProperty("username", "root");
            props.setProperty("password", "0000");

            return props;
        }
    }

