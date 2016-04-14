/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.Dog;
import java.util.Scanner;

/**
 *
 * @author truonghxse616
 */
public class Menu {

    private int count = 0;
    private String[] mn;
    private int tmp;
    private Dog dl[] = new Dog[10];
    Scanner sc = new Scanner(System.in);

    public Menu(String[] mnList) {
        this.mn = mnList;
    }

    public String[] addMenu() {
        int n = 0;
        System.out.print("Please input number of list: ");
        n = Integer.parseInt(sc.nextLine());
        tmp = n;
        for (int i = 1; i <= tmp; i++) {
            System.out.print((i) + ":");
            mn[i] = sc.nextLine().toUpperCase();
        }
        return mn;
    }

    public void printMn() {
        System.out.println("--------------------------------------");
        System.out.println("\tDog Manager Program");

        for (int i = 1; i <= tmp; i++) {
            System.out.println("\t" + i + "." + mn[i]);
        }
        System.out.print("\tPlease choose [1 - " + tmp + "]: ");
    }

    public void addDog() {
        String name = "";
        int a = 0, w = 0, p = 0;
        if (count == dl.length) {
            System.out.println("The list is full.Cannot add any more!");
            return;
        }
        System.out.print("Please input name: ");
        name = sc.nextLine().toUpperCase().trim();
        if (name.trim().toUpperCase().length() == 0) {
            name = sc.next();
        }
        System.out.print("Please input age: ");
        a = Integer.parseInt(sc.nextLine());
        System.out.print("Please input weight: ");
        w = Integer.parseInt(sc.nextLine());
        System.out.print("Please input price: ");
        p = Integer.parseInt(sc.nextLine());
        this.dl[count] = new Dog(name, a, w, p);
        count++;
    }

//    public void addDog(Dog newDog) {
//        Scanner sc = new Scanner(System.in);
//        name = sc.nextLine();
//        newDog.setName(name);
//        System.out.print("Please input age: ");
//        a = sc.nextInt();
//        newDog.setAge(a);
//        System.out.print("Please input weight: ");
//        w = sc.nextInt();
//        newDog.setWeight(w);
//        System.out.print("Please input price: ");
//        p = sc.nextInt();
//        newDog.setPrice(p);
//    }
    public void printList() {
        if (count <= 0) {
            System.out.print("Empty List");
            return;
        }
        System.out.println("List of Dog: ");
        for (int i = 0; i < count; i++) {
            System.out.println(dl[i].toString());
        }
    }

    public int searchDog() {
        String keyword;
        System.out.println("Please input name of dog");
        keyword = sc.nextLine();
        return searchDog(keyword);


    }

    public int searchDog(String keyword) {
        if (count == 0) {
            System.out.println("Is empty!");
            return -1;
        }
        for (int i = 0; i < count; i++) {
            String n = dl[i].getName();
            //if (n.compareTo(keyword.trim()) == 0) {}
            if (n.equalsIgnoreCase(keyword.trim())) {
                return i;
            }
        }
        return -1;
    }

    public Dog searchDogreturnDog(String keyword) {
        int pos;
        pos = searchDog(keyword);
        if (pos == -1) {
            return null;
        } else {
            return dl[pos];
        }
    }

    public void editDog(String name) {
        if (count == 0) {
            System.out.println("Is Empty");
            return;
        }
        Dog tmpDog;
        tmpDog = searchDogreturnDog(name);
        if (tmpDog == null) {
            System.out.println("The dog doesn't exist");
            return;
        }
        System.out.println("The current age is: " + tmpDog.getAge());
        System.out.println("Input the new age: ");
        int tmpBirth = Integer.parseInt(sc.nextLine());
        tmpDog.setAge(tmpBirth);
        System.out.println("Update age sucessfully!");
    }

    public void removeDog(String dogName) {
        if (count == 0) {
            System.out.println("Is Empty");
            return;
        }
        int pos = searchDog(dogName);
        if (pos == -1) {
            System.out.println("Dog doesn't exist!");
            return;
        }
        for (int i = pos; i < count - 1; i++) {
            dl[i] = dl[i + 1];
            count--;
            System.out.println("Remove sucessfully");
        }

    }

    public void sortByname() {
        if (count == 0) {
            System.out.println("Is Empty");
            return;
        }
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                Dog tmpSort, dogA, dogB;
                dogA = dl[i];
                dogB = dl[j];
                if (dogA.getName().compareToIgnoreCase(dogB.getName()) > 0) {
                    // thay the  <0 thi se sap xep giam dan
                    tmpSort = dl[i];
                    dl[i] = dl[j];
                    dl[j] = tmpSort;
                }
            }
        }
        printList();
    }
//    public String[] printList() {
//        if (count != 0) {
//            System.out.println("List of Dog:");
//            for (int i = 0; i < count; i++) {
//                System.out.print("\nDog " + (i + 1) + ":");
//                System.out.println(dl[i].toString());
//            }
//        } else {
//            System.out.print("Empty List");
//        }
//        return;
//    }

    public String choice() {
        String nc = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            nc = sc.nextLine();
            if (!nc.matches("[1-" + tmp + "]")) {
                System.out.println("Please choose again !");
            } else {
                switch (nc) {
                    case "1":
                        addDog();
                        System.out.println("Successful!");
                        printMn();
                        break;
                    case "2":
                        printList();
                        System.out.println("");
                        printMn();
                        break;
                    case "3":
                        System.exit(0);
                        break;
                }
            }
        }
    }
}
