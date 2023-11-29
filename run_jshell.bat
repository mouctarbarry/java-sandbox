@echo off

jshell --class-path  @(Get-Content C:\Users\bmouc\IdeaProjects\java-sandbox\lib\dependencies.txt)

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

WebDriver driver = new ChromeDriver();

driver.get("https://www.example.com");

WebElement searchBox = driver.findElement(By.name("q"));
searchBox.sendKeys("Selenium example");
searchBox.submit()

exit
