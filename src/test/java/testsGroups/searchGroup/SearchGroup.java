package testsGroups.searchGroup;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchGroup extends BaseTest {

    @Test
    @DisplayName("Test-case - 1: Sort by price.")
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
        try {
            String actualPriceText = searchPage.getPriceText();
            String expectedPriceText = "1000 - 1500 ₽";
            assertEquals(actualPriceText, expectedPriceText);
            logger.info("Ожидаемый текст введенной ранее цены:\t" + expectedPriceText);
        }
        catch (Exception exception){
            logger.error("Не удалось выполнить ТК:\t"+ testInfo.getDisplayName());
        }
    }
}