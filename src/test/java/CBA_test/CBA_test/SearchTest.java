package CBA_test.CBA_test;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SearchTest extends Base {
	public WebDriver driver;

	@Test
	public void Search_caribean() throws IOException, InterruptedException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		QueryPage BlackPearl = new QueryPage(driver);

		Assert.assertTrue(BlackPearl.test_VerifyInput());

		Assert.assertTrue(BlackPearl.test_VerifySearchButton());

		BlackPearl.test_clickonSearch();
		Assert.assertTrue(BlackPearl.test_VerifySearchResults("Provide some query"));

		BlackPearl.test_enterText("castle");
		BlackPearl.test_clickonSearch();
		Assert.assertTrue(BlackPearl.test_VerifySearchResults("No results"));

		BlackPearl.test_enterText("isla");
		BlackPearl.test_clickonSearch();
		Assert.assertTrue(BlackPearl.test_VerifySearchResultsCount());

		BlackPearl.test_enterText("port");
		BlackPearl.test_clickonSearch();
		Assert.assertTrue(BlackPearl.test_VerifySearchResults("Port Royal"));

		BlackPearl.test_closeTheSearch();

	}

}
