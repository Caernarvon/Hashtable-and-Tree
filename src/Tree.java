import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable> {
    private TreeNode root;

    public TreeNode<T> find(T x) {
        return find(this.root, x);
    }

    private TreeNode<T> find(TreeNode<T> root, T x) {
        if(root == null) {
            return null;
        }

        if(root.key == x) {
            return root;
        }

        if(root.key.compareTo(x)==1) {
            return find(root.left, x);
        }
        else {
            return find(root.right, x);
        }
    }

    public boolean Contains(T value)
    {
        // Поиск узла осуществляется другим методом.
        TreeNode parent = this.root;
        return FindWithParent(value, parent) != null;
    }

    private TreeNode FindWithParent(T value, TreeNode parent)
    {
        TreeNode current = this.root;
        parent = null;

        while (current != null) {
            int result = current.key.compareTo(value);

            if (result > 0) {
                parent = current;
                current = current.getLeft();
            }
        else if (result < 0) {
                parent = current;
                current = current.getRight();
            }
        else {
                break;
            }
        }

        return current;
    }

    public void insert(T x) {
        insert(this.root, x);
    }

    private TreeNode<T> insert(TreeNode<T> root, T x) {
        if(root == null) {
            TreeNode temp =  new TreeNode<T>();
            temp.key = x;

            if(this.root == null) {
                this.root = temp;
            }
            return temp;
        }

        if(root.key.compareTo(x) < 0){
            root.right = insert(root.right, x);
        }
        if(root.key.compareTo(x) >= 0){
            root.left = insert(root.left, x);
        }
        return root;
    }

    public void printTree() {
        printTree(this.root, 0, "root");
    }

    private void printTree(TreeNode treeNode, int level, String action){
        if(treeNode == null) {
            return;
        }
        printTree(treeNode.getLeft(), level + 1,"left");
        printTree(treeNode.getRight(), level + 1,"right");
        System.out.println(action + " " + treeNode + " level is: " + level);
    }

    public List<T> getNodes(){
        List<T> list = new ArrayList<T>();
        getNodes(this.root, list);
        return list;
    }

    private void getNodes(TreeNode treeNode, List<T> list) {
        if(treeNode == null) {
            return;
        }
        getNodes(treeNode.getLeft(), list);
        getNodes(treeNode.getRight(), list);
        list.add((T) treeNode.getKey());
    }

    private <T> T[] toArray(final List<T> obj) {
        if (obj == null || obj.isEmpty()) {
            return null;
        }
        final T t = obj.get(  0 );
        final T[] res = (T[]) Array.newInstance(t.getClass(), obj.size());
        for (int i = 0; i < obj.size(); i++) {
            res[i] = obj.get(i);
        }
        return res;
    }

    public void createTreeFromList(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        T[] data = toArray(list);
        createTreeFromList(data, 0, data.length - 1);
    }

    private void createTreeFromList(final T[] data, final int startIndex, final int endIndex){
        int diff = endIndex - startIndex;

        if (diff == 0){
            insert(this.root, data[startIndex]);
            return;
        }
        else if (diff == 1){
            insert(this.root, data[startIndex]);
            insert(this.root, data[startIndex + 1]);
            return;
        }

        int middleIndex = startIndex + diff / 2;
        insert(this.root, data[middleIndex]);
        createTreeFromList(data, startIndex, middleIndex - 1);
        createTreeFromList(data, middleIndex + 1, endIndex);

    }

    public boolean Remove(T value)
    {
        TreeNode parent = this.root;
        TreeNode current = this.root;

        while (current != null) {
            int result = current.key.compareTo(value);

            if (result > 0) {
                parent = current;
                current = current.getLeft();
            }
            else if (result < 0) {
                parent = current;
                current = current.getRight();
            }
            else {
                break;
            }
        }

        if (current == null) {
            return false;
        }

        if (current.getRight() == null) {
            parent.setLeft(current.getLeft());
        }
        else if (current.getRight() != null && current.getRight().getLeft() == null ) {
            int res = parent.key.compareTo(current.getKey());
            if (res > 0) {
                current = current.getRight();
                parent.setLeft(current);
            }
            if (res < 0) {
                current = current.getRight();
                parent.setRight(current);
            }
        }
        else if (current.getRight() != null && current.getRight().getLeft() != null) {
            int res = parent.key.compareTo(current.getKey());
            if (res > 0) {
                current = current.getRight().getLeft();
                parent.setRight(current);
            }
            if (res < 0) {
                current = current.getRight().getLeft();
                parent.setLeft(current);
            }
        }
        return true;
    }

}
