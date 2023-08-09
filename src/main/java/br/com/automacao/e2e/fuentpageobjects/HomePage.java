package br.com.automacao.e2e.fuentpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
    }

    @FindBy(id = "btn-TRANSFERÊNCIA")
    WebElement botaoTransferencia;
    @FindBy(css = "p[id='textAccountNumber'] span")
    WebElement numeroContaBancaria;
    @FindBy(css = "div[class='home__ContainerLink-sc-1auj767-2 cCGrzy']")
    WebElement botaoLoggout;

    public TransferenciaPage clicarBotaoTranferencia(){
        this.botaoTransferencia.click();
        return new TransferenciaPage(driver);
    }
    public String getNumeroConta(){
        String numeroConta = numeroContaBancaria.getText();
        botaoLoggout.click();
        return numeroConta;
    }
}
