package com.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTests extends BaseTests {

	@Parameters({ "username", "userPassword" })
	@Test
	public void verifyUserLoginWithValidCredentials(String username, String userPassword) {

		reportUtils.createATestCase("verify User Login With Valid Credentials");

		reportUtils.addTestLog(Status.INFO, "Performing Login");

		loginpage.loginToApplication(username, userPassword);

		String expectedTitle = "GTPL Bank Manager Home Page";
		String actualTitle = cmnDriver.getTitleOfThePage();

		reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");

		Assert.assertEquals(actualTitle, expectedTitle);

	}

}
