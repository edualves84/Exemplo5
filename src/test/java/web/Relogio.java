package web;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Carrinho;
import pages.Home;
import pages.Resultado;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Relogio {
    static String dataHora = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
    String casoDeTeste = "consultar relogio";
    WebDriver driver;
    Home home;
    Resultado resultado;
    Carrinho carrinho;
    Evidencia evidencia;
    Log log;

    @Before
    public void start () throws IOException {
        System.setProperty("webdriver.chrome.driver", "driver/92/chromedriver.exe");
        driver = new ChromeDriver();
        home =   new Home(driver);
        resultado = new Resultado(driver);
        carrinho = new Carrinho(driver);
        evidencia = new Evidencia();
        log = new Log();
        log.iniciarCSV(dataHora);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);


    }

     @After
     public void finish (){
        driver.quit();

     }


    @Given("^que acesso o site da magalu$")
    public void queAcessoOSiteDaMagalu() throws IOException {
        log.registrarCSV("consultar relogio", "iniciou teste");
        driver.get("https://www.magazineluiza.com.br/");
        evidencia.print(driver,dataHora, casoDeTeste, "acessou o site");

    }

    @When("^vou na caixa de pesquisa e digito \"([^\"]*)\"$")
    public void vouNaCaixaDePesquisaEDigito(String relogio) throws IOException {

        home.pesquisarPorRelogio(relogio);
        evidencia.print(driver,dataHora, casoDeTeste,"vai na caixa de pesquisa e digita relogio");
    }

    @And("^clico na lupa$")
    public void clicoNaLupa() throws IOException {

        home.clicarBotaoProcurar();
        evidencia.print(driver,dataHora,casoDeTeste, "clica na lupa");


    }

    @Then("^retorna uma lista de resultados para \"([^\"]*)\"$")
    public void retornaUmaListaDeResultadosPara(String relogio) throws IOException {
        driver.findElement(By.className("text-button-cookie")).click();
        assertEquals(resultado.lerIndicadorRelogio(),relogio);
        evidencia.print(driver, dataHora,casoDeTeste,"exibe lista do item pesquisado");


    }

    @When("^clico no modelo \"([^\"]*)\"$")
    public void clicoNoModelo(String relogio) throws IOException {
      resultado.clicarModeloRelogio();
      evidencia.print(driver,dataHora, casoDeTeste, "clica no modelo do relogio");


    }

    @Then("^confirmo o modelo do relogio como \"([^\"]*)\" com o valor de \"([^\"]*)\"$")
    public void confirmoOModeloDoRelogioComoComOValorDe(String relogio, String preco) throws IOException {
        assertEquals(carrinho.confirmoModeloRelogio(), relogio);
        assertEquals(carrinho.confirmoPrecoRelogio(), preco);
        evidencia.print(driver, dataHora, casoDeTeste, "confirma o modelo e preco do relogio escolhido");
    }
}
