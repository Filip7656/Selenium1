package selenium.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.springframework.http.HttpStatus;

public class SingUp {
	private static final Logger LOG = LogManager.getLogger(Chrome.class);
	private static WebDriver driver;
	private static Actions actions;
	private static ChromeOptions chromeOptions;
	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	static String email = "fchlebowski+" + timeStamp + "@gmail.com";
	public static Response testResponse = new Response();

	/*
	 * Tipy do pisania testow 1. jezeli jest unikalna nazwa klasy div to najlepiej
	 * cssSelector i po class 2. Czasami nie potrafi znalesc bo selenium za szybko
	 * wykonuje interakcje wzgledem szybkosci dzialania angualara : dac
	 * Thread.sleep(); 3. W jendym przypadku musialem dac action i zeby selenium
	 * przeszlo do szukanego elementu bo pomimo ze go znajdowalo to nie moglo
	 * kliknac 4. Ten rand to jest po to zeby generowal kolejne mozliwe adresy
	 * email, jezeli wysypie sie na klikaniu terms to trzeba puscic jescze raz,
	 * narazie to rozwiazanie tymczasowe 5. Kod do momentu "Clicked Lets Begin"
	 * dziala i testuje dobrze 6. Mega przydatna rzecz to wtyczka Selenium IDE do
	 * chroma, ona pozwala latwo znalesc po czym szukac to co chcemy zrobic
	 */

	public static void initialization() {
		BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");
		// zamiast rand timestampa do maila

		driver = new ChromeDriver(chromeOptions);
		actions = new Actions(driver);
		// strona - test.healthdom.com
		driver.get("https://app.healthdom.com/");
		// Thread.sleep(1000);
		LOG.info("reached the website");

	}

	public static Response runTest() throws InterruptedException {
		initialization();
		return	singUpTest();

	}


	public static Response singUpTest() throws InterruptedException {

		try {
			driver.findElement(By.linkText("Sign up")).click();
			LOG.info("CLicked sign up");

		} catch (NoSuchElementException e) {
			errorHandle("click sugn up",e);

		}

		formtest("signUpFirstName", "FilipTestSignIn");
		formtest("signUpLastName", "Brown");
		formtest("signUpEmail", email);
		formtest("signUpPassword", "secret");

		try {
			driver.findElement(By.xpath("//span[contains(.,'Create account')]")).click();
			LOG.info("CLicked create account");
		} catch (NoSuchElementException e) {
			errorHandle("click create account", e);
		}

		try {
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.cssSelector("[class='mat-checkbox-input cdk-visually-hidden']"));
			actions.moveToElement(element).click().perform();
			LOG.info("Clicked accept ");

		} catch (NoSuchElementException e) {
			errorHandle("Accept credentials and term", e);

		}

		try {
			WebElement Form = driver.findElement(By.xpath("//div/div/input"));
			Form.sendKeys("J.W");
			LOG.info("Sended initials");

			driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
			LOG.info("Clicked next");

		} catch (NoSuchElementException e) {
			errorHandle("send initials", e);

		}
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(), ' My family illness history ')]")).click();
			LOG.info("Clicked family ill");
			driver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
			LOG.info("CHoosed illness and clicked submit");

		} catch (NoSuchElementException e) {
			errorHandle("choose illness", e);

		}

		try {
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("[class='ring-avatar__results ng-star-inserted']")).click();
			LOG.info("Clicked Lets Begin");

		} catch (NoSuchElementException e) {
			errorHandle("click let's begin", e);

		}
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
			LOG.info("Clicked Next");

		} catch (NoSuchElementException e) {
			errorHandle("click next", e);

		}
		try {
			LOG.debug(driver.getCurrentUrl());
			driver.findElement(By.xpath("//img[@src='/assets/img/questions/Male.svg']")).click();
			LOG.info("Clicked male");
		} catch (NoSuchElementException e) {
			errorHandle("choose gender", e);

		}

		try {
			Thread.sleep(2000);
			LOG.debug(driver.getCurrentUrl());
			// formtest zmienic jak na te nizej
			formtest("account_birthday_undefined", "17");
			WebElement month = driver.findElement(By.id("mat-input-9"));
			month.sendKeys("05");
			LOG.info("Seded month");
			WebElement year = driver.findElement(By.id("mat-input-10"));
			LOG.info("Sended year");
			year.sendKeys("1999");
			driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
			LOG.info("Clicked next");

		} catch (NoSuchElementException e) {
			errorHandle("account birthday", e);

		}

		try {
			Thread.sleep(2000);
			LOG.debug(driver.getCurrentUrl());

			// tutaj trzeba dodac klikniecie na obrazki, narazie mnie to przerasta.
			// driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
			WebElement element = driver.findElement(By.xpath("//button[contains(.,'Next')]"));
			actions.moveToElement(element).click().perform();
			// feet
			// css=.stepper-row:nth-child(1) .stepper-sign:nth-child(1)
			// driver.findElement(By.xpath("//img[@src='/assets/img/questions/plus.svg']")).click();
			// driver.findElement(By.cssSelector("css=.stepper-row:nth-child(1)
			// .stepper-sign:nth-child(1)"));
			LOG.info("Added Height");
			// driver.findElement(By.cssSelector(""));
			// inch
			// driver.findElement(By.cssSelector(""));

			// driver.findElement(By.xpath("//img[@src='/assets/img/questions/plus.svg']")).click();
			// LOG.info("Added height (feet");

		} catch (NoSuchElementException e) {
			errorHandle("account Height", e);
		}

		try {
			Thread.sleep(3000);
			driver.navigate().to("https://app.healthdom.com/#/questionnaire/account?questionId=weight");
			LOG.debug(driver.getCurrentUrl());

			// id=mat-input-1
			WebElement weight = driver.findElement(By.name("account_weight"));
			actions.moveToElement(weight).sendKeys("170").perform();
			LOG.info("Sended weight");
			// LOG.debug(driver.getPageSource().toString());
		} catch (NoSuchElementException e) {

			errorHandle("account_weight", e);
		}

		try {
			driver.navigate().to("https://app.healthdom.com/#/questionnaire/account?questionId=ethnicity");
			Thread.sleep(2000);
			LOG.info(driver.getCurrentUrl());
			// col-6 col-md-4 col-lg-3 ng-star-inserted
			// driver.findElement(By.cssSelector(".col-6:nth-child(2) > .answer-entry"));
			// driver.findElement(By.cssSelector("[class='col-6 col-md-4 col-lg-3
			// ng-star-inserted']")).click();
			driver.findElement(By.xpath("//html/body/app-root/questionnaire_wizard/div/div[3]/div/div[1]/div/div[6]"))
					.click();
			driver.findElement(By.xpath("//div[contains(text(), ' American Indian ')]")).click();
			LOG.info("Choosed ethnicity");
			LOG.debug(driver.getCurrentUrl());
		} catch (NoSuchElementException e) {
			errorHandle("ethinicity", e);

		}

		try {
//			//https://app.healthdom.com/#/questionnaire/account?questionId=connectDevice
//			// tylko next
//			driver.navigate().to("https://app.healthdom.com/#/questionnaire/account?questionId=connectDevice");
//			WebElement element = driver.findElement(By.xpath("//button[contains(.,'Next')]"));
//			actions.moveToElement(element).click().perform();
//			LOG.info(driver.getCurrentUrl());
		} catch (NoSuchElementException e) {

		}
		driver.close();
		return testResponse;

	}

	private static Response errorHandle(String errorName, NoSuchElementException e) {
		testResponse.setLogError(e.toString());
		testResponse.setError("Couldn't do " + errorName);
		testResponse.setTestStatus(HttpStatus.NO_CONTENT);

		return testResponse;
	}



private static void analyzeLog() {
	System.out.println("=================BROWSER CONSOLE LOGS==================");
	
	LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	for (LogEntry entry : logEntries) {
		System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage() + " "
				+ entry.toString());
	}
	System.out.println("=======================================================");
}

private static void formtest(String name, String key) {
	try {
		WebElement Form = driver.findElement(By.name(name));
		Form.sendKeys(key);
		LOG.info("Sended:" + key);
		
	} catch (NoSuchElementException e) {
		errorHandle(name,e);

	}
}
}