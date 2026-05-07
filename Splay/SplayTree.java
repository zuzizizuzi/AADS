import java.util.LinkedList;
import java.util.Queue;

public class SplayTree {
    private Node root;

    //right turn
    private void rotRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
    
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    //left turn
    private void rotLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }    
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }


    //method splay
    private void splay(Node x) {
        while (x.parent != null) {
            Node p = x.parent;
            Node g = p.parent;
            if (g == null) { // zig
                if (x == p.left) rotRight(p);
                else rotLeft(p);
            } else if ((x == p.left) == (p == g.left)) { // zig-zig
                if (x == p.left) { rotRight(g); rotRight(p); }
                else { rotLeft(g); rotLeft(p); }
            } else { // zig-zag
                if (x == p.left) {
                     rotRight(p); 
                     rotLeft(g); }
                else { 
                    rotLeft(p); 
                    rotRight(g); }
            }
        }
    }


    //вставка
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        Node curr = root;
        Node parent = null;
        while (curr != null) {
            parent = curr;
            if (key < curr.key){
              curr = curr.left;  
            } 
            else if (key > curr.key) curr = curr.right;
            else { 
                splay(curr); 
                return; 
            } // Ключ уже есть
        }
        Node newNode = new Node(key);
        newNode.parent = parent;
        if (key < parent.key) parent.left = newNode;
        else parent.right = newNode;
        splay(newNode);
    }

    public boolean search(int key) {
        if (root == null) return false;
    
        Node curr = root;
        Node lastVisited = null;
    
        while (curr != null) {
            lastVisited = curr;
            if (key == curr.key) {
                splay(curr); // Делаем splay найденного узла
                return true;
            } else if (key < curr.key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    
    // Если не нашли, splay для последнего посещенного узла
        splay(lastVisited);
        return false;
    }

    public void delete(int key) {
        if (root == null) {
            return;
        }
        if (!search(key)) {
            return;
        }

        Node leftSebtree = root.left;
        Node rightSebtree = root.right;

        if (leftSebtree == null) {
            root = rightSebtree;
            if (root != null) {
                root.parent = null;
            }
        } else {
            Node maxLeft = leftSebtree;
            while (maxLeft.right != null) {
                maxLeft = maxLeft.right;
            }

            splay(maxLeft);

            maxLeft.right=rightSebtree;
            if (rightSebtree != null) {
                rightSebtree.parent = maxLeft;
            }
            root = maxLeft;
            root.parent = null;
        }

    }






    //BFS
    public void printBFS() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.print(n.key + " ");
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
    }

    //dfs
    public void printDFS(Node node) {
        if (node != null) {
            printDFS(node.left);
            System.out.print(node.key + " ");
            printDFS(node.right);
        }
    }
}
