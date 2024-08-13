import java.io.File;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumTest {

    private WebDriver webDriver;
    private String path;

    @BeforeEach
    public void setUp() {
        // Set up ChromeDriver path
          System.setProperty("webdriver.chrome.driver", "driver/chromedriver");//linux_64
       

        // Get file
        File file = new File("src/main/java/com/revature/index.html");
        path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
         ChromeOptions options = new ChromeOptions();
        
        options.addArguments("headless");
          webDriver = new ChromeDriver(options);
        webDriver.get(path);
    }

 @AfterEach
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }

    @Test
    public void testNumber() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("numberMethod();");
        WebElement output = webDriver.findElement(By.id("output"));
        Assertions.assertEquals("Number: 3.14", output.getText());
    }
    
    @Test
    public void testUndefined() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("undefinedMethod();");
        WebElement output = webDriver.findElement(By.id("output"));
        Assertions.assertEquals("Undefined: undefined", output.getText());
    }
    
    @Test
    public void testNull() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("nullMethod();");
        WebElement output = webDriver.findElement(By.id("output"));
        Assertions.assertEquals("Null: null", output.getText());
    }
    
    @Test
public void testObject() {
    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    js.executeScript("objectMethod('John', 30);");

    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.textToBe(By.id("output"), "Object: {\"name\":\"John\",\"age\":30}"));

    WebElement output = webDriver.findElement(By.id("output"));
    Assertions.assertEquals("Object: {\"name\":\"John\",\"age\":30}", output.getText());
}
    
    @Test
    public void testArray() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arrayMethod();");    
        WebElement output = webDriver.findElement(By.id("output"));
        Assertions.assertEquals("Array: [1,2,3,4,5]", output.getText());
    }
}
