package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int[] numbers = splitByDelimiter(input);
        int result = sum(numbers);
        System.out.println("결과 : " + result);
    }

    private static int[] splitByDelimiter(String input) {
        String[] numbers = input.split("[,:]");
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
