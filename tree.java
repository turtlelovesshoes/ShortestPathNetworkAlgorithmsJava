public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }

    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private List<Node<T>> children;
    }

	public void setroot()
	public void create node
	public void set node
	public void return new distance
	public void print tou
	public void print distance array
	public void traverse through tree to find and print
}
