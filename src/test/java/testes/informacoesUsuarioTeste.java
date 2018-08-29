package testes;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class informacoesUsuarioTeste {
	
	private WebDriver navegador;

	@Before
	public void setUp() {
		// indicando aonde está salvo o driver para acesso
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		navegador.get("http://www.juliodelima.com.br/taskit");
		navegador.manage().window().maximize();

	}

	//@Test
	public void atualizarPagina() {
		navegador.navigate().refresh();
	}

	@Test
	public void testAdicionarUmaInformacaoDoUsuario() {
		// Clicar no link que possui o texto "Sign in"
		navegador.findElement(By.linkText("Sign in")).click();

		// Identificando o formulario de login
		WebElement formularioSignInbox = navegador.findElement(By.id("signinbox"));

		// Digitar no campo com name "login" que está dentro do formulario de id
		// "signinbox" o texto "julio001"
		formularioSignInbox.findElement(By.name("login")).sendKeys("julio0001");

		// Digitar no campo com name "password" que está dentro do formulario de id "signinbox" o texto "123456"
		formularioSignInbox.findElement(By.name("password")).sendKeys("123456");
		
		// Clicar no link com o texto "SIGN IN"
		navegador.findElement(By.linkText("SIGN IN")).click();
		
		// Clicar em um link que possui a class "me"
		navegador.findElement(By.className("me")).click();
		
		// Clicar em um link que possui o text "MORE DATE ABOUT YOU"
		navegador.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		
		// Identificando atraves de XPATH e Clicar no botão através do xpath "//button[@data-target='addmoredata']"
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		
		// Identificar a pop-up onde está o formulario de id addmoredata
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
		
		// Na combo de name "type" escolhe a opção phone
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");
		
		// No campo de name "contact" digitar "+5511999999999"
		popupAddMoreData.findElement(By.name("contact")).sendKeys("5511999999999");
		
		// Clicar No linktext "SAVE que está no pop-up
		popupAddMoreData.findElement(By.linkText("SAVE")).click();
		
		// No mensagem de id "toast-container" validar o texto  é "Your contact has been added!"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Your contact has been added!", mensagem);
		
		
	}
	
	

	//@After
	public void tearDown() {
		navegador.quit();
	}
}
