package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    WebDriver driver;

    @FindBy(id = "inpHeaderSearch")
    WebElement caixaDePesquisa;

    @FindBy(css = "div.tiao-header.header-v2:nth-child(4) div.wrapper-main div.wrapper-top div.wrapper-header header.container-top-header.header-a div.container-top-header.header-a div.locker-full:nth-child(1) div.laterals div.container-top-header-a div.container-right-top-header div.search-header.header-search-container div.content-search:nth-child(1) span.container-bloom-header.field-icon-search > i.icon-search")
    WebElement botaoProcurar;


    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void pesquisarPorRelogio(String relogio){
        caixaDePesquisa.clear();
        caixaDePesquisa.sendKeys(relogio);

    }
    public void clicarBotaoProcurar (){
        botaoProcurar.click();
    }
    }

