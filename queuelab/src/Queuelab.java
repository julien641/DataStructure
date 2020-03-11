/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

public class Queuelab {

    private int rc = 0;
    private int intrc = 0;
    private boolean boolrc = false;
    private int input;
    private int maxsize = 10;
    private int request = 0;
    private Object inputobject = null;
    private pipequeueds ds = null;
    private boolean keepgoing = true;
    static int src = 0;

    public static void main(String[] args) {
        Queuelab t = new Queuelab();
        src = t.process();
    }

    public int process() {
        String keyline;
        ds = new pipequeueds(maxsize);
        Scanner sc = new Scanner(System.in);

        for (;;) /* Do Forever */ {
            System.out.println(" ");
            System.out.println("1  // insert a number in the queue");
            System.out.println("2  // remove the first element from the queue");
            System.out.println("3  // query the first element in the queue ");
            System.out.println("4  // Query the size ");
            System.out.println("5  // Query the Maximum size ");
            System.out.println("6  // show the contents of the entire data structure ");
            System.out.println("7  // Query the tail");
            System.out.println("8  // Query the head");
            System.out.println("9 // Populate data structure with random numbers ");
            System.out.println("0  // Exit \n");

            keyline = sc.nextLine();
            keyline = keyline.trim();
            if (keyline.length() == 0) {
                System.out.println("Nothing entered, retry");
                continue;
            }
            try {
                request = Integer.parseInt((String) keyline);
            } catch (NumberFormatException e) {
                System.out.println("Non-integer detected");
                continue;
            }

            switch (request) {

                case 0: {
                    System.out.println("Exiting...");
                    return 0;
                }
                case 1:// push an element to the stack"
                {
                    keepgoing = true;
                    for (;;) {
                        if (keepgoing) {
                            System.out.println("enter an element to the queue");
                            inputobject = sc.nextLine();
                            try {
                                input = Integer.parseInt((String) inputobject);
                            } catch (NumberFormatException e) {
                                System.out.println("Non-integer detected");
                                keepgoing = false;
                                break;
                            }
                            boolrc = ds.insert(input);
                            if (boolrc == false) {
                                System.out.println("OVERFLOW");
                            }
                        }
                    }
                    break;
                }
                case 2:// pop one element from the Array
                {
                    rc = ds.removal();
                    if (rc < 0) {
                        System.out.println("UNDERFLOW or OVERFLOW or Empty position (RC=" + rc + ")");
                        break;
                    }
                    break;
                }
                case 3:// Query the first elements in the Array
                {
                    int rc = ds.queryChead();
                    if (rc >= 0) {
                        System.out.println("The element at " + ds.queryindexhead() + " is " + rc);
                    } else {
                        System.out.println("The stack is empty. The rc code is " + rc);
                    }

                    //for (int ix = 0; ix < ds.querymaxsize(); ix++) {
                    //    System.out.println("The contents at slot " + ix + " is " + ds.queryElement(ix));
                    // }
                    break;
                }
                case 4:// Query the size
                {
                    System.out.println("the number of element is " + ds.querypopu());
                    break;
                }
                case 5:// Query the Maximum array size
                {
                    System.out.println("The maximum size is " + ds.maxsize());
                    break;
                }
                case 6:// show structure
                //rc =-1
                {
                    ds.showstructure();
                    break;
                }
                case 7:// tail
                //rc =-1
                {
             System.out.println("the tail index is "+ds.queryindextail()+" and the content is "+ds.queryCtail());
                    break;
                }
                case 8:// head
                //rc =-1
                {
                    System.out.println("The head index is "+ds.queryindexhead()+" and the content is "+ds.queryChead());
                    break;
                }

                case 9:// populate
                {
                    for (int i = 0; i < maxsize; i++) {
                        input = (int) (Math.random() * 100);
                        boolrc = ds.insert(input);
                        if (boolrc == false) {
                            System.out.println("OVERFLOW");
                            break;
                        }
                    }
                    break;

                }

                default: {
                    System.out.println("Not a valid option");
                    break;
                }
            } // end switch
        }
    } // end process

} // end class

