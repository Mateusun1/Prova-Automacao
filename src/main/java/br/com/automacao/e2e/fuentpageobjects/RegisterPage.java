package br.com.automacao.e2e.fuentpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "form[class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY'] input[name='email']")
    WebElement inputEmail;
    @FindBy(css = "form[class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY'] input[name='name']")
    WebElement inputNome;
    @FindBy(css = "form[class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY'] input[name='password']")
    WebElement inputSenha;
    @FindBy(css = "form[class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY'] input[name='passwordConfirmation']")
    WebElement inputConfirmarSenha;
    @FindBy(css = "label[class='styles__Container-sc-1pngcbh-0 kIwoPV'] label[id='toggleAddBalance']")
    WebElement botaoAtivarSaldo;
    @FindBy(css = "button[class='style__ContainerButton-sc-1wsixal-0 CMabB button__child']")
    WebElement botaoCadastrar;
    @FindBy(css = "a[id='btnCloseModal']")
    WebElement botaoFecharModal;


    public RegisterPage preencherDados(String email,String nome,String senha,String confirmarSenha){
        this.inputEmail.sendKeys(email);
        this.inputNome.sendKeys(nome);
        this.inputSenha.sendKeys(senha);
        this.inputConfirmarSenha.sendKeys(confirmarSenha);
        return this;
    }
    public RegisterPage ativarSaldo() throws InterruptedException {
        Thread.sleep(300);
        this.botaoAtivarSaldo.click();
        return this;
    }
    public RegisterPage cadastrarConta(){
        this.botaoCadastrar.click();
        return this;
    }
    public LoginPage fecharModal() throws InterruptedException {
        Thread.sleep(300);
        this.botaoFecharModal.click();
        return new LoginPage(driver);
    }

    public RegisterPage limparCampo() {
        this.inputEmail.clear();
        this.inputNome.clear();
        this.inputSenha.clear();
        this.inputConfirmarSenha.clear();
        return this;
    }
}
