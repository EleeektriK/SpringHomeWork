package ru.geekbrains.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.Class.Product;
import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductRepository {

    public Cart cart;
    public CartFactory cartFactory;
    public Scanner scanner = new Scanner(System.in);
    public int number;

    @Autowired
    public void setCartFactory(CartFactory cartFactory) {
        this.cartFactory = cartFactory;
    }

    public static List<Product> productList = new ArrayList<>();

    public void productAdd(){
        productList.add(new Product(1, "milk", 100));
        productList.add(new Product(2, "chocolate", 200));
        productList.add(new Product(3, "water", 300));
        productList.add(new Product(4, "apple", 400));
        productList.add(new Product(5, "orange", 500));
    }

    @PostConstruct
    public void startProgr(){
        productAdd();
        switchMenu();
    }

    public void switchMenu(){
        System.out.println("Введите номер меню");
        System.out.println("1. Список продуктов");
        System.out.println("2. Создать корзину");
        System.out.println("3. Выход из программы");
        number = scanner.nextInt();

        while (number !=0) {
            switch (number) {
                case 1:
                    System.out.println("1. Показать весь список продуктов");
                    System.out.println("2. Выбрать продукт по ID от 0-9");
                    System.out.println("3. Вернуться в меню");
                    int numberProd = scanner.nextInt();
                    switch (numberProd) {
                        case 1:
                            seeListAll();
                            break;
                        case 2:
                            System.out.println("Введите номер ID");
                            int numberId = scanner.nextInt();
                            seeListForId(numberId);
                            break;
                        case 3:
                            switchMenu();
                        default:
                            System.out.println("Введите ещё раз номер меню из списка");
                    }
                    break;
                case 2:

                    System.out.println("1. Добавить продукты в корзину");
                    System.out.println("2. Удалить продукты из корзины");
                    System.out.println("3. Вернуться в меню");
                    System.out.println("4. Создать корзину");

                    int cartProd = scanner.nextInt();
                    switch (cartProd){
                        case 1:
                            if (cart == null){
                                cart = cartFactory.getCart();
                            }
                            System.out.println("Выберете товар, который хотите добавить в корзину");
                            seeListAll();
                            int prod = scanner.nextInt();
                            cart.addCart(prod);
                            System.out.println("Товар добавлен");
                            break;
                        case 2:
                            if (cart.cartList.size() != 0) {
                                System.out.println("Выберете товар, который хотите удалить из корзины");
                                cart.seeCart();
                                int cartDel = scanner.nextInt();
                                cart.deleteCart(cartDel);
                                System.out.println("Товар удален");
                            }
                            break;
                        case 3:
                            switchMenu();
                            break;
                        case 4:
                            cart = cartFactory.getCart();
                            break;
                        default:
                            System.out.println("Выберете меню из списка");
                    }
                    break;
                case 3:
                    number = 0;
                    break;
                default:
                    System.out.println("Введите ещё раз номер меню из списка");
            }
        }
    }

    public void seeListAll(){
        for (Product product: productList){
            System.out.println(product.getId() + " " + product.getTitle() + " " + product.getCost());
        }
    }

    public void seeListForId(int i){
        System.out.println("Id товара: " + productList.get(i).getId() + " Наименование товара: " + productList.get(i).getTitle() + " Стоимость товара: " + productList.get(i).getCost() );
    }


}