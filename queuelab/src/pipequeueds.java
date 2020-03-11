/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author julien
 */
public class pipequeueds {

    private int tail;
    private int head;
    private int maxsize;
    private int numEls;
    private NodeElement queue[];

    public pipequeueds(int maxsize) {
        this.maxsize = maxsize;
        queue = new NodeElement[maxsize];
        for (int i = 0; i < maxsize; i++) {
            queue[i] = new NodeElement();
            queue[i].setInfo(-1);

        }
        tail = -1;
        head = -1;
    }

    boolean insert(int data) {

        if (isFull()) {
            return false;
        }
        head++;
        if (isEmpty()) {
            tail = 0;

        } else {

            shift();

        }

        queue[0].setInfo(data);
        numEls++;
        return true;
    }

    public void shift() {

        for (int i = head; i >= 1; i--) {
            queue[i].setInfo(queue[i - 1].getInfo());

        }

    }

    public int removal() {
        if (isEmpty()) {
            return -1;
        }

        queue[head].setInfo(-1);
        head--;
        numEls--;
         if (isEmpty()) {
           head=-1;
           tail=-1;
        }
        return 0;
    }

    public boolean isEmpty() {
        if (numEls == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (numEls == maxsize) {
            return true;
        }
        return false;
    }

    public int queryCtail() {
        if (isEmpty()) {
            return -1;

        }
        return queue[tail].getInfo();
    }

    public int maxsize() {
        return maxsize;
    }

    public void showstructure() {
        if (isEmpty()) {
            System.out.println("It is empty");
        } else {
            for (int i = 0; i < maxsize; i++) {
                System.out.println("The content at " + i + " is " + queue[i].getInfo());
            }
            System.out.println("tail " + tail);
            System.out.println("maxsize " + maxsize);
            System.out.println("head " + head);
            System.out.println("numEls " + numEls);

        }

    }

    public int queryindexhead() {
        return head;

    }

    public int queryindextail() {
        return tail;

    }

    public int querypopu() {
        return numEls;
    }

    public int queryChead() {
        if (isEmpty()) {
            return -1;

        }
        return queue[head].getInfo();
    }

}
