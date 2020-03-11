/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class Paranthese {

    private int stack;
    private int index = -1;
    private int openchar;
    private int closechar;
    private String keyline;

    public static void main(String[] args) {
        Paranthese program = new Paranthese();
        program.start();
    }

    public void start() {
        for (;;) {
            stack = 0;
            index = -1;
            openchar = 0;
            closechar = 0;
            System.out.println("Enter a string");
            Scanner sc = new Scanner(System.in);
            keyline = sc.nextLine();
            if (keyline.length() == 0) {
                System.out.println("Nothing entered");
                break;
            } else {
                recursivemethod();
                answer();
            }
        }

    }

    public int recursivemethod() {
        index++;

        if (index > keyline.length() - 1) {
            return 0;
        }

        if (keyline.charAt(index) == '(') {
            openchar++;
        }
        if (keyline.charAt(index) == ')') {
            closechar++;
        }

        if (stack == -1) {

        } else if (keyline.charAt(index) == ')') {
            stack--;

        } else if (keyline.charAt(index) == '(') {
            stack++;

        }
        recursivemethod();

        return 0;
    }

    public void answer() {
        String isvalid = " invalid";
        String isbalanced = " not balanced";

        if (openchar == closechar) {
            isbalanced = "balanced";
        }

        if (stack == 0) {
            isvalid = "valid";
        }
            if (openchar > 0 || closechar > 0) {
                System.out.println("The parentheses are " + isbalanced + " and " + isvalid);
            } else {
                System.out.println("Their was no parentheses in the string");

            }
        }

    }

