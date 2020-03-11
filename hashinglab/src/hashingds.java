/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class hashingds {

    private int maxsize;
    private Linktstack stack;
    private int numels;
    private linkedqueue hashtable[];

    public hashingds(int maxsize) {
        this.maxsize = maxsize;
        stack = new Linktstack(maxsize);
        hashtable = new linkedqueue[101];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new linkedqueue(stack);
        }
    }

    public int key(int x) {
        return x % 100;
    }

    public int insert(int input) {
        int key;
        if (full()) {
            return -1;
        }
        numels++;
        key = key(input);
        hashtable[key].insert(input);
        return 0;
    }
    public int find(int value){
         int key;
         int pos;
            if (emptie()) {
            return -1;
        }
            key = key(value);
          pos = hashtable[key].find(value);
          if(pos==-1){
          return -1;
          }
          System.out.println("The key is "+key);
          hashtable[key].queryat(pos);
    
    return 0;
    }

    public int remove(int input) {
        int key;
        int pos;
        if (emptie()) {
            return -1;
        }
        key = key(input);
        pos = hashtable[key].find(input);
        if(pos==-1){
        return -1;
        }
        hashtable[key].removeat(pos);
        numels--;
        return 0;
    }
    public int print(int input){
        
    hashtable[input].showstructurehead();
    return 1;
    }

    public int size(){
    return numels;
    
    }
    public boolean full() {
        if (maxsize == numels) {
            return true;

        } else {
            return false;
        }
    }

    public boolean emptie() {
        if (0 == numels) {
            return true;

        } else {
            return false;
        }

    }

}
