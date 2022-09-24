package pages.search;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class SearchPage extends BasePage {

    public SearchPage(AndroidDriver androidDriver) {
        super(androidDriver);
        PageFactory.initElements(androidDriver, this);
    }

    @FindBy(id = "ru.beru.android:id/filters")
    private WebElement filtersButton;
    @FindBy(id = "ru.beru.android:id/viewSearchAppBarLayoutInput")
    private WebElement searchBar;
    @FindBy(id = "ru.beru.android:id/viewSearchAppBarLayoutSearchIcon")
    private WebElement searchButton;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.appcompat.widget.LinearLayoutCompat/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView")
    private WebElement priceFilter;

    public SearchPage openFiltersPage() {
        clickOnClickableElement(filtersButton);
        logger.info("Происходит нажатие на иконку фильтров");
        return this;
    }

    public SearchPage clickOnSearchButton() {
        clickOnClickableElement(searchButton);
        logger.info("Происходит нажатие на иконку поиска");
        return this;
    }

    public SearchPage searchByText(String text) {
        sendKeys(searchBar, text);
        hideKeyboard();
        clickOnSearchButton();
        logger.info("Происходит поиск по тексту");
        return this;
    }

    public String getPriceText() {
        String actualPriceText = getText(priceFilter);
        logger.info("Происходит получение текущего атрибута суммы");
        return actualPriceText;
    }
}
