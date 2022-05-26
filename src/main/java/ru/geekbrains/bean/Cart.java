package ru.geekbrains.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.Class.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {

    public List<Product> cartList = new ArrayList<>();

    public  void deleteCart(int i) {
        Iterator<Product> cartIterator = cartList.iterator();
        while (cartIterator.hasNext()){
            Product cart = cartIterator.next();
            if (cart.getId() == i){
                cartIterator.remove();
            }
            System.out.println(cart.getId() +" " +  cart.getCost()+ " " + cart.getTitle());
        }
    }
    public void seeCart(){
        for (Product cart: cartList){
            System.out.println(cart.getId() +" " +  cart.getCost()+ " " + cart.getTitle());
        }
    }
    public void addCart(int i){


        cartList.add(ProductRepository.productList.get(i-1));
        for (Product cart: cartList){
            System.out.println(cart.getId() +" " +  cart.getCost()+ " " + cart.getTitle());
        }
    }


}
