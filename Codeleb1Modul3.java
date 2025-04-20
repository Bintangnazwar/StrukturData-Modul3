import java.util.Stack;

public class Codeleb1Modul3 {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();

        System.out.println(myStack.isEmpty());

        myStack.push("Kucing");
        myStack.push("Burung");
        myStack.push("Kelinci");
        myStack.push("Ikan");
        myStack.push("Gajah");

        System.out.println(myStack.isEmpty());
        System.out.println("Peek: " + myStack.peek());
        System.out.println("Contents: " + myStack);

        myStack.pop();
        myStack.pop();

        System.out.println("Contents after pop: " + myStack);
        System.out.println("Position of 'Kucing': " + myStack.search("Kucing"));
    }
}
