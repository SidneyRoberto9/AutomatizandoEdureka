package br.workspace.core;

import static br.workspace.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class BasePage {

	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}
	public void clicarBotao(String id_campo) {
		clicarBotao(By.id(id_campo));
	}
	
	public void escreva(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
		
	}
	public void escreva(String id_campo, String texto) {
		escreva(By.id(id_campo), texto);
	}
	
	public void selecionarCombo(String aba, String DropName, String valor) {
		clicarBotao(By.xpath("//*[@id='onboarding']/div//"+aba+"//*[@name='"+DropName+"']"));
		clicarBotao(By.xpath("//*[@id='onboarding']/div//"+aba+"//*[@name='"+DropName+"']//*[@value='"+valor+"']"));
	}

	public void irPagina(String pagina) {
		getDriver().navigate().to(pagina);
	}
	
	public String janela() {
		return getDriver().getWindowHandle();
	}
	
	public void mudarTela(String tela) {
		getDriver().switchTo().window(tela);
	}
}
