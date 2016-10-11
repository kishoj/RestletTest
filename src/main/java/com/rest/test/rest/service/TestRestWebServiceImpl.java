package com.rest.test.rest.service;

import org.restlet.representation.Representation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.test.dao.TestDAO;
import com.rest.test.domains.Test;
import com.rest.test.utils.JsonUtils;

@Service("testRestWebService")
public class TestRestWebServiceImpl implements TestRestWebService {
	@Autowired
	private TestDAO testDAO;

	public Representation getResource(Long testId) throws Exception {
		if (testId != null) {
			return JsonUtils.getJsonRepresentation(testDAO.getById(testId));
		} else {
			return JsonUtils.getJsonRepresentation(testDAO.getAll());
		}
	}

	public Representation postResource(Test test) throws Exception {
		return JsonUtils.getJsonRepresentation(testDAO.create(test));
	}
	
	public Representation putResource(Test test) throws Exception {
		testDAO.update(test);
		return JsonUtils.getJsonRepresentation(null);
	}
	
	public Representation deleteResource(Long testId) throws Exception {
		testDAO.deleteById(testId);
		return JsonUtils.getJsonRepresentation(null);
	}
}
