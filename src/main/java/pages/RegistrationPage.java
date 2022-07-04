package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage extends pages.HeaderElements {

    // поля Имя и email
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private ElementsCollection nameAndEmailFields;

    // поле Пароль
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordField;

    // кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    // уведомление Некорректный пароль
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement errorNotification;

    @Step("Проверка отображения нотификации \"Некорректный пароль\"")
    public boolean isErrorNotificationVisible() {
        return errorNotification.isDisplayed();
    }

    // кнопка Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginLink;

    @Step("Нажатие кнопки \"Войти\" на странице регистрации")
    public pages.SignInPage clickLoginLink() {
        loginLink.click();
        return page(pages.SignInPage.class);
    }

    @Step("Регистрация пользователя")
    public void registration(String name, String email, String password) {
        nameAndEmailFields.get(0).setValue(name);
        nameAndEmailFields.get(1).setValue(email);
        passwordField.setValue(password);
        registrationButton.click();
    }


}