package org.example.ejercicios;

//PARTES DE UNA PRUEBA EXAMEN
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

public class BuscadorGoogleTest {
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
    public void paginaPrincipalGoogle(){
        //PREPARACION DE LA PRUEBA
        //1. Ingresar a la pagina de Google
        String googleurl = "https://www.google.com";
        driver.get(googleurl);

        //LOGICA DE LA PRUEBA
        //2.En el campo de texto,escribir un criterio de busqueda
        //capturar el campo de busqueda
        WebElement campoBusqueda = driver.findElement(By.name("q"));

        campoBusqueda.sendKeys("Universidad catolica Boliviana");
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //Presionar tecla enter
        campoBusqueda.submit();

        try {
            TimeUnit.SECONDS.sleep(7);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //VERIFICACION DE LA PRUEBA
        //full xpath
        WebElement resultado = driver.findElement(By.xpath("/html/body/div[6]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/table/tbody/tr[1]/td/div/h3/a"));

        String label = resultado.getText();
        System.out.println("Texto del resultado: "+label);
        Assert.assertEquals(label,"Universidad Católica Boliviana");

    }

    @AfterTest
    public void closeDriver() throws Exception{
        driver.quit();
    }

}
