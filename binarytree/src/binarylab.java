/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

public class binarylab {

    private int rc = 0;
    private int intrc = 0;
    private boolean boolrc = false;
    private int input;
    private int maxsize = 1000;
    private int request = 0;
    private Object inputobject = null;
    private node rcnode = null;
    private Binarytree ds = null;
    private boolean keepgoing = true;
    static int src = 0;

    public static void main(String[] args) {
        binarylab t = new binarylab();
        src = t.process();
    }

    public int process() {
        String keyline;
        ds = new Binarytree(maxsize);
        Scanner sc = new Scanner(System.in);

        for (;;) /* Do Forever */ {
            System.out.println(" ");
            System.out.println("1  // Insert elements into the Tree ");
            System.out.println("2  //  Insert one element onto the Tree ");
            System.out.println("3  // Query the Root of the Tree");
            System.out.println("4  // Query the Current size of the Tree ");
            System.out.println("5  // Traverse the Tree (preorder) ");
            System.out.println("6  //  Traverse the Tree (inorder)  ");
            System.out.println("7  //  Traverse the Tree (postorder) ");
            System.out.println("8  // Prune the Tree to nothing ");
            System.out.println("9  //  Traverse the Tree (inverseorder) ");
            System.out.println("10 //  populate");
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
                            rc = ds.insert(ds.queryroot(), input);
                            if (rc == -1) {
                                System.out.println("OVERFLOW");
                            }
                        }
                    }
                    break;
                }
                case 2: {//  Insert one element onto the Tree
                    String pos;
                    int x;
                    System.out.println("enter an element to the queue");
                    inputobject = sc.nextLine();
                    try {
                        input = Integer.parseInt((String) inputobject);

                    } catch (NumberFormatException e) {
                        System.out.println("Non-integer detected");
                        break;
                    }
                    if (input > 0) {
                        ds.insert(ds.queryroot(), input);
                        if (boolrc == false) {
                            System.out.println("OVERFLOW");
                        }
                    } else {
                        System.out.println("Invalid number");
                    }
                    break;
                }
                case 3:// / Query the Root of the Tree
                {
                    rc = ds.queryroot();
                    if (rc != -1) {
                        System.out.println("The information in the root is " + ds.stack.item[rc].info);
                        System.out.println("The left child in the root is " + ds.stack.item[rc].lchild);
                        System.out.println("The right child in the root is " + ds.stack.item[rc].rchild);
                        System.out.println("The parent in the root is " + ds.stack.item[rc].parent);
                    } else {
                        System.out.println("Tree is emptie");

                    }
                    break;
                }
                case 4:// Query the Current size of the Tree
                {

                    System.out.println("The size of the tree is " + ds.numels);

                    break;
                }

                case 5:// Traverse the Tree (preorder) 
                {
                    ds.preorder();

                    break;
                }

                case 6: {//  Traverse the Tree (inorder)
                    //rc =-1

                    ds.inorder();

                    break;
                }
                case 7: {

                    ds.postorder();

                    break;

                }

                case 8://prune(int node)
                {
                    ds.prune();

                    break;
                }
                case 9: {
                    ds.inverseorder();
                    break;
                }
                case 10: {
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
                        rc = ds.insert(ds.queryroot(), in);
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

