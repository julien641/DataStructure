
public class Binarytree {

    int root;
    Linktstack stack;
    int numels;
    int maxsize;
    String x = "%-6s";

    public Binarytree(int maxsize) {
        stack = new Linktstack(maxsize);
        this.maxsize = maxsize;
        root = -1;
        numels = 0;
    }

    public int queryroot() {
        return root;

    }

    public void startroot(int x) {
        root = stack.getnode();
        numels++;
        stack.item[root].setInfo(x);
        System.out.println("rchild " + stack.item[root].rchild);
        System.out.println("info " + stack.item[root].info);
        System.out.println("lchild " + stack.item[root].lchild);

    }

    public int attachleft(int subroot, int info) {
        int p;
        p = stack.getnode();
        if (p == -1) {
            return -1;

        }
        stack.item[subroot].lchild = p;
        stack.item[p].parent = subroot;
        stack.item[p].info = info;
        numels++;

        return 0;
    }

    public int attachright(int subroot, int info) {
        int p = stack.getnode();
        if (p == -1) {
            return -1;

        }
        stack.item[subroot].rchild = p;
        stack.item[p].parent = subroot;
        stack.item[p].info = info;
        numels++;

        return 0;
    }

    public boolean isEmptie() {
        if (numels == 0) {
            return true;

        } else {
            return false;

        }

    }

    public boolean emptie() {
        if (numels == 0) {
            return true;
        } else {
            return false;

        }

    }

    public boolean full() {
        if (numels == maxsize) {
            return true;
        } else {
            return false;

        }

    }

    public void nodenumbervisit(int node) {
        System.out.printf(x, node);
    }

    public void parentvisit(int node) {
        System.out.printf(x, stack.item[node].parent);
    }

    public void rchildvisit(int node) {
        System.out.printf(x, stack.item[node].rchild);
    }

    public void lchildvisit(int node) {
        System.out.printf(x, stack.item[node].lchild);
    }

    public void infovisit(int node) {
        System.out.printf(x, stack.item[node].info);
    }

    public int prune() {
        numels = 0;
        root = -1;
        stack = null;
        stack = new Linktstack(maxsize);
        return 0;
    }

    public int insert(int subroot, int value) {
        int rc = -1;
        int left;
        if (full()) {
            return -1;
        }
        if (isEmptie()) {
            startroot(value);
            rc = 0;
        } else {

            int y = stack.item[subroot].getInfo();
            if (value < y) {

                left = stack.item[subroot].lchild;
                if (left == -1) {

                    rc = attachleft(subroot, value);
                    if (rc == -1) {
                        return -1;

                    }

                } else {
                    rc = insert(left, value);

                }
            } else if (value >= y) {
                int right = stack.item[subroot].rchild;
                if (right == -1) {

                    rc = attachright(subroot, value);
                    if (rc == -1) {
                        return -1;

                    }
                } else {
                    rc = insert(right, value);

                }
            }
        }
        return rc;
    }

    public int inorder() {
        if (emptie()) {
            return -1;
        }
        System.out.print("info-------> ");
        infoinorder(root);
        System.out.println();
        System.out.print("nodenumber-> ");
        nodenumberinorder(root);
        System.out.println();
        System.out.print("parent-----> ");
        parentinorder(root);
        System.out.println();
        System.out.print("rchild-----> ");
        rchildinorder(root);
        System.out.println();
        System.out.print("lchild-----> ");
        lchildinorder(root);

        return 0;
    }

    public int preorder() {
        if (emptie()) {
            return -1;
        }
        System.out.print("info-------> ");
        infopreorder(root);
        System.out.println();
        System.out.print("nodenumber-> ");
        nodenumberpreorder(root);
        System.out.println();
        System.out.print("parent-----> ");
        parentpreorder(root);
        System.out.println();
        System.out.print("rchild-----> ");
        rchildpreorder(root);
        System.out.println();
        System.out.print("lchild-----> ");
        lchildpreorder(root);
        return 0;
    }

    public int postorder() {
        if (emptie()) {
            return -1;
        }
        System.out.print("info-------> ");
        infopostorder(root);
        System.out.println();
        System.out.print("nodenumber-> ");
        nodenumberpostorder(root);
        System.out.println();
        System.out.print("parent-----> ");
        parentpostorder(root);
        System.out.println();
        System.out.print("rchild-----> ");
        rchildpostorder(root);
        System.out.println();
        System.out.print("lchild-----> ");
        lchildpostorder(root);
        return 0;
    }

    public int inverseorder() {
        if (emptie()) {
            return -1;
        }
        System.out.print("info-------> ");
        infoinverseorder(root);
        System.out.println();
        System.out.print("nodenumber-> ");
        nodenumberinverseorder(root);
        System.out.println();
        System.out.print("parent-----> ");
        parentinverseorder(root);
        System.out.println();
        System.out.print("rchild-----> ");
        rchildinverseorder(root);
        System.out.println();
        System.out.print("lchild-----> ");
        lchildinverseorder(root);
        System.out.println();
        return 0;
    }

    public int lchildinverseorder(int node) {

        if (node == -1) {
            return 0;
        }
        lchildinverseorder(stack.item[node].rchild);
        lchildvisit(node);
        lchildinverseorder(stack.item[node].lchild);
        return -1;
    }

    public int nodenumberinverseorder(int node) {

        if (node == -1) {
            return 0;
        }
        nodenumberinverseorder(stack.item[node].rchild);
        nodenumbervisit(node);
        nodenumberinverseorder(stack.item[node].lchild);
        return -1;
    }

    public int parentinverseorder(int node) {

        if (node == -1) {
            return 0;
        }
        parentinverseorder(stack.item[node].rchild);
        parentvisit(node);
        parentinverseorder(stack.item[node].lchild);
        return -1;
    }

    public int infoinverseorder(int node) {

        if (node == -1) {
            return 0;
        }
        infoinverseorder(stack.item[node].rchild);
        infovisit(node);
        infoinverseorder(stack.item[node].lchild);
        return -1;
    }

    public int rchildinverseorder(int node) {

        if (node == -1) {
            return 0;
        }
        rchildinverseorder(stack.item[node].rchild);
        rchildvisit(node);
        rchildinverseorder(stack.item[node].lchild);
        return -1;
    }

    public int lchildinorder(int node) {

        if (node == -1) {
            return 0;
        }

        lchildinorder(stack.item[node].lchild);
        lchildvisit(node);
        lchildinorder(stack.item[node].rchild);
        return -1;
    }

    public int infoinorder(int node) {

        if (node == -1) {
            return 0;
        }

        infoinorder(stack.item[node].lchild);
        infovisit(node);
        infoinorder(stack.item[node].rchild);
        return -1;
    }

    public int nodenumberinorder(int node) {

        if (node == -1) {
            return 0;
        }

        nodenumberinorder(stack.item[node].lchild);
        nodenumbervisit(node);
        nodenumberinorder(stack.item[node].rchild);
        return -1;
    }

    public int parentinorder(int node) {

        if (node == -1) {
            return 0;
        }

        parentinorder(stack.item[node].lchild);
        parentvisit(node);
        parentinorder(stack.item[node].rchild);
        return -1;
    }

    public int rchildinorder(int node) {

        if (node == -1) {
            return 0;
        }

        rchildinorder(stack.item[node].lchild);
        rchildvisit(node);
        rchildinorder(stack.item[node].rchild);
        return -1;
    }

    public int parentpostorder(int node) {

        if (node == -1) {
            return 0;
        }
        parentpostorder(stack.item[node].lchild);
        parentpostorder(stack.item[node].rchild);
        parentvisit(node);
        return 1;

    }

    public int rchildpostorder(int node) {

        if (node == -1) {
            return 0;
        }
        rchildpostorder(stack.item[node].lchild);
        rchildpostorder(stack.item[node].rchild);
        rchildvisit(node);
        return 1;

    }

    public int lchildpostorder(int node) {

        if (node == -1) {
            return 0;
        }
        lchildpostorder(stack.item[node].lchild);
        lchildpostorder(stack.item[node].rchild);
        lchildvisit(node);
        return 1;

    }

    public int infopostorder(int node) {

        if (node == -1) {
            return 0;
        }
        infopostorder(stack.item[node].lchild);
        infopostorder(stack.item[node].rchild);
        infovisit(node);
        return -1;

    }

    public int nodenumberpostorder(int node) {

        if (node == -1) {
            return 0;
        }
        nodenumberpostorder(stack.item[node].lchild);
        nodenumberpostorder(stack.item[node].rchild);
        nodenumbervisit(node);
        return -1;

    }

    public int infopreorder(int subroot) {

        if (subroot == -1) {
            return 0;
        }

        infovisit(subroot);
        infopreorder(stack.item[subroot].lchild);
        infopreorder(stack.item[subroot].rchild);
        return 1;
    }

    public int nodenumberpreorder(int subroot) {

        if (subroot == -1) {
            return 0;
        }

        nodenumbervisit(subroot);
        nodenumberpreorder(stack.item[subroot].lchild);
        nodenumberpreorder(stack.item[subroot].rchild);
        return 1;
    }

    public int lchildpreorder(int subroot) {

        if (subroot == -1) {
            return 0;
        }

        lchildvisit(subroot);
        lchildpreorder(stack.item[subroot].lchild);
        lchildpreorder(stack.item[subroot].rchild);
        return 1;
    }

    public int rchildpreorder(int subroot) {

        if (subroot == -1) {
            return 0;
        }

        rchildvisit(subroot);
        rchildpreorder(stack.item[subroot].lchild);
        rchildpreorder(stack.item[subroot].rchild);
        return 1;
    }

    public int parentpreorder(int subroot) {

        if (subroot == -1) {
            return 0;
        }

        parentvisit(subroot);
        parentpreorder(stack.item[subroot].lchild);
        parentpreorder(stack.item[subroot].rchild);
        return 1;
    }
}

/*
constructor
startroot
attach left
attach right
queryroot
queryanynode
queryparrent
querysize
queryrchild
querylchild
 */
