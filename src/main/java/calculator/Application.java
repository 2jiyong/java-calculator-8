package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        // Scanner sc = new Scanner(System.in);
        String input = Console.readLine();

        int[] numbersArray = splitByDelimiter(input);
        int result = sum(numbersArray);
        System.out.println("결과 : " + result);
    }

    private static int[] splitByDelimiter(String input) {
        String delimiter = "[,:]";
        if (input.startsWith("//")) {
            String[] parts = input.split("\\\\n", 2);

            if (parts.length < 2) {
                throw new IllegalArgumentException();
            }

            String header = parts[0];
            input = parts[1];
            String customDelimiter = getDelimiter(header);
            delimiter = Pattern.quote(customDelimiter);
        }

        String[] numbers = input.split(delimiter);
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            try {
                result[i] = Integer.parseInt(numbers[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
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

    private static String getDelimiter(String input) {
        return input.substring(2);
    }
}
