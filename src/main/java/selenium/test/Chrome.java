package selenium.test;

import java.io.IOException;

import org.apache.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.openqa.selenium.chrome.ChromeDriver;
@SpringBootApplication
public class Chrome {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(Chrome.class);
	}
}
/*
 * xpath=//a[contains(text(),
 * 'continue without account')] 
 * 1) On the "Login"
 * screen choose "continue without account"
 *  2) On the "WhatBringsYou" screen
 * choose "My family illness history", and click "Submit"
 *  3) On the "Home.Main"
 * screen choose "Let's begin!" 
 * 4) On the "ToCreatePrevention" screen choose
 * "Next"
 *  5) On the "Gender" screen choose "Male" 
 *  6) On the "BirthDate" screen
 * write 11/28/1958 and click "Next" 
 * 
 * 7) On the "Height" screen choose 3 feet 10
 * inches and click "Next" 
 * 8) On the "Weight" screen write 124 lbs and click
 * "Next" 
 * 9) On the "Ethnicity" screen choose "White" and "American Indian" and
 * click "Next"
 *  10) On the "ConnectDevices" screen click "Next" 
 *  11) On the
 * "Exercise" screen choose: 1'st question: 5.75 hrs/day, 2'nd question: 9.5
 * hrs/day and click "Next" 
 * 12) On the "Smoke" screen choose: "No" 
 * 
 * 13) On the
 * "Alcohol" screen choose: 1 drink and click "Next" 
 * 14) On the "Sleep" screen
 * choose: 6.5 hours and click "Next" 
 * 15) On the "Diet" screen choose: 1; 5; 7;
 * 4 (in order of the questions) and click "Next" 
 * 16) On the "AddressHome"
 * screen write 23321 in the "Zip code" field and click "Next" 
 * 17) On the
 * "YourMedicalConditions" screen choose "Heart disease", "Hight cholesterol",
 * "Lymphoma cancer" and click "Next" 
 * 18) On the "FamilyMedicalConditions"
 * screen choose "Hypertension", "Hepatitis", "Breast cancer",
 * "Type II Diabetes" and click "Next" 
 * 19) On the "FamilyDetails" screen add
 * informations: for "Hypertension": brother - 32 years; for "Breast cancer":
 * Son - 4 years; for "Type II Diabetes": Mother - 56 years; for "Hepatitis":
 * Daughter - 24 years, and click "Next" 
 * 20) On the "SignUp" screen write: First
 * name: John; Last name: Brown e-mail: test@healthdom.com; password: secret and
 * click "Create account"
 *  21) On the "Terms of service" screen click
 * "I accept the terms of service" and write J.W. and click "Next" 
 * 22) On the
 * "GreatJob" screen click on "Take me there" 
 * 23) On the "TIP 1" screen click
 * anywhere 
 * 24) On the "TIP 2" screen click anywhere 
 * 25) On the "TIP 3" screen
 * click anywhere 
 * 26) If there appear the Home.Main screen
 * (https://app.healthdom.com/#/dashboard/start) - test is passed if not - test
 * failed, also in case of any problem during test - test is failed.
 * 
 */
