package calculator;

import java.util.Scanner;

public class Main {

    private static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение, соблюдая интервал между знаками!");
        String input = scn.nextLine();
        String result = calc(input);
        System.out.println("Результат: " + result);

    }

    private static String calc(String input) throws Exception {
        int firstNumber;
        int secondNumber;
        boolean isRoman = false;
        String[] array = input.split(" ");

        if (array.length != 3) {
            throw new Exception("Формат математической операции не удовлетворяет требование - два операнда и один оператор!");
        }

        String patternNumber = "^[0-9]*$";
        if (array[0].matches(patternNumber) && array[2].matches(patternNumber)) {
            firstNumber = Integer.parseInt(array[0]);
            secondNumber = Integer.parseInt(array[2]);
        } else {
            firstNumber = Roman.romToArabian(array[0]);
            secondNumber = Roman.romToArabian(array[2]);
            isRoman = true;
        }

        if (firstNumber < 1 || firstNumber > 10 || secondNumber < 1 || secondNumber > 10) {
            throw new Exception("Числа должны быть от 1 до 10!");
        }

        char operation = array[1].charAt(0);
        int result = Arabic.sumArabic(operation, firstNumber, secondNumber);
        if (isRoman) {
            return Roman.arabToRoman(result);
        } else {
            return String.valueOf(result);
        }
    }
}