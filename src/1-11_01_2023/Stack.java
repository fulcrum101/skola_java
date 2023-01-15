public class Stack{
    static class Node{
        char value;
        Node next = null;
    }

    public Node top;

    public Stack(){}

    public boolean isEmpty(){
        return top==null;
    }

    public void push(char ch){
        Node newNode = new Node();
        newNode.value = ch;
        newNode.next = top;
        top = newNode;
    }

    public void print(){
        Node current_node = new Node();
        current_node = top;

        System.out.print("Stack: ");
        while (true){
            System.out.print(" ");
            System.out.print( current_node.value);
            if (current_node.next!=null){
                current_node = current_node.next;
            } else {
                break;
            }
        }
        System.out.println();
    }

    public char peek(){
        if (!isEmpty()) {
            return top.value;
        } else {
            System.out.println("Stack is empty.");
            return '1';
        }
    }

    public void pop(){
        if (!isEmpty()){
            top = top.next;
        } else {
            System.out.println("Stack is empty.");
        }
    }

    public static void main(String[] args){
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.print();
        stack.pop();
        stack.print();
        System.out.println(stack.peek());
    }
}