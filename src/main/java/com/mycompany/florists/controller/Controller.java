package com.mycompany.florists.controller;

import com.mycompany.florists.ServerInterface;
import com.mycompany.florists.model.PriceList;
import com.mycompany.florists.model.ProofOfPurchase;
import com.mycompany.florists.model.FactoryFlyweight;
import com.mycompany.florists.model.BussinesCustomer;
import com.mycompany.florists.model.IndividualCustomer;
import com.mycompany.florists.model.ColourName.Colours;
import com.mycompany.florists.view.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import com.mycompany.florists.model.Customer;
import com.mycompany.florists.model.Flower;

/**
 * Responsible for application logic.
 *
 * @author Sławomir Kowalczyk
 */
public class Controller implements ActionListener {

    /**
     * Instance of the server to communicate with our controller (model).
     */
    private ServerInterface server;
    /**
     * Main window of our application(view).
     */
    private MainFrame mainFrame;
    /**
     * Shop user instance(model).
     */
    private Customer customer;

    /**
     * Creates a new controller attached to server (server) and view
     * (mainFrame).
     *
     * @param server Server instance.
     * @param mainFrame Main window instance.
     */
    public Controller(ServerInterface server, MainFrame mainFrame) {
        this.server = server;
        this.mainFrame = mainFrame;
        this.mainFrame.addActionListener(this);
    }

    /**
     * The method sorts the list of Strings alphabetically.
     *
     * @param list A list to be sorted.
     */
    public static void sortList(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    /**
     * The method is responsible for receiving information from the main window
     * (mainFrame) and communicating with the server (server).
     *
     * @param e Event derived from view.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("INDIVIDUAL".equals(e.getActionCommand())) {
            customer = new IndividualCustomer();
            mainFrame.setVisibleCustomerChoose(false);
            mainFrame.setVisibleShop(true);
            server.connect();

            PriceList priceList = server.getPriceList();
            List<String> flowers = new ArrayList();
            List<String> accessories = new ArrayList();
            for (Map.Entry<String, Double> en : priceList.getPriceList().entrySet()) {
                if (en.getKey().split(" ").length == 2) {
                    flowers.add(en.getKey());
                } else {
                    accessories.add(en.getKey());
                }
            }
            sortList(flowers);
            mainFrame.setFlowers(flowers);

            sortList(accessories);
            accessories.add(0, "BRAK");
            mainFrame.setAccessories(accessories);
        } else if ("COMPANY".equals(e.getActionCommand())) {
            mainFrame.setVisibleCustomerChoose(false);
            mainFrame.setVisibleCompanyDetails(true);
        } else if ("COMPANY_DATA_OK".equals(e.getActionCommand())) {
            boolean validation = true;
            try {
                if (mainFrame.getCompanyName().isEmpty()) {
                    validation = false;
                }
                if (mainFrame.getStreet().isEmpty()) {
                    validation = false;
                }
                Integer.parseInt(mainFrame.getHouseNumber());
                Integer.parseInt(mainFrame.getFlatNumber());
                if (mainFrame.getTown().isEmpty()) {
                    validation = false;
                }
                if (!mainFrame.getPostCode().matches("[0-9]{2}-[0-9]{3}")) {
                    validation = false;
                }
                if (mainFrame.getPost().isEmpty()) {
                    validation = false;
                }
                if (!mainFrame.getNipNumber().matches("[0-9]{10}")) {
                    validation = false;
                }
            } catch (Exception ex) {
                validation = false;
            }
            if (validation == true) {
                customer = new BussinesCustomer(mainFrame.getCompanyName(), mainFrame.getStreet(),
                        Integer.parseInt(mainFrame.getHouseNumber()),
                        Integer.parseInt(mainFrame.getFlatNumber()),
                        mainFrame.getTown(), mainFrame.getPostCode(), mainFrame.getPost(),
                        mainFrame.getNipNumber());
                mainFrame.setVisibleCompanyDetails(false);
                mainFrame.setVisibleShop(true);

                server.connect();

                PriceList priceList = server.getPriceList();
                List<String> flowers = new ArrayList();
                List<String> accessories = new ArrayList();
                for (Map.Entry<String, Double> en : priceList.getPriceList().entrySet()) {
                    if (en.getKey().split(" ").length == 2) {
                        flowers.add(en.getKey());
                    } else {
                        accessories.add(en.getKey());
                    }
                }
                sortList(flowers);
                mainFrame.setFlowers(flowers);

                sortList(accessories);
                accessories.add(0, "BRAK");
                mainFrame.setAccessories(accessories);
            } else {
                mainFrame.showMessage("Nie poprawne dane.");
            }
        } else if ("ADD_TO_CART".equals(e.getActionCommand())) {
            if (mainFrame.getHowMany().matches("[1-9][0-9]*")) {
                String[] text = mainFrame.getFlower().split(" ");
                for (int i = 0; i < Integer.parseInt(mainFrame.getHowMany()); i++) {
                    Flower flower = FactoryFlyweight.factoryFlyweight(text[0], Enum.valueOf(Colours.class, text[1]));
                    String accessories = mainFrame.getAccessories();
                    if (!"BRAK".equals(accessories)) {
                        try {
                            Class classAccessories = Class.forName("com.mycompany.florists.model.accessories." + accessories);
                            Constructor constructor = classAccessories.getConstructors()[0];
                            flower = (Flower) constructor.newInstance(flower);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    customer.add(flower);
                }
                mainFrame.showMessage("Dodano artykuł do koszyka.");
                mainFrame.setHowManyTF("1");
            } else {
                mainFrame.showMessage("Błędna liczba sztuk.");
            }
        } else if ("CLEAR_CART".equals(e.getActionCommand())) {
            int number = mainFrame.showMessageYesOrNo("Czy chcesz opróżnić koszyk?");
            if (number == 0) {
                customer.clear();
            }
        } else if ("SUMMARY".equals(e.getActionCommand())) {
            ProofOfPurchase proofOfPurchase = server.getReceiptInvoice(customer);
            mainFrame.setProofOfPurchase(proofOfPurchase.getInscription() + "\n\n\nSuma:\t" + proofOfPurchase.getSum() + " PLN");
            mainFrame.setVisibleCustomerChoose(false);
            mainFrame.setVisibleShop(false);
            mainFrame.setVisibleProofOfPurchase(true);
        } else if ("EXIT".equals(e.getActionCommand())) {
            mainFrame.showMessage("Zapraszamy ponownie!");
            server.disconnect();
            System.exit(0);
        } else if ("BACK_SHOP_WINDOW".equals(e.getActionCommand())) {
            mainFrame.setVisibleProofOfPurchase(false);
            mainFrame.setVisibleShop(true);
        } else if ("BACK_WINDOW_START".equals(e.getActionCommand())) {
            mainFrame.setVisibleCompanyDetails(false);
            mainFrame.setVisibleShop(false);
            mainFrame.setVisibleCustomerChoose(true);
        } else if ("SET_FLOWER_PRICE".equals(e.getActionCommand())) {
            try {
                mainFrame.setFlowerPrice(server.getPriceList().getPrice(mainFrame.getFlower()) + " zł/szt");
            } catch (Exception ex) {
            }
        } else if ("SET_ACCESSORIES_PRICE".equals(e.getActionCommand())) {
            try {
                String ozdoba = mainFrame.getAccessories();
                if (!"BRAK".equals(ozdoba)) {
                    mainFrame.setAccessoriesPrice(server.getPriceList().getPrice(mainFrame.getAccessories()) + " zł/szt");
                } else {
                    mainFrame.setAccessoriesPrice("0.00 zł/szt");
                }
            } catch (Exception ex) {
            }
        }
    }
}
