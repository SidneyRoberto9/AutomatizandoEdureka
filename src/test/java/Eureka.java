import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Eureka {
    private WebDriver driver;

    private String Login = "shidoni0507@gmail.com", Password = "Sid12345678";

    @Before
    public void inicializar(){
        System.setProperty("webdriver.gecko.driver", "C:/Driver/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @After
    public void finalizar(){
        driver.quit();
    }

    public void wait(int time) throws InterruptedException {
        Thread.sleep (time);
    }

    @Test
    public void login() throws InterruptedException {
        //Passo 1 - Faça login no Edureka
        driver.get("https://www.edureka.co/");

        driver.findElement(By.xpath("/html/body/header/nav/ul/li[4]/span")).click();

        WebElement email = driver.findElement(By.xpath("//*[@id=\"si_popup_email\"]"));
        email.clear();
        email.sendKeys(Login);

        driver.findElement(By.xpath("//*[@id=\"si_popup_passwd\"]")).sendKeys(Password);
        driver.findElement(By.xpath("//*[@id=\"new_sign_up_optim\"]/div/div/div[2]/div[3]/form/button")).click();

        wait(5000);

        //Passo 2 - Navegue até 'Meu Perfil'
        driver.findElement(By.xpath("/html/body/header/nav/div[4]/ul/li[6]/a")).click();
        driver.findElement(By.xpath("/html/body/header/nav/div[4]/ul/li[6]/ul/li[4]/a")).click();
        wait(5000);

        //Passo 3 - Atualize dados profissionais e pessoais
        driver.findElement(By.xpath("//*[@id=\"footauto\"]/app-root/app-profile-main/div/div/div[1]/app-profile-leftnav-pro/div/ul/li[1]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"professional_details\"]/i")).click();

        wait(5000);
        driver.findElement(By.xpath("//*[@id=\"onboarding\"]/div/div[1]/div[1]/app-onboarding-leftnav/ul/li[4]/a")).click();

        new Select(driver.findElement(By.xpath("//*[@id=\"onboarding\"]/div/div[1]/div[2]/div[2]/app-onboarding-career-interests/accordion/accordion-group/div/div[2]/div/form/div[1]/select"))).selectByValue("Cyber Security");
        new Select(driver.findElement(By.xpath("//*[@id=\"onboarding\"]/div/div[1]/div[2]/div[2]/app-onboarding-career-interests/accordion/accordion-group/div/div[2]/div/form/div[2]/select"))).selectByValue("Both");
        new Select(driver.findElement(By.xpath("//*[@id=\"onboarding\"]/div/div[1]/div[2]/div[2]/app-onboarding-career-interests/accordion/accordion-group/div/div[2]/div/form/div[4]/select"))).selectByValue("> $500k");

        driver.findElement(By.xpath("//*[@id=\"onboarding\"]/div/div[1]/div[2]/div[2]/app-onboarding-career-interests/accordion/accordion-group/div/div[2]/div/form/div[5]/div/label[2]")).click();

        wait(5000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait(2000);
        driver.navigate().to("https://www.edureka.co/");
        driver.findElement(By.xpath("/html/body/header/nav/div[4]/ul/li[6]/a")).click();
        driver.findElement(By.xpath("/html/body/header/nav/div[4]/ul/li[6]/ul/li[4]/a")).click();
        wait(5000);

        driver.findElement(By.xpath("//*[@id=\"other_details\"]")).click();
        wait(5000);

        WebElement Name = driver.findElement(By.xpath("//*[@id=\"fullName\"]"));
        Name.clear();
        Name.sendKeys("Sidney Roberto");

        WebElement designation = driver.findElement(By.xpath("//*[@id=\"designation\"]"));
        designation.clear();
        designation.sendKeys("Qa Testing");

        driver.findElement(By.xpath("//*[@id=\"footauto\"]/app-root/app-onboarding-user-details/section/div[2]/div/div[4]/button")).click();
        wait(7000);

        String inicio = driver.getWindowHandle();
        //Passo 4 - explore os blogs e navegue até a página principal
        driver.findElement(By.xpath("//*[@id=\"footauto\"]/app-root/app-profile-main/app-header/header/nav/div/div[1]/a")).click();
        wait(7000);

        driver.findElement(By.xpath("/html/body/section[7]/div/div/div[2]/div/a")).click();

        driver.switchTo().window(inicio);
        driver.findElement(By.xpath("/html/body/header/nav/div[4]/ul/li[6]/a")).click();
        driver.findElement(By.xpath("/html/body/header/nav/div[4]/ul/li[6]/ul/li[12]/a")).click();
    }

}
