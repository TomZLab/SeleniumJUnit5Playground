package tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import pageObjects.FirstPage;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTestsExampleWithSetupTest extends BaseTest {

    FirstPage firstPage;

    @BeforeAll
    public void testClassSetup(){
        firstPage = new FirstPage(driver);
        log.info("Run 'OrderedTestsExampleWithSetupTest - testClassSetup'");

    }

    @BeforeEach
    public void testSetup(){
        log.info("Run 'OrderedTestsExampleWithSetupTest - testSetup'");
    }

    @Test
    @Order(1)
    public void featureOneTest() {
        //Write test code here
        log.info("Ordered tests example - 1st feature test");
        firstPage.firstPageAction();
    }

    @Test
    @Order(2)
    public void featureTwoTest() {
        //Write test code here
        log.info("Ordered tests example - 2nd feature test");
        firstPage.pageComponent.componentPageAction();
    }

    @Test
    @Order(3)
    public void featureThreeTest() {
        //Write test code here
        log.info("Ordered tests example - 3rd feature test");
        firstPage.pageComponent.componentPageAction();
    }

    @AfterAll
    public void testClassTearDown(){
        firstPage = new FirstPage(driver);
        log.info("Run 'OrderedTestsExampleWithSetupTest - testClassTearDown'");
    }

    @AfterEach
    public void testTearDown(){
        log.info("Run 'OrderedTestsExampleWithSetupTest - testTearDown'");
    }
}
