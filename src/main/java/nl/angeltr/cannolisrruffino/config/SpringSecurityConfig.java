package nl.angeltr.cannolisrruffino.config;


import nl.angeltr.cannolisrruffino.filter.JwtRequestFilter;
import nl.angeltr.cannolisrruffino.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManager auth) throws Exception {
        auth.userDetailsService(customUserDetailService);
    }

    @Override
    @Bean
    public AuthenticationManager authenicationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //JWT token authentication
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.POST, "/users/create").permitAll()
                .antMatchers(HttpMethod.POST, "/users/{username}").permitAll()
                .antMatchers(HttpMethod.GET, "/users/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/users/{id}").permitAll()
                .antMatchers(HttpMethod.PUT, "/users/{username}").permitAll()
                .antMatchers(HttpMethod.PUT, "/users/{username}/{id}").permitAll()
                .antMatchers(HttpMethod.PUT, "/users/{username}/image").permitAll()
                .antMatchers(HttpMethod.DELETE, "/users/delete/{username}").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/persons").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/persons/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/persons/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/persons/**").permitAll()
                .antMatchers(HttpMethod.POST, "/persons").permitAll()
                .antMatchers(HttpMethod.PUT, "/persons/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/persons/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/cannolis").permitAll()
                .antMatchers(HttpMethod.GET, "/cannolis/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/cannolis/{id}/image").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/cannolis/{id}/image").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/cannolis/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/cannolis").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/cannolis/{id}").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/deliveryRequests/all").permitAll()
                .antMatchers(HttpMethod.GET, "/deliveryRequests/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/deliveryRequests/create").permitAll()
                .antMatchers(HttpMethod.PUT, "/deliveryRequests/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/deliveryRequests/delete/{id}").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/images/upload").permitAll()
                .antMatchers(HttpMethod.GET, "/images/download/{fileName}").permitAll()
                .antMatchers(HttpMethod.GET, "/images/delete").hasRole("ADMIN")

                .antMatchers("/authenticated").authenticated()
                .antMatchers("/authenticate").permitAll()

                .anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreateionPolicy(SessionCreationPolicy.STATELESS);
                http.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);

    }


}
