import java.util.Stack;

class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    // Push operation
    void push(int value) {
        mainStack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }
    // Pop operation
    void pop() {
        if (!mainStack.isEmpty()) {
            if (mainStack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            mainStack.pop();
        }
    }
    // Get the minimum element in the stack
    int min() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else {
            System.out.println("Stack is empty.");
            return -1; 
        }
    }
    static void prnt(MinStack stack) {
        System.out.println("Current Min: " + stack.min());
    }
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        prnt(stack);
        stack.push(31);
        stack.push(19);
        prnt(stack);
        stack.push(121);
        stack.push(16);
        prnt(stack);
        stack.pop();
        prnt(stack);
        stack.pop();
        prnt(stack);
    }
}
