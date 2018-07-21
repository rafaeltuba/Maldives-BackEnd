package com.maldives.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.maldives.repository.EmpresaDB;
import com.maldives.repository.UsuarioDB;
import com.maldives.service.EmpresaService;
import com.maldives.service.UsuarioService;

public class RegistrarNovaEmpresaFlow {
	
	private final String CHROMEDRIVER_PATH = "D:\\tools\\web-driver\\chromedriver_win32\\chromedriver.exe";
  
	public EmpresaService empresaService = null;
	public UsuarioService usuarioService = null;
  
  
	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}
	
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@Before
    public void beforeExecution() {
		EmpresaService empresaService = new EmpresaService();
		empresaService.setEmpresaDB(new EmpresaDB());
		setEmpresaService(empresaService);
		
		UsuarioService usuarioService = new UsuarioService();
		usuarioService.setUsuarioDB(new UsuarioDB());
		
		setUsuarioService(usuarioService);
		usuarioService.deleteAll();
		empresaService.deleteAll(); 
	}
	  
	  @Test
	  public void fluxoCadastrarEmpresaComSucessoTest() {

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
		
		WebElement body = driver.findElement(By.tagName("body"));
		String bodyText = body.getText();
		
	    assertEquals("Conta criado com Sucesso!", driver.getTitle());
	    assertEquals(bodyText.contains(nmEmpresa), true); 
	    assertEquals(bodyText.contains(cdRamoAtividade), true);
	    assertEquals(bodyText.contains(deEmail), true);
	    
	    driver.quit();
		  
	  }
	  
	  @Test
	  public void fluxoCadastrarEmpresaInSucessoTest() {
		
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
		
	    assertEquals("HTTP Status 500 – Internal Server Error", driver.getTitle());
	    
	    driver.quit();
		  
	  }
	
}
