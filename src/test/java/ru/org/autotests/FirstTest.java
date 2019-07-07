package ru.org.autotests;//package com.example.tests;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest extends YandexPage {
//    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private String url = "https://yandex.ru/";
    private By market = By.linkText("Маркет");
    private By electronics = By.linkText("Электроника");
    private By tv = By.xpath("//a[contains(.,'Телевизоры')]");

    @Before
    public void setUp() throws Exception {
        initializeDriver();
        setPropertyWindow();
    }

    @Test
    public void test_1() throws Exception {
        // Зайти на yandex.ru
        open(url);
        // Перейти в яндекс маркет
        go_to(market);
        // Выбрать раздел Электроника
        go_to(electronics);
        // Выбрать раздел Телевизоры
        go_to(tv);
        //Зайти в расширенный поиск
        allFiltres();
        //Задать параметр поиска от 20000 рублей
        setMaxPrice("20000");
        //Выбрать производителей Samsung и LG
        setSamsung();
        setLG();
        // Нажать кнопку Применить
        showAll();
        // Проверить, что элементов на странице 48.
        try {
            assertThat(countResults().size(), is(48));
        }catch (AssertionError e){System.out.println("Количество элементов на странице = " + countResults().size() + ", ожидается 48");}
        //Запомнить первый элемент в списке
        String first_element = countResults().get(0).getAttribute("textContent");
        //В поисковую строку ввести запомненное значение
        search(first_element);
        //Найти и проверить, что наименование товара соответствует запомненному значению
        WebElement h1 = driver.findElement(By.tagName("h1"));
        String FinalEmelentName = h1.getAttribute("textContent");
        assertEquals(first_element, FinalEmelentName);

    }


    @After
    public void tearDown() throws Exception {
        closeBrowser();
    }
}
