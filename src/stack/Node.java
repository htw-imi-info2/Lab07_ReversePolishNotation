package stack;
/**
 * Created by Kain on 22-May-17.
 */
public class Node<E>
{
    private E data;
    private Node<E> nextNode;

    public Node(E element)
    {
        data = element;
        nextNode = null;
    }

    public void setData(E element)
    {
        data = element;
    }

    public void setNext(Node<E> node)
    {
        nextNode = node;
    }

    public Node<E> getNext()
    {
        return nextNode;

    }

    public E getData()
    {
        return data;
    }

}
