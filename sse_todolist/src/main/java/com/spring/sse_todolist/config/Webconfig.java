package com.spring.sse_todolist.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.Rfc6265CookieProcessor;
import org.apache.tomcat.util.http.SameSiteCookies;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@RequiredArgsConstructor
public class Webconfig implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")

                // 주소 수정 부분
                .allowedOrigins(
                        "http://localhost:3000",
                        "http://localhost:5500",
                        "http://3.35.210.170:8080",
                        "http://mychatting.s3-website.ap-northeast-2.amazonaws.com/",
                        "https://s3.ap-northeast-2.amazonaws.com/marketkurly-imageupload",
                        "https://s3.ap-northeast-2.amazonaws.com/ljw8967",
                        "http://ljw8967.s3-website.ap-northeast-2.amazonaws.com"
                )
                .allowedOriginPatterns("*")
                .allowedMethods("POST", "GET","PATCH", "PUT","DELETE", "HEAD", "OPTIONS")
//                .exposedHeaders("*")
                .allowCredentials(true);
    }

    @Bean
    public TomcatContextCustomizer sameSiteCookiesConfig() {
        return context -> {
            final Rfc6265CookieProcessor cookieProcessor = new Rfc6265CookieProcessor();
            cookieProcessor.setSameSiteCookies(SameSiteCookies.NONE.getValue());
            context.setCookieProcessor(cookieProcessor);
        };
    }


}
