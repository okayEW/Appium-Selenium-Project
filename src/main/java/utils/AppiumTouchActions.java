package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AppiumTouchActions {

    protected static Logger logger = LoggerFactory.getLogger(AppiumTouchActions.class);

    public void scrollUp(int howManySwipes, AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startVerticalY = (int) (size.height * 0.8);
        int endVerticalY = (int) (size.height * 0.21);
        int startVerticalX = (int) (size.width / 2.1);
        try {
            for (int i = 1; i <= howManySwipes; i++) {
                new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startVerticalX, startVerticalY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(startVerticalX, endVerticalY)).release()
                        .perform();
                logger.info("Выполнен свайп вверх");
            }
        } catch (Exception ex) {
            logger.error("Не удалось выполнить свайп");
        }
    }

    public void scroll(int howManySwipes, int fromX, int fromY, int toX, int toY, AppiumDriver driver) {
        try {
            for (int i = 1; i <= howManySwipes; i++) {
                TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
                touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
                logger.info("Выполнен свайп по координатам");
            }
        } catch (Exception ex) {
            logger.error("Не удалось выполнить свайп по координатам");
        }
    }

    public WebElement scrollToElement(WebElement element, AppiumDriver driver) {
        int numberOfTimes = 10;
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width / 2);
        int startPoint = (int) (size.height - 10);
        int endPoint = 10;

        for (int i = 0; i < numberOfTimes; i++) {
            try {
                new TouchAction((PerformsTouchActions) driver)
                        .longPress(PointOption.point(anchor, startPoint))
                        .moveTo(PointOption.point(anchor, endPoint)).release().perform();
                element = driver.findElement((By) element);
                i = numberOfTimes;
            } catch (NoSuchElementException ex) {
                System.out.println(String.format("Элемент не доступен, скролл выполнялся колличество раз: (%s)", i + 1));
            }
        }
        return element;
    }
}