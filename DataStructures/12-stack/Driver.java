public class Driver {
    public static void main(String[] argS) {
        MyStack stack = new MyStack();        
        stack.push("one");
        stack.push("one");
        stack.push("one");
        stack.push("one");
        stack.push("one");
        stack.push("one");
        stack.push("one");
        stack.push("one");
        stack.push("one");
        stack.push("one");
        stack.push("two");
        stack.push("two");
        stack.push("two");
        stack.push("two");
        stack.push("two");
        stack.push("two");
        stack.push("two");
        stack.push("two");
        stack.push("two");
        stack.push("two");
        stack.push("three");
        System.out.println(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        stack.push("hello");
        System.out.println(stack.peek());
        stack.push("world");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
