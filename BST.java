import java.util.ArrayList;
public class BST {
    BinaryNode<Integer> root;
    int length;
    public BST(){
        root = null;
        length = 0;
    }

    public BST(int[] arr){
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

    public void delete(BinaryNode<Integer> headNode, Integer target){
        BinaryNode<Integer> it = root;
        BinaryNode<Integer> parent = null;
        while(it != null && !it.value.equals(target)){
            parent = it;
            if(it.value < target){
                if(it.right == null){
                    return;
                }
                it = it.right;
            }
            else{
                if(it.left == null){
                    return;
                }
                it = it.left;
            }
        }

        if(it.left != null && it.right != null){
            BinaryNode<Integer> succParent = it;
            BinaryNode<Integer> succ = it.right;
            while(succ.left != null){
                succParent = succ;
                succ = succ.left;
            }
            it.value = succ.value;
            parent = succParent;
            it = succ;
        }

        BinaryNode<Integer> child;

        if(it.left != null){
            child = it.left;
        }
        else{
            child = it.right;
        }

        if(parent.left == it){
            parent.left = child;
        }
        else{
            parent.right = child;
        }
        length--;
    }

    public ArrayList<Integer> toArray(){
        ArrayList<Integer> array = new ArrayList<Integer>();
        BinaryNode<Integer> it = root;
        Sorter(it, array);
        return array;
    }

    public void Sorter(BinaryNode<Integer> node, ArrayList<Integer> array){
        if(node == null){
            return;
        }
        Sorter(node.left, array);
        array.add(node.value);
        Sorter(node.right,array);
    }

    public static void main(String[] args){

        BST tree = new BST();
        ArrayList<Integer> array;
        tree.insert(new BinaryNode<Integer>(5));
        tree.insert(new BinaryNode<Integer>(10));
        tree.insert(new BinaryNode<Integer>(8));
        tree.insert(new BinaryNode<Integer>(2));

        array = tree.toArray();
        for(int num : array){
            System.out.println(num);
        }

        System.out.println(tree.find(new BinaryNode<Integer>(5)));
        tree.delete(tree.root, 2);

        array = tree.toArray();
        for(int num : array){
            System.out.println(num);
        }

        ArrayList<Integer> array2;
        int[] arr = new int[]{1, 3, 5, 6, 8, 9, 10};
        BST arrayTree = new BST(arr);
        array2 = arrayTree.toArray();
        for(int num : array2){
            System.out.println(num);
        }
    }
}