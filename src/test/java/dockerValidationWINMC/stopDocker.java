package dockerValidationWINMC;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import org.junit.Assert;
import org.testng.annotations.Test;
public class stopDocker {
	@Test
	public void stopFile() throws IOException, InterruptedException {
		boolean flag=false;		
		Runtime runtime=Runtime.getRuntime();
		runtime.exec("cmd /c start dockerDown.bat");
		// This is used to execute any command at runtime.
		//cThread.sleep(40000);
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
			String currentLine=reader.readLine();  //This will read the 1st line from the File
			while(currentLine!=null && !flag)
			{
				if(currentLine.contains("selenium-hub exited"))
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
		
	}
}
