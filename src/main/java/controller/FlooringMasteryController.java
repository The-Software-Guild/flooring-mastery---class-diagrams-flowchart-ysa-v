package controller;

import dao.FlooringMasteryException;
import service.FlooringMasteryService;
import ui.FlooringMasteryView;

import java.time.LocalDate;
import java.util.Date;

public class FlooringMasteryController {

    private FlooringMasteryView view;
    private FlooringMasteryService service;

    public FlooringMasteryController(FlooringMasteryView view, FlooringMasteryService service) {
        this.view = view;
        this.service = service;
    }

    public void run() throws FlooringMasteryException {
        boolean start = true;

//        try {
            while (start) {
                view.printMenu();
                int operation = view.getMenuSelection();
                switch(operation) {
                    case 1: // display orders
                        view.displayOrdersBanner();
                        String dateInput = view.getDateInput();
//                        Date date =
                        break;
                    case 2: // add order
                        break;
                    case 3: // edit order
                        break;
                    case 4: // remove order
                        break;
                    case 5: // export data
                        break;
                    case 6: /// quit
                        start = false;
                        view.quitMessage();
                        break;
                }
            }
//        } catch (FlooringMasteryException e){
//            view.displayErrorMessage(e.getMessage());
        }
    }

