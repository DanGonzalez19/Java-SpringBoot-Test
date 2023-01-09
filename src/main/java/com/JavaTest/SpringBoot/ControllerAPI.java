package com.JavaTest.SpringBoot;

import com.JavaTest.SpringBoot.Models.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ControllerAPI {

    public Arrays arrays = new Arrays();

    @GetMapping(value = "prueba")
    public String prueba(){
        return "prueba";
    }
    @GetMapping(value = "updateSupply")
    public Object updateSupply(String productId,String updateTimeStamp, double quantity){
        Supply request = new Supply(productId, DateConvert.StringToDate("yyyy-MM-dd'T'HH:mm:ss.SSS",updateTimeStamp),quantity);

        try {
            Supply supply = arrays.getSupplies().stream().filter(s -> s.getProductId().equals(request.getProductId())).toList().get(0);
            if (request.getUpdateTimeStamp().before(supply.getUpdateTimeStamp())){
                request.setStatus("Out Of Sync Update");
                return request;
            }else{
                request.setQuantity(request.getQuantity()+supply.getQuantity());
                request.setStatus("Updated");
                return request;
            }
        }catch (IndexOutOfBoundsException ex){
            return "ProductId Not Found";
        }
    }

    @GetMapping(value = "getProdAvailability")
    public Object getProdAvailability(String storeNo, String productId, double reqQty, Date reqDate){
        Q2Response response = new Q2Response(storeNo,productId,reqQty,reqDate);
        double sumCapacity = arrays.getCapacities().stream().filter(c-> (c.getDate().equals(response.getReqDate()) || c.getDate().before(response.getReqDate()))
                && c.getProdId().equals(response.getProductId()) && c.getStoreNo().equals(response.getStoreNo()) ).mapToDouble(c->c.getNoOfOrdersAccepted()).sum();

        double sumAvailability = arrays.getAvailabilities().stream().filter(a-> (a.getDate().equals(response.getReqDate()) || a.getDate().before(response.getReqDate()))
                && a.getProductId().equals(response.getProductId()) && a.getStoreNo().equals(response.getStoreNo()) ).mapToDouble(a->a.getAvailQty()).sum();

        if(sumAvailability==0){
            return "Response code 204 - no content to be returned";
        }if(sumCapacity==0){
            response.setStatus("No capacity");
            return response;
        }
        else{
            response.setStatus("Available");
            return response;
        }
    }

    @PostMapping(value = "getOrderStats")
    public Object getOrderStats(@RequestBody Q3Request request){
        List<Order> orders = new ArrayList<>();
        double [] products={arrays.getOrders().stream().filter(order -> order.getProductId().equals("Producto1")).mapToDouble(o ->o.getQuantity()).sum(),
                arrays.getOrders().stream().filter(order -> order.getProductId().equals("Producto2")).mapToDouble(o ->o.getQuantity()).sum(),
                arrays.getOrders().stream().filter(order -> order.getProductId().equals("Producto3")).mapToDouble(o ->o.getQuantity()).sum()};

        String productId="";
        if(request.getStatName().equals("MAX_SALE")){
            productId=getHigher(products);
            orders = arrays.getOrders().stream().filter(order -> order.getProductId().equals(getHigher(products))).toList();

        }else if(request.getStatName().equals("MAX_SALE")){
            productId=getHigher(products);
            orders = arrays.getOrders().stream().filter(order -> order.getProductId().equals(getLower(products))).toList();
        }

        return new Q3Response(productId,orders);
    }

    /*public double getQuantity(String prodId){
        return arrays.getOrders().stream().filter(order -> order.getProductId().equals(prodId)).mapToDouble(o ->o.getQuantity()).sum();
    }
    */


    public String getHigher(double [] products){
        double higher = products[0];
        int index = 0;
        for(int i = 0; i<products.length;i++){
            if(products[i]>higher){
                higher = products[i];
                index=i;
            }

        }
        return "Product"+(index+1);
    }

    public String getLower(double [] products){
        double lower = products[0];
        int index = 0;
        for(int i = 0; i<products.length;i++){
            if(products[i]<lower){
                lower = products[i];
                index=i;
            }

        }
        return "Product"+(index+1);
    }
}
