package com.rest.test.rest.service;

import org.restlet.representation.Representation;

import com.rest.test.domains.Test;

public interface TestRestWebService {
	Representation getResource(Long testId) throws Exception;
	Representation postResource(Test test) throws Exception;
	Representation putResource(Test test) throws Exception;
	Representation deleteResource(Long testId) throws Exception;
}
