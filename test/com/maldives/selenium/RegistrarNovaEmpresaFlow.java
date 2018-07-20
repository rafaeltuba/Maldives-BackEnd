package com.maldives.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrarNovaEmpresaFlow {

  @Test
  public void fluxoCadastrarEmpresaComSucessoTest() {
	
	System.setProperty("webdriver.chrome.driver", "D:\\web-driver\\chromedriver_win32\\chromedriver.exe");	  
	  
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8080/maldives/");
	  
	WebElement nmEmpresaElement = driver.findElement(By.name("nmEmpresa"));
    WebElement cdRamoAtividade = driver.findElement(By.name("cdRamoAtividade"));
    WebElement deEmail = driver.findElement(By.name("deEmail"));
    WebElement deSenha = driver.findElement(By.name("deSenha"));

    WebElement formElement = driver.findElement(By.id("registrarForm"));
 
    nmEmpresaElement.sendKeys("Rafael da Silva Rodrigues");
    cdRamoAtividade.sendKeys("1");
    deEmail.sendKeys("rafael@gmail.com");
    deSenha.sendKeys("1234");
    
    formElement.submit();
    
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	
    assertEquals("Conta criado com Sucesso!", driver.getTitle());
    
    driver.quit();
	  
  }
  
  @Test
  public void fluxoCadastrarEmpresaInSucessoTest() {
	
	System.setProperty("webdriver.chrome.driver", "D:\\tools\\web-driver\\chromedriver_win32\\chromedriver.exe");	  
	  
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8080/maldives/");
	  
    WebElement cdRamoAtividade = driver.findElement(By.name("cdRamoAtividade"));
    WebElement deEmail = driver.findElement(By.name("deEmail"));
    WebElement deSenha = driver.findElement(By.name("deSenha"));

    WebElement formElement = driver.findElement(By.id("registrarForm"));
 
    cdRamoAtividade.sendKeys("1");
    deEmail.sendKeys("rafael@gmail.com");
    deSenha.sendKeys("1234");
    
    formElement.submit();
    
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	
    assertEquals("HTTP Status 500 – Internal Server Error", driver.getTitle());
    
    driver.quit();
	  
  }
	
}
