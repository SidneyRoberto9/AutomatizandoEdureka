package br.workspace.core;

import static br.workspace.core.DriverFactory.getDriver;
import static br.workspace.core.DriverFactory.killDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;

public class BaseTest {
	@Before
	public void inicializar() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get("https://www.edureka.co/");
	}
	
	@After
	public void finalizar() {
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
