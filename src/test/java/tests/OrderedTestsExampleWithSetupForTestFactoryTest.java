package tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import pageObjects.FirstPage;
import testHelpers.pojos.User;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTestsExampleWithSetupForTestFactoryTest extends BaseTest {

    FirstPage firstPage;

    @BeforeAll
    public void testClassSetup() {
        firstPage = new FirstPage(driver);
        log.info("Run 'OrderedTestsExampleWithSetupTest - testClassSetup'");

    }

    @BeforeEach
    public void testSetup() {
        log.info("Run 'OrderedTestsExampleWithSetupTest - testSetup'");
    }

    @AfterAll
    public void testClassTearDown() {
        firstPage = new FirstPage(driver);
        log.info("Run 'OrderedTestsExampleWithSetupTest - testClassTearDown'");
    }

    @AfterEach
    public void testTearDown() {
        log.info("Run 'OrderedTestsExampleWithSetupTest - testTearDown'");
    }

    @TestFactory
    Stream<DynamicTest> runMixedTests() {
        List<User> users = List.of(
                new User("Alice", "Bimmer", 25),
                new User("Adam", "Bimmer", 17),
                new User("Adam", "Merc", 18)
        );

        return users.stream().flatMap(user -> Stream.of(
                DynamicTest.dynamicTest("[1] Feature One Test - " + user.getFirstName() + " " + user.getLastName(), () -> {
                    log.info("Running feature one for {} {}", user.getFirstName(), user.getLastName());
                    Assertions.assertTrue(user.getFirstName().startsWith("A"), "First name starts with 'A'");
                    firstPage.firstPageAction();
                }),
                DynamicTest.dynamicTest("[2] Feature Two Test - " + user.getFirstName() + " " + user.getLastName(), () -> {
                    log.info("Running feature two for {} {}", user.getFirstName(), user.getLastName());
                    Assertions.assertTrue(user.getLastName().startsWith("M"), "Last name starts with 'M'");
                    firstPage.pageComponent.componentPageAction();
                }),
                DynamicTest.dynamicTest("[3] Feature Three Test - " + user.getFirstName() + " " + user.getLastName(), () -> {
                    log.info("Running feature three for {} {}", user.getFirstName(), user.getLastName());
                    Assertions.assertTrue(user.isAdult(), "User is an adult");
                    firstPage.pageComponent.componentPageAction();
                })
        ));
    }
}
