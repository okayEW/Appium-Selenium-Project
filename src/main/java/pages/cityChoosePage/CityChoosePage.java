package pages.cityChoosePage;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class CityChoosePage extends BasePage {
    public CityChoosePage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    @FindBy(id = "ru.beru.android:id/closeButton")
    private WebElement firstCityChooseCloseButton;

    //Пропуск первого анбординга с выбором города с помощью клика на кнопку крестика
    @Step("Пропуск первого поп-апа с выбором города")
    public CityChoosePage skipFirstCityChoose() {
        clickOnClickableElement(firstCityChooseCloseButton);
        logger.info("Происходит пропуск первого поп-апа с выбором города");
        return this;
    }
}