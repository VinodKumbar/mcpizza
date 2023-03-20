package mcpizza.test;

import java.time.Duration;
import java.util.List;

import org.checkerframework.common.util.report.qual.ReportUse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import mcpizza.main.pageObjects.chatBot_Login;
import mcpizza.main.pageObjects.chatBot_OrderPizza;
import mcpizza.main.pageObjects.chatBot_Questions;
import mcpizza.test.BaseTest.Basetest;
import utils.resuable;

public class mcpizza_chatBot_Assignment_Test extends Basetest {
	
	ExtentReports extent;

	@BeforeTest
	public void launcBrowser() {
		
		// ExtentReports, ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Autpmation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vinod Kumbar");
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\VINOD\\OneDrive\\Desktop\\selenium_webDrivers\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}


		@Test
		public void assignment() {	
		extent.createTest("Verify the Pizza Order is Successfull");
		resuable reuse = new resuable(driver);
		chatBot_Login bot = new chatBot_Login(driver);
		chatBot_Questions botQue = new chatBot_Questions(driver);
		chatBot_OrderPizza order = new chatBot_OrderPizza(driver);
	
	
		bot.goTo();

		// ChatBot Registration
		bot.enterFirstName("Vinod");
		bot.enterLastName("Kumbar");
		bot.enterEmail("im.vinod.kumbar@gmail.com");
		bot.clickNextButton();
		bot.verifyJourneyMsg();

		// Chat bot Q1
		botQue.Que1("How old are you?");
		reuse.clickSendBtn();
		botQue.verifyQue1Response();

		// Chat bot Q2
		botQue.Que2("Where did you come from?");
		reuse.clickSendBtn();
		botQue.verifyQue2Response();

		// Chat bot Q3
		botQue.Que3("Where did you get your name?");
		reuse.clickSendBtn();
		botQue.verifyQue3Response();

		// Chat bot Q4

		botQue.Que4("Are you a robot?");
		reuse.clickSendBtn();
		botQue.verifyQue4Response();

		botQue.Que4_1("Nope, you cant fool around me !!!");
		reuse.clickSendBtn();

		botQue.Que4_2("Thats okay, can you help me to order pizza ?");
		reuse.clickSendBtn();

		// Order Veg Pizza
		order.SelectVeg();
		order.SelectCheese();
		order.SelectTomoto();
		order.Submit();
		order.Right_Nav();
		order.ThickCrust();
		order.Large();
		order.Order_Preview();
		order.Yes();
		order.verifyOrderPlacedMsg();
		order.Thumbs_Up();

		// provide feedback and close the browser
		order.provideFeedback();
		extent.flush();

	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
