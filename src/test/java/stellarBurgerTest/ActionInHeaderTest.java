package stellarBurgerTest;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import pages.AccountPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ActionInHeaderTest {

    static MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    AccountPage accountPage = page(AccountPage.class);
    static String email = "kolbasa@yandex.ru";
    static String password = "87654321";


    // авторизация перед каждым тестом
    @BeforeClass
    public static void authorizationBeforeTest() {
        mainPage.clickAccountButtonInHeader()
                .authorization(email, password);
    }

    @AfterClass
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    @DisplayName("Проверка перехода в личный кабинет после авторизации по кнопке в хедере")
    @Test
    public void openAccountPageTest() {
        mainPage.clickAccountButtonInHeader();
        Assert.assertTrue("Переход в личный кабинет не выполнен", accountPage.isExplanatoryTextVisible());
    }

    @DisplayName("Проверка возвращения на главную страницу из личного кабинета по Лого")
    @Test
    public void returnToMainPageByLogoTest() {
        mainPage.clickAccountButtonInHeader();
        Assert.assertTrue("Ошибка открытия конструктора", accountPage.clickStellarBurgerLogo()
                .isMakeOrderButtonVisible());

    }

    @DisplayName("Проверка перехода в конструктор из личного кабинета")
    @Test
    public void openConstructorTest() {
        mainPage.clickAccountButtonInHeader();
        Assert.assertTrue("Ошибка открытия конструктора", accountPage.clickConstructorButton()
                .isMakeOrderButtonVisible());
    }

}