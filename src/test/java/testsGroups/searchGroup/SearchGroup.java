package testsGroups.searchGroup;

import base.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchGroup extends BaseTest {

    @Test
    @DisplayName("Test-case - 1: Sort by price")
    @Description("Тест-кейс на поиск товара по названию и сортировки посковой выдачи по возрастанию цены ")
    public void sortByCheaperPrice() {
        cityChoosePage
                .skipFirstCityChoose();
        mainPage
                .agreeCityChooseButton()
                .skipCookiePopUp()
                .clickOnSearchBar();
        searchPage
                .searchByText("Шампунь")
                .clickOnSearchButton()
                .openSortDropList()
                .clickOnSortCheaperInDropList();

        String actualSortName = searchPage.getSortText();
        String expectedPriceText = "Подешевле";
        logger.info("Ожидаемое название сортировки:\t" + expectedPriceText);
        assertEquals(actualSortName, expectedPriceText, "Фактическая цена, не совпадает с ожидаемой");
    }
}