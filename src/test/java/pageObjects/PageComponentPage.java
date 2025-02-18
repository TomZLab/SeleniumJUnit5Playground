package pageObjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class PageComponentPage extends BasePage{
    public PageComponentPage(WebDriver driver) {
        super(driver);
    }

    public void componentPageAction(){
        log.info("### Action on component page");
    }
}
