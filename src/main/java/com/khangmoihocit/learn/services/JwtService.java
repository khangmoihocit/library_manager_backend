package com.khangmoihocit.learn.services;

import com.khangmoihocit.learn.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "JWT SERVICE")
public class JwtService {

    private final JwtConfig jwtConfig;

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtConfig.getSecretKey());
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Long userId, String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtConfig.getExpirationTime());

        return Jwts.builder()
                .subject(String.valueOf(userId))
                .claim("email", email)
                .issuer(jwtConfig.getIssuer())
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSignInKey(), Jwts.SIG.HS512)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    public String getEmailFromJwt(String token){
        Claims claims = extractAllClaims(token);
        return claims.get("email", String.class);
    }

    /*
    1. token có đúng định dạng không
    2. chữ ký của token có đúng không
    3. kiểm tra xem token có hết hạn hay chuưa
    4.  user_id của token có khớp với userdetail không
    5. kiểm tra xem token có trong blacklist không
    6. kiểm tra quyền
    */

    public boolean isValidToken(String token, UserDetails userDetails){
        try{
            //1. kiem tra dinh dang
            if(!isTokenFormatValid(token)){
                log.error("token k dung dinh dang");
                return false;
            }

            //2. kiem tra chu ky token
            if(!isSignatureValid(token)){
                log.error("chu ky khogn hop le");
                return false;
            }

            //3. token het han chua
            if(!isTokenExpired(token)){
                log.error("token het han");
                return false;
            }

            //4. kiem tra nguon goc cua token
            if(!isIssuerToken(token)){
                log.error("nguon goc token khong hop le");
                return false;
            }

            //5. ktra xem userid trong token co khop voi userdetail khong
            final String email = getEmailFromJwt(token);
            if(!email.equals(userDetails.getUsername())){
                log.error("user token khong hop le");
                return false;
            }

            //6. ktra token co trong blacklist khong

        }catch (Exception e){
            log.error("xac thuc token that bai: " + e.getMessage());
            return false;
        }

        return false;
    }

    private boolean isTokenFormatValid(String token){
        try{
            String[] tokenParts = token.split("\\.");
            return tokenParts.length == 3;
        }catch (Exception e){
            return false;
        }
    }

    private boolean isSignatureValid(String token){
        try{
            Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token){
        final Date expiration = extractClaims(token, Claims::getExpiration);
        return expiration.before(new Date());
    }

    private boolean isIssuerToken(String token){
        String tokenIssuer = extractClaims(token, Claims::getIssuer);
        return tokenIssuer.equals(jwtConfig.getIssuer());
    }

    // Lấy theo nhiều claim khác nhau
    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Giải mã token và lấy tất cả claims
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}