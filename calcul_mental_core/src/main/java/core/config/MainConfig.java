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

            /*
            ENVIRONMENT VARIABLE DATABASE_URL SHOULD BE SET
                                                            -- for Mac and Linux
                                                                    export DATABASE_URL=postgres://$(whoami)
                                                            -- for Windows
                                                                    set DATABASE_URL=postgres://$(whoami)
            URI dbUri = new URI(System.getenv("DATABASE_URL"));

            Properties props = new Properties();
            props.setProperty("jdbcUrl","jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require");
            props.setProperty("username",dbUri.getUserInfo().split(":")[0]);
            props.setProperty("password", dbUri.getUserInfo().split(":")[1]);


            else
             */

            Properties props = new Properties();
            props.setProperty("driverClass", "org.postgresql.Driver");
            props.setProperty("jdbcUrl", "jdbc:postgres://ec2-79-125-110-209.eu-west-1.compute.amazonaws.com:5432/dnhnkr1kfvvb0");
            props.setProperty("username", "abeqfgbsldfhfv");
            props.setProperty("password", "cd2472481a06ab2311155ea82a7e325641f6cee2162bf61465fc025655439c43");
            props.setProperty("ssl", "true");
            return props;
        }
    }

