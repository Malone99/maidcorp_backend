package com.fmc.maidcorp.security.config;

import com.fmc.maidcorp.user.AppUser;
import com.fmc.maidcorp.user.UserAppService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.transaction.TransactionDefinition.withDefaults;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebsecurityConfig  {

    private final UserAppService userAppService;
    @Autowired
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Bean
    public SecurityFilterChain  filterChain(HttpSecurity httpSecurity) throws Exception{
       return httpSecurity.csrf().disable()
                .authorizeHttpRequests(
                        (auth)->{
                            try {
                                auth.requestMatchers("maidcorp/api/registration/**")
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated()
                                        .and()
                                        .formLogin();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                ).build();
    }

    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
         provider.setPasswordEncoder(bCryptPasswordEncoder);
         provider.setUserDetailsService(userAppService);
         return provider;
    }


}
