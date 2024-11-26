package ru.inno.consultation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("камень-0, ножницы-1, бумага-2");
        int V = (int) (Math.random()*3);
        int P = (int) (Math.random()*3);

        if(V == 0 && P == 0){
            System.out.println("Ничья");
        } else if ((V == 0 && P == 1) || (V == 1 && P == 2) || (V == 2 && P == 0)) {
            System.out.println("Вася");
        } else {
            System.out.println("Петя");
        }

        if (V==0){
            if (P==0) {
                System.out.println("Ничья");
            } else if (P==1) {
                System.out.println("Вася");
            } else if (P==2) {
                System.out.println("Петя");
            }
        } else if (V==1) {
            if (P == 0) {
                System.out.println("Петя");
            } else if (P == 1) {
                System.out.println("Ничья");
            } else if (P == 2) {
                System.out.println("Вася");
            }
        }
        else if (V==2) {
            if (P==0) {
                System.out.println("Вася");
            }
            else if (P==1) {
                System.out.println("Петя");
            }
            else if (P==2) {
                System.out.println("Ничья"); }
        }
    }
}