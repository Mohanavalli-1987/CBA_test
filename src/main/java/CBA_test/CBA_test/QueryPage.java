package CBA_test.CBA_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QueryPage {
	public WebDriver driver;

	// Constructor to initialize driver
	public QueryPage(WebDriver driver) {
		this.driver = driver;

	}

	// Check if query input and search button are on the main screen of the
	// application:
	// Search query input field is exist
	// Search button is exist.
	public boolean test_VerifyInput() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-input")));

		return driver.findElement(By.id("search-input")).isDisplayed();
	}

	public boolean test_VerifySearchButton() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-button")));
		return driver.findElement(By.id("search-button")).isDisplayed();

	}

	// Check if searching with empty query is forbidden:
	public void test_clickonSearch() {
		driver.findElement(By.id("search-button")).click();
	}

	// Check if user gets feedback if there are no results
	// Check if results match the query:
	public boolean test_VerifySearchResults(String getText) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-results")));
		if (getText.equals(driver.findElement(By.id("search-results")).getText().toString())) {
			return true;
		}
		return false;
	}

	// Check if at least one island is returned after querying for isla:
	public boolean test_VerifySearchResultsCount() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-results")));
		List<WebElement> islands = driver.findElements(By.id("search-results"));

		if (islands.size() > 0) {
			return true;
		}
		return false;
	}

	// Check if user gets feedback if there are no results
	// Check if results match the query:
	public void test_enterText(String enterText) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-input")));
		driver.findElement(By.id("search-input")).click();
		driver.findElement(By.id("search-input")).clear();
		driver.findElement(By.id("search-input")).sendKeys(enterText);
	}

	public void test_closeTheSearch() {
		driver.close();

	}

}
