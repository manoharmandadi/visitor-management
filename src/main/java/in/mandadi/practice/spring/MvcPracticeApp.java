package in.mandadi.practice.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MvcPracticeApp {

    public static void main(String[] args) {
        SpringApplication.run(MvcPracticeApp.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/visit")
                        .allowedOrigins("http://mandadi.in","http://localhost:3000");
                registry.addMapping("/api/v1/welcome")
                        .allowedOrigins("http://mandadi.in","http://localhost:3000");

            }
        };
    }
}
