package testHelpers;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

public class Screenshots {

    public static void addScreenshotToAllure(WebDriver driver){
            String timestamp = java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSS"));
            String pathToPNG = takeScreenshot(driver, timestamp);
            Path content = Paths.get(pathToPNG);
            try (InputStream is = Files.newInputStream(content)) {
                Allure.addAttachment("Screenshot", is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Delete source files
            try {
                Files.deleteIfExists(Paths.get(pathToPNG));
            } catch (IOException e) {
                e.printStackTrace();
        }
    }

    private static String takeScreenshot(WebDriver driver, String timeStamp) {
        String pathToDirectory = "target/screenshots";
        String pathToFile = pathToDirectory + "/" + timeStamp + "_error.png";
        File directory = new File(pathToDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File(pathToFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathToFile;
    }
}
