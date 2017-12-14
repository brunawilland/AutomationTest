package main;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.SeleniumSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.thoughtworks.selenium.*;

public class SearchSteps extends SeleniumSteps {

	private final String pageLoadTimeout = "6000";
	private WebDriver driver;


	public SearchSteps() {
		
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
	        driver = new FirefoxDriver();
	      
	}

	@Given("I navigate to site.getnet.com.br")
	public void navigateToWebsite() {
		driver.get(" https://site.getnet.com.br/");
	}

	@When("I search for \"vermelhinha\"")
	public void searchForTerm(final String term) throws InterruptedException {
		
		//Send 'vermelhinha'
		WebElement inputSearch = driver.findElement(By.id("fl-search-input"));
		inputSearch.sendKeys("vermelhinha");
		 
		// Click OK button
		WebElement buttonSearch = driver.findElement(By.id("OK"));
		buttonSearch.click();
	}

	@Then("the text \"$textFragment\" is present")
	public void verifyTextIsPresent(final String textFragment) {
		
		assertThat(driver.getPageSource(), Matchers.containsString( textFragment));
	}

	@When("I click the link \"$linkText\"")
	public void clickLink(final String linkText) {
		
		WebElement link = driver.findElement(By.cssSelector("a[href*='perguntas-frequentes-vermelhinha']"));
		link.click();
		
		}

	@Then("the text \"$textFragment\" is present")
	public void pageURLShouldBe(final String textFragment) {
		assertThat(driver.getPageSource(), Matchers.containsString(textFragment));
	}
}