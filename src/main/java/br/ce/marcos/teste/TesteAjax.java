package br.ce.marcos.teste;
import static br.ce.marcos.core.DriverFactory.getDriver;
import static br.ce.marcos.core.DriverFactory.killDriver;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.marcos.core.DSL;


public class TesteAjax {
	
	private DSL dsl;

	@Before
	public void inicializa() {
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();

	}

	@After
	public void finaliza() {
		killDriver();
	}

	
	@Test
	public void TestAjax() {
		dsl.escrever("j_idt311:name", "Teste");
		dsl.clicarBotao("j_idt311:j_idt315");
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBe(By.id("j_idt311:display"), "Teste"));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("'j_idt98")));
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt311:display"));
		
	}
}
