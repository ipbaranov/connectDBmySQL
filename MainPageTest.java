package com.example.scrapeTable;

import com.mysql.cj.x.protobuf.MysqlxResultset;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    public ArrayList<String> Cools;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://checkme.kavichki.com/");

        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() throws IOException {
        WebElement simpleTable = driver.findElement(By.xpath("//*[@id=\"tbl\"]"));


        // Get all rows

        List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
        // Print data from each row

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));

            for (WebElement col : cols) {
                System.out.println(col.getText() + "\t" + "main");



               /* for (int j = 0; j < rows.size(); j++){
                    System.out.println(row.getText() + "\t");}*/
            }
            }

        }


    }
