public class BinaryNode<Integer> {
    Integer value;
    BinaryNode<Integer> right;
    BinaryNode<Integer> left;
    public BinaryNode(Integer value){
        this.value = value;
        right = null;
        left = null;
    }

    public void setRight(BinaryNode<Integer> right){
        this.right = right;
    }
    public void setLeft(BinaryNode<Integer> left){
        this.left = left;
    }
}
