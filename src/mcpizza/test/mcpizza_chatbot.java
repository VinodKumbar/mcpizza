package mcpizza.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class mcpizza_chatbot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Chrome Browser
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VINOD\\OneDrive\\Desktop\\selenium_webDrivers\\chromedriver.exe");	
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	/*	//Firfox Browser
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VINOD\\OneDrive\\Desktop\\selenium_webDrivers\\geckodriver.exe");	
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new FirefoxDriver();  */
		
		
	/*	//Edge Browser
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\VINOD\\OneDrive\\Desktop\\selenium_webDrivers\\msedgedriver.exe");	
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new EdgeDriver(); */
		
		
		
		
		driver.get("https://c0.avaamo.com/web_channels/d0880907-3408-4c8d-9226-7648880a94fa/demo.html?banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("[alt='Chat agent button']")).click();
		driver.findElement(By.cssSelector(".get-started-link")).click();
		driver.switchTo().frame(driver.findElement(By.name("avaamoIframe")));
		driver.findElement(By.id("first_name")).sendKeys("Vinod");
		driver.findElement(By.id("last_name")).sendKeys("Kumbar");
		driver.findElement(By.id("email")).sendKeys("im.vinod.kumbar@gmail.com");
		driver.findElement(By.cssSelector(".send")).click();
		String journey = driver.findElement(By.xpath("//*[contains(text(),'Booking')]")).getText();
		System.out.println(journey);
		//driver.switchTo().defaultContent();
		
		// Chat bot Q1
		driver.findElement(By.id("queryTextbox")).sendKeys("How old are you?");
		driver.findElement(By.xpath("//*[@id='query-autocomplete-list']//following::button[1]")).click();
		String q1_bot_reply = driver.findElement(By.xpath("//*[contains(text(),'How old')]//following::div[14]")).getText();
		System.out.println(q1_bot_reply);
		
		//Chat bot Q2
		driver.findElement(By.id("queryTextbox")).sendKeys("Where did you come from?");
		driver.findElement(By.xpath("//*[@id='query-autocomplete-list']//following::button[1]")).click();
		String q2_bot_reply = driver.findElement(By.xpath("//*[contains(text(),'come from')]//following::div[14]")).getText();
		System.out.println(q2_bot_reply);
		
		//Chat bot Q3
		driver.findElement(By.id("queryTextbox")).sendKeys("Where did you get your name?");
		driver.findElement(By.xpath("//*[@id='query-autocomplete-list']//following::button[1]")).click();
		String q3_bot_reply = driver.findElement(By.xpath("//*[contains(text(),'your name')]//following::div[14]")).getText();
		System.out.println(q3_bot_reply);
		
		//Chat bot Q4
		driver.findElement(By.id("queryTextbox")).sendKeys("Are you a robot?");
		driver.findElement(By.xpath("//*[@id='query-autocomplete-list']//following::button[1]")).click();
		String q4_bot_reply = driver.findElement(By.xpath("//*[contains(text(),'you a robot')]//following::div[14]")).getText();
		System.out.println(q4_bot_reply);
		driver.findElement(By.id("queryTextbox")).sendKeys("Nope, you cant fool around me !!!");
		driver.findElement(By.xpath("//*[@id='query-autocomplete-list']//following::button[1]")).click();
		
		// Order Veg Pizza
		driver.findElement(By.id("queryTextbox")).sendKeys("Thats okay, can you help me to order pizza ?");
		driver.findElement(By.xpath("//*[@id='query-autocomplete-list']//following::button[1]")).click();
		
		//select veg option
		driver.findElement(By.cssSelector("[title='veg']")).click();
		driver.findElement(By.cssSelector("[value='cheese_id']")).click();
		driver.findElement(By.cssSelector("[value='tomato_id']")).click();
		driver.findElement(By.cssSelector(".default_card_submit")).click();
		driver.findElement(By.xpath("//button[@class='navigator right']")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Thick Crust')])[3]")).click();
		driver.findElement(By.cssSelector("[title='Large']")).click();
		String pizzaa = driver.findElement(By.xpath("//*[contains(text(),'Will Look')]")).getText();
		System.out.println(pizzaa);
		driver.findElement(By.cssSelector("[title='Yes']")).click();
		String confirmMsg = driver.findElement(By.xpath("(//*[contains(text(),'PLACED .')])[2]")).getText();
		System.out.println(confirmMsg);
		driver.findElement(By.cssSelector(".thumbs-up")).click();
		
		// provide feedback
		WebElement dropdown = driver.findElement(By.xpath("(//*[@role='combobox'])[2]"));
		dropdown.click();
		dropdown.findElement(By.xpath("//*[contains(text(),'Excellent')]")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Submit')])[3]")).click();
		String thankyou = driver.findElement(By.xpath("(//*[contains(text(),'Support')])[2]")).getText();
		System.out.println(thankyou);
		driver.quit();
	}

}
