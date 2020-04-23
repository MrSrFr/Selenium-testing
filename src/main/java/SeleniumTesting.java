import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class SeleniumTesting {
    public static void main(String[] args) {
        Random random = new Random();

        //testing in chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lee Fesler\\Documents\\selenium-prerequisite\\executables\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        //full screen window and go to site
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/insurance/v1/index.php");

        //find register button and click
        WebElement registerButton = driver.findElement(By.xpath("//html//body//div[3]//a"));
        registerButton.click();

        handleTitleDropDown(driver, random);

        WebElement firstName = driver.findElementById("user_firstname");
        WebElement surName = driver.findElementById("user_surname");
        WebElement phoneNbr = driver.findElementById("user_phone");
        //^gather basic elements information

        firstName.sendKeys("Lee");
        surName.sendKeys("Fesler");
        phoneNbr.sendKeys("660-332-6734");
        //^send information

        handleDateOfBirthDropDowns(driver, random);

        WebElement radioButton = driver.findElementById("licencetype_t");
        Select radioOptions = new Select(radioButton);
        List<WebElement> allRadioOptions = radioOptions.getOptions(); //put all options of dropdown into list
        WebElement randomRadioSelection = allRadioOptions.get(random.nextInt(allRadioOptions.size()));
        radioOptions.selectByVisibleText(randomRadioSelection.getText()); //select random item from list


        Screenshot screenshot = new AShot().takeScreenshot(driver); //take screenshot of page
        final BufferedImage image = screenshot.getImage(); //buffer the image to make sure completed

        try {
            ImageIO.write(image, "jpg", new File(".\\screenshot\\fullimage.jpg")); //write image to path
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleTitleDropDown(ChromeDriver driver, Random random) {
        //find title element and input
        WebElement titleElement = driver.findElement(By.xpath("//html//body//div[3]//form//div[2]//select"));
        Select titleDropDown = new Select(titleElement);
        List<WebElement> allTitleOptions = titleDropDown.getOptions(); //put all options of dropdown into list

        WebElement randomTitleSelection = allTitleOptions.get(random.nextInt(allTitleOptions.size()));
        //^picks random option out of list for testing purposes

        titleDropDown.selectByVisibleText(randomTitleSelection.getText()); //select random item from list
        for (WebElement allTitleOption : allTitleOptions) {
            System.out.println(allTitleOption.getText()); //display all list option in list for debug
        }
    }

    private static void handleDateOfBirthDropDowns(ChromeDriver driver, Random random) {
        //find year element and input
        WebElement yearElement = driver.findElement(By.id("user_dateofbirth_1i"));
        Select yearDropDown = new Select(yearElement);
        List<WebElement> allYearOptions = yearDropDown.getOptions(); //put all options of dropdown into list

        WebElement randomYearSelection = allYearOptions.get(random.nextInt(allYearOptions.size()));
        //^picks random option out of list for testing purposes

        yearDropDown.selectByVisibleText(randomYearSelection.getText()); //select random item from list
        for (WebElement allYearOption : allYearOptions) {
            System.out.println(allYearOption.getText()); //display all list option in list for debug
        }

        //find month element and input
        WebElement monthElement = driver.findElement(By.id("user_dateofbirth_2i"));
        Select monthDropDown = new Select(monthElement);
        List<WebElement> allMonthOptions = monthDropDown.getOptions(); //put all options of dropdown into list

        WebElement randomMonthSelection = allMonthOptions.get(random.nextInt(allMonthOptions.size()));
        //^picks random option out of list for testing purposes

        monthDropDown.selectByVisibleText(randomMonthSelection.getText()); //select random item from list
        for (WebElement allMonthSelection : allMonthOptions) {
            System.out.println(allMonthSelection.getText()); //display all list option in list for debug
        }

        //find day element and input
        WebElement dayElement = driver.findElement(By.id("user_dateofbirth_3i"));
        Select dayDropDown = new Select(dayElement);
        List<WebElement> allDayOptions = dayDropDown.getOptions(); //put all options of dropdown into list

        WebElement randomDaySelection = allDayOptions.get(random.nextInt(allDayOptions.size()));
        //^picks random option out of list for testing purposes

        dayDropDown.selectByVisibleText(randomDaySelection.getText()); //select random item from list
        for (WebElement allDaySelection : allDayOptions) {
            System.out.println(allDaySelection.getText()); //display all list option in list for debug
        }
    }

}
