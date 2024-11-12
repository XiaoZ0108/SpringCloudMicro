package com.example.Order.Service;

import com.example.Order.Model.Order;
import com.example.Order.Repo.OrderRepo;
import com.example.Order.client.InventoryClient;
import com.example.Order.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Order_service {
    private final OrderRepo orderRepo;
    private final InventoryClient inventoryClient;


    public void placeOrder(OrderRequest orderRequest){
        //map to order object
        boolean isInStock=inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if(isInStock){
            Order order=new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());

            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            System.out.println(orderRequest.skuCode());
            System.out.println(order);
            //save to repo
            orderRepo.save(order);
        }else{
            throw new RuntimeException("Product with skuCode"+orderRequest.skuCode()+"out of stock");
        }



    }
}
