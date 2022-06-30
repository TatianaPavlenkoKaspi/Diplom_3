package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends pages.HeaderElements {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";

    // кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement accountButton;

    @Step("Нажатие на кнопку \"Войти в аккаунт\"")
    public pages.SignInPage clickAccountButton() {
        accountButton.click();
        return Selenide.page(pages.SignInPage.class);
    }

    // кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement makeOrderButton;

    @Step("Нажатие на кнопку \"Оформить заказ\"")
    public MainPage clickMakeOrderButton() {
        makeOrderButton.click();
        return page(MainPage.class);
    }

    @Step("Проверка отображения кнопки \"Оформить заказ\"")
    public boolean isMakeOrderButtonVisible() {
        makeOrderButton.shouldBe(visible);
        return makeOrderButton.isDisplayed();
    }

    // таб Булки
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsButton;

    @Step("Переход в таб \"Булки\"")
    public MainPage clickBunsButton() {
        bunsButton.click();
        return page(MainPage.class);
    }

    // таб Соусы
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement sauceButton;

    @Step("Переход в таб \"Соусы\"")
    public MainPage clickSauceButton() {
        sauceButton.click();
        return page(MainPage.class);
    }

    // таб Начинки
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsButton;

    @Step("Переход в таб \"Начинки\"")
    public MainPage clickFillingsButton() {
        fillingsButton.click();
        return page(MainPage.class);
    }

    // название раздела Булки
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']/..")
    private SelenideElement bunText;

    @Step("Проверка выбора раздела \"Булки\"")
    public void isBunTabSelected() {
        bunText.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

    // название раздела Соусы
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']/..")
    private SelenideElement sauceText;

    @Step("Проверка выбора раздела \"Соусы\"")
    public void isSauceTabSelected() {
        sauceText.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

    // название раздела Начинки
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']/..")
    private SelenideElement fillingsText;

    @Step("Проверка выбора раздела \"Начинки\"")
    public void isFillingsTabSelected() {
        fillingsText.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

}