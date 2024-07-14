package com.example.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertText implements Question<String> {

    private final WebDriver driver;

    public AlertText(WebDriver driver) {
        this.driver = driver;
    }

    public static AlertText text() {
        return new AlertText(Serenity.getWebdriverManager().getCurrentDriver());
    }

    @Override
    public String answeredBy(Actor actor) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}