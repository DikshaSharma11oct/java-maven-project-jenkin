package com.ehcache.LibraryApp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.ehcache.LibraryApp.service.serviceImpl.UserInfoUserDetailService;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    //Authentication
    public UserDetailsService userDetailsService(PasswordEncoder encoder){

        // UserDetails admin= User.withUsername("Basant")
        //     .password(encoder.encode("pwd1"))
        //     .roles("ADMIN")
        //     .build();

        // UserDetails user= User.withUsername("John")
        //     .password(encoder.encode("pwd2"))
        //     .roles("USER")
        //     .build();    

        // return new InMemoryUserDetailsManager(admin,user);   

        return new UserInfoUserDetailService();
        

    }

    @Bean
    //Authorization
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       return http.csrf(csrf -> csrf.disable())
               .authorizeHttpRequests()
               .requestMatchers("/book/welcome","/book/addUser","/attachment/**","/attachment/download/**","/contactus/**").permitAll()
               .and()
               .authorizeHttpRequests()
               .requestMatchers("/book/**").authenticated()
               .and().formLogin(withDefaults()).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService(null));
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    //to provide authentication at a level
}

//https://www.youtube.com/watch?v=R76S0tfv36w&ab_channel=JavaTechie