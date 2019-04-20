package com.eternitysl.idam.common.localization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Translator {
    private static ResourceBundleMessageSource resourceBundleMessageSource;

    @Autowired
    Translator(ResourceBundleMessageSource resourceBundleMessageSource) {
        Translator.resourceBundleMessageSource = resourceBundleMessageSource;
    }

    public static String toLocale(String msgCode) {
        Locale locale = LocaleContextHolder.getLocale();
        return resourceBundleMessageSource.getMessage(msgCode, null, locale);
    }
}
