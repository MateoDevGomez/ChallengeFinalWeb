package com.example.tasks;

import com.example.userinterfaces.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickOnElement implements Task {

    private final Target target;

    public ClickOnElement(Target target) {
        this.target = target;
    }

    public static ClickOnElement onTarget(Target target) {
        return instrumented(ClickOnElement.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(target)
        );
    }
}
