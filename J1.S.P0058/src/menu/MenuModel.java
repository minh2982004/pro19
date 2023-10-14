package menu;



public class MenuModel {
    private String[] menuItems = {
        "Add new word.",
        "Delete word.",
        "Search word.",
        "Exit"
    };

    private int selectedMenuItem;

    public String[] getMenuItems() {
        return menuItems;
    }

    public void setSelectedMenuItem(int selectedMenuItem) {
        this.selectedMenuItem = selectedMenuItem;
    }

    public int getSelectedMenuItem() {
        return selectedMenuItem;
    }
}
