package com.example.stepdefinitions;

import com.example.questions.CartQuestion;
import com.example.questions.CompletePurchase;
import com.example.questions.FormQuestion;
import com.example.tasks.*;
import com.example.userinterfaces.StorePage;
import com.example.userinterfaces.CarritoPage;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class StoreStepdefs {

    //#######################################################################
    private Scenario scenario;

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) BrowseTheWeb.as(theActorInTheSpotlight()).getDriver()).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 1)

    public void setScenario (Scenario scenario){
        this.scenario = scenario;
    }

    //#######################################################################

    @Given("^el (.*) ingresa a la pagina web$")
    public void elClienteIngresaALaPaginaWeb(String actor) {
        theActorCalled(actor).attemptsTo(
                NavigateTo.MainPage()
        );
        screenShot();
    }

    @When("agrega el primer producto {string} al carrito")
    public void agregaElPrimerProductoAlCarrito(String arg0) {
        theActorInTheSpotlight().attemptsTo(
                AddToCart.withTarget(StorePage.SAMSUNG_REF),
                AcceptAlert.accept(),
                NavigateTo.MainPage()
        );
        screenShot();
    }

    @And("agrega el segundo producto {string} al carrito")
    public void agregarElSegundoProductoAlCarrito(String arg0) {
        theActorInTheSpotlight().attemptsTo(
                AddToCart.withTarget(StorePage.IPHONE_REF),
                AcceptAlert.accept(),
                NavigateTo.MainPage()
        );
        screenShot();
    }
    @And("se dirige a visualizar el carrito de compras")
    public void seDirigeAVisualizarElCarritoDeCompras() {
        theActorInTheSpotlight().attemptsTo(
                NavigateTo.thePage("cart.html")
        );
        screenShot();
    }


    @Then("comprueba que el producto {string} se haya agregado al carrito")
    public void comprueboQueElProductoPRODSeHayaAgregadoAlCarrito(String prod) {
        theActorInTheSpotlight().should(
                seeThat(CartQuestion.withName(prod), equalTo(true))
        );
        screenShot();
    }

    @When("ingresa al formulario")
    public void ingresaAlFormulario() {
        theActorInTheSpotlight().attemptsTo(
                ClickOnElement.onTarget(CarritoPage.PLACE_ORDER_BTN)
        );

        theActorInTheSpotlight().should(
                seeThat("El título del Form es visible", FormQuestion.titleForm(), equalTo(true)),
                seeThat("Texto de Formulario", FormQuestion.text(),equalTo("Place order") )
        );
        screenShot();
    }

    @And("ingresa al formulario el nombre {string}, pais {string}, ciudad {string}, tarjeta {string}, mes {string}, anio {string}")
    public void ingresaAlFormularioElNombrePaisCiudadTarjetaMesAnio(String name, String country, String city, String card, String month, String year) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FillOutForm.withDetails(name, country, city, card, month, year)
        );
        screenShot();
    }
    @Then("verifica el mensaje {string} que confirma la compra")
    public void verificaElMensajeQueConfirmaLaCompra(String message) {
        theActorInTheSpotlight().should(
                seeThat("Texto de Compra", CompletePurchase.text(), equalTo(message))
        );
        screenShot();
    }

    @And("finaliza la compra")
    public void finalizaLaCompra() {
        theActorInTheSpotlight().attemptsTo(
          ClickOnElement.onTarget(CarritoPage.OK_BUTTON)
        );
        screenShot();
    }


}
