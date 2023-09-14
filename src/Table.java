
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver= new ChromeDriver();

driver.navigate().to("http://the-internet.herokuapp.com/challenging_dom");
driver.manage().window().maximize();

int ColCount = driver.findElements(By.xpath("//table/tbody/tr[1]/td")).size();
int RowCount = driver.findElements(By.xpath("//table/tbody/tr")).size();

for (int i=1; i<=ColCount; i++){
	String HeadxPath = "//table/thead/tr/th["+i+"]";
	String HeadData = driver.findElement(By.xpath(HeadxPath)).getText();
	System.out.print(HeadData +"       ");
}

System.out.println();

for (int i=1; i<=RowCount; i++){
	for(int j=1; j<=ColCount; j++){
		String tablexPath = "//table/tbody/tr["+i+"]/td["+j+"]";
		String TableData = driver.findElement(By.xpath(tablexPath)).getText();
		System.out.print(TableData +"  ");  	
	}
	System.out.println(""); 
	
}
//driver.quit();
	}
	

}
