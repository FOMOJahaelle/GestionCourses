package com.shopping.shopping.securities;

import com.shopping.shopping.repositories.UserRepository;
import com.shopping.shopping.services.Authencationervice;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@AllArgsConstructor
@Configuration
//@EnableWebSecurity
@EnableMethodSecurity
@EnableWebSecurity

public class SpringSecurityConfig{
    private final String [] Authority = {
          "/swagger-ui/index.html#/**",
           "/swagger-ui/index.html#",
           "/swagger-ui/**",
            "/v3/api-docs/**",
            "/configuration/security",
        "/swagger-resources",
        "/swagger-resources/**",
           "/api/users/login",
          "/api/users/create",
    };

    private final JwtAuthorizationFilter  jwtAuthorizationFilter;
   private final Authencationervice userService;

    private final UserRepository userRepository;


    @Bean
    UserDetailsService userDetailsService() {
        return username -> userRepository.findByUserName(username);

    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return   http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(request -> request
                        .requestMatchers(Authority).permitAll()
//                       .requestMatchers(POST,"/api/**").permitAll()
                       .requestMatchers("/api/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .sessionManagement(manager -> manager.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
//@Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
////    }
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//      authProvider.setUserDetailsService(userService.userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
//            throws Exception {
//        return config.getAuthenticationManager();
//    }

    @Bean
    UrlBasedCorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//
//        configuration.setAllowedOrigins(List.of("http://localhost:8080"));
//        configuration.setAllowedMethods(List.of("GET","POST"));
//        configuration.setAllowedHeaders(List.of("Authorization","Content-Type"));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//        source.registerCorsConfiguration("/**",configuration);
//
//        return source;
//    }



//
////    @Bean
////    UserDetailsService userDetailsService() {
////        return new UserDetailsServiceImpl();
////    }
//
//    @Bean
//    BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//
//    @Bean
//    SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth -> auth
//                                .requestMatchers(GET,"/api/**").permitAll()
//                                               .requestMatchers(Authority).permitAll()
//                                               .requestMatchers(POST,"/api/**").hasAnyAuthority("ADMIN")
//                                               .requestMatchers(GET,"/api/**").hasAnyAuthority("USER","ADMIN")
//
//                                                .anyRequest().authenticated()
//                )
//                                                 .formLogin(login -> login.permitAll())
//                                                .logout(logout -> logout.permitAll())
//                .exceptionHandling(eh -> eh.accessDeniedPage("/403"))
//        ;
//
//        return http.build();
//    }

//
//    private final JwtTokenProvider tokenProvider;
//    private final UserDetailsService userDetailsService;
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }




//   @Autowired
//   BearerTokenAuthFilter bearerTokenAuthFilter;

//    private final AuthenticationProvider authenticationProvider;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http
//                .authorizeHttpRequests(request -> {
//                    request.requestMatchers(Authority).permitAll();
//                    request.requestMatchers(GET,"/api/**").permitAll();
//                    request.anyRequest().authenticated();
//                })
//                .csrf(AbstractHttpConfigurer::disable)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }

//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//        return
//                httpSecurity
//                       .csrf(AbstractHttpConfigurer::disable)
//
//                        .authorizeHttpRequests(
//                                authorize ->
//                                        authorize
//                                                .requestMatchers(GET,"/api/**").permitAll()
//                                                .requestMatchers(Authority).permitAll()
////                                                .requestMatchers(POST,"/api/**").hasAnyAuthority("ROLE_ADMIN")
//                                                .anyRequest().authenticated()
//                                                  )
////                                          .addFilter(new JwtAuthorizationFilter(authenticationManager(), tokenProvider))
//                                            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
//
//                        .build();
//
//    }
//
//
////
////    @Bean
////    public AuthenticationProvider authenticationProvider() {
////        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
////        authProvider.setUserDetailsService(userService.userDetailsService());
////        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
////        return authProvider;
////    }
//
//
//
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManager();
//    }
//    //Cross origin resource sharing.
////    @Bean
////    public WebMvcConfigurer corsConfigurer() {
////        return new WebMvcConfigurer() {
////            @Override
////            public void addCorsMappings(CorsRegistry registry) {
////                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
////            }
////        };
////    }
//
////    @Bean
////    public AuthenticationProvider authenticationProvider() {
////        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
////        authenticationProvider.setUserDetailsService(userDetailsService());
////        authenticationProvider.setPasswordEncoder(passwordEncoder());
////        return authenticationProvider;
////
////    }
//
////    @Bean
////    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
////        return config.getAuthenticationManager();
////    }
//
//
////    @Bean
////    public SecurityFilterChain web(HttpSecurity http) throws Exception {
//////        http
//////                .authorizeHttpRequests((authorize) ->
//////                        authorize
//////                        .requestMatchers(Authority).permitAll()
////////                        .anyRequest().authenticated()
//////                );
//////        // ...
////
////        return http.build();
////    }
//
//
////    @Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////
////        return new BCryptPasswordEncoder();
////    }
//
////    @Bean
////    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
////        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
////        authenticationManagerBuilder.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
////        retudzrn authenticationManagerBuilder.build();
////    }

}
