package dockerValidationWINMC;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import org.junit.Assert;
import org.testng.annotations.Test;
public class startDocker {
	@Test
	public void startFile() throws IOException, InterruptedException {
		boolean flag=false;		
		Runtime runtime=Runtime.getRuntime();
		runtime.exec("cmd /c start dockerUp.bat");
		// This is used to execute any command at runtime.
		//Thread.sleep(40000);
		String file="output.txt";
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.SECOND, 45);
		long stopnow=cal.getTimeInMillis();
		Thread.sleep(6000);		
		while(System.currentTimeMillis()<stopnow)
		{
			if(flag)
			{
				break;
			}
			BufferedReader reader=new BufferedReader(new FileReader(file));
			// Here new FileReader(file) will consider the string "file" as file, name not only string
			// It will return the "output.txt" file name to BufferedReader	
			// We need to check all the possible combination of the Scenarios to explore all the combination of the 
			// Scenarios.
			String currentLine=reader.readLine();  //This will read the 1st line from the File
			while(currentLine!=null && !flag)
			{
				if(currentLine.contains("The node is registered to the hub and ready to use"))
				{
					System.out.println("Found the desired text");
					flag=true;
					break;
				}
				currentLine=reader.readLine();
		}
		reader.close();	
		}
		Assert.assertTrue(flag);
		runtime.exec("cmd /c start scale.bat");
		Thread.sleep(5000);
	}
}
