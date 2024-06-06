package se.ifmo.lab8.security.encoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/*
 * FIPS-standard password encoder configuration
 * algorithm: PBKDF2WithHmacSHA512
 */

@Configuration
public class PasswordEncoderConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder(
            @Value("${encoder.secret}") String secret,
            @Value("${encoder.iterations}") int iterations,
            @Value("${encoder.hashWidth}") int hashWidth
    ) {
        return new Pbkdf2PasswordEncoder(secret, iterations, hashWidth, Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA512);
    }
}