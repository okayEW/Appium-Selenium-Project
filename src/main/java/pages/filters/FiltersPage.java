package pages.filters;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class FiltersPage extends BasePage {
    public FiltersPage(AndroidDriver androidDriver) {
        super(androidDriver);
        PageFactory.initElements(androidDriver, this);
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView")
    private WebElement filterByPrice;
    @FindBy(id = "ru.beru.android:id/bt_submit")
    private WebElement SubmitButton;

    public FiltersPage openFilterByPrice(){
        clickOnClickableElement(filterByPrice);
        logger.info("Происходит нажатие на иконку фильтров");
        return this;
    }
    public FiltersPage clickOnSubmitButton(){
        clickOnClickableElement(SubmitButton);
        logger.info("Происходит нажатие на кнопку сохранения фильтров");
        return this;
    }
}