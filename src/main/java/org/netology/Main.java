package org.netology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shop customer = new Shop();
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Выберите действие: \n" +
                    "1. Добавить в продукт в корзину\n" +
                    "2. Убрать продукт из корзины\n" +
                    "3. Пополнить баланс кошелька\n" +
                    "4. Проверить баланс кошелька\n" +
                    "5. Посмотреть список продуктов в корзине\n" +
                    "6. Узнать итоговую стоимость товаров в корзине\n" +
                    "7. Оплатить покупки\n" +
                    "8. Выход");
            input = scanner.nextInt();
            if (input == 8) break;
            switch (input) {
                case (1):
                    System.out.println("Введите название продукта и цену через пробел");
                    customer.put(scanner.next(), scanner.nextInt());
                    break;
                case (2):
                    System.out.println("Введите название продукта, который хотите убрать");
                    customer.remove(scanner.next());
                    break;
                case (3):
                    System.out.println("Введите сумму, которую хотите ввести");
                    customer.deposit(scanner.nextInt());
                    break;
                case (4):
                    customer.showBalance();
                    break;
                case (5):
                    customer.productList();
                    break;
                case (6):
                    customer.totalCost();
                    break;
                case (7):
                    customer.pay();
                    break;
            }
        }

    }
}