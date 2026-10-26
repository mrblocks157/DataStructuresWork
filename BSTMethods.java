import java.util.ArrayList;
import java.util.*;
public class BSTMethods {
    BinaryNode<Integer> root;
    int length;
    public BSTMethods(){
        root = null;
        length = 0;
    }

    public BSTMethods(int[] arr){
        length = arr.length;
        int high = arr.length-1;
        int low = 0;
        root = add(arr, high, low);
    }

    public BinaryNode<Integer> add (int[] arr, int high, int low){
        if(low > high){
            return null;
        }
        int mid = low + (high - low) / 2;
        BinaryNode<Integer> it = new BinaryNode<Integer>(arr[mid]);
        it.left = add(arr, mid-1, low);
        it.right = add(arr, high, mid+1);
        return it;
    }

    public void insert(BinaryNode<Integer> node){
        if(root == null){
            root = node;
        }
        else{
            BinaryNode<Integer> it = root;
            while(true){
                if(node.value > it.value){
                    if (it.right == null){
                        it.setRight(node);
                        break;
                    }
                    it = it.right;
                }
                else{
                    if (it.left == null){
                        it.setLeft(node);
                        break;
                    }
                    it = it.left;
                }
            }
        }
        length++;
    }

    public boolean find(BinaryNode<Integer> node){
        BinaryNode<Integer> it = root;
        while(true){
            if(it.value == node.value){
                return true;
            }
            else{
                if(it.value > node.value){
                    if(it.left == null){
                        return false;
                    }
                    it = it.left;
                }
                else{
                    if(it.right == null){
                        return false;
                    }
                    it = it.right;
                }
            }
        }
    }


    public int getHeight(BinaryNode<Integer> node){
        if(node == null){
            return 0;
        }
        int rightHeight = getHeight(node.right);
        int leftHeight = getHeight(node.left);
        return Math.max(rightHeight, leftHeight) +1;
    }

    public void printTree(){
        writer(root, 0);
    }

    public void writer(BinaryNode<Integer> node, int distance){
        if(node == null){
            return;
        }
        writer(node.right, distance+1);
        System.out.println(String.valueOf("  ").repeat(distance) + node.value);
        writer(node.left, distance+1);
    }

    public boolean balanced(){
        return search(root) != -1;
    }

    public int search(BinaryNode<Integer> node){
        if (node == null) {
            return 0;
        }
        int left = search(node.left);
        if (left == -1){
            return -1;
        }

        int right = search(node.right);
        if (right == -1){
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public ArrayList<Integer> layerOrderedTraversal(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Queue<BinaryNode<Integer>> queue = new LinkedList<>();
        if (root == null){
            return arr;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode<Integer> node = queue.poll();
            arr.add(node.value);
            if(node.left!= null){
                queue.add(node.left);
            }
            if(node.right!= null){
                queue.add(node.right);
            }

        }
        return arr;
    }

    public BinaryNode<Integer> balance(BinaryNode<Integer> onode){
        ArrayList<Integer> flat = new ArrayList<Integer>();
        flatten(onode, flat);
        return order(flat, 0, flat.size()-1);
    }

    public void flatten(BinaryNode<Integer> node, ArrayList<Integer> array){
        if(node == null){
            return;
        }
        flatten(node.left, array);
        array.add(node.value);
        flatten(node.right, array);
    }

    public BinaryNode<Integer> order(ArrayList<Integer> array, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end-start)/2;
        BinaryNode<Integer> node = new BinaryNode<Integer>(array.get(mid));
        node.left = order(array, start, mid-1);
        node.right = order(array, mid+1, end);
        return node;
    }

    public boolean valid(BinaryNode<Integer> node){
        return check(node, null, null);
    }

    public boolean check(BinaryNode<Integer> node, Integer min, Integer max){
        if(node == null){
            return true;
        }
        if((min != null && node.value <= min) || (max != null && node.value >= max)){
            return false;
        }
        return check(node.left, min, node.value) && check(node.right, node.value, max);
    }
    public static void main(String[] args){

        BSTMethods tree = new BSTMethods();
        tree.insert(new BinaryNode<Integer>(5));
        tree.insert(new BinaryNode<Integer>(3));
        tree.insert(new BinaryNode<Integer>(6));
        tree.insert(new BinaryNode<Integer>(4));
        tree.insert(new BinaryNode<Integer>(2));
        tree.insert(new BinaryNode<Integer>(1));
        tree.insert(new BinaryNode<Integer>(0));
        System.out.println(tree.getHeight(tree.root));
        System.out.println(tree.balanced());
        ArrayList<Integer> arr = tree.layerOrderedTraversal();
        for (int num : arr){
            System.out.print(num + ", ");
        }
        System.out.println();
        tree.printTree();
        tree.root = tree.balance(tree.root);
        tree.printTree();

        System.out.println(tree.valid(tree.root));

        BSTMethods bad = new BSTMethods();
        bad.root = new BinaryNode<Integer>(10);
        bad.root.left = new BinaryNode<Integer>(5);
        bad.root.right = new BinaryNode<Integer>(15);
        bad.root.right.left = new BinaryNode<Integer>(6);
        bad.root.right.right = new BinaryNode<Integer>(20);

        System.out.println(bad.valid(bad.root));
    }
}