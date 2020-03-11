/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julien
 */
public class linkedqueuewithobject {

    String x = "%-11s";
    private objectbnode tail;
    private objectbnode head;
    private int numels;

    public linkedqueuewithobject() {
        numels = 0;
        tail = null;
        head = null;

    }

    public boolean insertat(int pos, int value) {
        if (isEmpty() || pos == numels + 1) {
            return insert(value);
        }
        if (pos < 1 || numels + 1 < pos) {
            return false;
        }
        objectbnode p = nodeobject();
        p.setNodeNumber(p);
        p.setInfo(value);
        if (pos == 1) {
            p.setFlink(null);
            p.setBlink(head);
            head.setFlink(p);
            head = p;

        } else {
            objectbnode n = head;

            for (int i = 0; i < (pos - 2); i++) {
                n = n.getBlink();
            }
            objectbnode q = n.getBlink();
            p.blink = q;
            q.flink = p;
            n.blink = p;
            p.flink = n;

        }
        numels++;
        return true;
    }

    public int removeat(int pos) {
        if (pos == 1) {
            return remove();
        }
        if (pos < 0 || pos > numels) {
            return -1;
        }
        if (pos == (numels)) {
            objectbnode p = tail.getFlink();
            p.setBlink(null);

            tail = p;
        } else {
            objectbnode p = head;
            for (int i = 0; i < (pos - 1); i++) {
                p = p.getBlink();

            }
            objectbnode after = p.getFlink();
            objectbnode before = p.getBlink();

            before.setFlink(after);
            after.setBlink(before);
        }
        numels--;
        return 1;

    }

    public objectbnode lastNode(objectbnode node) {

        while (node.blink != null) {
            node = node.blink;
        }
        return node;
    }

    public objectbnode partition(objectbnode low, objectbnode high) {
        int x = high.getInfo();
        objectbnode beforelow = low.flink;
        for (objectbnode newlow = low; newlow != high; newlow = newlow.blink) {
            if (newlow.getInfo() <= x) {
                beforelow = (beforelow == null) ? low : beforelow.blink;
                int temp = beforelow.getInfo();
                beforelow.info = newlow.getInfo();
                newlow.info = temp;
            }
        }
        beforelow = (beforelow == null) ? low : beforelow.blink;  // Similar to i++
        int temp = beforelow.info;
        beforelow.info = high.info;
        high.info = temp;
        return beforelow;
    }

    public void quickSort(objectbnode node) {
        // Find last node
        objectbnode head = lastNode(node);

        // Call the recursive QuickSort
        _quickSort(node, head);
    }

    public void _quickSort(objectbnode low, objectbnode high) {
        if (high != null && low != high && low != high.blink) {
            objectbnode temp = partition(low, high);
            _quickSort(low, temp.flink);
            _quickSort(temp.blink, high);
        }
    }

    public objectbnode nodeobject() {
        objectbnode x = new objectbnode();

        return new objectbnode();
    }

    public boolean insert(int x) {
        objectbnode nnode = nodeobject();
        nnode.setNodeNumber(nnode);
        nnode.setBlink(null);
        nnode.setInfo(x);
        nnode.setFlink(tail);
        if (numels > 0) {
            tail.blink = nnode;
        }
        tail = nnode;
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
        if (isEmpty()) {
            return -1;
        }
        if (numels == 1) {
            head = null;
            tail = null;

        } else {
            head = head.blink;
            head.flink = null;
        }
        numels--;
        return 0;
    }

    public int querypop() {
        return numels;

    }

    public objectbnode queryhead() {

        return head;

    }

    public objectbnode querytail() {
        return tail;
    }

    public int queryheadcontext() {
        if (isEmpty()) {
            return -1;

        }
        return head.getInfo();
    }

    public int querytailcontents() {
        if (isEmpty()) {
            return -1;

        }
        return head.getInfo();
    }

    public int find(int value) {
        objectbnode blink = head;
        int index = 0;
        while (blink != null) {
            index++;
            if (blink.getInfo() == value) {
                return index;

            }

            blink = blink.blink;

        }

        return -1;
    }

    public int queryat(int index) {

        if (isEmpty() || index > numels || index < 1) {
            return -1;
        }
        if (index == 1) {
            if (head.blink != null) {
                System.out.println("back link   :" + head.blink.toString().substring(12));
            } else {
                System.out.println("back link   :" + head.blink);
            }
            if (head.flink != null) {
                System.out.println("front link  :" + head.flink.toString().substring(12));
            } else {
                System.out.println("front link  :" + head.flink);
            }
            System.out.println("info        :" + head.getInfo());
            System.out.println("node number :" + head.nodenumber.toString().substring(12));

        } else {
            objectbnode blink = head;
            for (int i = 0; i < (index - 1); i++) {
                blink = blink.blink;
            }
            System.out.println("back link   :" + blink.blink.toString().substring(12));
            System.out.println("front link  :" + blink.flink.toString().substring(12));
            System.out.println("info        :" + blink.getInfo());
            System.out.println("node number :" + blink.nodenumber.toString().substring(12));

        }
        return 0;
    }

    public void traverseinfohead() {

        System.out.print("head Content--> ");
        objectbnode p;
        p = head;
        for (int i = 0; i < numels; i++) {

            System.out.printf(x, p.getInfo());
            p = p.blink;
        }
        System.out.println(" <--tail content");

    }

    public void traversenodenumberhead() {

        System.out.print("Node slot-----> ");
        objectbnode p;
        p = head;
        for (int i = 0; i < numels; i++) {
            if (p.nodenumber != null) {
                System.out.printf(x, p.nodenumber.toString().substring(12));
            } else {
                System.out.printf(x, p.nodenumber);

            }
            p = p.blink;
        }
        System.out.println(" <-----Node slot");

    }

    public void traverseblinkhead() {

        System.out.print("Back Link-----> ");
        objectbnode p;
        p = head;
        for (int i = 0; i < numels; i++) {
            if (p.blink != null) {
                System.out.printf(x, p.blink.toString().substring(12));
            } else {
                System.out.printf(x, p.blink);
            }
            p = p.blink;
        }
        System.out.println(" <-----back link");
    }

    public void traversefowardlinkhead() {

        System.out.print("forward Link--> ");
        objectbnode p;
        p = head;
        for (int i = 0; i < numels; i++) {
            if (p.flink != null) {
                System.out.printf(x, p.flink.toString().substring(12));
            } else {
                System.out.printf(x, p.flink);
            }
            p = p.blink;
        }
        System.out.println(" <--forward link");

    }

    public int showstructurehead() {

        if (isEmpty()) {
            System.out.println("numels: " + numels);
            if (tail != null) {
                System.out.println("Tail: " + tail.toString().substring(12));
            } else {
                System.out.println("Tail: " + tail);

            }
            if (head != null) {
                System.out.println("Head: " + head.toString().substring(12));
            } else {
                System.out.println("Head: " + head);

            }
            return -1;
        }
        System.out.println("numels: " + numels);
        System.out.println("Tail: " + tail.toString().substring(12));
        System.out.println("Head: " + head.toString().substring(12));

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

        System.out.print("Tail Content--> ");
        objectbnode p;
        p = tail;
        for (int i = 0; i < numels; i++) {

            System.out.printf(x, p.getInfo());
            p = p.flink;
        }
        System.out.println(" <--Head content");

    }

    public void traversenodenumbertail() {

        System.out.print("Node slot-----> ");
        objectbnode p;
        p = tail;
        for (int i = 0; i < numels; i++) {

            System.out.printf(x, p.nodenumber.toString().substring(12));
            p = p.flink;
        }
        System.out.println(" <-----Node slot");

    }

    public void traverseblinktail() {

        System.out.print("Back Link-----> ");
        objectbnode p;
        p = tail;
        for (int i = 0; i < numels; i++) {
            if (p.blink != null) {
                System.out.printf(x, p.blink.toString().substring(12));
            } else {
                System.out.printf(x, p.blink);
            }
            p = p.flink;
        }
        System.out.println(" <-----back link");
    }

    public void traversefowardlinktail() {

        System.out.print("forward Link--> ");
        objectbnode p;
        p = tail;
        for (int i = 0; i < numels; i++) {
            if (p.flink != null) {
                System.out.printf(x, p.flink.toString().substring(12));
            } else {
                System.out.printf(x, p.flink);
            }
            p = p.flink;
        }
        System.out.println(" <--forward link");

    }

    public int showstructuretail() {

        if (isEmpty()) {
            System.out.println("numels: " + numels);
            if (tail != null) {
                System.out.println("Tail: " + tail.toString().substring(12));
            } else {
                System.out.println("Tail: " + tail);

            }
            if (head != null) {
                System.out.println("Head: " + head.toString().substring(12));
            } else {
                System.out.println("Head: " + head);

            }
            return -1;
        }
        System.out.println("numels: " + numels);
        System.out.println("Tail: " + tail.toString().substring(12));
        System.out.println("Head: " + head.toString().substring(12));

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
}
