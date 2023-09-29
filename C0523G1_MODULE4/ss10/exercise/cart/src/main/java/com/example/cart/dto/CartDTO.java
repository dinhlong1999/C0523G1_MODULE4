package com.example.cart.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private Map<ProductDTO,Integer> productDTOs = new HashMap<>();

    public CartDTO() {
    }

    public Map<ProductDTO, Integer> getProductDTOs() {
        return productDTOs;
    }

    public void setProductDTOs(Map<ProductDTO, Integer> productDTOs) {
        this.productDTOs = productDTOs;
    }

    public void addProduct(ProductDTO productDTO){
        if (productDTOs.containsKey(productDTO)){
            int valueNew = productDTOs.get(productDTO);
            productDTOs.replace(productDTO,valueNew +1);
        }else{
            productDTOs.put(productDTO,1);
        }
    }
    public Integer countProductQuantity(){
        int productQuantity = 0;
        for (Map.Entry<ProductDTO,Integer> entry:productDTOs.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public int countItemQuantity(){
        return productDTOs.size();
    }
    public double countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDTO,Integer> entry:productDTOs.entrySet()) {
            payment +=entry.getKey().getSalePrice()  * entry.getValue();
        }
        return payment;
    }
    public void deleteProduct(ProductDTO productDTO){
        productDTOs.remove(productDTO);

    }
}
