package mcpizza.test.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	public static WebDriver driver;

	public WebDriver initializeDriver() throws IOException {

		// properties class

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream
				(System.getProperty("user.dir")+"src\\utils\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			// Chrome Browser

			// optional
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\VINOD\\OneDrive\\Desktop\\selenium_webDrivers\\chromedriver.exe");
			System.setProperty("webdriver.http.factory", "jdk-http-client");

			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\VINOD\\OneDrive\\Desktop\\selenium_webDrivers\\geckodriver.exe");
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			 driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {

			// Edge Browser

			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\VINOD\\OneDrive\\Desktop\\selenium_webDrivers\\msedgedriver.exe");
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			 driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}
}
