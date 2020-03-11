/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

public class Hashinglab {

    private int rc = 0;
    private int intrc = 0;
    private boolean boolrc = false;
    private int input;
    private int maxsize = 10;
    private int request = 0;
    private Object inputobject = null;
    private NodeElement rcnode = null;
    private hashingds ds = null;
    private boolean keepgoing = true;
    static int src = 0;

    public static void main(String[] args) {
        Hashinglab t = new Hashinglab();
        src = t.process();
    }

    public int process() {
        String keyline;
        ds = new hashingds(10000);
        Scanner sc = new Scanner(System.in);

        for (;;) /* Do Forever */ {
            System.out.println(" ");
            System.out.println("1  // Insert elements into the hash table ");
            System.out.println("2  // from file ");
            System.out.println("3  // display all entries for a key");
            System.out.println("4  // find value for a given value ");
            System.out.println("5  // delete a particular element ");
            System.out.println("6  // print out the whole hash ");
            System.out.println("7  // populate"); //populate
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
                case 1:// Insert elements into the hash table
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
                            rc = ds.insert(input);
                            if (rc == -1) {
                                System.out.println("OVERFLOW");
                            }
                        }
                    }
                    break;
                }
                case 2: {//  from file
                    break;
                }
                case 3:// display all entries for a key
                {

                    System.out.println("Print at what key 0-99");
                    inputobject = sc.nextLine();
                    try {
                        input = Integer.parseInt((String) inputobject);
                    } catch (NumberFormatException e) {
                        System.out.println("Non-integer detected");
                        keepgoing = false;
                        break;
                    }
                    if (input >= 0 && input <= 99) {
                        rc = ds.print(input);
                        if (rc == -1) {
                            System.out.println("OVERFLOW");
                        }
                    } else {
                        System.out.println("invalid key");
                    }
                    break;
                }
                case 4:// find element for a given value
                {

                    System.out.println(" find element for a given value");
                    inputobject = sc.nextLine();
                    try {
                        input = Integer.parseInt((String) inputobject);
                    } catch (NumberFormatException e) {
                        System.out.println("Non-integer detected");
                        keepgoing = false;
                        break;
                    }
                    rc = ds.find(input);
                    if (rc == -1) {
                        System.out.println("not found");
                    }

                    break;
                }

                case 5:// delete a particular element
                {

                    System.out.println("delete a particular element");
                    inputobject = sc.nextLine();
                    try {
                        input = Integer.parseInt((String) inputobject);
                    } catch (NumberFormatException e) {
                        System.out.println("Non-integer detected");
                        keepgoing = false;
                        break;
                    }
                    rc = ds.remove(input);
                    if (rc == -1) {
                        System.out.println("underflow");
                    }
                    break;

                }
                case 6://print out the whole hash
                {
                    System.out.println("The size is " + ds.size());
                    for (int i = 0; i < 100; i++) {
                        System.out.println("the key is " + i);
                        rc = ds.print(i);
                    }
                    break;
                }
                case 7://populate
                {
                    int in;
                    System.out.println("How many elements do you want to populate?");

                    inputobject = sc.nextLine();
                    try {
                        input = Integer.parseInt((String) inputobject);

                    } catch (NumberFormatException e) {
                        System.out.println("Non-integer detected");
                        break;
                    }
                    for (int i = 0; i < input; i++) {
                        in = (int) (Math.random() * 1000);
                        rc = ds.insert(in);
                        if (rc == -1) {
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

