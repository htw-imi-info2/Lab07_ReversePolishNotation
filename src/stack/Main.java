package stack;
/**
 * Created by Kain on 22-May-17.
 */
public class Main
{
    public static void main(String [] args) throws Underflow
    {
        LinkedListStack<String> list = new LinkedListStack<>();
        list.isEmpty();
        list.push("asdas");
        list.push("asfageq");
        list.push("asfageq");
        list.push("asfageq");
        list.push("asfageq");
        list.pop();
        System.out.println(list.toString());
    }
}
