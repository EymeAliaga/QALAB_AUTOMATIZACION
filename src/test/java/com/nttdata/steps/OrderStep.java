package com.nttdata.steps;

import com.nttdata.model.Order;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;


import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class OrderStep {
    private static String URL = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear order en PetStore")
    public void crear_order(int id,int petId,int quantity, String shipDate,String status,boolean complete){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": \""+id+"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \""+shipDate+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\": \""+complete+"\"\n" +
                "}")
                .log().all()
                .post(URL)
                .then()
                .log().all()
                ;

    }


    public void validarCodigoRespuesta(int statusCode) {
        Assert.assertEquals(200,statusCode);
    }

    public void Descripcion(){
        System.out.println("successful operation");
    }
    private static String URL2 = null;
    Response response1;


    public void laUrl(String url){
        URL2=url;
    };

    public void buscoUnaOrdenPorIdOrderId() {
        response1 =
                SerenityRest.given()
                        .contentType("application/jason")
                        .log()
                        .all()
                        .get(URL2+"/5")
                        .then()
                        .log()
                        .all()
                        .extract().response();

    }
    public void imprimoMiRespuesta() {
         List<Order> Orders =response1.jsonPath().getList(".", Order.class);
         System.out.println("Numero de consulta: "+Orders.size());
         for(Order order:Orders){
             System.out.println("id: " +order.getId() +
                                "petId: "+order.getPetId()+
                     "shipDate: " + order.getShipDate() +
                     "status: "+ order.getStatus() +
                     "complete: "+ order.isComplete()
             )
                   ;
         }

    }


}
