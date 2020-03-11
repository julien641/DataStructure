
public class NodeElement {

    int nodenumber;   //Record or Node number IDentifier
    int info;         //Any information fields
    int flink;        //forward link, if used, to next record
    int blink;        //backward link, if used, to previous record
    int parent;       //parent link, if used, for a binary tree
    int lchild;       //left child, if used, for a binary tree
    int rchild;       //right child, if used, for a binary tree

    public NodeElement() // The no-arg constructor 
    {
        lchild = -1;
        rchild = -1;
        parent = -1;
    }

    int setInfo(int x) {
        info = x;
        return 0;
    }

    int getInfo() {
        return info;
    }

    int setNodeNumber(int n) {
        nodenumber = n;
        return 0;
    }

    int getNodeNumber() {
        return nodenumber;
    }

    int setFlink(int n) {
        flink = n;
        return 0;
    }

    int setBlink(int n) {
        blink = n;
        return 0;
    }

    int getFlink() {
        return flink;
    }

    int getBlink() {
        return blink;
    }

}  //End of Class
