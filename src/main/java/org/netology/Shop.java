package org.netology;

import java.util.HashMap;
import java.util.Map;

//все возможности класса магазина распределены по небольшим интерфейсам (принцип сегрегации интерфейсов),
//реализация класса магазина зависит от интерфейсов (принцип инверсии зависимостей)
//также нет необходимости наследоваться и быть наследником (принцип Лисков)
//в дополнение, класс выполняет только те функции, для которых он предназначен (принцип единственной ответственности)
//все поля класса закрыты для модификации извне, но сам класс открыт для расширения (принцип открытости/закрытости)
public class Shop implements Basket, Display, Payment {
    final int ZERO = 0;

    private int wallet = ZERO;
    private Map<String, Integer> basket = new HashMap<>();
    private int count = ZERO;

    //положить в корзину продукт определенной стоимости
    @Override
    public void put(String product, int cost) {
        basket.put(product, cost);
        System.out.println("Вы положили " + product + " в корзину");
    }
    //убрать из корзины продукт
    @Override
    public void remove(String product) {
        if (!basket.containsKey(product)) System.out.println("Данный продукт отсутствует в корзине!");
        else {
            System.out.println("Вы убрали из корзины " + product);
            basket.remove(product);
        }
    }
    //показать список продуктов в корзине
    @Override
    public void productList() {
        if (basket.isEmpty()) System.out.println("У вас еще нет продуктов в корзине!");
        else System.out.println("В вашей корзине лежат товары: \n " + basket.keySet());
    }
    //показать стоимость всех продуктов в корзине
    @Override
    public void totalCost() {
        if (basket.isEmpty()) System.out.println("У вас еще нет продуктов в корзине!");
        else {
            for (int i : basket.values()) {
                count += i;
            }

            System.out.println("Стоимость всех товаров в корзине составляет: " + count + " руб");
            count = ZERO;
        }
    }
    //оплатить покупку
    @Override
    public void pay() {
        if (basket.isEmpty()) System.out.println("У вас еще нет продуктов в корзине!");
        else {
            for (int i : basket.values()) {
                count += i;
            }
            if (count > wallet) {
                System.out.println("На вашем счету недостаточно средств для совершения покупки! Нужно " + count + " руб");
            } else {
                System.out.println("Вы купили продукты на: " + count + " руб");
                wallet -= count;
                basket.clear();
            }
            count = ZERO;
            showBalance();
        }
    }
    //пополнить баланс кошелька
    @Override
    public void deposit(int money) {
        if (money > 0) {
            System.out.println("Вы пополнили кошелек на " + money + " руб");
            wallet += money;
            showBalance();
        } else System.out.println("Неправильное значение!");
    }
    //показать баланс кошелька
    @Override
    public void showBalance() {
        System.out.println("Ваш баланс составляет: " + wallet);
    }
}
