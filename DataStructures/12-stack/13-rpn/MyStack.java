public class MyStack {
    private int top;
    private int start_length = 10;
    private int size;
    private double[] stack = new double[start_length];
    
    public MyStack() {
        top = stack.length - 1;
    }

    public void push(double s) {
        if (stack[top] == 0) {
            stack[top] = s;
            size++;
        }
        else {
            if (top == 0) {
                expand();
            }
            stack[--top] = s;
            size++;
        }
    }

    public double pop() {
        double tmp = stack[top];
        stack[top] = 0;
        if (top != stack.length - 1) {
            top++;
        }
        size--;
        return tmp;
    }

    public double peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String s = "";
        for (int i = top;i < stack.length;i++) {
            s += Double.toString(stack[i]) + ", ";
        }
        return s;
    }

    public int size() {
        return size;
    }

    private void expand() {
        double[] tmp = new double[stack.length * 2];
        System.arraycopy(stack, top, tmp, top = tmp.length - size, size);
        stack = tmp;
    }
}
