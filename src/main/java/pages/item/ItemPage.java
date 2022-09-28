package pages.item;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class ItemPage extends BasePage {
    public ItemPage(AndroidDriver androidDriver) {
        super(androidDriver);
        PageFactory.initElements(androidDriver, this);
    }
    @FindBy(xpath = "(//android.widget.FrameLayout[@content-desc=\"В корзину\"])[1]/android.widget.FrameLayout")
    private WebElement addToCartButton;
    @Step("Проверка отображения кнопки 'Добавить в корзину' на странице товара")
    public boolean addToCartButtonIsDisplayed() {
        return addToCartButton.isDisplayed();
    }
}