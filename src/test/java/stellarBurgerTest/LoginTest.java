package stellarBurgerTest;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import pages.MainPage;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    String email = "kolbasa@yandex.ru";
    String password = "87654321";

    @BeforeClass
    public static void setUp() {
        browser = "chrome";
//        browser = "safari";
    }
    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @DisplayName("Логин через кнопку в хедере")
    @Test
    public void successLoginWithButtonInHeader() {
        Assert.assertTrue("Авторизация через кнопку в хедере не выполнена", mainPage.clickAccountButtonInHeader()
                .authorization(email, password)
                .isMakeOrderButtonVisible());
    }

    @DisplayName("Логин через кнопку на главной странице")
    @Test
    public void successLoginWithAccountButtonOnMainPage() {
        Assert.assertTrue("Авторизация через кнопку на главной не выполнена", mainPage.clickAccountButton()
                .authorization(email, password)
                .isMakeOrderButtonVisible());
    }

    @DisplayName("Логин через кнопку на странице регистрации")
    @Test
    public void successLoginWithButtonOnRegistrationPage() {
        Assert.assertTrue("Авторизация через страницу регистрации не выполнена", mainPage.clickAccountButtonInHeader()
                .clickRegistrationLink()
                .clickLoginLink()
                .authorization(email, password)
                .isMakeOrderButtonVisible());
    }

    @DisplayName("Логин через кнопку на странице восстановления пароля")
    @Test
    public void successLoginWithButtonOnRecoveryPage() {
        Assert.assertTrue("Авторизация через страницу восстановления пароля не выполнена", mainPage.clickAccountButtonInHeader()
                .clickPasswordRecoveryLink()
                .clickEnterButtonOnRecoveryPage()
                .authorization(email, password)
                .isMakeOrderButtonVisible());
    }

}