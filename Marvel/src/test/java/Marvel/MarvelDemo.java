package Marvel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MarvelDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver wd = new EdgeDriver();
		
		wd.get("https:/www.google.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) wd;
		
		By textbox = By.id("APjFqb");
		String search = "List of Marvel Cinematic Universe films";
		
		wd.findElement(textbox).sendKeys(search); // Entering text in search box
		
		Actions act = new Actions(wd);
		
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform(); // Keyboard action of Enter
		
		Thread.sleep(20000); // will be useful if "I'm not a Robot" captcha occurs
		
		By link = By.xpath("(//a[@class='zReHs'])[1]"); 
		
		By phase_one = By.xpath("//h4[@id='Phase_One']");
		By phase_two = By.xpath("//h4[@id='Phase_Two']");
		By phase_three = By.xpath("//h4[@id='Phase_Three']");
		
		List<String> phaseone = new ArrayList<String>(); // phase1_movies list
		List<String> phasetwo = new ArrayList<String>(); // phase2_movies list
		List<String> phasethree = new ArrayList<String>(); // phase3_movies list
		
		wd.findElement(link).click(); // Clicking on first link of search results
		
		String title = wd.getTitle(); // Title of website after clicking on the first link

		WebElement w = wd.findElement(phase_one);
		WebElement w1 = wd.findElement(phase_two);
		WebElement w2 = wd.findElement(phase_three);
		
		js.executeScript("arguments[0].scrollIntoView()", w);
		
		for(int i=2;i<=6;i++) {
			phaseone.add(wd.findElement(By.xpath("((//table[@style='width: 99%;'])[1]//tr["+i+"]//th//a)")).getText());
		}
		
		js.executeScript("arguments[0].scrollIntoView()", w1);
		
		for(int i=2;i<=6;i++) {
			phasetwo.add(wd.findElement(By.xpath("((//table[@style='width: 99%;'])[2]//tr["+i+"]//th//a)")).getText());
		}
		
		js.executeScript("arguments[0].scrollIntoView()", w2);
		
		for(int i=2;i<=6;i++) {
			phasethree.add(wd.findElement(By.xpath("((//table[@style='width: 99%;'])[3]//tr["+i+"]//th//a)")).getText());
		}
		
		System.out.println(title);
		System.out.println(phaseone.toString());
		System.out.println(phasetwo.toString());
		System.out.println(phasethree.toString());
		
		wd.quit();

	}

}
