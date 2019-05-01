package selenium.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
	private static final Logger LOG = LogManager.getLogger(Chrome.class);

	public static void logInTest() {
		BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver(chromeOptions);
		// strona - test.healthdom.com
		driver.get("https://test.healthdom.com/");
		// Thread.sleep(1000);
		LOG.info("reached the website");

		try {
			driver.findElement(By.linkText("continue without account")).click();
			LOG.info("CLicked");

		} catch (NoSuchElementException e) {
			LOG.debug("Impossible to click the pop-up. Reason: " + e.toString());
		}

		try {
			driver.findElement(By.cssSelector(".col-12:nth-child(4) > .answer-entry")).click();
			LOG.info("CLicked");

		} catch (NoSuchElementException e) {
			LOG.debug("Impossible to click the My family illness history. Reason: " + e.toString());
		}

		driver.close();

	}

}
