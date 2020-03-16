package com.wdcloud.config.i18n;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
@Component("localeResolver")
public class NativeLocaleResolver implements LocaleResolver {

        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String language = request.getHeader("lang");
            if(!StringUtils.isEmpty(language)){
                String[] split = language.split("_");
                return new Locale(split[0],split[1]);
            }
            return Locale.getDefault();
        }

        @Override
        public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

        }
    }