package pindorama.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import pindorama.requests.ConteudoRequest;

@Configuration
@EnableWebMvc
public class JspConfig implements WebMvcConfigurer {
    @Value("${spring.mvc.view.prefix}")
    private String prefix;

    @Value("${spring.mvc.view.suffix}")
    private String suffix;

    @Bean
    InternalResourceViewResolver jspViewResolver() {
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(prefix);
        viewResolver.setSuffix(suffix);
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/about/**").addResourceLocations("/about/");
        registry.addResourceHandler("/internal/**").addResourceLocations("/internal/");
        registry.addResourceHandler("/materias/**").addResourceLocations("/materias/");
        registry.addResourceHandler("/Hamburger_icon.svg.png").addResourceLocations("/Hamburger_icon.svg.png");
        registry.addResourceHandler("/favicon/**").addResourceLocations("/favicon/");
        registry.addResourceHandler("/Images/**").addResourceLocations("/Images/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
    }

}
