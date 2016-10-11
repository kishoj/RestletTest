package com.rest.test.resources;

import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.test.domains.Test;
import com.rest.test.rest.service.TestRestWebService;
import com.rest.test.utils.JsonUtils;

@Component
public class TestServerResource extends ServerResource implements TestResource {
	@Autowired
	private TestRestWebService testRestWebService;

	@Get
	public Representation getResource() throws ResourceException {
		Long testId = null;
		Object obj = getRequestAttributes().get("testId");
		if (obj != null) {
			String testIdString = (String) obj;
			testId = Long.parseLong(testIdString);
			System.out.println(testId);
		}
		getResponse().setStatus(Status.SUCCESS_OK);
		try {
			return testRestWebService.getResource(testId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage());
		}
	}

	public Representation postResource(StringRepresentation postData) throws ResourceException {
		String jsonString = postData.getText();
		if (jsonString == null || jsonString.isEmpty()) {
			throw new ResourceException(400, "postData cannot be null", "Error detail: postData cannot be null",
					"API URI");
		}
		Test test = JsonUtils.getObjectFromJSON(jsonString, Test.class);
		getResponse().setStatus(Status.SUCCESS_CREATED);
		try {
			return testRestWebService.postResource(test);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage());
		}
	}

	public Representation putResource(StringRepresentation putData) throws ResourceException {
		Object objId = getRequestAttributes().get("testId");
		if (objId == null) {
			System.out.println("Cannot update: id missing");
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Cannot update: id missing");
		}
		getResponse().setStatus(Status.SUCCESS_OK);
		String jsonString = putData.getText();
		if (jsonString == null || jsonString.isEmpty()) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "putData cannot be null");
		}
		Test test = JsonUtils.getObjectFromJSON(jsonString, Test.class);
		try {
			return testRestWebService.putResource(test);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage());
		}
	}

	public Representation deleteResource() throws ResourceException {
		Long testId = null;
		Object objId = getRequestAttributes().get("testId");
		if (objId == null) {
			System.out.println("Requests for delete all resources");
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Cannot delete all resources");
		} else {
			String testIdString = (String) objId;
			testId = Long.parseLong(testIdString);
			System.out.println("Requests for delete single resource with id " + testId);
		}
		getResponse().setStatus(Status.SUCCESS_OK);
		try {
			return testRestWebService.deleteResource(testId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage());
		}
	}
}