/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpaging;

import java.util.*;

public class process {

    private String name;
    private boolean referencebit;
    private boolean contentbit;
    private int storage;
    private int accesed;
    private int inmemory = 0;

    public process(String name) {
        this.name = name;
        referencebit = false;
        contentbit = false;
        accesed = 0;
    }

    public int getinmemory() {
        return inmemory;
    }

    public void addinmemory(int x) {
        inmemory = inmemory + x;

    }

    public void setaccesed(int accesed) {
        this.accesed = accesed;
    }

    public int getaccesed() {
        return accesed;

    }

    public String getname() {
        return name;
    }

    public boolean getreferencebit() {
        return referencebit;
    }

    public boolean getcontentbit() {
        return contentbit;
    }

    public void setreferencebit(boolean x) {
        referencebit = x;
    }

    public void setcontentbit(boolean x) {
        contentbit = x;
    }
}
