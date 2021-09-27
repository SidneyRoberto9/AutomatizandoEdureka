package br.ce.workspace.test;
import org.junit.Test;

import br.ce.workspace.core.BaseTest;
import br.ce.workspace.page.EdurekaPage;

public class EdurekaTest extends BaseTest{
	private EdurekaPage page = new EdurekaPage();
	private String user = "shidoni0507@gmail.com", Passw = "Sid12345678";
	
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
