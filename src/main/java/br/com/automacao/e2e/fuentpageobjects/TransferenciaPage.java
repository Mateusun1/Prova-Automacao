package br.com.automacao.e2e.fuentpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TransferenciaPage {
    WebDriver driver;
    public TransferenciaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }
    @FindBy(name = "accountNumber")
    WebElement inputNumeroConta;
    @FindBy(name = "digit")
    WebElement inputDigitoConta;
    @FindBy(name = "transferValue")
    WebElement inputValorTransferencia;
    @FindBy(css = ".CMabB")
    WebElement botaoTransferir;
    @FindBy(id = "modalText")
    WebElement mensagemTransferenciaSucesso;

    public TransferenciaPage preencherValoresDaTransferencia(String numeroConta, String valorTransferencia){
        this.inputNumeroConta.sendKeys(numeroConta.substring(0,3));
        this.inputDigitoConta.sendKeys(numeroConta.substring(4,5));
        this.inputValorTransferencia.sendKeys(valorTransferencia);
        return this;
    }

    public TransferenciaPage realizarTransferencia(){
        this.botaoTransferir.click();
        return this;
    }

    public String PegarMensagem() throws InterruptedException {
        Thread.sleep(500);
        return this.mensagemTransferenciaSucesso.getText();
    }
}
