package ua.tarch64.carlineapi.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
@EnableWebSecurity
class AuthConfigurer(environment: Environment): WebSecurityConfigurerAdapter() {
    private val username = environment.getProperty("ua.tarch64.car-line-api.basic-auth.username")
    private val password = environment.getProperty("ua.tarch64.car-line-api.basic-auth.password")
    private val passwordEncoder = BCryptPasswordEncoder()

    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity
            .csrf().disable()
            .authorizeRequests().anyRequest().authenticated()
            .and().httpBasic()
    }

    @Autowired
    fun configureGlobal(authentication: AuthenticationManagerBuilder) {
        authentication.inMemoryAuthentication()
            .withUser(username)
            .password(passwordEncoder.encode(password))
            .authorities("ADMIN")
    }

    @Bean
    fun providePasswordEncoder(): PasswordEncoder {
        return passwordEncoder
    }
}
