package com.eternitysl.idam.common.localization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Configuration
public class CustomLocalResolver  extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    List<Locale> LOCALES = Arrays.asList(
            new Locale("en"),
            new Locale("si")
    );

    public Locale resolveLocale(HttpServletRequest request){
        String headerLang = request.getHeader("Accept-language");
        return headerLang == null || headerLang.isEmpty()
                ? Locale.getDefault()
                : Locale.lookup(Locale.LanguageRange.parse(headerLang),LOCALES);
    }

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource sc = new ResourceBundleMessageSource();
        sc.setBasename("messages");
        sc.setDefaultEncoding("UTF8");
        sc.setUseCodeAsDefaultMessage(true);
        return sc;
    }
}
