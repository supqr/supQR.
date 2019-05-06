package com.coderbunker.supqr.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.coderbunker.supqr.annotation.Injectable;
import com.coderbunker.supqr.auth.User.UserType;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jvnet.hk2.annotations.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Date;

import static java.time.Duration.ofHours;

@Slf4j
@Builder
@RequiredArgsConstructor
@Injectable
public class JwtService {

	private static final String TYPE = "type";
	private static final String USER = "user";
	private static final String USER_ID = "userId";

	private static Algorithm algorithm;
	private static JWTVerifier verifier;
	private static JWTVerifier renewalVerifier;

	static {
		try {
			byte[] bytes = new byte[20];
			new SecureRandom().nextBytes(bytes);
			algorithm = Algorithm.HMAC512(bytes);
			verifier = JWT.require(algorithm).build();
			renewalVerifier = JWT
				.require(algorithm)
				.acceptLeeway(60L * 5)
				.build();
		} catch (Exception e) {
			log.error("Encoding exception", e);
		}
	}

	public static User validateToken (String token) {
		DecodedJWT jwt = verifier.verify(token);
		User user = convertJwtToUser(jwt);
		log.info("User {} was validated as {}.", user.getName(), user.getUserType());
		return user;
	}

	public String generateToken (UserType type, String username, Integer userId, int duration) {
		log.info("Creating JWT for user {} with type {}. Expires in {} hours.", username, type, duration);
		return JWT
			.create()
			.withClaim(TYPE, type.toString())
			.withClaim(USER, username)
			.withClaim(USER_ID, userId)
			.withExpiresAt(Date.from(Instant.now().plus(ofHours(duration))))
			.sign(algorithm);
	}

	public String renewToken (String oldToken, int duration) {
		DecodedJWT jwt = renewalVerifier.verify(oldToken);
		User user = convertJwtToUser(jwt);
		log.info("Renewing token of user {}", user.getName());
		return generateToken(user.getUserType(), user.getName(), user.getUserId(), duration);
	}

	private static User convertJwtToUser (DecodedJWT decodedJWT) {
		String name = decodedJWT.getClaim(USER).asString();
		UserType userType = UserType.valueOf(decodedJWT.getClaim(TYPE).asString());
		Integer userId = decodedJWT.getClaim(USER_ID).asInt();
		return new User(userId, name, userType);
	}

}

