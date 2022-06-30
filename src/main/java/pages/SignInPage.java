package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class SignInPage extends pages.HeaderElements {

    // поле ввода email
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement fieldEmail;

    // поле ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement fieldPassword;


    // ссылка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registrationLink;

    @Step("Нажатие на ссылку регистрации на странице авторизации")
    public pages.RegistrationPage clickRegistrationLink() {
        registrationLink.click();
        return Selenide.page(pages.RegistrationPage.class);
    }

    // ссылка "Восстановить пароль"
    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement passwordRecoveryLink;

    @Step("Нажатие на ссылку восстановления пароля")
    public pages.PasswordRecoveryPage clickPasswordRecoveryLink() {
        passwordRecoveryLink.click();
        return Selenide.page(pages.PasswordRecoveryPage.class);
    }

    // кнопка Войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    @Step("Проверка отображения кнопки \"Войти\" на странице авторизации")
    public boolean isEnterButtonVisible() {
        return enterButton.shouldBe(visible).isDisplayed();
    }

    @Step("Авторизация пользователя")
    public pages.MainPage authorization(String email, String password) {
        fieldEmail.setValue(email);
        fieldPassword.setValue(password);
        enterButton.click();
        return page(pages.MainPage.class);
    }


}