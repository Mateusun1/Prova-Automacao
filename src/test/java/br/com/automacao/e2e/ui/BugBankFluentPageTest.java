package br.com.automacao.e2e.ui;

import br.com.automacao.e2e.fuentpageobjects.LoginPage;
import br.com.automacao.e2e.utils.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

class BugBankFluentPageTest extends BaseTest {
    private final WebDriver driver = getDriver();
    @Test
    @DisplayName("Deve realizar uma transferência de uma conta pra outra")
    void DeveTransferirDinheiroParaOutraConta() {
        LoginPage loginPage = new LoginPage(driver)
                .clicarBotaoRegistrar()
                .preencherDados("email@email.com","Joao","12345", "12345")
                .ativarSaldo()
                .cadastrarConta()
                .fecharModal();

        String numeroConta = loginPage
                .clicarBotaoRegistrar()
                .limparCampo()
                .preencherDados("maria@email.com","Maria","12345", "12345")
                .cadastrarConta()
                .fecharModal()
                .preencherDados("maria@email.com","12345")
                .clicarBotaoEntrar()
                .getNumeroConta();

        String mensagem = loginPage
                        .preencherDados("email@email.com", "12345")
                        .clicarBotaoEntrar()
                        .clicarBotaoTranferencia()
                        .preencherValoresDaTransferencia(numeroConta, "16.00")
                        .realizarTransferencia()
                        .pegarMensagem();

       assertEquals("Transferencia realizada com sucesso", mensagem);
    }

}
