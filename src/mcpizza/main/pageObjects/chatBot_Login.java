package mcpizza.main.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class chatBot_Login {

	WebDriver driver;
	
	public chatBot_Login(WebDriver driver) {
		this.driver = driver;
	}


	By FirstName = By.id("first_name");
	By LastName = By.id("last_name");
	By Email = By.id("email");
	By Next = By.cssSelector(".send");
	By Message = By.xpath("//*[contains(text(),'Booking')]");
	
	public void enterFirstName (String fName) {
		driver.findElement(FirstName).sendKeys(fName);
		
	}
	
	public void enterLastName (String lName) {
		driver.findElement(LastName).sendKeys(lName);
		
	}
	
	public void enterEmail (String eMail) {
		driver.findElement(Email).sendKeys(eMail);
		
	}
	
	public void clickNextButton() {
		driver.findElement(Next).click();
	}
	
	public void verifyJourneyMsg() {		 
		String msg = driver.findElement(Message).getText();
		System.out.println(msg);
	}
	public void goTo() {
		driver.get(
				"https://c0.avaamo.com/web_channels/d0880907-3408-4c8d-9226-7648880a94fa/demo.html?banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up");
		driver.findElement(By.cssSelector("[alt='Chat agent button']")).click();
		driver.findElement(By.cssSelector(".get-started-link")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(driver.findElement(By.name("avaamoIframe")));
	}
	
	
}
