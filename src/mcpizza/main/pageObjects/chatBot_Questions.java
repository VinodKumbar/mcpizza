package mcpizza.main.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class chatBot_Questions {

	WebDriver driver;
	
	public chatBot_Questions(WebDriver driver) {
		this.driver = driver;
	}


	By Que1 = By.id("queryTextbox");
	By Que2 = By.id("queryTextbox");
	By Que3 = By.id("queryTextbox");
	By Que4 = By.id("queryTextbox");
	By Q1Respionse = By.xpath("//*[contains(text(),'How old')]//following::div[14]");
	By Q2Respionse = By.xpath("//*[contains(text(),'come from')]//following::div[14]");
	By Q3Respionse = By.xpath("//*[contains(text(),'your name')]//following::div[14]");
	By Q4Respionse = By.xpath("//*[contains(text(),'you a robot')]//following::div[14]");
	By Q4_1Respionse = By.xpath("//*[contains(text(),'you a robot')]//following::div[14]");
	By Q4_2Respionse = By.xpath("//*[contains(text(),'you a robot')]//following::div[14]");
	
	public void Que1(String howOld) {
		driver.findElement(Que1).sendKeys(howOld);
		
	}
	
	public void Que2 (String whereDid) {
		driver.findElement(Que2).sendKeys(whereDid);
		
	}
	
	public void Que3 (String yourName) {
		driver.findElement(Que3).sendKeys(yourName);
		
	}
	
	public void Que4(String fool) {
		driver.findElement(Que4).sendKeys(fool);
	}
	public void Que4_1(String orderPizza) {
		driver.findElement(Que4).sendKeys(orderPizza);
	}
	public void Que4_2(String robot) {
		driver.findElement(Que4).sendKeys(robot);
	}
	
	public void verifyQue1Response() {
		String Q1Res = driver.findElement(Q1Respionse).getText();
		System.out.println(Q1Res);
		
	}
	public void verifyQue2Response() {
		String Q2Res = driver.findElement(Q2Respionse).getText();
		System.out.println(Q2Res);
		
	}
	public void verifyQue3Response() {
		String Q3Res = driver.findElement(Q3Respionse).getText();
		System.out.println(Q3Res);
		
	}
	public void verifyQue4Response() {
		String Q4Res = driver.findElement(Q4Respionse).getText();
		System.out.println(Q4Res);
		
	}
	
	
	
	
}
