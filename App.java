import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class MultipleWindows
{
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\anand\\OneDrive\\Desktop\\ST_MODEL_LAB\\src\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.navigate().to("https://demo.automationtesting.in/Windows.html");

        WebElement seperElement = webdriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a"));
        seperElement.click();

        String originalWindow = webdriver.getWindowHandle();

        WebElement nexElement = webdriver.findElement(By.xpath("//*[@id=\"Seperate\"]/button"));
        nexElement.click();

        Thread.sleep(3000);

        for (String windowHandle : webdriver.getWindowHandles())
        {
            if (!windowHandle.equals(originalWindow))
            {
                webdriver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(5000);
        webdriver.switchTo().window(originalWindow);
    }
}