package pageObjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class FirstPage extends BasePage {
    public PageComponentPage pageComponent;

    public FirstPage(WebDriver driver) {
        super(driver);
        pageComponent = new PageComponentPage(driver);
    }

    public void firstPageAction() {
        log.info("## Action on first page");
    }
}
