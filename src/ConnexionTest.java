import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;


public class ConnexionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Définition des propriétés système du pilote chrome et spécification de chemin d'accès
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe"); 
		
		//Création d'un objet pour instancier le pilote du navigateur
		WebDriver driver= new ChromeDriver();
		
		String baseUrl = "https://www.legalife.fr/";
	    String expectedTitle;
	    String expectedUrl;
	    
	    //Etape 1: Navigation vers la Homepage 
		driver.get(baseUrl); 
		expectedTitle = "LegaLife | Modèles de documents juridiques et avocats en ligne";
		Assert.assertEquals(expectedTitle, driver.getTitle()); 
		System.out.println("Navigation to Home OK");
		
		//Etape 2: Navigation vers la page de connexion 
		driver.findElement(By.linkText("Login")).click(); 
		expectedUrl="https://www.legalife.fr/inscription/";
		Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
		WebElement LoginField = driver.findElement(By.xpath("//*[@id=\'login-popup-login\']/form/input[1]"));
		Assert.assertEquals(true, LoginField.isDisplayed());
		WebElement PassworField =driver.findElement(By.xpath("//*[@id=\'login-popup-login\']/form/input[1]"));
		Assert.assertEquals(true, PassworField.isDisplayed());
		WebElement ConnctionButton=driver.findElement(By.xpath("//*[@id=\"login-popup-login\"]/form/button"));
		Assert.assertEquals(true, ConnctionButton.isDisplayed());
		System.out.println("Navigation to Connexion Page OK");
		
		//Etape 3 : Authentification
		driver.findElement(By.xpath("//*[@id=\'login-popup-login\']/form/input[1]")).sendKeys("ben.meddeb.montassar@gmail.com");
		driver.findElement(By.xpath("//*[@id=\'login-popup-login\']/form/input[2]")).sendKeys("dgbtumnq");
		driver.findElement(By.xpath("//*[@id=\"login-popup-login\"]/form/button")).click();
		WebElement element = (new WebDriverWait(driver, 10)) .until(ExpectedConditions.elementToBeClickable(By.linkText("Déconnexion"))); 
		expectedUrl="https://www.legalife.fr/documents/";
		Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
		WebElement DisconnectionLink= driver.findElement(By.linkText("Déconnexion"));
		Assert.assertEquals(true, DisconnectionLink.isDisplayed());
		System.out.println("Log in OK");
		
		//Etape 4 : Déconnexion
		driver.findElement(By.linkText("Déconnexion")).click();
		Assert.assertEquals(expectedTitle, driver.getTitle());
		System.out.println("Logout OK");
		
		//Fermer le navigateur
		driver.close();	
	}
}