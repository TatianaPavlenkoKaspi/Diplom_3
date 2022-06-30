package stellarBurgerTest;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.AccountPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LogOutTest {

    MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    AccountPage accountPage = page(AccountPage.class);
    String email = "kolbasa@yandex.ru";
    String password = "87654321";

    // авторизация перед тестом
    @Before
    public void authorizationBeforeTest() {
        mainPage.clickAccountButtonInHeader()
                .authorization(email, password)
                .clickAccountButtonInHeader();
    }

    @DisplayName("Проверка логаута")
    @Test
    public void logoutTest() {
        Assert.assertTrue("Ошибка логаута", accountPage.clickExitButton()
                .isEnterButtonVisible());
    }

}