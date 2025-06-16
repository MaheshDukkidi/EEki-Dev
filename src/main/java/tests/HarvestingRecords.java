package tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HarvestingRecords {

    public static void main(String[] args) {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability("appPackage", "com.eekifoods.dev");
            caps.setCapability("appActivity", "com.eekifoods.MainActivity");
            caps.setCapability("automationName", "UiAutomator2");

            AndroidDriver<MobileElement> driver = new AndroidDriver<>(
                    new URL("http://127.0.0.1:4723/wd/hub"), caps);
            WebDriverWait wait = new WebDriverWait(driver, 10);

            Thread.sleep(5000); // Let the app load

            // Scroll to "Harvesting" section once
            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().textContains(\"Harvest\"))"
            )).click();
            
            System.out.println("Click on Harvest");
            // Handle permission popup if shown
            try {
                MobileElement permission = (MobileElement) wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                MobileBy.AndroidUIAutomator("new UiSelector().text(\"While using the app\")")
                        )
                );
                permission.click();
            } catch (Exception e) {
                System.out.println("No permission popup shown.");
            }

            int globalInputCounter = 1;

            for (int record = 1; record <= 50; record++) {
                try {
                    // Click the + icon (Add Harvesting)
                	  MobileElement addHarvest = (MobileElement)wait.until(ExpectedConditions.presenceOfElementLocated(
                              MobileBy.AndroidUIAutomator("new UiSelector().text(\"󰐕\")")));
                	  addHarvest.click();
                      System.out.println("Clicked on Add Harvest");
                    System.out.println("➡️ Creating record #" + record);

                    Thread.sleep(2000); // Wait for form fields to appear

                    // Fill all EditText fields
                    Set<String> filledFields = new HashSet<>();
                    int maxScrolls = 20;

                    for (int i = 0; i < maxScrolls; i++) {
                        List<MobileElement> fields = driver.findElementsByClassName("android.widget.EditText");
                        boolean filledNew = false;

                        for (MobileElement field : fields) {
                            String fieldId = field.getId();
                            if (!filledFields.contains(fieldId)) {
                                try {
                                    field.click();
                                    field.clear();
                                    field.sendKeys(String.valueOf(globalInputCounter));
                                    filledFields.add(fieldId);
                                    globalInputCounter++;
                                    Thread.sleep(300);
                                    filledNew = true;
                                } catch (Exception e) {
                                    System.out.println("Failed to fill a field: " + e.getMessage());
                                }
                            }
                        }

                        if (!filledNew) {
                            try {
                                driver.findElement(MobileBy.AndroidUIAutomator(
                                        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
                                )).click();
                                Thread.sleep(800);
                            } catch (Exception scrollEnd) {
                                System.out.println("Reached end of form.");
                                break;
                            }
                        }
                    }

                    System.out.println("✅ Filled form for record #" + record);

                    // Submit the form
                    try {
                        MobileElement submitButton = driver.findElement(MobileBy.AndroidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true))" +
                                        ".scrollIntoView(new UiSelector().textContains(\"Submit\"))"
                        ));
                        submitButton.click();
                        System.out.println("✅ Submitted form for record #" + record);
                    } catch (Exception e) {
                        System.out.println("❌ Could not click Submit for record #" + record + ": " + e.getMessage());
                    }

                    Thread.sleep(1500); // Delay before next record

                } catch (Exception recordException) {
                    System.out.println("⚠️ Error while creating record #" + record + ": " + recordException.getMessage());
                }
            }

            System.out.println("🎉 All 50 records created successfully!");
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
