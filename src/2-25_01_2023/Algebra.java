import com.sun.tools.attach.AgentInitializationException;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

class Algebra{
    private int priority(char ch) {
        if ((ch == '(') || (ch == ')')) {
            return 0;
        } else if ((ch == '+') || (ch == '-')) {
            return 1;
        }
        return 2;
    }
    private void print(Stack<Character> st){
        for (Character character : st) {
            System.out.printf(" %s", character);
        }
        System.out.println();
    }
    // INFIX -> POSTFIX
    public String postfix(String s){
        String res = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')'){
                while ((!stack.empty())&&(stack.peek()!='(')){
                    res += stack.pop();
                }
                stack.pop(); // pop '('
            } else if ((c>='0') && (c<='9')){
                res += c;
            } else {
                while ((!stack.empty())&&(priority(stack.peek()) >= priority(c))){
                    res += stack.pop();
                }
                stack.push(c);
            }
//            System.out.printf("Char: %s\n", c);
//            System.out.printf("Res: %s\n", res);
//            print(stack);
        }
        while (!stack.empty()){
            res += stack.pop();
        }
        return res;
    }

    public double eval(String s){
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i)>='0') {
                stack.push((double) s.charAt(i) - 48);
            } else {
                switch(s.charAt(i)){
                    case '+':
                        stack.push(stack.pop()+stack.pop());
                        break;
                    case '-':
                        stack.push(stack.pop()-stack.pop());
                        break;
                    case '*':
                        stack.push(stack.pop()*stack.pop());
                        break;
                    case '/':
                        double d_1 = stack.pop();
                        double d_2 = stack.pop();
                        if (d_1==0.0){
                            throw new ArithmeticException("Division by 0!");
                        }
                        stack.push(d_2/d_1);
                        break;
                    default:
                        throw new ArithmeticException("Unknown char!");
                }
            }
        }
        return stack.pop();
    }


    public static void main(String[] args){
        // INFIX -> POSTFIX
        // POSTFIX -> double
        // helper priority
        Algebra calc = new Algebra();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String infix = sc.next();
        String postfix = calc.postfix(infix);
        double result = calc.eval(postfix);
        System.out.printf("Result %f\n", result);
    }
}