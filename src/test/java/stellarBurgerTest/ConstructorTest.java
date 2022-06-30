package stellarBurgerTest;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @DisplayName("Проверка перехода в таб \"Булки\"")
    @Test
    public void openBunsTabTest() {
        mainPage.clickSauceButton()
                .clickBunsButton()
                .isBunTabSelected();
    }

    @DisplayName("Проверка перехода в таб \"Соусы\"")
    @Test
    public void openSauceTabTest() {
        mainPage.clickSauceButton()
                .isSauceTabSelected();
    }

    @DisplayName("Проверка перехода в таб \"Начинки\"")
    @Test
    public void openFillingsTabTest() {
        mainPage.clickFillingsButton()
                .isFillingsTabSelected();
    }

}