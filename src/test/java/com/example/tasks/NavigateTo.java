package com.example.tasks;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateTo implements Task {
    EnvironmentVariables environmentVariables;

    private final String url;

    public NavigateTo(String url) {
        this.url = url;
    }

    public NavigateTo() {
        this.url="";
    }


    @Override
    @Step("{0} Inicia la página #url")
    public <T extends Actor> void performAs(T actor) {
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("webdriver.base.url");
        String fullUrl = baseUrl + "/" + url;
        actor.attemptsTo(
                Open.url(fullUrl)
        );
    }

    public static NavigateTo MainPage() {
        return instrumented(NavigateTo.class);
    }

    public static NavigateTo thePage(String url) {
        return instrumented(NavigateTo.class, url);
    }




}
