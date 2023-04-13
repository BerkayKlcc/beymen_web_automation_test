package Pages;

import Utilities.WebDrv;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Parent {

    WebDriverWait wait = new WebDriverWait(WebDrv.getDriver(), Duration.ofSeconds(30));

//    public void isDisplayed(WebElement element){
//        waitUntilVisiable(element);
//    }
    public void sendKeysFunction(WebElement element, String value) {

        waitUntilVisiable(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void clickFunction(WebElement element) {
        waitUntilVisiable(element);
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void waitUntilVisiable(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDrv.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilClickable(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void verifyContainsTextFunc(WebElement element, String value) {

        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assertions.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()), "The text you searched could not be find");
    }

    public void isDisplayed(WebDriver driver, String value){
        Assertions.assertTrue(driver.getCurrentUrl().contains(value.toLowerCase()),"The text could not find");
    }

    public String getText(WebElement element) {
        String text = element.getText();
        return text;
    }


    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }
}
