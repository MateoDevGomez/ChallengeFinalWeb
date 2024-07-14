package com.example.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class StorePage {
    public static final Target SAMSUNG_REF = Target.the("Samsung Galaxy s6 Ref").located(By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a"));
    public static final Target IPHONE_REF = Target.the("Iphone 6 32gb Ref").located(By.xpath("/html/body/div[5]/div/div[2]/div/div[5]/div/div/h4/a"));
    public static final Target ADD_BTN = Target.the("Add to cart").located(By.xpath("//a[contains(@class, 'btn')]"));
}
