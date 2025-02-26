package config;

import aspect.LogginAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "service")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public LogginAspect logginAspect() {
        return new LogginAspect();
    }
}
