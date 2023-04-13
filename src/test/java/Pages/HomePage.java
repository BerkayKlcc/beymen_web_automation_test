package Pages;

import Utilities.WebDrv;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class HomePage extends Parent {

    public HomePage() {
        PageFactory.initElements(WebDrv.getDriver(), this);
    }

    @FindBy(css = "button[class='o-modal__closeButton bwi-close'] >svg>use")
    private WebElement genderOptions;
    @FindBy(css = "div[class='banner-actions-container']")
    private WebElement acceptCookies;
    @FindBy(css = "div[class='o-footer__logo']")
    private WebElement verifyLogo;

    @FindBy(css = "input[class='default-input o-header__search--input']")
    public WebElement searchBox;

    @FindBy(css = "#productList > div:nth-child(2)")
    private WebElement clickItem;

    @FindBy(css = "span[class='o-productDetail__description']")
    private WebElement findName;

    @FindBy(css = "#priceNew")
    private WebElement findPrice;

    @FindBy(css = "#sizes > div >span")
    private WebElement itemVariation;

    @FindBy(css = "button[id='addBasket']")
    private WebElement addToBasket;

    @FindBy(css = "a[title='Sepetim']>span")
    private WebElement clickToBasket;

    @FindBy(css = "span[class='m-productPrice__salePrice']")
    private WebElement itemSalePrice;

    @FindBy(css = "#productList > div:nth-child(2) > div > div > div.m-productCard__detail > div.m-productCard__price > span > span")
    private WebElement itemListPrice;

    @FindBy(css = "select[id='quantitySelect0-key-0']")
    private WebElement increaseQuantity;

    @FindBy(css = "#removeCartItemBtn0-key-0")
    private WebElement deleteItem;


    WebElement myElement;

    public void findAndSend(String strElement, String value) {

        switch (strElement) {
            case "searchBox":
                myElement = searchBox;
                break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "acceptCookies":
                myElement = acceptCookies;
                break;
            case "genderOptions":
                myElement = genderOptions;
                break;
            case "clickItem":
                myElement = clickItem;
                break;
            case "itemVariation":
                myElement = itemVariation;
                break;
            case "addToBasket":
                myElement = addToBasket;
                break;

            case "increaseQuantity":
                myElement = increaseQuantity;
                break;

            case "deleteItem":
                myElement = deleteItem;
                break;
        }
        clickFunction(myElement);
    }


    public WebElement getElementText(String value) {
        switch (value) {
            case "findName":
                myElement = findName;
                break;

            case "findPrice":
                myElement = findPrice;
                break;
        }
        return myElement;
    }

    public String readExcel(int x, int y) throws IOException {

        FileInputStream fileReadCom = new FileInputStream("src/test/java/Resource/beymen.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileReadCom);
        XSSFSheet worksheet = workbook.getSheet("Beymen");
        Row row = worksheet.getRow(x);
        Cell cell = row.getCell(y);
        String text = cell.toString();

        return text;
    }

    public void writeTxt(String name, String price) {
        try {
            FileWriter myWriter = new FileWriter("productInfo.txt");
            myWriter.write("Ürün Adı: " + name + "\n" + "Fiyatı: " + price);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
