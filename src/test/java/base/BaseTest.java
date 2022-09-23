package base;

import common.AppiumActions;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.cityChoosePage.CityChoosePage;
import pages.filters.FiltersPage;
import pages.filters.byPrice.FiltersByPricePage;
import pages.main.MainPage;
import pages.search.SearchPage;

public abstract class BaseTest {
    protected TestInfo testInfo;
    protected AndroidDriver androidDriver = AppiumActions.setUpAppium();
    protected MainPage mainPage = new MainPage(androidDriver);
    protected CityChoosePage cityChoosePage = new CityChoosePage(androidDriver);
    protected FiltersPage filtersPage = new FiltersPage(androidDriver);
    protected FiltersByPricePage filtersByPricePage = new FiltersByPricePage(androidDriver);
    protected SearchPage searchPage = new SearchPage(androidDriver);
    protected static Logger logger;

    @BeforeEach
    void InitializeLogger(TestInfo testInfo){
        logger = LoggerFactory.getLogger(BaseTest.class);
        logger.info(String.format("Test started:\t" + testInfo.getDisplayName()));
    }
    @AfterEach
    void LogTestFinished(TestInfo testInfo){
        logger.info(String.format("Test finished:\t") + testInfo.getDisplayName());
    }
}