import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class AppiumSetupTest {
    public static void main(String[] args) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // change to your device name
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        // ✅ Instead of APK path, use appPackage and appActivity
        caps.setCapability("appPackage", "com.eekifoods.dev");         // Replace with your actual app package
        caps.setCapability("appActivity", "com.eekifoods.MainActivity"); // Replace with your main activity

        try {
            AndroidDriver<MobileElement> driver = new AndroidDriver<>(
                new URL("http://127.0.0.1:4723/wd/hub"), caps);
            System.out.println("App launched successfully");

           //  Example: Wait for 3 seconds and click an element
          Thread.sleep(3000);
       //   Tap on "Specimen"
       
          
            WebDriverWait wait = new WebDriverWait(driver, 20);
            MobileElement specimenButton = (MobileElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Specimen\")")
                )
            );
            specimenButton.click();
            System.out.println("Clicked on Specimen");
            
         // Handle permission popup: "Allow Eeki dev to take pictures and record video?"
            try {
                WebDriverWait wait2 = new WebDriverWait(driver, 10);
                MobileElement allowPermission = (MobileElement) wait2.until(
                    ExpectedConditions.presenceOfElementLocated(
                        MobileBy.AndroidUIAutomator("new UiSelector().text(\"While using the app\")")
                    )
                );
                allowPermission.click();
                System.out.println("Permission granted: While using the app");
            } catch (Exception e) {
                System.out.println("Permission popup not displayed or already handled");
            }
          //Tap on addSpecimen
            WebDriverWait wait1 = new WebDriverWait(driver, 20);
            MobileElement addSpecimen = (MobileElement) wait1.until(
                ExpectedConditions.presenceOfElementLocated(
                    MobileBy.AndroidUIAutomator("new UiSelector().text(\"󰐕\")")
                )
                );
            addSpecimen.click();
            System.out.println("Clicked on addSpecimmen");
            
            
            
            
//         // Fill in Dome
//            MobileElement domeField = (MobileElement) wait.until(
//                ExpectedConditions.presenceOfElementLocated(
//                    MobileBy.AndroidUIAutomator("new UiSelector().text(\"Dome\")")
//                )
//            );
//            domeField.sendKeys("A1");
//
//            // Fill in Line
//            MobileElement lineField = driver.findElement(
//                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Line\")")
//            );
//            lineField.sendKeys("L1");
//
//            // Fill in Set
//            MobileElement setField = driver.findElement(
//                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Set\")")
//            );
//            setField.sendKeys("S1");
//
//            // Fill in Chamber
//            MobileElement chamberField = driver.findElement(
//                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Chamber\")")
//            );
//            chamberField.sendKeys("C1");
//
//            // Fill in Position
//            MobileElement positionField = driver.findElement(
//                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Position\")")
//            );
//            positionField.sendKeys("P1");
//
//            // Tap on Submit button
//            MobileElement submitButton = driver.findElement(
//                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Submit\")")
//            );
//            submitButton.click();
//            System.out.println("Form submitted successfully!");

//new UiSelector().resourceId("com.android.permissioncontroller:id/permission_allow_foreground_only_button")
            
//         // Tap on "Media Moisture"
//            MobileElement mediaMoistureButton = driver.findElementByAndroidUIAutomator(
//                    "new UiSelector().text(\"Media Moisture\")");
//            mediaMoistureButton.click();
//            System.out.println("Clicked on Media Moisture");
//            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
