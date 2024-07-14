package com.example.tasks;
import com.example.userinterfaces.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillOutForm implements Task {

    private final String name;
    private final String country;
    private final String city;
    private final String card;
    private final String month;
    private final String year;

    public FillOutForm(String name, String country, String city, String card, String month, String year) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.card = card;
        this.month = month;
        this.year = year;
    }

    public static FillOutForm withDetails(String name, String country, String city, String card, String month, String year) {
        return instrumented(FillOutForm.class, name, country, city, card, month, year);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CarritoPage.NAME_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(name).into(CarritoPage.NAME_FIELD),
                Enter.theValue(country).into(CarritoPage.COUNTRY_FIELD),
                Enter.theValue(city).into(CarritoPage.CITY_FIELD),
                Enter.theValue(card).into(CarritoPage.CARD_FIELD),
                Enter.theValue(month).into(CarritoPage.MONTH_FIELD),
                Enter.theValue(year).into(CarritoPage.YEAR_FIELD),
                Click.on(CarritoPage.SUBMIT_BUTTON)
        );
    }
}
