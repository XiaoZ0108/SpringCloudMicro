package com.example.Inventory_Service.Service;

import com.example.Inventory_Service.Repo.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepo inventoryRepo;

    public boolean isInStock(String skuCode,Integer quantity){
        return inventoryRepo.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
    }
}
