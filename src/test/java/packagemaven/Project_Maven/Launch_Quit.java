package packagemaven.Project_Maven;

import java.time.Duration;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Launch_Quit extends Listeners_Logic {

	@Parameters("browser")
	@BeforeMethod
	public void launch(String nameofbrowser) {

		if (nameofbrowser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (nameofbrowser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}

		driver.get("https://www.amazon.in"); // Open Amazon website
		driver.manage().window().maximize(); // Maximize the browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Set implicit wait
	}

	@AfterMethod
	public void quit() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
