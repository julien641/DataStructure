package arraylab;

import java.util.*;

public class Arraylab {

    private int rc = 0;
    private int intrc = 0;
    private boolean boolrc = false;
    private int input;
    private int maxsize = 30;
    private int request = 0;
    private Object inputobject = null;
    private arrayds ds = null;
    private boolean keepgoing = true;
    static int src = 0;

    public static void main(String[] args) {
        Arraylab t = new Arraylab();
        src = t.process();
    }

    public int process() {
        String keyline;
        ds = new arrayds(maxsize);
        Scanner sc = new Scanner(System.in);

        for (;;) /* Do Forever */ {
            System.out.println(" ");
            System.out.println("1  // Add an element to the Array");
            System.out.println("2  // Remove one element from the Array ");
            System.out.println("3  // Query all the elements in the Array ");
            System.out.println("4  // Query the Current array size ");
            System.out.println("5  // Query the Maximum array size ");
            System.out.println("6  // Update one element in the Array ");
            System.out.println("7  // Find element ");
            System.out.println("8  // Perform a binary search for an element ");
            System.out.println("9  // Sort elements ");
            System.out.println("10 // Populate data structure with random numbers ");
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
                case 1:// Add an element to the Array"
                {
                    keepgoing = true;
                    for (;;) {
                        if (keepgoing) {
                            System.out.println("Enter an element to add to the Array");
                            inputobject = sc.nextLine();
                            try {
                                input = Integer.parseInt((String) inputobject);
                            } catch (NumberFormatException e) {
                                System.out.println("Non-integer detected");
                                keepgoing = false;
                                break;
                            }
                            boolrc = ds.addElement(input);
                            if (boolrc == false) {
                                System.out.println("OVERFLOW");
                            }
                        }
                    }
                    break;
                }
                case 2:// Remove one element from the Array
                {
                    System.out.println("Enter the slot you want removed from the Structure");
                    keyline = sc.nextLine();
                    keyline = keyline.trim();
                    input = Integer.parseInt(keyline);
                    rc = ds.removeElement(input);
                    if (rc < 0) {
                        System.out.println("UNDERFLOW or OVERFLOW or Empty position (RC=" + rc + ")");
                    }
                    break;
                }
                case 3:// Query all the elements in the Array
                {
                    for (int ix = 0; ix < ds.queryMaxSize(); ix++) {
                        System.out.println("The contents at slot " + ix + " is " + ds.queryElement(ix));
                    }
                    break;
                }
                case 4:// Query the Current array size
                {
                    System.out.println("The current populated size is " + ds.querySize());
                    break;
                }
                case 5:// Query the Maximum array size
                {
                    System.out.println("The maximum size is " + ds.queryMaxSize());
                    break;
                }
                case 6:// Update one element in the Array
                //rc =-1
                {
                    System.out.println("Enter a slot you would like updated");
                    keyline = sc.nextLine();
                    keyline = keyline.trim();
                    int slot = Integer.parseInt(keyline);
                    rc = ds.queryElement(slot);
                    if (rc < 0) {
                        System.out.println("UNDERFLOW, OVERFLOW or Empty position specified (RC=" + rc + ")");
                        break;
                    }
                    System.out.println("Enter the new value");
                    keyline = sc.nextLine();
                    keyline = keyline.trim();
                    input = Integer.parseInt(keyline);
                    rc = ds.updateElement(slot, input);
                    if (rc < 0) {
                        System.out.println("Update failed (RC=" + rc + ")");
                    } else {
                        System.out.println("Update successful");
                    }
                    break;
                }
                case 7:// Find element
                {
                    System.out.println("Enter the element you wish to find");
                    keyline = sc.nextLine();
                    keyline = keyline.trim();
                    input = Integer.parseInt(keyline);
                    intrc = ds.findElement(input);
                    if (intrc == -1) {
                        System.out.println("Not Found");
                    } else {
                        System.out.println("Found element " + input + " at slot " + intrc);
                    }
                    break;
                }
                case 8:// Perform a binary search for an element
                {
                    System.out.println("Enter the element you wish to search for");
                    keyline = sc.nextLine();
                    keyline = keyline.trim();
                    input = Integer.parseInt(keyline);
                    intrc = ds.search(input, 0, ds.queryMaxSize() - 1);
                    if (intrc == -1) {
                        System.out.println("Not Found");
                    } else {
                        System.out.println("Found element " + input + " at slot " + intrc);
                    }
                    break;

                }
                case 9:// Sort elements
                {
                    intrc = ds.qsort();
                    break;
                }
                case 10:// Populate data structure with random numbers
                {
                    for (int i = 0; i < maxsize; i++) {
                        input = (int) (Math.random() * 100);
                        boolrc = ds.addElement(input);
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
