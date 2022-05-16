package br.ce.marcos.teste;
import static br.ce.marcos.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.marcos.core.BaseTest;
import br.ce.marcos.page.CampoTreinamentoPage;

public class TesteCadastro extends BaseTest {

	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}

	@Test
	public void deveRealizarCadastroComSucesso() {
		page.setNome("Marcos");
		page.setSobrenome("Rodrigues");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsportes("Natacao");
		page.cadastrar();

		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Marcos", page.obterNomeCadastro());
		Assert.assertEquals("Rodrigues", page.obterSobrenomeCadrasto());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Pizza", page.obterComidaCadastro());
		Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Natacao", page.obterEsportesCadastro());
	}
}