package testsGroups.searchGroup;

import base.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchGroup extends BaseTest {

    @Test
    @DisplayName("Test-case - 1: Sort by price.")
    @Description("Тест-кейс на поиск товара по названию, фильтрации посковой выдачи по цене и проверку корректной фильтрации по цене")
    public void sortByPrice() {
        cityChoosePage
                .skipFirstCityChoose();
        mainPage
                .agreeCityChooseButton()
                .skipCookiePopUp()
                .clickOnSearchBar();
        searchPage
                .searchByText("Шампунь")
                .openFiltersPage();
        filtersPage
                .openFilterByPrice();
        filtersByPricePage
                .changeFilterByPrice("1000", "1500")
                .clickOnSubmutButton();

        String actualPriceText = searchPage.getPriceText();
        String expectedPriceText = "1000 - 1500 ₽";
        logger.info("Ожидаемый текст введенной ранее цены:\t" + expectedPriceText);
        assertEquals(actualPriceText, expectedPriceText, "Фактическая цена, не совпадает с ожидаемой");
    }
}