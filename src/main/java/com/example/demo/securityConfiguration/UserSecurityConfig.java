package com.example.demo.securityConfiguration;

import com.example.demo.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**","/static/**","/css/**","/js/**","/img/**","/vendor/**"); // #3
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/getsignup","/postsignup","/login","/index", "/gra" , "/receiptform", "/searchprescription" , "/otp").permitAll()
                .antMatchers("/shivamdash").hasAuthority("user")
                .antMatchers("/Manufacturedash","/manfinvent","/addinvent").hasAuthority("manufacture")
                .antMatchers("/rinventory").hasAuthority("retailer")
                .antMatchers("/getshipments").hasAuthority("shipment")
                .antMatchers("/get/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        for (GrantedAuthority auth : authentication.getAuthorities()) {

                            if("user".equals(auth.getAuthority())) {
                                response.sendRedirect("/shivamdash");
                            }

                            else if("manufacture".equals(auth.getAuthority())) {
                                response.sendRedirect("/Manufacturedash");
                            }

                            else if ("retailer".equals(auth.getAuthority())) {
                                response.sendRedirect("/retaildash");
                            }

                            else if ("shipment".equals(auth.getAuthority())) {
                                response.sendRedirect("/shipmentdash");
                            }
                            else if ("hospital".equals(auth.getAuthority())) {
                                response.sendRedirect("/receiptform");
                            }


                            else {
                                response.sendRedirect("/hello");
                            }
                        }
                    }
                })

                .and().logout().permitAll();
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
