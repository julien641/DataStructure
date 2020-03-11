/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
import java.util.Scanner;

public class Linkedqueuetest {

    private int rc = 0;
    private int intrc = 0;
    private boolean boolrc = false;
    private int input;
    private int maxsize = 10;
    private int request = 0;
    private Object inputobject = null;
    private linkedqueue ds = null;
    private boolean keepgoing = true;
    static int src = 0;

    public static void main(String[] args) {
        Linkedqueuetest t = new Linkedqueuetest();
        src = t.process();
    }

    public int process() {
        String keyline;
        ds = new linkedqueue();
        Scanner sc = new Scanner(System.in);

        for (;;) /* Do Forever */ {
            System.out.println(" ");
            System.out.println("1  // insert a number in the queue");
            System.out.println("2  // insert a number at a certain position in the queue");
            System.out.println("3  // remove the first element from the queue");
            System.out.println("4  // Remove a number at a position in the queue ");
            System.out.println("5  // Query the size ");
            System.out.println("6  // show the contents starting at the head of the entire data structure ");
            System.out.println("7  // Query the tail");
            System.out.println("8  // Query the head");
            System.out.println("9  // Populate data structure with random numbers ");
            System.out.println("10 // Find a value in the structure");
            System.out.println("11 // Query a node in the structure");
            System.out.println("12 // show the contents starting at the tail of the entire data structure ");
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
                case 1:// insert a number in the queue
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
                              ds.showstructurehead();
                            if (boolrc == false) {
                                System.out.println("OVERFLOW");
                            }
                        }
                    }
                    break;
                }
                case 2: {//insert at a position
                    String pos;
                    int x;
                    System.out.println("enter an element to the queue");
                    inputobject = sc.nextLine();
                    System.out.println("At what position");
                    pos = sc.nextLine();
                    try {
                        input = Integer.parseInt((String) inputobject);
                        x = Integer.parseInt((String) pos);

                    } catch (NumberFormatException e) {
                        System.out.println("Non-integer detected");
                        break;
                    }
                    if (input > 0) {
                        boolrc = ds.insertat(x, input);
                        ds.showstructurehead();
                        if (boolrc == false) {
                            System.out.println("OVERFLOW");
                        }
                    } else {
                        System.out.println("Invalid number");
                    }
                    break;
                }
                case 3:// remove the first element from the queue"
                {
                    rc = ds.remove();
                    if (rc < 0) {
                        System.out.println("UNDERFLOW or OVERFLOW or Empty position (RC=" + rc + ")");
                        break;
                    }
                       ds.showstructurehead();
                    break;
                }
                case 4:// Remove a number at a position in the queue
                {

                    System.out.println("At what position");
                    inputobject = sc.nextLine();
                    try {
                        input = Integer.parseInt((String) inputobject);

                    } catch (NumberFormatException e) {
                        System.out.println("Non-integer detected");
                        break;
                    }
                    if (input > 0) {
                        rc = ds.removeat(input);
                        ds.showstructurehead();
                        if (rc == -1) {
                            System.out.println("underflow");
                        }
                    } else {
                        System.out.println("Invalid input");
                    }
                    break;
                }

                case 5:// Query the size 
                {
                    System.out.println("the number of element is " + ds.querypop());
                    break;
                }

                case 6:// show the contents of the entire data structure
                //rc =-1
                {
                    ds.showstructurehead();

                    break;
                }
                case 7: // Query the tail
                //rc =-1
                {
                    System.out.println("the tail index is " + ds.querytail() + " and the content is " + ds.querytailcontents());
                    break;
                }

                case 8://Query the head
                {
                    System.out.println("The head index is " + ds.queryhead() + " and the content is " + ds.queryheadcontext());
                    break;

                }
                case 9:// Populate data structure with random numbers
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
                        in = (int) (Math.random() * 100);
                        boolrc = ds.insert(in);
                        if (boolrc == false) {
                            System.out.println("OVERFLOW");
                            break;
                        }

                    }

                    break;
                }

                case 10: {//find value
                    System.out.println("What value do you want to find in the structure");
                    inputobject = sc.nextLine();
                    try {
                        input = Integer.parseInt((String) inputobject);

                    } catch (NumberFormatException e) {
                        System.out.println("Non-integer detected");
                        break;
                    }
                    rc = ds.find(input);
                    if (rc != -1) {
                        System.out.println("The value " + input + " is located at " + rc);
                    } else {
                        System.out.println("The value " + input + " is not found");

                    }

                    break;
                }
                case 11: {//query at
                    System.out.println("which node do you want to find in the structure");
                    inputobject = sc.nextLine();
                    try {
                        input = Integer.parseInt((String) inputobject);

                    } catch (NumberFormatException e) {
                        System.out.println("Non-integer detected");
                        break;
                    }
                    rc = ds.queryat(input);
                    if (rc == -1) {
                        System.out.println("The node at " + input + " is not found");
                    }

                    break;
                }
                case 12: {
                    ds.showstructuretail();

                    break;
                }case 13: {


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

