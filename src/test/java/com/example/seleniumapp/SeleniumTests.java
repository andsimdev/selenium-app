package com.example.seleniumapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTests {
    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        driver.get("https://iths.se");


    }

    @BeforeEach
    void navigate() {
        driver.get("https://iths.se");
    }

    @Test
    void checkTitle() {
        assertEquals("IT-Högskolan – Här startar din IT-karriär!", driver.getTitle(), "Titeln verkar inte stämma");
    }

    @Test
    void checkHeading() {
        String heading = driver.findElement(By.tagName("h1")).getText();

        assertEquals("Här startar din IT-karriär!", heading, "Huvudrubriken verkar inte stämma");
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }

}
