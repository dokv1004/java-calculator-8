package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static void validateInput(String input) {
        // 커스텀 구분자로 시작하는 경우
        if (input.startsWith("//")) {
            if (!input.contains("\\n")) {
                throw new IllegalArgumentException("");
            }
            if (input.endsWith("\\n")) {
                throw new IllegalArgumentException();
            }
        }
        else if (!input.matches("^[0-9,:]+$")) {
            throw new IllegalArgumentException();
        }
    }

    private static int add(String input) {
        String delimiter = "[,:]";
        String numbers = input;

        if (input.isEmpty() || input.equals("0")) {
            return 0;
        }

        validateInput(input);

        if (input.startsWith("//")) {
            delimiter = input.substring(2, 3);
            numbers = input.substring(5);
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            sum += number;
        }
        return sum;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int sum = add(input);
        System.out.println("결과 : " + sum);
    }
}
