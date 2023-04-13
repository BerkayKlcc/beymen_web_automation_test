package Tests;

import Pages.HomePage;
import Utilities.WebDrv;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomePageTest extends WebDrv {

    HomePage hp = new HomePage() ;
    Actions action = new Actions(driver);


    @Test
    @Order(1)
    public void closeDialogs(){
        hp.findAndClick("acceptCookies");
        hp.findAndClick("genderOptions");
    }

//    @Test
//    @Order(2)
//    public void verifyHomePage(){
//        hp.isDisplayed("verifyHeaderLogo");
//    }

    @Test
    @Order(3)
    public void searchBox() throws IOException, InterruptedException {
        String x = hp.readExcel(1,1);
        hp.findAndSend("searchBox",x);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).keyUp(Keys.CONTROL).build().perform();

    }

    @Test
    @Order(4)
    public void searchBox1() throws IOException {
        String y = hp.readExcel(1,2);
        hp.findAndSend("searchBox",y);
        action.sendKeys(Keys.ENTER).build().perform();
    }

    @Test
    @Order(5)
    public void clickItem(){
        hp.findAndClick("clickItem");
    }

    @Test
    @Order(6)
    public void writeTxt(){
            String name= hp.getText(hp.getElementText("findName"));
            String price= hp.getText(hp.getElementText("findPrice"));
            hp.writeTxt(name,price);
    }

    @Test
    @Order(7)
    public void increaseQnt(){
       hp.findAndClick("increaseQuantity");
    }

    @Test
    @Order(8)
    public void deleteItem(){
        hp.findAndClick("deleteItem");
    }
}
