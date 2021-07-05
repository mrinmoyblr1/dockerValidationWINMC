package dockerValidationWINMC;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class firefoxStandAloneTest {
	public static void main(String[] args) throws MalformedURLException {		
		DesiredCapabilities cap=DesiredCapabilities.firefox();		
		URL u=new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver=new RemoteWebDriver(u, cap);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("Mrinmoy Biswas");
		
		
	}
}
