package br.ce.marcos.teste;
import static br.ce.marcos.core.DriverFactory.getDriver;
import static br.ce.marcos.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.marcos.core.DSL;


public class TestePrimeDesafio {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=6aef8");
		dsl = new DSL();
	}

	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test
	public void deveInteragirComSelect() {
		dsl.selecionComboPrime("j_idt311:option", "Option3");
		Assert.assertEquals("Option3", dsl.obterTexto("j_idt311:option_label"));
		
	}

}