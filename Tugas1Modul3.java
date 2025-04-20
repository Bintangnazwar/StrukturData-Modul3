import java.util.*;

public class Tugas1Modul3 {

    // Menentukan prioritas operator
    private static int precedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }

    // Mengecek apakah string adalah operator
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // Mengonversi infix ke postfix
    public static String infixToPostfix(String infix) {
        Stack<String> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        String[] tokens = infix.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                postfix.append(token).append(" ");
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) stack.pop();
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    // Mengevaluasi postfix
    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();

        String[] tokens = postfix.split(" ");
        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                double result = switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> throw new IllegalArgumentException("Invalid operator: " + token);
                };
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ekspresi infix (gunakan spasi): ");
        String infix = scanner.nextLine();

        String postfix = infixToPostfix(infix);
        double result = evaluatePostfix(postfix);

        System.out.println("Postfix: " + postfix);
        System.out.println("Hasil Evaluasi: " + result);
    }
}