package ru.org.autotests;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class YandexPage extends InitialTestClass{


    public void open(String url) {
        driver.get(url);
    }

    public void go_to(By locator) {
        driver.findElement(locator).click();
    }

    public void setMaxPrice(String price) {
        driver.findElement(By.xpath("//input[@id='glf-priceto-var']")).sendKeys(price);
    }
    public void setMinPrice(String price) {
        driver.findElement(By.xpath("//input[@id='glf-pricefrom-var']")).sendKeys(price);
    }

    public void search(String value) {
        driver.findElement(By.id("header-search")).sendKeys(value);
        driver.findElement(By.xpath("//button[contains(.,'Найти')]")).click();
    }

    public void setSamsung() {
        driver.findElement(By.xpath("//label[@for='glf-7893318-153061']")).click();
    }

    public void setLG() {
        driver.findElement(By.xpath("//label[@for='glf-7893318-153074']")).click();
    }

    public void setBeats() {
        driver.findElement(By.xpath("//label[@for='glf-7893318-8455647']")).click();
    }

    public void showAll() {
        driver.findElement(By.xpath("//a[contains(.,'Показать подходящие')]")).click();
    }

    public void allFiltres() {
        driver.findElement(By.xpath("//a[contains(.,' Все фильтры')]")).click();
    }

    public void setManufacturer(String value){
        WebElement manufacturer = driver.findElement(By.xpath("//span[contains(.,'Производитель')]"));
        manufacturer.findElement(By.xpath("//span[@class='button_text' and contains(.,'Показать всё')]")).click();
        manufacturer.findElement(By.xpath("//input[@class='input__control']")).sendKeys(value);
        manufacturer.findElement(By.xpath("//span[contains(.,'" + value + "')]")).click();
        manufacturer.findElement(By.xpath("//input[contains(@name,'Поле поиска')]")).clear();
//        manufacturer.findElement(By.xpath("//a[contains(.,'Свернуть')]")).click();
    }

    public List<WebElement> countResults(){
        WebElement result = driver.findElement(By.xpath("html/body/div[1]/div[5]/div[2]/div[1]/div[2]/div/div[1]"));
        List<WebElement> num_result = result.findElements(By.cssSelector(".n-snippet-cell2__title, .n-snippet-card2__title"));
        return num_result;
    }

    public String saveFirstElement(){
        String s = countResults().get(0).getAttribute("textContent");
        return s;

    }

    public void waitResultPage(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[5]/div[2]/div[1]/div[2]/div")));

    }

    public void checkPageIsReady() {

    }

}
