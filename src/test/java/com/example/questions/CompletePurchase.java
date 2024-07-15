package com.example.questions;

import com.example.userinterfaces.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class CompletePurchase  {

    public static Question<String> text(){
        return actor -> TextContent.of(CarritoPage.PURCHASE_TEXT).answeredBy(actor);
    }
}
