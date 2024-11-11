/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите выражение (например, 2 * 6.5): ");
        String input = scanner.nextLine();
        
        try {
            double result = calculate(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static double calculate(String input) throws Exception {
        String[] tokens = input.split(" ");
        
        if (tokens.length != 3) {
            throw new Exception("Неверный формат ввода. Ожидается 'число оператор число'.");
        }

        double number1 = Double.parseDouble(tokens[0]);
        String operator = tokens[1];
        double number2 = Double.parseDouble(tokens[2]);

        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    throw new Exception("Деление на ноль невозможно.");
                }
                return number1 / number2;
            default:
                throw new Exception("Неизвестный оператор: " + operator);
        }
    }
}