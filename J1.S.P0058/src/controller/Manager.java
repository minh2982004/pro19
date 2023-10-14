package controller;

import j1.s.p0058.Validation;
import menu.MenuModel;
import menu.MenuView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Manager {

    Validation vali = new Validation();
    private MenuModel model;
    private MenuView view;

    public Manager(MenuModel model, MenuView view) {
        this.model = model;
        this.view = view;
    }

    public void startMenu() {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> hm = new HashMap<>();
        while (true) {
            view.Menu();
            int choice = view.UserChoice();

            switch (choice) {
                case 1:
                    addNewWord(hm);
                    break;
                case 2:
                    deleteWord(hm);
                    break;
                case 3:
                    translate(hm);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void addNewWord(HashMap<String, String> hm) {
        System.out.print("Enter Enlish: ");
        String english = vali.checkInputString();
        if (!checkKeywordExist(hm, english)) {
            if (!vali.checkInputYN()) {
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vietnam = vali.checkInputString();
        //check key word english exist or not
        hm.put(english, vietnam);
        System.err.println("Add successful.");
    }

    public void deleteWord(HashMap<String, String> hm) {
        System.out.print("Enter english: ");
        String english = vali.checkInputString();
        hm.remove(english);
        System.err.println("Delete successful.");
    }

    public void translate(HashMap<String, String> hm) {
        System.out.print("Enter english: ");
        String english = vali.checkInputString();
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry entry : entries) {
            if (entry.getKey().equals(english)) {
                System.out.println("Vietnamese: " + entry.getValue());
                return;
            }
        }
        System.err.println("Not found in data");
    }

    public boolean checkKeywordExist(HashMap<String, String> hm, String english) {
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (english.equalsIgnoreCase(mentry.getKey().toString())) {
                return false;
            }
        }
        return true;
    }
}
