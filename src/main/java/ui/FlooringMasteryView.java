package ui;

public class FlooringMasteryView {

    private UserIO io;

    public FlooringMasteryView () { io = new UserIOImpl(); }

    public FlooringMasteryView (UserIO io) { this.io = io; }

    // print main menu
    public void printMenu() {
        mainMenuBanner();
        io.print("1. Display all Orders");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Export All Data");
        io.print("6. Quit");
    }

    public int getItemSelection(){
        return io.readInt("Please select an item");
    }

    public void mainMenuBanner(){
        io.print("======Main Menu========");
    }

    public void addOrderBanner(){
        io.print("======Add Order========");
    }

    public void editOrderBanner(){
        io.print("======Edit Order========");
    }

    public void removeOrderBanner(){
        io.print("======Remove Order========");
    }

    public void exportDataBanner(){
        io.print("======Export Data========");
    }

    public void quitMessage(){
        io.print("Goodbye" + "\n");
    }
}
