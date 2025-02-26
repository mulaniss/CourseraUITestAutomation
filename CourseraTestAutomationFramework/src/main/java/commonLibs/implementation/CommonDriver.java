package commonLibs.implementation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonDriver {

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	private WebDriver driver;
	private int pageLoadTimeout;
	private int elementDetectionTimeout;
	private String currentWorkingDiretory;

	public CommonDriver(String browserType) throws Exception {
		pageLoadTimeout = 10;
		elementDetectionTimeout = 10;
		currentWorkingDiretory = System.getProperty("user.dir");
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", currentWorkingDiretory + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			throw new Exception("Invalid Browser Type" + browserType);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	public void navigateToURL(String url) {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));
		driver.get(url);

	}

	public void closeAllBrowser() {

		driver.quit();
	}

	public String getTitleOfThePage() {
		return driver.getTitle();
	}
}
