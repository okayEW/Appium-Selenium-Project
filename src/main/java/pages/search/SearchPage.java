package pages.search;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class SearchPage extends BasePage {

    public SearchPage(AndroidDriver androidDriver) {
        super(androidDriver);
        PageFactory.initElements(androidDriver, this);
    }
    @FindBy(id = "ru.beru.android:id/viewSearchAppBarLayoutInput")
    private WebElement searchBar;
    @FindBy(id = "ru.beru.android:id/viewSearchAppBarLayoutSearchIcon")
    private WebElement searchButton;
    @FindBy(id = "ru.beru.android:id/text1")
    private WebElement sortDropListButton;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
    private WebElement sortCheaper;

    @Step("Нажатие на иконку сортировки на странице поиска")
    public SearchPage openSortDropList() {
        clickOnClickableElement(sortDropListButton);
        logger.info("Происходит нажатие на иконку сортировки");
        return this;
    }
    @Step("Нажатие на 'Подешевле' в выпадающем списке сортировки")
    public SearchPage clickOnSortCheaperInDropList() {
        clickOnClickableElement(sortCheaper);
        logger.info("Происходит нажатие на 'Подешевле' в выпадающем списке сортировки");
        return this;
    }
    @Step("Нажатие на иконку поиска на странице поиска")
    public SearchPage clickOnSearchButton() {
        clickOnClickableElement(searchButton);
        logger.info("Происходит нажатие на иконку поиска");
        return this;
    }
    @Step("Поиск по тексту:\t {text} на странице поиска")
    public SearchPage searchByText(String text) {
        sendKeys(searchBar, text);
        hideKeyboard();
        clickOnSearchButton();
        logger.info("Происходит поиск по тексту");
        return this;
    }
    @Step("Получение текущей отображаемой сортировки")
    public String getSortText() {
        String actualPriceText = getText(sortDropListButton);
        logger.info("Происходит получение текущей сортировки");
        return actualPriceText;
    }
}