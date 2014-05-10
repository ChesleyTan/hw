import java.util.Scanner;
public class RPN {
    private MyStack stack = new MyStack();

    public void push(String s) {
        double d = Double.parseDouble(s);
        stack.push(d);
    }

    public void add() {
        double result = 0.0;
        if (!stack.isEmpty()) {
            result = stack.pop();
        }
        if (!stack.isEmpty()) {
            result += stack.pop();
        }
        stack.push(result);
    }

    public void subtract() {
        double result = 0.0;
        if (!stack.isEmpty()) {
            result = stack.pop();
        }
        if (!stack.isEmpty()) {
            result = stack.pop() - result;
        }
        stack.push(result);
    }

    public void multiply() {
        double result = 0.0;
        if (!stack.isEmpty()) {
            result = stack.pop();
        }
        if (!stack.isEmpty()) {
            result *= stack.pop();
        }
        stack.push(result);
    }

    public void divide() {
        double result = 0.0;
        if (!stack.isEmpty()) {
            result = stack.pop();
        }
        if (!stack.isEmpty()) {
            result = stack.pop() / result;
        }
        stack.push(result);
    }

    public double eval(String[] a) {
        for (String s : a) {
            if (s.equals("+")) {
                add();
            }
            else if (s.equals("-")) {
                subtract();
            }
            else if (s.equals("*")) {
                multiply();
            }
            else if (s.equals("/")) {
                divide();
            }
            else {
                push(s);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        RPN rpn = new RPN();
        Scanner scanStr = new Scanner(System.in);
        System.out.println("Please input a mathematical expression.");
        String[] expr = scanStr.nextLine().split(" ");
        System.out.println("Result: " + rpn.eval(expr));
    }

}
