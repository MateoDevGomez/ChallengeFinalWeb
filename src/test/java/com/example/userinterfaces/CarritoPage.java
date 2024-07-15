package com.example.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoPage {
    public static final Target PRODS = Target.the("Productos").located(By.xpath("//*[@id='tbodyid']"));
    public static final Target PLACE_ORDER_BTN = Target.the("Boton Place Order").located(By.xpath("//button[@data-toggle='modal']"));

    public static final Target NAME_FIELD = Target.the("Input Nombre").located(By.id("name"));
    public static final Target COUNTRY_FIELD = Target.the("Input Pais").located(By.id("country"));
    public static final Target CITY_FIELD = Target.the("Input Ciudad").located(By.id("city"));
    public static final Target CARD_FIELD = Target.the("Input Tarjeta").located(By.id("card"));
    public static final Target MONTH_FIELD = Target.the("Input Mes").located(By.id("month"));
    public static final Target YEAR_FIELD = Target.the("Input Anio").located(By.id("year"));
    public static final Target SUBMIT_BUTTON = Target.the("Boton Submit").located(By.xpath("//button[@onclick='purchaseOrder()']"));
    public static final Target OK_BUTTON = Target.the("OK Submit").located(By.xpath("//button[@tabindex='1']"));

    public static final Target PURCHASE_TEXT = Target.the("Texto Confirmar Compra").located(By.xpath("/html/body/div[10]/h2"));
    public static final Target FORM_TEXT = Target.the("Texto Confirmar Compra").located(By.xpath("//*[@id='orderModalLabel']"));


}
