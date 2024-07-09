//package com.shopping.shopping.securities;
//
//import com.shopping.shopping.entyties.Users;
//import com.shopping.shopping.enums.Role;
//import com.shopping.shopping.repositories.UserRepository;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.AllArgsConstructor;
//import lombok.Value;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//
//@AllArgsConstructor
//@Component
//public class JwtTokenProvider {
//
////    @Value("${derteuffel.app.jwtSecret}")
//    private String jwtSecret;
//
////    @Value("${app.jwt.token.prefix}")
//    private String jwtTokenPrefix;
//
////    @Value(staticConstructor = "${app.jwt.header.string}")
//    private String jwtHeaderString;
//
////    @Value("${derteuffel.app.jwtExpiration}")
//    private Long jwtExpirationInMs;
//
//    private final UserRepository userRepository;
//
//
//
//    public String generateToken(Authentication authentication){
//        String authorities = authentication.getAuthorities()
//                .stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining());
//
//        return Jwts
//                .builder()
//                .setSubject(authentication.getName())
//                .claim("roles", authorities)
//                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
//                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
//    }
//
//    public String generateToken(Users user){
////        Role[]auth = {user.getRole()};
//        String authorities = Arrays.asList(auth)
//                .stream().map(r->r.name()).collect(Collectors.joining());
//        //String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining());
//
//        return Jwts.builder().setSubject(user.getUserName())
//                .claim("roles", authorities)
//                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
//                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
//    }
//
//    public Authentication getAuthentication(HttpServletRequest request){
//        String token = resolveToken(request);
//        if(token == null){
//            return null;
//        }
//        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//        String username = claims.getSubject();
//        List<GrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
//                .map(role -> role.startsWith("ROLE_")? role:"ROLE_"+role)
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//        return username!=null ? new UsernamePasswordAuthenticationToken(username, null, authorities):null;
//    }
//
//    public boolean validateToken(HttpServletRequest request){
//        String token = resolveToken(request);
//        if(token == null){
//            return false;
//        }
//        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//        if(claims.getExpiration().before(new Date())){
//            return false;
//        }
//        return true;
//    }
//
//    public Users extractUser(HttpServletRequest request){
//        String token = resolveToken(request);
//        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//        String username = claims.getSubject();
//        return userRepository.findByUserName(username);
//
//    }
//
//    private String resolveToken(HttpServletRequest request){
//        String bearerToken = request.getHeader(jwtHeaderString);
//        if(bearerToken!=null && bearerToken.startsWith(jwtTokenPrefix)){
//            return bearerToken.substring(7, bearerToken.length());
//        }
//        return null;
//    }
//
////    Long getUserIdFromToken(HttpServletRequest request) {
////        Users userOptional = extractUser(request);
////        if(userOptional.isPresent()){
////            return userOptional.getId();
////        }
////        return null;
////    }
//
//
//}
