package ru.geekbrains.bean;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class CartFactory {
    @Lookup
    public Cart getCart(){
        return null;
    }
}
