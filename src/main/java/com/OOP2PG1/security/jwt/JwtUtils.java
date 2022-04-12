package com.OOP2PG1.security.jwt;

import java.util.Date;

import com.OOP2PG1.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${OOP2PG1.app.jwtSecret}")
    private String jwtSecret;

    @Value("${OOP2PG1.app.jwtExpirationMs}")
    private int jwtExpirationMs;
    // Takes the authentication object. (that have the loginRequest username and password originally)
    public String generateJwtToken(Authentication authentication) {

        // creating an object from UserDetailsImpl class called userPrincipal. In it, we pass the authentication object username and password
        // into a new object of the UserDetailsImpl type. (In UserDetailsImpl there is additional variables, id, email and a collection of authorities.
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        // Creating a Jwt based on the users username, current date, sets an expiration date and an encrypted signatur, lastly (compact) it into one String variable and return it.
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
