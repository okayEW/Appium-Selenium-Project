package pages.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static data.constants.Constants.TimeoutVariables.EXPLICIT_WAIT;

public class BasePage {

    protected static Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected AndroidDriver androidDriver;

    public BasePage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }
    public void waitElementIsVisible(WebElement element){
        new WebDriverWait(androidDriver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        logger.debug(element  + "\tВиден");
    }
    public void waitElementToBeClickable(WebElement element){
        new WebDriverWait(androidDriver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.elementToBeClickable(element));
        logger.debug(element  + "\tКликабелен");
    }
    public WebElement clickOnClickableElement(WebElement element){
        waitElementToBeClickable(element);
        element.click();
        logger.debug("Происходит нажатие по элементу:\t" + element);
        return element;
    }
    public WebElement clickOnVisibleElement(WebElement element){
        waitElementIsVisible(element);
        element.click();
        logger.debug("Происходит нажатие по элементу:\t" + element);
        return element;
    }
    public void sendKeys(WebElement element, String text){
        waitElementIsVisible(element);
        element.sendKeys(text);
        logger.debug("Происходит отправка текста:\t" + text, "В элемент:\t" + element);
    }
    public void pressEnter(){
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void clear(WebElement element){
        waitElementIsVisible(element);
        element.clear();
        logger.debug("Происходит очистка элемента:\t" + element);
    }
    public String getAttribute(WebElement element, String attribute) {
        waitElementIsVisible(element);
        logger.debug("Получение аттрибута у элемента:\t" + element);
        return element.getAttribute(attribute);
    }
    public String getText(WebElement element){
        String txt =  null;
        txt = getAttribute(element, "text");
        logger.debug("Получен текст:\t" + txt);
        return txt;
    }
    public void hideKeyboard(){
        androidDriver.hideKeyboard();
    }
}
