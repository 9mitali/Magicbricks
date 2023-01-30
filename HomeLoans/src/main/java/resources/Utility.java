package resources;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class Utility
{
    public static void captureScreenshot(WebDriver driver, String screenshotName)
    {

        try
        {
            TakesScreenshot ts=(TakesScreenshot)driver;

            File source=ts.getScreenshotAs(OutputType.FILE);

            FileHandler.copy(source, new File("src\\main\\java\\screenShots"+screenshotName+".png"));

            System.out.println("Screenshot taken");
        }
        catch (Exception e)
        {

            System.out.println("Couldnt take Screenshot "+e.getMessage());
        }
    }
}