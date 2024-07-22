import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.util.Arrays;
import java.util.List;
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
       

        // Open the HTML file
        webDriver.get(path);
    }

 @AfterEach
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }

@Test
    public void testIntegerMethod() {
        
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("IntegerMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();


        Assertions.assertEquals("619", output, "Integer output does not match");
    }

    @Test
    public void testFloatMethod() {
       
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("FloatMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();


        Assertions.assertEquals("3.14", output, "Float output does not match");
    }

    @Test
    public void testBooleanMethod() {
       
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("BooleanMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();


        Assertions.assertEquals("false", output, "Boolean output does not match");
    }

    @Test
    public void testStringMethod() {
        
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("StringMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();


        Assertions.assertEquals("Just started learning JavaScript!", output, "String output does not match");
    }

    @Test
    public void testTupleMethod() {
        
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("TupleMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();


        Assertions.assertEquals("[10,20,30]", output, "Tuple output does not match");
    }

    @Test
    public void testSetMethod() {
        
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("SetMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();
    
        Assertions.assertEquals("[\"a\",\"b\",\"c\"]", output, "Set output does not match");
    }

    @Test
    public void testDictionaryMethod() {
       
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("DictionaryMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();
    
        Assertions.assertEquals("{\"key1\":\"value1\",\"key2\":\"value2\"}", output, "Dictionary output does not match");
    }

    @Test
    public void testListMethod() {
        
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("ListMethod();");
        
        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();

        List<String> outputList = Arrays.asList(output.substring(0, output.length()).split(","));
        List<String> expectedList = Arrays.asList("1","2","3","4","5");

    Assertions.assertEquals(expectedList, outputList, "List output does not match");
    }

}


  
    
    
