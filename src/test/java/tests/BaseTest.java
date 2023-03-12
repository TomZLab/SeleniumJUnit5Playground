package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import testHelpers.pojos.TestEnvironment;
import testHelpers.TestStatus;

import java.io.File;

import static testHelpers.Screenshots.addScreenshotToAllure;

@SuppressWarnings({"unused", "JUnitMalformedDeclaration"})
public class BaseTest {

    protected TestEnvironment testEnvironment;
    protected WebDriver driver;
    private final ObjectMapper mapper = new ObjectMapper();

    @RegisterExtension
    private TestStatus testStatus = new TestStatus();

    @BeforeAll
    @SneakyThrows
    protected void mainSetup() {
        testEnvironment = mapper.readValue(new File("src/test/resources/environment.json"), TestEnvironment.class);
        ChromeOptions options = new ChromeOptions();
        if (testEnvironment.getHeadless()) {
            options.addArguments("headless");
        }
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    protected void afterTest() {
        if (testStatus.isFailed) {
            addScreenshotToAllure(driver);
        }
    }

    @AfterAll
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
