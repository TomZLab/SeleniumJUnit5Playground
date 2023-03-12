package tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTestsExampleTest extends BaseTest {

    @Test
    @Order(1)
    public void featureOneTest() {
        //Write test code here
        log.info("ordered tests example - 1st feature test");
    }

    @Test
    @Order(2)
    public void featureTwoTest() {
        //Write test code here
        log.info("ordered tests example - 2nd feature test");
    }

    @Test
    @Order(3)
    public void featureThreeTest() {
        //Write test code here
        log.info("ordered tests example - 3rd feature test");
    }
}
