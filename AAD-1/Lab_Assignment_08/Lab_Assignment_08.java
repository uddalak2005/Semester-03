package Lab_Assignment_08;

import java.util.Stack;

public class StackJavaCollections {

    public static void insertInAscendingOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int top = stack.pop();

        insertInAscendingOrder(stack, element);

        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();

        reverseStack(stack);

        insertAtBottom(stack, top);
    }

    public static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int top = stack.pop();

        insertAtBottom(stack, element);

        stack.push(top);
    }


    public static int findCelebrity(int[][] M, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {

            int a = stack.pop();
            int b = stack.pop();

            if (M[a][b] == 1) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        // The last remaining person is the candidate
        int candidate = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                    return -1; 
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) 
    {
        // Create a new stack
        Stack<Integer> stack = new Stack<>();

        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        int[][] M = {
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {0, 1, 0, 0},
            {0, 1, 0, 0}
        };
        int n = 4;


        int celebrity = findCelebrity(M, n);

        insertInAscendingOrder(stack, 4);
        
        System.out.println(stack);


        System.out.println("Original Stack: " + stack);
        
        reverseStack(stack);
        
        System.out.println("Reversed Stack: " + stack);

        if (celebrity == -1) {
            System.out.println("There is no celebrity at the party.");
        } else {
            System.out.println("The celebrity is person " + celebrity);
        }
    }
}
