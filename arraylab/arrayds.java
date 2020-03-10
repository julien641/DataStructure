/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylab;

public class arrayds {

    private int maxsize;
    private NodeElement item[];
    private int numels;

    public arrayds(int maxsize) {
        this.maxsize = maxsize;
        item = new NodeElement[maxsize];
        for (int i = 0; i < maxsize; i++) {
            item[i] = new NodeElement();
            item[i].setInfo(-1);
        }

    }

    public int qsort() {
        int temp;
        if (isempty()) {
            return -1;
        }
        int swap = 0, pass = 0, comparison = 0;

        for (int i = maxsize - 1; 0 < i; i--) {
            for (int j = 0; j < i; j++) {
                comparison++;
                if (item[j].info > item[j + 1].info && item[j].info != -1 && item[j + 1].info != -1) {

                    swap++;
                    temp = item[j].info;
                    item[j].info = item[j + 1].info;
                    item[j + 1].info = temp;
                    for (int in = 0; in < maxsize; in++) {
                        System.out.print(queryElement(in) + " ");
                    }
                    System.out.println();
                } else {
                    pass++;

                }
            }

        }
        System.out.println("swap " + swap + " pass " + pass + "comparison" + comparison);
        return 0;
    }

    public boolean isfull() {
        if (maxsize == numels) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isempty() {
        if (numels == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int queryMaxSize() {
        return maxsize;
    }

    public int querySize() {
        return numels;
    }

    public int updateElement(int pos, int input) {
        int rc = removeElement(pos);
        if (rc == -2) {
            return rc;
        }
        item[pos].setInfo(input);
        numels++;
        return 0;
    }

    public boolean addElement(int x) {
        if (isfull()) {
            return false;
        }
        for (int in = 0; in < maxsize; in++) {
            if (item[in].getInfo() == -1) {
                item[in].setInfo(x);
                numels++;
                break;
            }
        }
        return true;
    }

    public int findElement(int input) {
        for (int index = 0; index < maxsize; index++) {
            if (item[index].getInfo() == input) {
                return index;
            }
        }

        return -1;
    }

    public int removeElement(int x) {
        if (x < 0 || x >= maxsize) {
            return -2;
        } else if (item[x].getInfo() == -1) {
            return -1;

        } else {
            item[x].setInfo(-1);
            numels--;
            return 0;
        }

    }

    public int queryElement(int x) {
        if (x >= maxsize) {
            return -1;
        }
        if (x <= -1) {
            return -2;
        }
        return item[x].getInfo();
    }

    public int search(int x, int low, int high) {
        int mid;
        if (high < low) {
            return -1;
        }
        mid = (high + low) / 2;
        System.out.println(mid);

        if (item[mid].getInfo() < x) {
            mid = search(x, mid + 1, high);
        } else if (item[mid].getInfo() > x) {
            mid = search(x, low, mid - 1);
        }
        return mid;

    }

}/*
 NodeElement sort[] = new NodeElement[numels];
        boolean x = false;
        int small = 0;
        int indexus = 0;
        for (int i = 0; i < numels; i++) {
            sort[i] = new NodeElement();
            sort[i].setInfo(-1);
        }
        System.out.println(numels);
        for (int so = 0; so < numels; so++) {

            for (int sor = 0; sor < numels; sor++) {
                if (x == true) {
                    if (item[sor].getInfo() < small && item[sor].getInfo() != -1) {
                        small = item[sor].getInfo();
                        indexus = sor;

                    }
                }
                if (x == false && item[sor].getInfo() != -1) {//first
                    small = item[sor].getInfo();
                    x = true;
                    indexus = sor;
                }
            }
            x = false;

            sort[so].setInfo(small);
            item[indexus].setInfo(-1);
            small = 0;
        }
        for (int index = 0; index < numels; index++) {
            item[index].setInfo((sort[index].getInfo()));
        }
 */
