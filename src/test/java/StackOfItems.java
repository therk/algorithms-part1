/**
 * Created by therk on 1/2/17.
 */
public class StackOfItems<Item> {

  private int size = 0;
  private Node top = null;

  public void push(Item s) {
    Node n = new Node();
    n.value = s;
    n.next = top;
    size++;
    top = n;
  }

  public Item pop() {
    Item s = top.value;
    top = top.next;
    size--;
    return s;
  }

  public boolean isEmpty() {
    return (top == null);
  }

  public int size() {
    return size;
  }

  private class Node {
    public Item value;
    private Node next;
  }
}
