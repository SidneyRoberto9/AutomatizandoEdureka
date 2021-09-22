import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EdurekaPage {
	
private DSL dsl;
	
	public EdurekaPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void setFazerLogin(String user, String Passw) {
		dsl.clicarBotao(By.xpath("/html/body/header/nav/ul/li[4]/span")); //Clica no botão "Log in"
		dsl.escreva("si_popup_email", user);                              //Escreve o nome de Usuario
		dsl.escreva("si_popup_passwd", Passw);                            //Escreve a senha
		//Clica no Botão login, para finaliar o login
		dsl.clicarBotao(By.xpath("//*[@id=\"new_sign_up_optim\"]/div/div/div[2]/div[3]/form/button"));
		
	}
	
	public void setNavegarPerfil() {
		//clica no Botão onde se localiza seu nome, e desce um combo
		dsl.clicarBotao(By.xpath("//*[@id='auto_banner_load']/..//header/nav//*[@class='webinar-profile-name']"));
		//clica na opção "My Profile do Combo"
		dsl.clicarBotao(By.xpath("//*[@id='auto_banner_load']/..//header/nav//*[.='My Profile']"));
		
	}

	public void setAtualizarDados() throws InterruptedException {
		//em "my Profile" eu clico em "Career Services" para atualizar o cadastro profissional
		//dsl.clicarBotao(By.xpath("//*[@id='footauto']/app-root/app-profile-main//*[.='Career Services']"));
		//dsl.clicarBotao("professional_details"); //clico detalhes para poder editar
		
		//Sigo uma cadeira de comandos Para preencher todas as opções, deixando apenas "enviar arquivo de Fora"
		//Pagina "Professional Details"
		//dsl.escreva(By.xpath("//*[@id='onboarding']/div//app-onboarding-professional-details//*[.='Company Name?']/../input"), "Roberto Company");
		//dsl.escreva(By.xpath("//*[@id='onboarding']/div//app-onboarding-professional-details//*[.='Skills*']/../input"), "JUnit");
		//dsl.escreva(By.xpath("//*[@id='onboarding']/div//app-onboarding-professional-details//*[.='Linkedin Profile']/../input"), "https://www.linkedin.com/abb");
		//dsl.selecionarCombo("app-onboarding-professional-details", "currentIndustry", "IT-Hardware & Networking");
		//dsl.selecionarCombo("app-onboarding-professional-details", "currentjob", "Top/Executive Management");
		
		//muda de pagina para para avançar evitando o botão 
		dsl.irPagina("https://learning.edureka.co/onboarding/careerinterests");
		
		//Pagina "Career interests"
		
		dsl.selecionarCombo("app-onboarding-career-interests", "interestedJob", "Software Testing");
		dsl.selecionarCombo("app-onboarding-career-interests", "elementType", "Permanent");
		dsl.selecionarCombo("app-onboarding-career-interests", "lastDrawnSalaryUS", "$225K-$250k");
		
		//Pagina "Other Details"
		dsl.clicarBotao(By.xpath("//*[@id='onboarding']/div//app-onboarding-career-interests//*[@type='submit']"));
		
		//Clicar para finalizar e salvar tudo
		dsl.irPagina("https://learning.edureka.co/my-profile");
		
		//Ao voltar no "my Profile" clica em editar para atualizar as informações pessoais
		dsl.clicarBotao("other_details");
		
		//cadeia de comandos atualizando dados
		Thread.sleep(2000);
		dsl.escreva(By.xpath("//*[@id='fullName']"), "Roberto");
		Thread.sleep(2000);
		
		dsl.escreva("designation", "QA Tester player");
		dsl.clicarBotao(By.xpath("//*[@id='footauto']//app-onboarding-user-details/section//*[.='Improve in current job']/.."));
		
		//clico para enviar tudo que fora atualizado
		dsl.clicarBotao(By.xpath("//*[@id='footauto']//app-onboarding-user-details//*[.='SUBMIT']"));
		
		//navego ate a pagina inicial
		dsl.irPagina("https://www.edureka.co/");

	}
	
	public void setBlog() {
		 	String inicio = dsl.janela();//captura a janela atual
			
		 	dsl.clicarBotao("dropdownMenu4");//desce o menu
		 	//Clica na opção blogs e abre outra janela
			dsl.clicarBotao(By.xpath("//*[@id='auto_banner_load']/../header/nav//*[@class='ga-blog ga_ecom_info']//*[.='Blog']"));
			//Retorna a janela inicial
	        dsl.mudarTela(inicio);
	        //clica no Botão onde se localiza seu nome, e desce um combo
	      	dsl.clicarBotao(By.xpath("//*[@id='auto_banner_load']/..//header/nav//*[@class='webinar-profile-name']"));
	      	//clica na opção "Log out"
	      	dsl.clicarBotao(By.xpath("//*[@id='auto_banner_load']/..//header/nav//*[.='Log Out']"));
	}
}
