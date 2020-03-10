
public class Linktstack {

    private int maxsize;
    private int numelement;
    NodeElement item[];
    private int top;

    public Linktstack(int maxsize) {
        item = new NodeElement[maxsize];
        this.maxsize = maxsize;
        numelement = 0;
        for (int init = 0; init < maxsize; init++) {//initializ
            item[init]=new NodeElement();
            item[init].setInfo(-1);
            item[init].nodenumber = (init);
            item[init].blink = (init - 1);
            numelement++;
        }
        top = maxsize - 1;
    }

    public int putnode(int nodenumber) {
        if (isfull()) {
            return -1;
        }
        item[nodenumber].setBlink(top);
        top = item[nodenumber].getNodeNumber();
        numelement++;
        return 0;
    }

    public int getnode() {
        if (isEmptie()) {
            return -1;
        } else {
            int temp;
            temp = item[top].getNodeNumber();
            top = item[top].getBlink();
            numelement--;
            return temp;
        }

    }

    public boolean isfull() {
        if (numelement == maxsize) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmptie() {
        if (numelement > 0) {
            return false;
        } else {
            return true;
        }
    }

    public int peek() {
        if (isEmptie()) {
            return -1;
        }
        return item[top].getInfo();
    }

    public void showstructure() {
        if (isEmptie()) {
            System.out.println("Its Empty");
            return;
        }
        for (int ix = 0; ix < querymaxsize(); ix++) {
            System.out.println("The contents at slot " + ix + " is " + item[ix].getInfo());
        }

    }

    public int querynumberofelement() {
        return numelement;
    }

    public int querymaxsize() {

        return maxsize;
    }

    public int querytop() {
        return top;
    }
}
