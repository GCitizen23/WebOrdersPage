package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BasePage {


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h2")
    private WebElement listOfProductsHeader;

    @FindBy(xpath = "//table[@class = 'ProductsTable']")
    private WebElement productsTable;

    public void verifyProductTable() {

        String [][] productInfo ={
                {"MyMoney", "$100", "8%"},
                {"FamilyAlbum", "$80", "15%" },
                {"ScreenSaver", "$20", "10%"}
        };

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class = 'ProductsTable']/tbody/tr"));
        List<WebElement> cols = driver.findElements(By.xpath("//table[@class = 'ProductsTable']/tbody/tr[2]/td"));

        //this loop iterates the rows and columns
        for (int i = 1; i < rows.size(); i++) {
            for (int j = 0; j < cols.size(); j++) {
                String xpath = "//table[@class = 'ProductsTable']/tbody/tr[" + (i + 1) + "]/td[" + j + "]";
                WebElement eachCell = driver.findElement(By.xpath(xpath));
                // System.out.println(eachCell.getText());
                String actualCellData = eachCell.getText();
                String expectedCellData = productInfo[i-1][j];
                Assert.assertEquals(actualCellData, expectedCellData, "Cell Data not matches");

            }
        }
    }
}




