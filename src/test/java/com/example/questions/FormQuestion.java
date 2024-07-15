package com.example.questions;

import com.example.userinterfaces.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.questions.Visibility;

public class FormQuestion {

    public static Question<String> text(){
        return actor -> TextContent.of(CarritoPage.FORM_TEXT).answeredBy(actor);
    }

    public static Question<Boolean> titleForm(){
        return actor -> Visibility.of(CarritoPage.FORM_TEXT).answeredBy(actor).booleanValue();
    }
}
