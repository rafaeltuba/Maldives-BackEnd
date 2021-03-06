package com.maldives.selenium;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.maldives.service.CompanyService;
import com.maldives.service.UserService;

public class SignUpCompanyFlow extends UITest {
	
	private final String CHROMEDRIVER_PATH = "D:\\tools\\web-driver\\chromedriver_win32\\chromedriver.exe";
  
	public CompanyService companyService = null;
	public UserService userService = null;
  
  
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Before
    public void beforeExecution() {
		try {
			this.deleteAllCompanies();
			this.deleteAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	}
	  
	  @Test
	  public void signUpCompanyWIthSucessTest() {

		  System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);	  
		  
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/maldives/");
		  
		WebElement nmEmpresaElement = driver.findElement(By.name("nmEmpresa"));
	    WebElement cdRamoAtividadeElement = driver.findElement(By.name("cdRamoAtividade"));
	    WebElement deEmailElement = driver.findElement(By.name("deEmail"));
	    WebElement deSenhaElement = driver.findElement(By.name("deSenha"));
	    WebElement flAceiteTermosElement = driver.findElement(By.name("flAceiteTermos"));
	
	    WebElement formElement = driver.findElement(By.id("registrarForm"));
	 
	    String nmEmpresa = "Resultados Virtuais";
	    String cdRamoAtividade = "1";
	    String deEmail = "rafael@gmail.com";
	    String deSenha = "123";
	    
	    nmEmpresaElement.sendKeys(nmEmpresa);
	    cdRamoAtividadeElement.sendKeys(cdRamoAtividade);
	    deEmailElement.sendKeys(deEmail);
	    deSenhaElement.sendKeys(deSenha);
	    flAceiteTermosElement.click();
	    
	    formElement.submit();
	    
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		WebElement tdNmEmpresa = driver.findElement(By.id("tdNmEmpresa"));
		WebElement tdCdRamoAtividade = driver.findElement(By.id("tdCdRamoAtividade"));
		WebElement tdDeEmail = driver.findElement(By.id("tdDeEmail"));
		
		WebElement tdSenha = driver.findElement(By.id("tdDeSenha"));
		WebElement tdEmailId = driver.findElement(By.id("tdEmailId"));
		
	    assertEquals("Conta criado com Sucesso!", driver.getTitle());
	    assertEquals(tdNmEmpresa.getText().contains(nmEmpresa), true); 
	    assertEquals(tdCdRamoAtividade.getText().contains(cdRamoAtividade), true);
	    assertEquals(tdDeEmail.getText().contains(deEmail), true);
	    
	    assertEquals(tdSenha.getText().contains(deSenha), true);
	    assertEquals(tdEmailId.getText().contains(deEmail), true);
	    
	    driver.quit();
		  
	  }
	  
	  @Test
	  public void signUpCompanyWIthoutSucessTest() {
		
		System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);	  
		  
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/maldives/");
		  
		WebElement nmEmpresaElement = driver.findElement(By.name("nmEmpresa"));
	    WebElement cdRamoAtividadeElement = driver.findElement(By.name("cdRamoAtividade"));
	    WebElement deEmailElement = driver.findElement(By.name("deEmail"));
	    WebElement deSenhaElement = driver.findElement(By.name("deSenha"));
	
	    WebElement formElement = driver.findElement(By.id("registrarForm"));
	 
	    nmEmpresaElement.sendKeys("Rafael da Silva Rodrigues");
	    cdRamoAtividadeElement.sendKeys("1");
	    deEmailElement.sendKeys("rafael@gmail.com");
	    deSenhaElement.sendKeys("1234");
	    
	    formElement.submit();
	    
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
	    assertEquals("HTTP Status 500 � Internal Server Error", driver.getTitle());
	    
	    driver.quit();
		  
	  }
	
}
