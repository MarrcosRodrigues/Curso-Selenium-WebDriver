import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TesteGoogle {
	
	private WebDriver driver;

	@Before
	public void inicializa() {
		driver = new EdgeDriver();
		driver.manage().window().setSize(new Dimension(1000, 720));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void teste() {
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
	}
}
