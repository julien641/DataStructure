package projectpaging;

import java.util.*;

public class fnfo implements Runnable {
//initializer

    private Thread t;
    private ArrayList<process> harddrive = new ArrayList<>(), memory = new ArrayList<>();
    private final char alphabet[] = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
    private int pageacceses, resident, pagein, pageouts, pagefault, timepaging, clock, howmany = 1000000,algorithem, charcpuindex, msize;
    private double hitratio, freqaveragelocal;
    private String algname;

    public fnfo(int msize, int algorithem) {
        t = Thread.currentThread();
        this.msize = msize;

        //algorithem=0 first in first out
        this.algorithem = algorithem;
        if (algorithem == 0) {
            algname = "firstinfirst out";
        } //algorithem=1 least recently used
        else if (algorithem == 1) {
            algname = "leastrecentlyused";
        } //algorithem=2 random
        else if (algorithem == 2) {
            algname = "random";
        }

    }

    @Override
    //main
    public void run() {
        int pagingout;
        int active1;
        String name;

        fillvirtual();
        try {
            for (int roundrobincount = 0; roundrobincount < howmany; roundrobincount++) {
                name = randomprocess();
                active1 = lookingthroughtmemory(name, 0);

                //paging if not in mem
                if (active1 == -1) {
                    pagefault++;

                    //looking throught memory for ref if all are false
                    pagingout = 0;

                    //choosing algorithem
                    //gives out location in memory to take out
                    if (algorithem == 0) {
                        pagingout = fifo();

                    } else if (algorithem == 1) {
                        pagingout = lru();
                    } else if (algorithem == 2) {

                        pagingout = rspr();

                    }
                    //if memorie is not emptie
                    if (pagingout > -1) {
                        pagefault++;

                        //paging out
                        if (memory.get(pagingout).getcontentbit() == true) {
                            memory.get(pagingout).setcontentbit(false);
                            pageouts++;
                            timepaging += 10;
                        }
                        //paging
                        memory.get(pagingout).setaccesed(0);
                        // memory.get(pagingout).setreferencebit(false);
                        memory.remove(pagingout);
                    }

                    timepaging += 10;
                    //looking throught harddrive for page
                    lookingthroughtharddrive(name);
                    //locating page in memory
                    active1 = lookingthroughtmemory(name, 1);
                }
                //counting
                cpu(active1);
            }
            //bug fixing
        } catch (Throwable e) {
            System.out.println("error");
            System.out.println(e);
        }
        //geting frequency in memory
        freqaveragelocal = pagefreqinmemory();
    }
//get method of hit ratio

    public Double gethitratio() {
        return hitratio;

    }
//output

    public void output() {
        String format = "%-40s%s%n";
        hitratio = ((double) resident / (double) pageacceses) * 100;
        System.out.println(algname + "------" + " memory size " + msize);
        System.out.printf(format, "Count of pages accesses:", pageacceses);
        System.out.printf(format, "Count of PAGES found resident:", resident);
        System.out.printf(format, "Count of PAGEINS", pagein);
        System.out.printf(format, "Count of PAGEOUTS", pageouts);
        System.out.printf(format, "Count of pagefault", pagefault);
        System.out.printf(format, "Time Units spent PAGING", timepaging);
        System.out.printf(format, "Avg Cycles a page is resident", freqaveragelocal);
        System.out.printf(format, "Page Hit Ratio:", hitratio);
        System.out.println("Percentage of Wall Clock time performing paging operations");
        System.out.println("1msec \t 5msec \t 10msec \t 20msec \t 40msec");
        System.out.print(((double) timepaging / ((double) (pageacceses * 1))+(double) timepaging) * 100+"%\t");
        System.out.print(((double) timepaging / (double) (pageacceses * 5)) * 100 + "%\t");
        System.out.print(((double) timepaging / (double) (pageacceses * 10)) * 100 + "%\t");
        System.out.print(((double) timepaging / (double) (pageacceses * 20)) * 100 + "%\t");
        System.out.println(((double) timepaging / (double) (pageacceses * 40)) * 100 + "%\t");
        System.out.println("--------------------------------------------------------------------");
    }

    //adding up all inmemory
    public double pagefreqinmemory() {
        double freqtotal = 0, freqaverage;
        for (int indexhard = 0; indexhard < harddrive.size(); indexhard++) {
            freqtotal += harddrive.get(indexhard).getinmemory();

        }
        return freqaverage = freqtotal / howmany;
    }

    //counting
    public void cpu(int active2) {
        clock++;
        pageacceses++;
        //println("cpu");
        memory.get(active2).setreferencebit(true);
        memory.get(active2).setcontentbit(contentchangerandom());
        memory.get(active2).setaccesed(clock);
    }
//looking throught harddrive for page

    public boolean lookingthroughtharddrive(String name) {
        //println("shiftingthroughtharddrive");
        for (int indexmem = 0; indexmem < harddrive.size(); indexmem++) {
            if (harddrive.get(indexmem).getname().equals(name)) {
                pagein++;
                memory.add(harddrive.get(indexmem));
                return true;

            }
        }
        return false;
    }
//getting my process name

    public String randomprocess() {
        // println("randomprocess");
        String name;
        int random;
        random = getBiasedRand();
        if (charcpuindex > 9) {
            charcpuindex = 0;
        }

        name = alphabet[charcpuindex] + "" + random;
        charcpuindex++;
        return name;
    }

    //first in first out
    public int fifo() {
        int x = 0;
        if (memory.size() == msize) {
                    return x;


        }
        return -1;
    }
//least recently used

    public int lru() {
        int save = 1000000000;
        int x = 0;
        if (memory.size() == msize) {
            for (int indexmem = 0; indexmem < memory.size(); indexmem++) {
                if (save > memory.get(indexmem).getaccesed()) {
                    save = memory.get(indexmem).getaccesed();
                        x = indexmem;
                }
            }

            return x;
        }
        return -1;
    }
//random

    public int rspr() {
        int random;
        if (memory.size() == msize) {
            
                return (int) Math.floor(Math.random() * msize);

        }
        return -1;

    }

    public int lookingthroughtmemory(String name, int x) {
        int get = -1;
        //   println("shiftingthroughtmemory");
        for (int indexmem = 0; indexmem < memory.size(); indexmem++) {
            if (x == 0) {
                memory.get(indexmem).addinmemory(1);
            }
            if (memory.get(indexmem).getname().equals(name)) {
                if (x == 0) {
                    resident++;
                }
                get = indexmem;
            }
        }
        return get;
    }

    public boolean contentchangerandom() {
        double d = Math.random();
        if (d < 0.5) {
            return false;
        } else if (d < 0.7) {
            return true;
        } else {
            return false;
        }
    }

    //random number teachers code
    public int getBiasedRand() {
        int biasednum = 0;
        int num = (int) (Math.random() * 10);
        if (num >= 9) {
            num = (int) (Math.random() * 8);
            biasednum = num;
        } else {
            num = (int) (Math.random() * 2);
            if (num == 0) {
                biasednum = 8;
            } else {
                biasednum = 9;
            }
            return biasednum;
        }
        return biasednum;
    }
//fill hard drive a0 to j9;

    public void fillvirtual() {
        int charindex = 0;
        String name;
        int second = 0;
        for (int hardindexx = 0; hardindexx < 100; hardindexx++) {
            if (second < 10) {
                name = alphabet[charindex] + "" + second;
                second++;
            } else {
                second = 0;
                charindex++;
                name = alphabet[charindex] + "" + second;
                second++;
            }
            harddrive.add(new process(name));

        }

    }

}
