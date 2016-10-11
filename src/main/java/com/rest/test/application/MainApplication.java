package com.rest.test.application;

import org.restlet.Application;
import org.restlet.Restlet;

public class MainApplication extends Application {
	private Restlet root;

	public Restlet createInboundRoot() {
		return root;
	}

	public void setRoot(Restlet root) {
		this.root = root;
	}
}
