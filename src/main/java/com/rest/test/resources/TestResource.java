package com.rest.test.resources;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;

public interface TestResource {
	@Get
	Representation getResource() throws ResourceException;
	
	@Post
	Representation postResource(StringRepresentation postData) throws ResourceException;
	
	@Put
	Representation putResource(StringRepresentation putData) throws ResourceException;
	
	@Delete
	Representation deleteResource() throws ResourceException;
}
