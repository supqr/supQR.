package com.coderbunker.supqr.database;

import static org.jooq.generated.Tables.USER;

import java.util.Optional;

import javax.inject.Inject;

import org.jooq.generated.tables.pojos.User;
import org.jooq.generated.tables.records.UserRecord;

import com.bendb.dropwizard.jooq.jersey.DSLContextFactory;
import com.coderbunker.supqr.annotation.Injectable;
import com.coderbunker.supqr.service.model.Registration;


@Injectable
public class UserRepository extends AbstractRepository {

	@Inject
	public UserRepository (DSLContextFactory factory) {
		super(factory);
	}

	public Optional<User> getUser (String identification) {
		return getContext()
			.selectFrom(USER)
			.where(USER.EMAIL.eq(identification))
			.or(USER.USERNAME.eq(identification))
			.fetchOptionalInto(User.class);
	}

	public Integer createUser (Registration registration) {
		UserRecord userRecord = getContext()
			.newRecord(USER)
			.setFirstname(registration.getFirstName())
			.setLastname(registration.getLastName())
			.setUsername(registration.getUsername())
			.setEmail(registration.getEmail())
			.setPassword(registration.getHashedPassword());
		userRecord.insert();
		return userRecord.getUserId();
	}

	public boolean isUsernameUsed (String identification) {
		return getUser(identification).isPresent();
	}
}
