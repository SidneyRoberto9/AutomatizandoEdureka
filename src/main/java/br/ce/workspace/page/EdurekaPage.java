package br.ce.workspace.page;
import org.openqa.selenium.By;

import br.ce.workspace.core.BasePage;

public class EdurekaPage extends BasePage{
	
	public void setFazerLogin(String user, String Passw) {
		clicarBotao(By.xpath("/html/body/header/nav/ul/li[4]/span")); //Clica no botão "Log in"
		escreva("si_popup_email", user);                              //Escreve o nome de Usuario
		escreva("si_popup_passwd", Passw);                            //Escreve a senha
		//Clica no Botão login, para finaliar o login
		clicarBotao(By.xpath("//*[@id=\"new_sign_up_optim\"]/div/div/div[2]/div[3]/form/button"));
		
	}
	
	public void setNavegarPerfil() {
		//clica no Botão onde se localiza seu nome, e desce um combo
		clicarBotao(By.xpath("//*[@id='auto_banner_load']/..//header/nav//*[@class='webinar-profile-name']"));
		//clica na opção "My Profile do Combo"
		clicarBotao(By.xpath("//*[@id='auto_banner_load']/..//header/nav//*[.='My Profile']"));
		
	}

	public void setAtualizarDados() throws InterruptedException {
		//em "my Profile" eu clico em "Career Services" para atualizar o cadastro profissional
		//.clicarBotao(By.xpath("//*[@id='footauto']/app-root/app-profile-main//*[.='Career Services']"));
		//.clicarBotao("professional_details"); //clico detalhes para poder editar
		
		//Sigo uma cadeira de comandos Para preencher todas as opções, deixando apenas "enviar arquivo de Fora"
		//Pagina "Professional Details"
		//.escreva(By.xpath("//*[@id='onboarding']/div//app-onboarding-professional-details//*[.='Company Name?']/../input"), "Roberto Company");
		//.escreva(By.xpath("//*[@id='onboarding']/div//app-onboarding-professional-details//*[.='Skills*']/../input"), "JUnit");
		//.escreva(By.xpath("//*[@id='onboarding']/div//app-onboarding-professional-details//*[.='Linkedin Profile']/../input"), "https://www.linkedin.com/abb");
		//.selecionarCombo("app-onboarding-professional-details", "currentIndustry", "IT-Hardware & Networking");
		//.selecionarCombo("app-onboarding-professional-details", "currentjob", "Top/Executive Management");
		
		//muda de pagina para para avançar evitando o botão 
		irPagina("https://learning.edureka.co/onboarding/careerinterests");
		
		//Pagina "Career interests"
		
		selecionarCombo("app-onboarding-career-interests", "interestedJob", "Software Testing");
		selecionarCombo("app-onboarding-career-interests", "elementType", "Permanent");
		selecionarCombo("app-onboarding-career-interests", "lastDrawnSalaryUS", "$225K-$250k");
		
		//Pagina "Other Details"
		clicarBotao(By.xpath("//*[@id='onboarding']/div//app-onboarding-career-interests//*[@type='submit']"));
		
		//Clicar para finalizar e salvar tudo
		irPagina("https://learning.edureka.co/my-profile");
		
		//Ao voltar no "my Profile" clica em editar para atualizar as informações pessoais
		clicarBotao("other_details");
		
		//cadeia de comandos atualizando dados
		Thread.sleep(2000);
		escreva(By.xpath("//*[@id='fullName']"), "Roberto");
		Thread.sleep(2000);
		
		escreva("designation", "QA Tester player");
		clicarBotao(By.xpath("//*[@id='footauto']//app-onboarding-user-details/section//*[.='Improve in current job']/.."));
		
		//clico para enviar tudo que fora atualizado
		clicarBotao(By.xpath("//*[@id='footauto']//app-onboarding-user-details//*[.='SUBMIT']"));
		
		//navego ate a pagina inicial
		irPagina("https://www.edureka.co/");

	}
	
	public void setBlog() {
		 	String inicio = janela();//captura a janela atual
			
		 	clicarBotao("dropdownMenu4");//desce o menu
		 	//Clica na opção blogs e abre outra janela
			clicarBotao(By.xpath("//*[@id='auto_banner_load']/../header/nav//*[@class='ga-blog ga_ecom_info']//*[.='Blog']"));
			//Retorna a janela inicial
	        mudarTela(inicio);
	        //clica no Botão onde se localiza seu nome, e desce um combo
	      	clicarBotao(By.xpath("//*[@id='auto_banner_load']/..//header/nav//*[@class='webinar-profile-name']"));
	      	//clica na opção "Log out"
	      	clicarBotao(By.xpath("//*[@id='auto_banner_load']/..//header/nav//*[.='Log Out']"));
	}
}
