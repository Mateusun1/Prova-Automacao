package br.com.automacao.e2e.fuentpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "password")
    WebElement senha;
    @FindBy(css = ".otUnI")
    WebElement botaoEntrar;
    @FindBy(css = "button[class='style__ContainerButton-sc-1wsixal-0 ihdmxA button__child']")
    WebElement botaoRegistrar;


    public LoginPage preencherDados(String email, String senha){
        this.email.sendKeys(email);
        this.senha.sendKeys(senha);
        return this;
    }
    public HomePage clicarBotaoEntrar(){
        this.botaoEntrar.click();
        return new HomePage(driver);
    }
    public RegisterPage clicarBotaoRegistrar(){
        this.botaoRegistrar.click();
        return new RegisterPage(driver);
    }
}
