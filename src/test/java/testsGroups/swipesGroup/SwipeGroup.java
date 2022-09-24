package testsGroups.swipesGroup;

import base.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SwipeGroup extends BaseTest {
    @Test
    @DisplayName("Test-case - 2: Swipe element")
    @Description("Тест-кейс на проверку свайпов карусели на главной странице, клика по последнему товару карусели и свайпа вверх до кнопки добавить в корзину")
    public void swipeElement() {
        cityChoosePage
                .skipFirstCityChoose();
        mainPage
                .agreeCityChooseButton()
                .skipCookiePopUp();
        appiumTouchActions
                .scroll(3, 1000, 1500, 50, 1500, androidDriver);
        mainPage
                .clickOnItem();
        appiumTouchActions
                .scrollUp(1, androidDriver);
        assertTrue(itemPage.addToCartButtonIsDisplayed(), "Не удалось обнаружить кнопку добавить в корзину");
        logger.info("Отображается кнопка добавить в корзину");
    }
}