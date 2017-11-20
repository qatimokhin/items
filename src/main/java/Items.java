import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Items {
    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "//Users/igortimokhin/Documents/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.get("file:///Users/igortimokhin/Documents/MyProjects/items/FoodItems.html");

//        a)	Display the third and fifth item from the above list. Your output should be:
//        Applesauce, unsweetened
//        Juice, Cranberry-apple drink


        String item5 = driver.findElement(By.cssSelector("span.title:nth-of-type(5)")).getText();
        String item9 = driver.findElement(By.cssSelector("span.title:nth-of-type(9)")).getText();


        System.out.println(item5 + "\n" + item9 + "\n");



//        b)	Fetch each food name and its servings and store them in a Map.
//          Iterate through all the entries in the Map and print them.

        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < driver.findElements(By.cssSelector("span.title")).size(); i++) {
            String titles = driver.findElements(By.cssSelector("span.title")).get(i).getText();
            String descs = driver.findElements(By.cssSelector("span.description")).get(i).getText();
            map.put(titles, descs);
        }

        System.out.println(map);

        driver.quit();

    }


}
