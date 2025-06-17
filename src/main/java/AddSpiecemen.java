import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class AddSpiecemen {

    public static void main(String[] args) {
        AndroidDriver<MobileElement> driver = null;

        try {
            // Set capabilities and launch app
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            caps.setCapability("appPackage", "com.eekifoods.dev");
            caps.setCapability("appActivity", "com.eekifoods.MainActivity");

            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            WebDriverWait wait = new WebDriverWait(driver, 20);

            System.out.println("App launched successfully");

            // Click on Specimen
            MobileElement specimen = (MobileElement)wait.until(ExpectedConditions.presenceOfElementLocated(
                    MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Specimen\")")));
            specimen.click();
            System.out.println("Clicked on Specimen");

            // Handle Permission Pop-up
            try {
                WebDriverWait shortWait = new WebDriverWait(driver, 5);
                MobileElement permission = (MobileElement)shortWait.until(ExpectedConditions.presenceOfElementLocated(
                        MobileBy.AndroidUIAutomator("new UiSelector().text(\"While using the app\")")));
                permission.click();
                System.out.println("Permission granted");
            } catch (Exception e) {
                System.out.println("No permission popup");
            }

            // Click on Add Specimen button
            MobileElement addSpecimen = (MobileElement)wait.until(ExpectedConditions.presenceOfElementLocated(
                    MobileBy.AndroidUIAutomator("new UiSelector().text(\"󰐕\")")));
            addSpecimen.click();
            System.out.println("Clicked on Add Specimen");
            
            MobileElement domeField = (MobileElement) wait.until(
            ExpectedConditions.presenceOfElementLocated(
            MobileBy.AndroidUIAutomator("new UiSelector().text(\"Dome\")")
                  )
              );
            domeField.sendKeys("A1");
        

      // Fill in Line
      MobileElement lineField = driver.findElement(
          MobileBy.AndroidUIAutomator("new UiSelector().text(\"Line\")")
      );
      lineField.sendKeys("100");

      // Fill in Set
      MobileElement setField = driver.findElement(
          MobileBy.AndroidUIAutomator("new UiSelector().text(\"Set\")")
      );
      setField.sendKeys("100");

      // Fill in Chamber
      MobileElement chamberField = driver.findElement(
          MobileBy.AndroidUIAutomator("new UiSelector().text(\"Chamber\")")
      );
      chamberField.sendKeys("100");

      // Fill in Position
      MobileElement positionField = driver.findElement(
          MobileBy.AndroidUIAutomator("new UiSelector().text(\"Position\")")
      );
      positionField.sendKeys("25");

      // Tap on Submit button
      MobileElement submitButton = driver.findElement(
          MobileBy.AndroidUIAutomator("new UiSelector().text(\"Submit\")")
      );
      submitButton.click();
      System.out.println("Form submitted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
