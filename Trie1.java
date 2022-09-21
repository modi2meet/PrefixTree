package Trie;
import java.util.*;
public class Trie1 {
    public Node root = new Node();
    public void add(String word) {
        Node node = root;
        int i;char j;
        for (i = 0; i < word.length(); i++) {
            j=Character.toLowerCase(word.charAt(i));
            if (!node.containsKey(j)){
                node.put(j, new Node());
            }
            node = node.get(j);
            node.increasePrefix();
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        int i;char j;
        for (i = 0; i < word.length(); i++) {
            j=Character.toLowerCase(word.charAt(i));
            if (!node.containsKey(j)) {
                return false;
            }
            node = node.get(j);
        }
        return node.isEnd();
    }

    void delete(String word) {
        Node node = root;
        int i;char j;
        for (i = 0; i < word.length(); i++) {
            j=Character.toLowerCase(word.charAt(i));
            if (node.containsKey(j)){
                node = node.get(j);
                node.reducePrefix();
            } else {
                return;
            }
        }
        node.deleteEnd();
    }
    
    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int ch;
        String str;
        do {
            System.out.println("\t\tTrie Menu");
            System.out.println("\t\t1.Add");
            System.out.println("\t\t2.Delete");
            System.out.println("\t\t3.Search");
            System.out.println("\t\t4.Exit");
            System.out.print("\t\tPlease enter a choice.");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    System.out.println("Enter keyword to be added");
                    str = sc.nextLine();
                    add(str);
                    break;
                case 2:
                    System.out.println("Enter keyword to be deleted");
                    str = sc.nextLine();
                    break;
                case 3:
                    System.out.println("Please enter search term");
                    str = sc.nextLine();
                    System.out.println(search(str));
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid Input. Please try again.");
            }
        } while (ch != 4);
    }
    public static void main(String args[]) {
        Trie1 obj = new Trie1();
        obj.mainMenu();
    }
}