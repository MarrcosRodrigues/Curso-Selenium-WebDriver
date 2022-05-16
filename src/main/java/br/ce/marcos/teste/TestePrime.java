package br.ce.marcos.teste;
import static br.ce.marcos.core.DriverFactory.getDriver;
import static br.ce.marcos.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.marcos.core.DSL;

public class TestePrime {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=cf2b4");
		dsl = new DSL();
	}

	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		dsl.clicarRadio(By.xpath("//input[@id='j_idt312:console:0']/../../div//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:0"));
	
		dsl.clicarRadio(By.xpath("//label[.='Option2']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:1"));
	}
	
	
}
