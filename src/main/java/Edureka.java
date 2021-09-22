import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Edureka {
	private WebDriver driver;
	private EdurekaPage page;
	private String user = "shidoni0507@gmail.com", Passw = "Sid12345678";
	
	@Before
	public void inicializar() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		page = new EdurekaPage(driver);
		driver.manage().window().setPosition(new Point(-2000,0)); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.edureka.co/");
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	
	@Test
	public void Passo1_fazerLogin() {
		page.setFazerLogin(user, Passw);
	}
	
	@Test
	public void Passo2_NavegarMeuPerfil() {
		page.setFazerLogin(user, Passw);
		page.setNavegarPerfil();
	}
	
	@Test
	public void Passo3_AtualizeDados () throws InterruptedException {
		page.setFazerLogin(user, Passw);
		page.setNavegarPerfil();
		page.setAtualizarDados();
	
	}
	
	@Test
	public void Passo4_blogsInicio() {
		page.setFazerLogin(user, Passw);
		page.setBlog();
	   
	}
	
	@Test
	public void test_completo() throws InterruptedException {
		page.setFazerLogin(user, Passw);
		page.setNavegarPerfil();
		page.setAtualizarDados();
		page.setBlog();
	   
	}

}
