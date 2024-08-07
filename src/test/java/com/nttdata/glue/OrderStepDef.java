package com.nttdata.glue;

import com.nttdata.steps.OrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrderStepDef {
    @Steps
    OrderStep order;


    @When("creo una order con id ,petId, quantity,shipDate,status,complete")
    public void creoUnaOrderConIdIdPetIdPetIdQuantityQuantityShipDateShipDateStatusStatusCompleteComplete(
            int arg0, int arg1, int arg2,String arg3, String arg4,boolean arg5

    ) {
       order.crear_order(arg0,arg1,arg2,arg3,arg4,arg5);

    }


    @Then("validar el codigo de respuesta")
    public void codigoDeRespuesta(int statusCode) {
        order.validarCodigoRespuesta(statusCode);
    }

    @And("mostrar descripcion")
    public void descripcion() {
        order.Descripcion();
    }

    @Given("la url {string}")
    public void laUrl(String url) {
       order.laUrl(url);
    }



    @Then("imprimo mi respuesta")
    public void imprimoMiRespuesta() {
       order.imprimoMiRespuesta();
    }

    @And("valido codigo de respuesta")
    public void validoCodidoDeRespuesta(int statusCode) {
        order.validarCodigoRespuesta(statusCode);
    }




    @When("busco una orden por Id")
    public void buscoUnaOrdenPorIdOrderId() {
            order.buscoUnaOrdenPorIdOrderId();

    }



}
