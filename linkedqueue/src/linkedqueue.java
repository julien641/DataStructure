
public class linkedqueue {

    private int tail;
    private int head;
    private int numels;
    Linktstack stack;
    int stacksize;

    public linkedqueue() {
        head = -1;
        tail = -1;
        stack = new Linktstack(1000);
    }

    public boolean insertat(int pos, int value) {
        if (isEmpty() || pos == numels + 1) {
            return insert(value);
        }
        if (pos < 1 || numels + 1 < pos) {
            return false;
        }
        int p = stack.getnode();
        if (p == -1) {
            return false;
        }
        stack.item[p].setInfo(value);
        if (pos == 1) {
            stack.item[p].setFlink(-1);
            stack.item[p].setBlink(head);
            stack.item[head].setFlink(p);
            head = p;

        } else {
            int n = head;

            for (int i = 0; i < (pos - 2); i++) {
                n = stack.item[n].getBlink();
            }
            int q = stack.item[n].getBlink();
            stack.item[p].blink = q;
            stack.item[q].flink = p;
            stack.item[n].blink = p;
            stack.item[p].flink = n;

        }
        numels++;
        return true;
    }

    public int Linktstacksize() {
        return stack.querymaxsize();

    }

    public int queryat(int index) {

        if (isEmpty() || index > numels || index < 1) {
            return -1;
        }
        if (index == 1) {
            System.out.println("back link   :" + stack.item[head].blink);
            System.out.println("front link  :" + stack.item[head].flink);
            System.out.println("info        :" + stack.item[head].getInfo());
            System.out.println("node number :" + stack.item[head].nodenumber);

        } else if (index == numels) {
            System.out.println("back link   :" + stack.item[tail].blink);
            System.out.println("front link  :" + stack.item[tail].flink);
            System.out.println("info        :" + stack.item[tail].getInfo());
            System.out.println("node number :" + stack.item[tail].nodenumber);

        } else {
            int blink = head;
            for (int i = 0; i < (index - 1); i++) {
                blink = stack.item[blink].blink;
            }
            System.out.println("back link   :" + stack.item[blink].blink);
            System.out.println("front link  :" + stack.item[blink].flink);
            System.out.println("info        :" + stack.item[blink].getInfo());
            System.out.println("node number :" + stack.item[blink].nodenumber);

        }
        return 0;
    }

    public int queryfloorat(int pos) {
        return stack.item[pos].floor;
    }

    public int find(int value) {
        int blink = head;
        int index = 0;
        while (blink != -1) {
            index++;
            if (stack.item[blink].getInfo() == value) {
                return index;

            }

            blink = stack.item[blink].blink;

        }

        return -1;
    }

    public void traverseinfohead() {
        String x = "%-6s";
        System.out.print("head Content--> ");
        int p;
        p = stack.item[head].nodenumber;
        for (int i = 0; i < numels; i++) {

            System.out.printf(x, stack.item[p].getInfo());
            p = stack.item[p].blink;
        }
        System.out.println(" <--tail content");

    }

    public void traversenodenumberhead() {
        String x = "%-6s";
        System.out.print("Node slot-----> ");
        int p = stack.item[head].nodenumber;
        for (int i = 0; i < numels; i++) {

            System.out.printf(x, stack.item[p].nodenumber);
            p = stack.item[p].blink;
        }
        System.out.println(" <-----Node slot");

    }

    public void traverseblinkhead() {
        String x = "%-6s";
        System.out.print("Back Link-----> ");
        int p = stack.item[head].nodenumber;
        for (int i = 0; i < numels; i++) {

            System.out.printf(x, stack.item[p].blink);
            p = stack.item[p].blink;
        }
        System.out.println(" <-----back link");
    }

    public void traversefowardlinkhead() {
        String x = "%-6s";
        System.out.print("forward Link--> ");
        int p = stack.item[head].nodenumber;
        for (int i = 0; i < numels; i++) {

            System.out.printf(x, stack.item[p].flink);
            p = stack.item[p].blink;
        }
        System.out.println(" <--forward link");

    }

    public int showstructurehead() {
        String x = "%-6s";
        if (isEmpty()) {
            System.out.println("numels: " + numels);
            System.out.println("Tail: " + tail);
            System.out.println("Head: " + head);
            return -1;
        }
        System.out.println("numels: " + numels);
        System.out.println("Tail: " + tail);
        System.out.println("Head: " + head);

        System.out.print("Position    --> ");
        for (int i = 1; i <= numels; i++) {
            System.out.printf(x, i + " ");
        }
        System.out.println(" <--  Position");

        traverseinfohead();
        traversenodenumberhead();
        traverseblinkhead();
        traversefowardlinkhead();

        return 0;
    }

    public void traverseinfotail() {
        String x = "%-6s";
        System.out.print("Tail Content--> ");
        int p;
        p = stack.item[tail].nodenumber;
        for (int i = 0; i < numels; i++) {

            System.out.printf(x, stack.item[p].getInfo());
            p = stack.item[p].flink;
        }
        System.out.println(" <--Head content");

    }

    public void traversenodenumbertail() {
        String x = "%-6s";
        System.out.print("Node slot-----> ");
        int p = stack.item[tail].nodenumber;
        for (int i = 0; i < numels; i++) {

            System.out.printf(x, stack.item[p].nodenumber);
            p = stack.item[p].flink;
        }
        System.out.println(" <-----Node slot");

    }

    public void traverseblinktail() {
        String x = "%-6s";
        System.out.print("Back Link-----> ");
        int p = stack.item[tail].nodenumber;
        for (int i = 0; i < numels; i++) {

            System.out.printf(x, stack.item[p].blink);
            p = stack.item[p].flink;
        }
        System.out.println(" <-----back link");
    }

    public void traversefowardlinktail() {
        String x = "%-6s";
        System.out.print("forward Link--> ");
        int p = stack.item[tail].nodenumber;
        for (int i = 0; i < numels; i++) {

            System.out.printf(x, stack.item[p].flink);
            p = stack.item[p].flink;
        }
        System.out.println(" <--forward link");

    }

    public int showstructuretail() {

        String x = "%-6s";
        if (isEmpty()) {
            System.out.println("numels: " + numels);
            System.out.println("Tail: " + tail);
            System.out.println("Head: " + head);
            return -1;
        }
        System.out.println("numels: " + numels);
        System.out.println("Tail: " + tail);
        System.out.println("Head: " + head);

        System.out.print("Position    --> ");
        for (int i = numels; i > 0; i--) {
            System.out.printf(x, i + " ");
        }
        System.out.println(" <--  Position");

        traverseinfotail();
        traversenodenumbertail();
        traverseblinktail();
        traversefowardlinktail();

        return 0;
    }

    public int removeat(int pos) {
        if (pos == 1) {
            return remove();
        }
        if (pos < 0 || pos > numels) {
            return -1;
        }
        if (pos == (numels)) {
            int p = stack.item[tail].getFlink();
            stack.item[p].setBlink(-1);
            stack.putnode(tail);
            tail = p;
        } else {
            int p = head;
            for (int i = 0; i < (pos - 1); i++) {
                p = stack.item[p].getBlink();

            }
            int after = stack.item[p].getFlink();
            int before = stack.item[p].getBlink();

            stack.item[before].setFlink(after);
            stack.item[after].setBlink(before);
            stack.putnode(p);
        }
        numels--;
        return 1;

    }

    public boolean insert(int x) {
        int p = stack.getnode();
        if (p == -1) {

            return false;
        }
        stack.item[p].setBlink(-1);
        stack.item[p].setInfo(x);
        stack.item[p].setFlink(tail);

        if (numels > 0) {
            stack.item[tail].blink = p;

        }
        tail = p;
        if (numels == 0) {
            head = tail;
        }

        numels++;
        return true;
    }

    public boolean isEmpty() {
        if (numels == 0) {
            return true;

        } else {
            return false;
        }

    }

    public int remove() {
        int rc;
        if (isEmpty()) {
            return -1;
        }

        if (numels == 1) {
            stack.putnode(head);
            head = -1;
            tail = -1;
        } else {

            int q = stack.item[head].blink;
            rc = stack.putnode(head);
            if (rc == -1) {
                return -1;

            }
            head = q;
            stack.item[head].flink = -1;
        }
        numels--;

        return 0;

    }

    public int querypop() {
        return numels;

    }

    public int queryhead() {

        return head;

    }

    public int querytail() {
        return tail;
    }

    public int queryheadcontext() {
        if (isEmpty()) {
            return -1;

        }
        return stack.item[head].getInfo();

    }

    public int querytailcontents() {
        if (isEmpty()) {
            return -1;

        }
        return stack.item[tail].getInfo();
    }
}

//constructor insert remove isEmpty isfull queryhead querytail queryheadcontext querytailcontents findinfo queryposition
