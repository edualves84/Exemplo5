package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resultado {

    WebDriver driver;

    @FindBy( css = "div.wrapper-main:nth-child(2) div.wrapper-middle.central-wrapper div.wrapper-content div.container-search div.top-search:nth-child(1) div.left-top-search div.header-search h1:nth-child(1) > strong:nth-child(1)")
    WebElement modeloRelogioResultado;


    @FindBy(xpath = "//body/div[2]/div[3]/div[2]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[1]/a[1]/div[1]/img[1]")
    WebElement clicarRelogio;


    public Resultado(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String lerIndicadorRelogio (){

        return   modeloRelogioResultado.getText();

    }

   public void clicarModeloRelogio(){
        clicarRelogio.click();

   }


}
