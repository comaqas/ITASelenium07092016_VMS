import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created by Marta Verenchikova on 7/20/2016.
 */
public class OnlinerFillingFormsWithLocatorsClassTest {

    @Test
    public void fillingFormsByUsingElementsLocatorsTestMethod(){

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.onliner.by/");

        // создаем веб-элемент для Каталога (аналогично и для всех последующих элементов)
        WebElement catalogButton = driver.findElement(By.cssSelector("[href='http://catalog.onliner.by/']>.b-main-navigation__text"));
        catalogButton.click();

        assertEquals(driver.getTitle(), "Каталог Onliner.by");


        // переход в раздел "Электроника"
        // можно было использовать xpath-локатор  "//span[text() = 'Электроника']"
        WebElement electronicLink = driver.findElement(By.xpath("//*[text() = 'Электроника']"));
        electronicLink.click();


        // переход в подраздел "Мобильные телефоны"
        WebElement mobilePhones = driver.findElement(By.cssSelector(".catalog-navigation-list__link-inner>a[href='http://catalog.onliner.by/mobile']"));
        mobilePhones.click();


        // работа с фильтром (заполнение блока "Производитель")
        WebElement producerFirstCheckBox = driver.findElement(By.cssSelector(".schema-filter__list .i-checkbox__real[value='samsung']"));
        producerFirstCheckBox.click();

        WebElement producerSecondCheckBox = driver.findElement(By.cssSelector(".schema-filter__list .i-checkbox__real[value='apple']"));
        producerSecondCheckBox.click();


        // работа с фильтром (заполнение блока "Минимальная цена")
        WebElement priceFirstInputField = driver.findElement(By.cssSelector(".schema-filter__number-input_price[placeholder='от']"));
        priceFirstInputField.sendKeys("100");


        WebElement priceSecondInputField = driver.findElement(By.xpath("//span[text() = 'Минимальная цена, после деноминации']/../..//div[2]/input"));
        priceSecondInputField.sendKeys("3500");



        // работа с фильтром (заполнение блока "Дата выхода на рынок")
        WebElement dateFirstInputField = driver.findElement(By.cssSelector(".schema-filter-control__item.schema-filter__number-input[placeholder='2009']"));
        dateFirstInputField.sendKeys("2014");

        WebElement dateSecondInputField = driver.findElement(By.xpath("//span[text() = 'Дата выхода на рынок']/../..//div[2]/input"));
        dateSecondInputField.sendKeys("2016");


        // работа с фильтром (заполнение блока "Операционная система")
        WebElement oSCheckBox = driver.findElement(By.xpath("//li//input[@value='windows']/.."));
        oSCheckBox.click();


        // работа с фильтром (заполнение блока "Размер экрана")
        WebElement screenSizeCheckBox = driver.findElement(By.xpath("//span[text()='5 - 5.5\"']/..//span[@class='i-checkbox__faux']"));
        screenSizeCheckBox.click();


        // работа с фильтром (заполнение блока "Разрешение экрана")
        WebElement screenResolutionCheckBox = driver.findElement(By.xpath("//span[text() = '1080x1920 (FullHD)']/..//span[@class='i-checkbox__faux']"));
        screenResolutionCheckBox.click();


        // работа с фильтром (заполнение блока "Технология экрана")
        WebElement screenTechnologyCheckBox = driver.findElement(By.cssSelector(".i-checkbox__real[value='slcd'] + .i-checkbox__faux"));
        screenTechnologyCheckBox.click();


        // работа с фильтром (заполнение блока "Оперативная память, ГБ")
        WebElement memoryFirstInputField = driver.findElement(By.xpath("//span[text() = 'Оперативная память, ГБ']/../..//input[@placeholder='от']"));
        memoryFirstInputField.sendKeys("2");

        WebElement memorySecondInputField = driver.findElement(By.xpath("//span[text() = 'Оперативная память, ГБ']/../..//div[2]/input"));
        memorySecondInputField.sendKeys("5");


        // работа с фильтром (заполнение блока "Флэш-память, ГБ")
        WebElement fleshMemoryFirstInputField = driver.findElement(By.xpath("//span[text() = 'Флэш-память, ГБ']/../..//input[@placeholder='от']"));
        fleshMemoryFirstInputField.sendKeys("8");

        WebElement fleshMemorySecondInputField = driver.findElement(By.xpath("//span[text() = 'Флэш-память, ГБ']/../..//div[2]/input"));
        fleshMemorySecondInputField.sendKeys("64");


        // работа с фильтром (заполнение блока "Поддержка карт памяти")
        WebElement memoryCardButton = driver.findElement(By.xpath("//span[text() ='Поддержка карт памяти']//../..//span[text() = 'Да']"));
        memoryCardButton.click();


        // работа с фильтром (заполнение блока "Камера, Мп")
        WebElement cameraCheckBox = driver.findElement(By.xpath("//span[text() = '16 Мп']/..//span[@class='i-checkbox__faux']"));
        cameraCheckBox.click();


        // работа с фильтром (заполнение блока "Формат SIM-карты")
        WebElement formatOfSIMCardCheckBox = driver.findElement(By.cssSelector(".i-checkbox__real[value='micro'] + .i-checkbox__faux"));
        formatOfSIMCardCheckBox.click();


        // работа с фильтром (заполнение блока "Dual-SIM")
        WebElement dualSIMButton = driver.findElement(By.xpath("//span[text()='Dual-SIM']//../..//span[text() = 'Да']"));
        dualSIMButton.click();


        // работа с фильтром (заполнение блока "LTE")
        WebElement lTECheckBox = driver.findElement(By.xpath("//span[text()='LTE']/..//span[@class='i-checkbox__faux']"));
        lTECheckBox.click();


        // работа с фильтром (заполнение блока "Цвет корпуса")
        WebElement colourCheckBox = driver.findElement(By.xpath("//li//span[text()='бронзовый']"));
        colourCheckBox.click();


        // работа с фильтром (заполнение блока "Емкость аккумулятора, мАч")
        WebElement batteryCapacityFirstInputField = driver.findElement(By.xpath("//div/*/input[@placeholder='400']"));
        batteryCapacityFirstInputField.sendKeys("8");

        WebElement batteryCapacitySecondInputField = driver.findElement(By.xpath("//span[text() = 'Емкость аккумулятора, мАч']/../..//div[2]/input"));
        batteryCapacitySecondInputField.sendKeys("64");

    }
    
    @AfterTest
    public void teardown(){
        driver.quit();
    }
    
}

