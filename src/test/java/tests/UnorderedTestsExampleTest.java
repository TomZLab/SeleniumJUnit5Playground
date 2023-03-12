package tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UnorderedTestsExampleTest extends BaseTest {

    @Test
    public void featureOneTest() {
        //Write test code here
        log.info("unordered tests example - 1st feature test");
    }

    @Test
    public void featureTwoTest() {
        //Write test code here
        log.info("unordered tests example - 2nd feature test");
    }

    @Test
    public void featureThreeTest() {
        //Write test code here
        log.info("unordered tests example - 3rd feature test");
    }
}
