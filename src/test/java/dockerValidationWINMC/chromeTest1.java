package dockerValidationWINMC;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class chromeTest1 {
	@BeforeTest
	public void startDockerScale() throws IOException, InterruptedException
	{
		File f=new File("output.txt");
		if(f.delete())
		{
			System.out.println("File deleted successfully");
		}
		startDocker s=new startDocker();
		s.startFile();
	}
	@AfterTest
	public void stopDockerDeleteFile() throws IOException, InterruptedException {
		stopDocker stop=new stopDocker();
		stop.stopFile();
	}
	@Test
	public void Test1() throws MalformedURLException
	{
		DesiredCapabilities cap=DesiredCapabilities.chrome();		
		URL u=new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver=new RemoteWebDriver(u, cap);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());	
	}
}
