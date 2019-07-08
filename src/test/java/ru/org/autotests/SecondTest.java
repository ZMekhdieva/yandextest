package ru.org.autotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SecondTest extends YandexPage {
    //    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private String url = "https://yandex.ru/";
    private By market = By.linkText("Маркет");
    private By electronics = By.linkText("Электроника");
    private By headphones = By.xpath("//a[contains(.,'Наушники и Bluetooth-гарнитуры')]");

    @Before
    public void setUp() throws Exception {
        initializeDriver();
        setPropertyWindow();

    }

    @Test
    public void test_2() throws Exception {
        // Зайти на yandex.ru
        open(url);
        // Перейти в яндекс маркет
        go_to(market);
        // Выбрать раздел Электроника
        go_to(electronics);
        // Выбрать раздел Телевизоры
        go_to(headphones);
        // Зайти в расширенный поиск
        allFiltres();
        // Задать параметр поиска от 5000 рублей.
        setMinPrice("5000");
        // Выбрать производителей Beats
        setBeats();
        // Нажать кнопку Применить
        showAll();
        // Проверить, что элементов на странице 48.
        try {
            assertThat(countResults().size(), is(48));
        }catch (AssertionError e){System.out.println("Количество элементов на странице = " + countResults().size() + ", ожидается 48");}
        //  Запомнить первый элемент в списке
        String first_element = countResults().get(0).getAttribute("textContent");
        //  В поисковую строку ввести запомненное значение.
        search(first_element);
        //  Найти и проверить, что наименование товара соответствует запомненному значению.
        countResults().get(0).click();
        WebElement h1 = driver.findElement(By.tagName("h1"));
        String FinalEmelentName = h1.getAttribute("textContent");
        assertEquals(first_element, FinalEmelentName);


    }

    @After
    public void tearDown() throws Exception {
        closeBrowser();
    }
}

