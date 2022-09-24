package pages.main;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class MainPage extends BasePage {

    public MainPage(AndroidDriver androidDriver) {
        super(androidDriver);
        PageFactory.initElements(androidDriver, this);
    }

    @FindBy(id = "ru.beru.android:id/agreeButton")
    private WebElement agreeCityChooseButton;
    @FindBy(id = "ru.beru.android:id/negativeButton")
    private WebElement skipCookisePopUp;
    @FindBy(id = "ru.beru.android:id/searchRequestView")
    private WebElement searchBar;
    @FindBy(xpath = "(//android.widget.FrameLayout[@content-desc=\"snippet_product_image\"])[3]/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.ImageView")

    private WebElement lastItemInCarousel;

    //Скрытие pop-up'a с подтверждением вашего населенного пункта
    public MainPage agreeCityChooseButton() {
        clickOnClickableElement(agreeCityChooseButton);
        logger.info("Происходит нажатие на кнопку согласия в поп-апе с подтверждением вашего населенного пункта");
        return this;
    }

    //Скрытие pop-up'a с куками
    public MainPage skipCookiePopUp() {
        clickOnClickableElement(skipCookisePopUp);
        logger.info("Происходит нажатие на кнопку 'skip' в поп-апе с куками");
        return this;
    }

    //Клик по полю поиска
    public MainPage clickOnSearchBar() {
        clickOnClickableElement(searchBar);
        logger.info("Происходит нажатие на поле поиска");
        return this;
    }

    public MainPage clickOnItem() {
        clickOnClickableElement(lastItemInCarousel);
        logger.info("Происходит нажатие на последний элемент в карусели");
        return this;
    }
}