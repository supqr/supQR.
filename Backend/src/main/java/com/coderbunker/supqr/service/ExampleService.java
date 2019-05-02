package com.coderbunker.supqr.service;

import com.coderbunker.supqr.annotation.Injectable;
import com.coderbunker.supqr.database.ExampleRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;

@RequiredArgsConstructor(onConstructor = @__(@Inject))
@Injectable
public class ExampleService {

	private final ExampleRepository exampleRepository;

	public String getExample () {
		return exampleRepository.getExample();
	}

}
