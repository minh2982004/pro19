package Thaycacac;


import controller.Manager;
import menu.MenuModel;
import menu.MenuView;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        MenuModel model = new MenuModel();
        MenuView view = new MenuView(model);
        Manager manager = new Manager(model, view);
        manager.startMenu();
    }
}