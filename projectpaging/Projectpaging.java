/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpaging;

/**
 *
 * @author julien
 */
public class Projectpaging {

    public static void main(String[] args) {
        start();

    }

    public static void start() {

        fnfo event1 = new fnfo(16, 0);
        Thread t1 = new Thread(event1);
        t1.start();

        fnfo event2 = new fnfo(32, 0);
        Thread t2 = new Thread(event2);
        t2.start();

        fnfo event3 = new fnfo(64, 0);
        Thread t3 = new Thread(event3);
        t3.start();

        fnfo event4 = new fnfo(128, 0);
        Thread t4 = new Thread(event4);
        t4.start();

        fnfo event5 = new fnfo(16, 1);
        Thread t5 = new Thread(event5);
        t5.start();

        fnfo event6 = new fnfo(32, 1);
        Thread t6 = new Thread(event6);
        t6.start();

        fnfo event7 = new fnfo(64, 1);
        Thread t7 = new Thread(event7);
        t7.start();

        fnfo event8 = new fnfo(128, 1);
        Thread t8 = new Thread(event8);
        t8.start();

        fnfo event9 = new fnfo(16, 2);
        Thread t9 = new Thread(event9);
        t9.start();

        fnfo event10 = new fnfo(32, 2);
        Thread t10 = new Thread(event10);
        t10.start();

        fnfo event11 = new fnfo(64, 2);
        Thread t11 = new Thread(event11);
        t11.start();

        fnfo event12 = new fnfo(128, 2);
        Thread t12 = new Thread(event12);
        t12.start();

        boolean t = false;
        do {
            if (!t12.isAlive()) {

                if (!t11.isAlive()) {
                    if (!t10.isAlive()) {
                        if (!t9.isAlive()) {
                            if (!t8.isAlive()) {
                                if (!t7.isAlive()) {
                                    if (!t6.isAlive()) {
                                        if (!t5.isAlive()) {
                                            if (!t4.isAlive()) {
                                                if (!t3.isAlive()) {
                                                    if (!t2.isAlive()) {

                                                        if (!t1.isAlive()) {
                                                            t = true;
                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } while (false == t);

        event1.output();

        event2.output();
        event3.output();
        event4.output();
        event5.output();
        event6.output();
        event7.output();
        event8.output();
        event9.output();
        event10.output();
        event11.output();

        event12.output();

        //16 mem
        System.out.println("best hit ratio for 16 memory" );
        if (event1.gethitratio() >= event5.gethitratio() && event1.gethitratio() >= event9.gethitratio()) {
            System.out.println("first in first out");
        } else if (event5.gethitratio() >= event1.gethitratio() && event5.gethitratio() >= event9.gethitratio()) {

            System.out.println("leastrecentlyused");
        } else if (event9.gethitratio() >= event1.gethitratio() && event9.gethitratio() >= event5.gethitratio()) {
            System.out.println("Random");
        }

        System.out.println("best hit ratio for 32 memory");
        if (event2.gethitratio() >= event6.gethitratio() && event2.gethitratio() >= event10.gethitratio()) {
            System.out.println("first in first out");
        } else if (event6.gethitratio() >= event2.gethitratio() && event6.gethitratio() >= event9.gethitratio()) {

            System.out.println("leastrecentlyused");
        } else if (event10.gethitratio() >= event2.gethitratio() && event10.gethitratio() >= event6.gethitratio()) {
            System.out.println("Random");
        }

        System.out.println("best hit ratio for 64 memory");
        if (event3.gethitratio() >= event7.gethitratio() && event3.gethitratio() >= event11.gethitratio()) {
            System.out.println("first in first out");
        } else if (event7.gethitratio() >= event3.gethitratio() && event7.gethitratio() >= event11.gethitratio()) {

            System.out.println("leastrecentlyused");
        } else if (event11.gethitratio() >= event3.gethitratio() && event11.gethitratio() >= event7.gethitratio()) {
            System.out.println("Random");

        }
        System.out.println("best hit ratio for 128 memory");
        System.out.println("they are equal");

    }
}
