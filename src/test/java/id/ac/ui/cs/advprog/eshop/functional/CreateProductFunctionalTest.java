package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setUpTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    void fillInputForm(ChromeDriver driver, String name, int quantity) {
        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        productNameInput.clear();
        productNameInput.sendKeys(name);

        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        productQuantityInput.clear();
        productQuantityInput.sendKeys(String.valueOf(quantity));
    }

    void checkProduct(ChromeDriver driver, String expectedName, int expectedQuantity) {
        WebElement productNameElement = driver.findElement(By.xpath("//table[@class='table table-striped table-responsive-md']//tbody//td[1]"));
        String actualProductName = productNameElement.getText();
        assertEquals(expectedName, actualProductName);

        WebElement productQuantityElement = driver.findElement(By.xpath("//table[@class='table table-striped table-responsive-md']//tbody//td[2]"));
        String actualProductQuantity = productQuantityElement.getText();
        assertEquals(String.valueOf(expectedQuantity), actualProductQuantity);
    }

    @Test
    void createProduct_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/list");
        driver.findElement(By.linkText("Create Product")).click();
        fillInputForm(driver, "Sampo Cap Bambang", 100);
        driver.findElement(By.xpath("//button[text()='Submit']")).click(); // Submit form
        checkProduct(driver, "Sampo Cap Bambang", 100);
        driver.findElement(By.linkText("Delete")).click();
    }
}
