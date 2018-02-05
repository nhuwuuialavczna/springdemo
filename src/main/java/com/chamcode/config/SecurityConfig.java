package com.chamcode.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
public class SecurityConfig /*extends WebSecurityConfigurerAdapter */{
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("us").password("us").roles("USER").and()
//                .withUser("ad").password("ad").roles("ADMIN");
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests() // bảo mật các request được gửi đến
////                .antMatchers("*/auth").hasRole("USER") // kiểm tra khớp url
////                .anyRequest()   // cho mọi request
//////                .permitAll() // cho phép tất cả
////                .fullyAuthenticated() // tất cả các bảo mật đươc cài đặt ở trên
////                .and().httpBasic(); // và tất cả http cơ bản
////        http.csrf().disable(); // csrf sẽ bị tắt. CSRF đọc google
//
//
//        // sử dụng servlet filter
//        http.authorizeRequests()
//
//                .anyRequest()
//                .fullyAuthenticated()
//                .and()
//                .addFilterAfter(customFilter(), BasicAuthenticationFilter.class)
//                .httpBasic(); // và tất cả http cơ bản
//        http.csrf().disable(); // csrf sẽ bị tắt. CSRF đọc google
//
//    }

//    @Bean
//    public Filter customFilter() {
//        return new CustomFilter();
//    }
}
