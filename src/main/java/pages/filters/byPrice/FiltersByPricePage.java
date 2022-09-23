package pages.filters.byPrice;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class FiltersByPricePage extends BasePage {

    public FiltersByPricePage(AndroidDriver androidDriver) {
        super(androidDriver);
        PageFactory.initElements(androidDriver, this);
    }

    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.EditText[2]")
    private WebElement firstPrice;
    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.EditText[2]")
    private WebElement lastPrice;
    @FindBy (id = "ru.beru.android:id/bt_submit")
    private WebElement submitButton;

    public FiltersByPricePage changeFilterByPrice(String firstPriceString, String lastPriceString){
        sendKeys(firstPrice, firstPriceString);
        sendKeys(lastPrice, lastPriceString);
        clickOnSubmutButton();
        logger.info("Происходит вставка первой и второй суммы для фильтрации");
        return this;
    }
    public void clickOnSubmutButton(){
        clickOnClickableElement(submitButton);
        logger.info("Происходит нажатие на кнопку сохранения фильтров цены");
    }
}