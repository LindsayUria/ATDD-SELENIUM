package org.example.ejercicios;

import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.*;

public class RegistroDZoneTest {
    private WebDriver driver;

    @BeforeTest
    public void setDriver() throws Exception{
        //String path ="Users/josig/Downloads/chromedriver_win32";

        String path ="F:/Programas/goggle/chromedriver_win32";

        System.setProperty("webdriver.chrome.driver",path);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void verificarMensajeErrorRegistrar(){
        //PREPARACION DE LA PRUEBA
        String dzone = "https://dzone.com";
        driver.get(dzone);

        //LOGICA DE LA PRUEBA
        WebElement joinlink = driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/div[2]/div[2]/a[2]"));
        String linktext = joinlink.getText();

        System.out.println("Texto del link: "+linktext );
        joinlink.click();

        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        /*
        //presionar el boton join
        WebElement joinButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[3]/button"));
        joinButton.click();

        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //validar el mensaje del correo
        WebElement iconAlert = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[1]/div[2]/form/div[1]/span[1]"));
        Assert.assertEquals(true, iconAlert.isDisplayed());

        System.out.println("Se muestra el icono?");


        WebElement emailError = driver.findElement(By.xpath("//div[@data-validate=\"Please enter a valid email address\"]"));
        String attribute = emailError.getAttribute("data-validate");
        System.out.println("Valor del attribute: "+attribute);

        Assert.assertEquals("Please enter a valid email address",attribute);

         */

        //verificar que el password se visualice


        //se introduce un password

        WebElement pass = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[1]/div[2]/form/div[3]/input"));

        pass.sendKeys("1234");
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //click en visualizar password

        WebElement ojito = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
        ojito.click();

        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //validar que se visualice el password

        WebElement iconEye = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[1]/div[2]/form/div[3]/button/i"));
        Assert.assertEquals(true, iconEye.isDisplayed());

        System.out.println("La contraseña si esta visualizandose.");


    }

    @AfterTest
    public void closeDriver() throws Exception{
        driver.quit();
    }
}
