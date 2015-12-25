
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ProjectOne {

	public static void main(String[] args) throws IOException  {
		
		
		
		WebDriver driver = new FirefoxDriver ();
		
		driver.get("http://waltdisneystudios.com/");
		
		
			
		WebElement type = null;
		
		testingHomePage (type, driver);
       
		// refresh browser
		driver.navigate().refresh();
			
		 
		// testing link at random
		testingLinks (type, driver);
		  
		
		//testing search button
		testingSearch (type, driver);
		
		//going back to the home page
		type =driver.findElement(By.linkText("The Walt Disney Studios"));
		type.click();
			
		//driver.close();
			
	}
	
	public static void testingHomePage (WebElement a, WebDriver c){
			
			a =  c.findElement(By.className("hometxt"));
			
			int test = 1;
			printingResult (test, a);
					
		}
		
	public static void testingLinks (WebElement a, WebDriver c){
		
		 a =c.findElement(By.linkText("Marvel"));
		 a.click();
		 
		 a =c.findElement(By.linkText("Touchstone"));
		 a.click();
		
		 a =c.findElement(By.linkText("Disney Music Group"));
		 a.click();
		 
		 a =c.findElement(By.linkText("Contact"));
		 a.click();
		 
		 int test =2;
			printingResult (test, a);
		
	}
		
		
	public static void testingSearch (WebElement a, WebDriver c){
		
		a = c.findElement(By.id("search-query")); 
		a.sendKeys("disney on ice");
		c.manage().timeouts().implicitlyWait(30,   TimeUnit.SECONDS); 
		a.clear();
		a.sendKeys("disney on game");
		a.submit();
		a = c.findElement(By.id("search-query"));
		c.manage().timeouts().implicitlyWait(30,   TimeUnit.SECONDS); 
		a.clear();
		a.sendKeys("disney on ice");
		c.manage().timeouts().implicitlyWait(30,   TimeUnit.SECONDS); 
		a.submit();
		
		int test =3;
		printingResult (test, a);
		
	}
		
	
	public static void printingResult (int b, WebElement a){
		
		if (b==1)
		{
			if (a.isDisplayed()==true)
			{
				System.out.println("First test is passed, if the required text "
						+ "is displayed at home page. ");
			    System.out.println (a.getText());
			}
			else
				System.out.println("First test, as the required text, "
						+ "is not at home page,  is failed");	
			
		}
		
		if (b==2)
		{
			System.out.println("Second test for checking some "
			 		+ "links is passed.");
		}
		if (b==3)
		{
			System.out.println("Third test for search button "
					+ "is passed.");
					
		}
		
	}

	

}
