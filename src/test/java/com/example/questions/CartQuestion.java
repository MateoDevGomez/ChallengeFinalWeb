package com.example.questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;

import static com.example.userinterfaces.CarritoPage.PRODS;


public class CartQuestion implements Question<Boolean> {
    private final String nombreProducto;

    public CartQuestion(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Obtener la lista de productos (filas <tr>) dentro del tbody
        List<WebElement> productos = PRODS.resolveFor(actor).findElements(By.xpath(".//tr"));

        // Comprobar si algún producto tiene el nombre especificado
        for (WebElement producto : productos) {
            String nombre = producto.findElement(By.xpath(".//td[2]")).getText();
            if (nombre.equals(nombreProducto)) {
                return true;
            }
        }
        return false;
    }

    public static CartQuestion withName(String nombreProducto) {
        return new CartQuestion(nombreProducto);
    }
}
