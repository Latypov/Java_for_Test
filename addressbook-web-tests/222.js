var webdriver = require('selenium-webdriver'),
    By = webdriver.By,
    until = webdriver.until;
var _ = require('underscore');
var VARS = {};

var globalTimeout = 60*1000;

var driver = new webdriver.Builder()
    .forBrowser('firefox')
    .build();

driver.controlFlow().on('uncaughtException', function(err) {
    console.log('There was an uncaught exception: ' + err);
});

driver.get("http://localhost/addressbook/"); 
driver.findElement(By.id("LoginForm")).click(); 
driver.findElement(By.name("user")).clear(); 
driver.findElement(By.name("user")).sendKeys("admin"); 
driver.findElement(By.name("pass")).clear(); 
driver.findElement(By.name("pass")).sendKeys("secret"); 
driver.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click(); 
driver.findElement(By.id("3")).isSelected().then(function(isSelected){ 
    if(isSelected){ 
        driver.findElement(By.id("3")).click(); 
    } 
}); 
driver.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click(); 
driver.findElement(By.linkText("Logout")).click(); 

driver.quit();
