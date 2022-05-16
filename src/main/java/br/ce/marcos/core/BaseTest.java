package br.ce.marcos.core;

import static br.ce.marcos.core.DriverFactory.killDriver;

import org.junit.After;

public class BaseTest {
	
	@After
	public void finaliza() {
		killDriver();
	}

}
