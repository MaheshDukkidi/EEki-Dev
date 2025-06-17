import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class AppLaunch {
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
       
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
