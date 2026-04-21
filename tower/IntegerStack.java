package tower;

public class IntegerStack {

    private int[] stack;
    private int depth;

    // Construct a stack of given depth
   public IntegerStack(int capacity) {
        this.depth = 0;
        stack = new int[capacity];
   }

    // Get the value of the top element without removal
    public int peek()
    {
        if (depth == 0) {
             return 0;
        }
        else if (depth > 0) {
            return stack[depth - 1];
        }
        else {
            return 0;
        }
    }

    // Remove an element from the top of the stack.
    public int pop()
    {
        int result = 0;
        if (depth > 0) {
            result = stack[depth-1];
            stack[depth - 1] = 0;
            depth--;
        }
        return result;
    }

    // Insert an element at the top of the stack
    public void push(int value) {
        if (depth >= stack.length) {
            return;
        }         
        else if (depth < stack.length) {
            stack[depth] = value;
        }
        if ((depth >= 0) && (depth < stack.length))
        {
            stack[depth++] = value;
        }
    }
public boolean isEmpty()
    {
        return depth == 0;
    }
    // Debug function for printing
    public int get(int index)
    {
        return stack[index];
    }
}
