package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Carrinho {

      WebDriver driver;

      @FindBy(className = "header-product__title")
      WebElement confirmoModeloRelogioCarrinho;

      @FindBy(xpath = "//body/div[3]/div[5]/div[1]/div[3]/div[2]/div[5]/div[1]/div[2]/div[1]/span[2]" )
      WebElement confirmoPrecoRelogioCarrinho;

      public Carrinho(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver,this);
      }

      public String confirmoModeloRelogio(){

            return confirmoModeloRelogioCarrinho.getText();

      }
      
      public String confirmoPrecoRelogio(){

            return confirmoPrecoRelogioCarrinho.getText();


      }



}
