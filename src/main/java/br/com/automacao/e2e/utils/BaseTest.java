package br.com.automacao.e2e.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static br.com.automacao.e2e.utils.DriverManager.quitDriver;

public class BaseTest {
    private static final FileReader file = new FileReader();

    public static WebDriver getDriver(){
        return DriverManager.getDriver();
    }

    @BeforeEach
    public void setUp() throws IOException {
        String URL = file.getProperties("config").getProperty("url");
        getDriver().get(URL);
    }
    @AfterEach
    public void finish(){
        quitDriver();
    }
}
