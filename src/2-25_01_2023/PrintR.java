import java.util.Queue;
import java.util.LinkedList;


class PrintR{
    private Queue<String> g_queue; // general queue
    private Queue<String> p_queue; // priority queue

    public PrintR(){
        g_queue = new LinkedList<String>();
        p_queue = new LinkedList<String>();
    }

    public boolean isEmpty(){
        return (g_queue.peek()==null) && (p_queue.peek()==null);
    }
    public void add(String name, boolean prior){
        if (prior){
            p_queue.add(name);
        } else {
            g_queue.add(name);
        }
    }

    public String remove(){
        if ((g_queue.peek()==null) && (p_queue.peek()==null)) return "";
        if (p_queue.peek()==null){
            return g_queue.poll();
        }
        return p_queue.poll();
    }

    public void print(){
        System.out.print("Current queue:");
        for (String name: p_queue){
            System.out.printf(" %s", name);
        }
        for (String name: g_queue){
            System.out.printf(" %s", name);
        }
        System.out.println();
    }

    public static void main(String[] args){
        PrintR myQ = new PrintR();
        myQ.add("referats.docx", false);
        myQ.add("tabula.docx", true);
        myQ.add("rokijums.docx", true);
        myQ.print();
        System.out.println(myQ.remove());
        System.out.println(myQ.remove());
        System.out.println(myQ.remove());
        System.out.println(myQ.remove());
        myQ.add("eseja.pdf", false);
        myQ.print();
        System.out.println(myQ.remove());
    }

}