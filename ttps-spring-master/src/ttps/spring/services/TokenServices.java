package ttps.spring.services;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;

@Service
public class TokenServices {

    final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // Primer metodo: Se genera el token a partir del builder de Jwts
    public static String generateToken(String username, int segundos) {

        Date exp = getExpiration(new Date(), segundos);

        return Jwts.builder().setSubject(username).signWith(key).setExpiration(exp).compact();
    }
    // Segundo metodo: Se genera la expiracion de modo que tomamos la fecha actual y luego le añadimos la cantidad de segundos 
    // en base a la cantidad de tiempo que queremos que dure el token
    private static Date getExpiration(Date date, int segundos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, segundos);

        return calendar.getTime();
    }
    
    // Tercer metodo: Es el validador, retornara true si es correcto y si no retornara una Exception.
    public static boolean validateToken(String token) {

        String prefix = "Bearer";
        try {

            if (token.startsWith(prefix)) {
                token = token.substring(prefix.length()).trim();
            }
            return true;
        } catch (ExpiredJwtException exp) {
            System.out.println("El Token es valido, pero expiro su tiempo de validez");
            return false;
        } catch (JwtException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }

    }
}