package test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStoreTest {
	
	private WebDriver navegador;

	@Rule
	public TestName nameTest = new TestName();

	@Before
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\drivers\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

		navegador.get("http://automationpractice.com/index.php");
	}

	@Test
	public void foundItemTest() {
		navegador.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("dress");
		navegador.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		WebElement result = navegador.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div[2]/div[2]"));

		assertEquals("Showing 1 - 7 of 7 items", result.getText());
	}

	@Test
	public void notFoundItemTest() {
		navegador.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("test");
		navegador.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		WebElement result = navegador.findElement(By.xpath("//*[@id=\"center_column\"]/p"));

		assertEquals("No results were found for your search \"test\"", result.getText());
	}

	@Test
	public void foundOneItemTest() {
		navegador.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("faded short sleeve T-shirts");
		navegador.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		WebElement result = navegador.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]"));

		assertEquals("1 result has been found.", result.getText());
	}
	
	@Test
	public void differentModelsTest() {
		navegador.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("Printed Summer Dress");
		navegador.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		WebElement test1 = navegador.findElement(By.className("color-list-container"));
		List<WebElement> result = test1.findElements(By.className("color_pick"));
		
		assertEquals(4, result.size());
	}
	
	@Test
	public void addItemOnCartTest() {
		navegador.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("Printed Summer Dress");
		navegador.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		navegador.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div")).click();
		navegador.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();
		navegador.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")).click();
		WebElement cart = navegador.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
				
		assertEquals("Cart 1 Product", cart.getText());
	}
	
	@Test
	public void finishSaleTeste() {
		navegador.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("Printed Summer Dress");
		navegador.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		navegador.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div")).click();
		navegador.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();
		navegador.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
		WebElement cart = navegador.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]"));
				
		assertEquals("Your shopping cart", cart.getText());
	}

	@After
	public void tearDown() {
		navegador.quit();
	}


}
