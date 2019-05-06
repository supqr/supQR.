package com.coderbunker.supqr.service;

import com.coderbunker.supqr.SupQrConfiguration;
import com.coderbunker.supqr.annotation.Injectable;
import com.coderbunker.supqr.auth.JwtService;
import com.coderbunker.supqr.database.UserRepository;
import com.coderbunker.supqr.rest.model.AuthTO;
import com.coderbunker.supqr.rest.model.JwtTO;
import com.coderbunker.supqr.rest.model.RegistrationTO;
import com.coderbunker.supqr.service.model.Registration;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.generated.tables.pojos.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;

import static com.coderbunker.supqr.auth.User.UserType.USER;

@Slf4j
@Builder
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@Injectable
public class AuthService {

	private final JwtService jwtService;
	private final UserRepository userRepository;
	private final SupQrConfiguration configuration;


	public JwtTO authenticate (AuthTO authTO) {
		log.info("Authenticating user {}...", authTO.getIdentification());
		User user = userRepository
			.getUser(authTO.getIdentification())
			.orElseThrow(() -> new BadRequestException("Wrong credentials"));
		boolean authenticationSuccessful = BCrypt.checkpw(new String(authTO.getPassword()), user.getPassword());
		if (authenticationSuccessful) {
			String token = jwtService.generateToken(USER, user.getUsername(), user.getUserId(), configuration.getSessionDuration());
			return JwtTO
				.builder()
				.token(token)
				.build();
		} else {
			throw new BadRequestException("Wrong credentials");
		}
	}

	public JwtTO register (RegistrationTO registrationTO) {
		log.info("User {} trying to register using password", registrationTO.getUsername());
		Registration registration = mapToRegistration(registrationTO);
		Integer userId = userRepository.createUser(registration);
		String token = jwtService.generateToken(USER, registration.getUsername(), userId, configuration.getSessionDuration());
		return JwtTO
			.builder()
			.token(token)
			.build();
	}

	private Registration mapToRegistration (RegistrationTO registrationTO) {
		String hashedPassword = BCrypt.hashpw(new String(registrationTO.getPassword()), BCrypt.gensalt());
		return Registration
			.builder()
			.firstName(registrationTO.getFirstName())
			.lastName(registrationTO.getLastName())
			.username(registrationTO.getUsername())
			.email(registrationTO.getEmail())
			.hashedPassword(hashedPassword)
			.build();
	}


}
