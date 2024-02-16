package calculator;

public class Arabic {
    public static int sumArabic(char operation, int firstNumber, int secondNumber) throws Exception {
        switch (operation) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if (firstNumber == 0 || secondNumber == 0) {
                    throw new Exception("Деление на ноль запрещено!");
                }
                return firstNumber / secondNumber;
            default:
                throw new Exception("Неизвестная операция!");
        }
    }

}
