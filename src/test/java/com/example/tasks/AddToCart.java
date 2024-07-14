package com.example.tasks;
import com.example.userinterfaces.StorePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToCart implements Task{

    private final Target productTarget;

    public AddToCart(Target productTarget) {
        this.productTarget = productTarget;
    }

    public static Performable withTarget(Target productTarget) {
        return instrumented(AddToCart.class, productTarget);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(productTarget, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(productTarget),
                Click.on(StorePage.ADD_BTN)
        );



    }
}
