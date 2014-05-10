public class MyStack {
    private int top;
    private int start_length = 10;
    private int size;
    private String[] stack = new String[start_length];
    
    public MyStack() {
        top = stack.length - 1;
    }

    public void push(String s) {
        if (stack[top] == null) {
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

    public String pop() {
        String tmp = stack[top];
        stack[top] = null;
        if (top != stack.length - 1) {
            top++;
        }
        size--;
        return tmp;
    }

    public String peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String s = "";
        for (int i = top;i < stack.length;i++) {
            s += stack[i] + ", ";
        }
        return s;
    }

    public int size() {
        return size;
    }

    private void expand() {
        String[] tmp = new String[stack.length * 2];
        System.arraycopy(stack, top, tmp, top = tmp.length - size, size);
        stack = tmp;
    }
}
