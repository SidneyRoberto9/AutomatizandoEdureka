import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {
private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
		
	}

	public void clicarBotao(By by) {
		driver.findElement(by).click();
	}
	public void clicarBotao(String id_campo) {
		clicarBotao(By.id(id_campo));
	}
	
	public void escreva(By by, String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
		
	}
	public void escreva(String id_campo, String texto) {
		escreva(By.id(id_campo), texto);
	}
	
	public void selecionarCombo(String aba, String DropName, String valor) {
		clicarBotao(By.xpath("//*[@id='onboarding']/div//"+aba+"//*[@name='"+DropName+"']"));
		clicarBotao(By.xpath("//*[@id='onboarding']/div//"+aba+"//*[@name='"+DropName+"']//*[@value='"+valor+"']"));
	}

	public void irPagina(String pagina) {
		driver.navigate().to(pagina);
	}
	
	public String janela() {
		return driver.getWindowHandle();
	}
	
	public void mudarTela(String tela) {
		driver.switchTo().window(tela);
	}
}
