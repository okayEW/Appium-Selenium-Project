package common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static data.appiumCapabilities.AppiumCapabilities.*;
import static data.constants.Constants.TimeoutVariables.IMPLICIT_WAIT;

public class AppiumActions {
    private static final Logger logger = LoggerFactory.getLogger(AppiumActions.class);

    public static AndroidDriver setUpAppium(){

        AndroidDriver androidDriver = null;
        //Set the Desired Capabilities
        File app = new File(APK_FILE_OZON);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, UI_AUTOMATOR2);
        capabilities.setCapability("chromedriverExecutable", CHROME_DRIVER);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        //capabilities.setCapability("appPackage", APP_PACKAGE);
        //capabilities.setCapability("appWaitActivity", APP_ACTIVITY);
        capabilities.setCapability("deviceName", DEVICE_NAME);
        capabilities.setCapability("unicodekeyboard", UNICODE_KEYBOARD);
        capabilities.setCapability("resetkeyboard", RESET_KEYBOARD);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        capabilities.setCapability("app", app.getAbsolutePath());

        try {
            androidDriver = new AndroidDriver (new URL(APPIUM_NODE), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            logger.error("Не удалось подключиться к Appium node");
        }
        logger.info("Выполнено подключение к Appium Android emulator, происходит запуск APK файла браузера.");
        androidDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return androidDriver;
    }
}
