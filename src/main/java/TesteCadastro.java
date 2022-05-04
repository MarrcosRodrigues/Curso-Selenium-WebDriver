import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TesteCadastro {

	private WebDriver driver;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		driver = new EdgeDriver();
		driver.manage().window().setSize(new Dimension(1000, 720));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);
	}

	@After
	public void finaliza() {
		driver.quit();
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

		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Marcos"));
		Assert.assertEquals("Sobrenome: Rodrigues", page.obterSobrenomeCadrasto());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", page.obterEsportesCadastro());
	}
}