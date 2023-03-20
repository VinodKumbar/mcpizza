package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class resuable {
	
	WebDriver driver;
	
	public resuable(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSendBtn() {
		driver.findElement(By.xpath("//*[@id='query-autocomplete-list']//following::button[1]")).click();
	}
	
	public void applyImplicitWait() {
		
	}

}
