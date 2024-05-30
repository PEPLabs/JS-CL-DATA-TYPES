import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.JavascriptExecutor;

public class DataTypesTest {

    private WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        String browserName = BrowserUtils.getWebDriverName();

        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("headless");
                webDriver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-headless");
                webDriver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                webDriver = new EdgeDriver(edgeOptions);
                break;

            case "ie":
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.addCommandSwitches("-headless");
                webDriver = new InternetExplorerDriver(ieOptions);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }

 

@Test
    public void testIntegerMethod() {
        File file = new File("src/main/java/com/revature/index.html");
        String path = "file://" + file.getAbsolutePath();
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("IntegerMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();


        Assertions.assertEquals("619", output, "Integer output does not match");
    }

    @Test
    public void testFloatMethod() {
        File file = new File("src/main/java/com/revature/index.html");
        String path = "file://" + file.getAbsolutePath();
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("FloatMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();


        Assertions.assertEquals("3.14", output, "Float output does not match");
    }

    @Test
    public void testBooleanMethod() {
        File file = new File("src/main/java/com/revature/index.html");
        String path = "file://" + file.getAbsolutePath();
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("BooleanMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();


        Assertions.assertEquals("false", output, "Boolean output does not match");
    }

    @Test
    public void testStringMethod() {
        File file = new File("src/main/java/com/revature/index.html");
        String path = "file://" + file.getAbsolutePath();
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("StringMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();


        Assertions.assertEquals("Just started learning JavaScript!", output, "String output does not match");
    }

    @Test
    public void testTupleMethod() {
        File file = new File("src/main/java/com/revature/index.html");
        String path = "file://" + file.getAbsolutePath();
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("TupleMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();


        Assertions.assertEquals("[10,20,30]", output, "Tuple output does not match");
    }

    @Test
    public void testSetMethod() {
        File file = new File("src/main/java/com/revature/index.html");
        String path = "file://" + file.getAbsolutePath();
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("SetMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();
    
        Assertions.assertEquals("[\"a\",\"b\",\"c\"]", output, "Set output does not match");
    }

    @Test
    public void testDictionaryMethod() {
        File file = new File("src/main/java/com/revature/index.html");
        String path = "file://" + file.getAbsolutePath();
        webDriver.get(path);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("DictionaryMethod();");

        WebElement outputElement = webDriver.findElement(By.id("output"));
        String output = outputElement.getText().trim();
    
        Assertions.assertEquals("{\"key1\":\"value1\",\"key2\":\"value2\"}", output, "Dictionary output does not match");
    }

    @Test
    public void testListMethod() {
        File file = new File("src/main/java/com/revature/index.html");
        String path = "file://" + file.getAbsolutePath();
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


    class BrowserUtils {
        public static String getWebDriverName() {
            String[] browsers = { "chrome", "firefox", "edge", "ie" };
    
            for (String browser : browsers) {
                try {
                    switch (browser) {
                        case "chrome":
                            WebDriverManager.chromedriver().setup();
                            new ChromeDriver().quit();
                            break;
                        case "firefox":
                            WebDriverManager.firefoxdriver().setup();
                            new FirefoxDriver().quit();
                            break;
                        case "edge":
                            WebDriverManager.edgedriver().setup();
                            new EdgeDriver().quit();
                            break;
                        case "ie":
                            WebDriverManager.iedriver().setup();
                            new InternetExplorerDriver().quit();
                            break;
                    }
                    return browser;
                } catch (Exception e) {
                    continue;
                }
            }
            return "Unsupported Browser";
        }
    }
    