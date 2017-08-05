package com.mycompany.florists.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Main view window.
 *
 * @author Sławomir Kowalczyk
 */
public class MainFrame extends JFrame {

    private JLabel signBoardL, chooseFlawerL, chooseAccessoriesL, howManyL,
            flowerPriceL, accessoriesPriceL, valueL,
            buyerL, companyNameL, streetL, houseNumberL, flatNumberL,
            townL, postCodeL, postL, nipNumberL, proofOfPurchaseL, requirFieldsL;
    private JButton individualB, companyB,
            addToCartB, clearCartB, backToShopWindowB, backToStartWindowB,
            summaryB, exitB, OK_DataB;
    private JComboBox chooseFlowerCB, chooseAccessoriesCB;
    private JTextField howManyTF, companyNameTF, postCodeTF, streetTF, houseNumberTF,
            flatNumberTF, townTF, postTF, nipNumberTF;
    private JTextArea proofPurchaseTA;
    private ImageIcon shoppingCartIconII;
    private JScrollPane proodOfPurchaseSP;
    private String pathImage = "src/main/resources/images/cart.jpg";

    /**
     * Builds the main window. Contains information about dimensions, position,
     * visibility, and initializes all fields along with the data needed.
     *
     */
    public MainFrame() {
        setTitle("Kwieciarnia");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

// Welcome window buttons.
        signBoardL = new JLabel("Zapraszamy do naszej nowej Kwieciarni!");
        signBoardL.setBounds(180, 70, 300, 20);

        individualB = new JButton("Indywidualny");
        individualB.setBounds(155, 155, 120, 20);
        individualB.setActionCommand("INDIVIDUAL");

        companyB = new JButton("Firma");
        companyB.setBounds(285, 155, 120, 20);
        companyB.setActionCommand("COMPANY");

        add(signBoardL);
        add(individualB);
        add(companyB);

//Buttons and fields for entering data into the invoice.
        buyerL = new JLabel("Nabywca:");
        buyerL.setBounds(20, 40, 60, 20);
        buyerL.setVisible(false);

        companyNameL = new JLabel("Nazwa firmy: *");
        companyNameL.setBounds(20, 80, 90, 20);
        companyNameL.setVisible(false);

        companyNameTF = new JTextField();
        companyNameTF.setBounds(120, 80, 160, 20);
        companyNameTF.setVisible(false);

        streetL = new JLabel("Ulica: *");
        streetL.setBounds(20, 110, 50, 20);
        streetL.setVisible(false);

        streetTF = new JTextField();
        streetTF.setBounds(120, 110, 160, 20);
        streetTF.setVisible(false);

        houseNumberL = new JLabel("Nr domu: *");
        houseNumberL.setBounds(290, 110, 60, 20);
        houseNumberL.setVisible(false);

        houseNumberTF = new JTextField();
        houseNumberTF.setBounds(360, 110, 40, 20);
        houseNumberTF.setVisible(false);

        flatNumberL = new JLabel("Nr mieszkania: *");
        flatNumberL.setBounds(400, 110, 100, 20);
        flatNumberL.setVisible(false);

        flatNumberTF = new JTextField();
        flatNumberTF.setBounds(500, 110, 40, 20);
        flatNumberTF.setVisible(false);

        townL = new JLabel("Miejscowość: *");
        townL.setBounds(20, 140, 160, 20);
        townL.setVisible(false);

        townTF = new JTextField();
        townTF.setBounds(120, 140, 160, 20);
        townTF.setVisible(false);

        postCodeL = new JLabel("Kod pocztowy: *");
        postCodeL.setBounds(20, 170, 100, 20);
        postCodeL.setVisible(false);

        postCodeTF = new JTextField("00-000");
        postCodeTF.setBounds(120, 170, 100, 20);
        postCodeTF.setVisible(false);

        postL = new JLabel("Poczta: *");
        postL.setBounds(290, 170, 120, 20);
        postL.setVisible(false);

        postTF = new JTextField();
        postTF.setBounds(360, 170, 140, 20);
        postTF.setVisible(false);

        nipNumberL = new JLabel("NIP: *");
        nipNumberL.setBounds(20, 200, 40, 20);
        nipNumberL.setVisible(false);

        nipNumberTF = new JTextField();
        nipNumberTF.setBounds(70, 200, 150, 20);
        nipNumberTF.setVisible(false);

        requirFieldsL = new JLabel("* wymagane pola.");
        requirFieldsL.setBounds(20, 300, 100, 20);
        requirFieldsL.setVisible(false);

        OK_DataB = new JButton("OK");
        OK_DataB.setBounds(510, 330, 70, 20);
        OK_DataB.setVisible(false);
        OK_DataB.setActionCommand("COMPANY_DATA_OK");

        add(buyerL);
        add(companyNameL);
        add(companyNameTF);
        add(streetL);
        add(streetTF);
        add(houseNumberL);
        add(houseNumberTF);
        add(flatNumberL);
        add(flatNumberTF);
        add(townL);
        add(townTF);
        add(postCodeL);
        add(postCodeTF);
        add(postL);
        add(postTF);
        add(nipNumberL);
        add(nipNumberTF);
        add(requirFieldsL);
        add(OK_DataB);

// Buttons and fields to operate the shop.
        chooseFlawerL = new JLabel("Wybierz kwiat");
        chooseFlawerL.setBounds(20, 60, 150, 20);
        chooseFlawerL.setVisible(false);

        chooseFlowerCB = new JComboBox();
        chooseFlowerCB.setBounds(20, 90, 150, 20);
        chooseFlowerCB.setVisible(false);
        chooseFlowerCB.setActionCommand("SET_FLOWER_PRICE");

        chooseAccessoriesL = new JLabel("Wybierz dekoracje");
        chooseAccessoriesL.setBounds(20, 130, 150, 20);
        chooseAccessoriesL.setVisible(false);

        chooseAccessoriesCB = new JComboBox();
        chooseAccessoriesCB.setBounds(20, 160, 150, 20);
        chooseAccessoriesCB.setVisible(false);
        chooseAccessoriesCB.setActionCommand("SET_ACCESSORIES_PRICE");

        howManyL = new JLabel("sztuk");
        howManyL.setBounds(240, 60, 50, 20);
        howManyL.setVisible(false);

        howManyTF = new JTextField("1");
        howManyTF.setBounds(240, 90, 50, 20);
        howManyTF.setVisible(false);

        valueL = new JLabel("Wartość");
        valueL.setBounds(340, 60, 80, 20);
        valueL.setVisible(false);

        flowerPriceL = new JLabel();
        flowerPriceL.setBounds(340, 90, 60, 20);
        flowerPriceL.setVisible(false);

        accessoriesPriceL = new JLabel("0.00zł");
        accessoriesPriceL.setBounds(340, 160, 60, 20);
        accessoriesPriceL.setVisible(false);

        shoppingCartIconII = new ImageIcon(pathImage);
        addToCartB = new JButton("Dodaj do koszyka", shoppingCartIconII);
        addToCartB.setBounds(420, 20, 150, 30);
        addToCartB.setActionCommand("ADD_TO_CART");
        addToCartB.setVisible(false);

        clearCartB = new JButton("Opróżnij koszyk");
        clearCartB.setBounds(420, 60, 150, 20);
        clearCartB.setVisible(false);
        clearCartB.setActionCommand("CLEAR_CART");

        backToStartWindowB = new JButton("Wstecz");
        backToStartWindowB.setBounds(20, 330, 80, 20);
        backToStartWindowB.setActionCommand("BACK_WINDOW_START");
        backToStartWindowB.setVisible(false);

        summaryB = new JButton("Przejdź do podsumowania");
        summaryB.setBounds(390, 330, 190, 20);
        summaryB.setActionCommand("SUMMARY");
        summaryB.setVisible(false);

        add(chooseFlawerL);
        add(chooseFlowerCB);
        add(chooseAccessoriesL);
        add(chooseAccessoriesCB);
        add(howManyL);
        add(howManyTF);
        add(valueL);
        add(flowerPriceL);
        add(accessoriesPriceL);
        add(backToStartWindowB);
        add(addToCartB);
        add(clearCartB);
        add(summaryB);

// Buttons and fields displaying proof of purchase.
        proofOfPurchaseL = new JLabel("Dowod zakupu");
        proofOfPurchaseL.setBounds(150, 20, 120, 20);
        proofOfPurchaseL.setVisible(false);

        proofPurchaseTA = new JTextArea();
        proofPurchaseTA.setEnabled(false);
        proofPurchaseTA.setForeground(Color.black);
        proodOfPurchaseSP = new JScrollPane(proofPurchaseTA);
        proodOfPurchaseSP.setBounds(20, 60, 300, 200);
        proodOfPurchaseSP.setVisible(false);

        backToShopWindowB = new JButton("Wstecz");
        backToShopWindowB.setBounds(20, 330, 80, 20);
        backToShopWindowB.setVisible(false);
        backToShopWindowB.setActionCommand("BACK_SHOP_WINDOW");

        exitB = new JButton("Wyjdź ze sklepu");
        exitB.setBounds(420, 330, 150, 30);
        exitB.setActionCommand("EXIT");
        exitB.setVisible(false);

        add(proodOfPurchaseSP);
        add(proofOfPurchaseL);
        add(backToShopWindowB);
        add(exitB);
    }

    /**
     * Adding listeners to windows.
     *
     * @param listener Events listeners.
     */
    public void addActionListener(ActionListener listener) {
        individualB.addActionListener(listener);
        companyB.addActionListener(listener);
        addToCartB.addActionListener(listener);
        exitB.addActionListener(listener);
        summaryB.addActionListener(listener);
        backToStartWindowB.addActionListener(listener);
        backToShopWindowB.addActionListener(listener);
        OK_DataB.addActionListener(listener);
        chooseFlowerCB.addActionListener(listener);
        chooseAccessoriesCB.addActionListener(listener);
        clearCartB.addActionListener(listener);
    }

    /**
     * The Method responsible for displaying customer type selection buttons.
     *
     * @param visible Visibility-defining parameter.
     */
    public void setVisibleCustomerChoose(boolean visible) {
        signBoardL.setVisible(visible);
        individualB.setVisible(visible);
        companyB.setVisible(visible);
    }

    /**
     * The Method responsible for displaying buttons in the shop.
     *
     * @param visible Visibility-defining parameter.
     */
    public void setVisibleShop(boolean visible) {
        chooseFlawerL.setVisible(visible);
        chooseFlowerCB.setVisible(visible);
        chooseAccessoriesL.setVisible(visible);
        chooseAccessoriesCB.setVisible(visible);
        howManyL.setVisible(visible);
        howManyTF.setVisible(visible);
        valueL.setVisible(visible);
        flowerPriceL.setVisible(visible);
        accessoriesPriceL.setVisible(visible);
        backToStartWindowB.setVisible(visible);
        addToCartB.setVisible(visible);
        clearCartB.setVisible(visible);
        summaryB.setVisible(visible);
    }

    /**
     * The Method responsible for displaying fields for entering bussines
     * customer details.
     *
     * @param visible Visibility-defining parameter.
     */
    public void setVisibleCompanyDetails(boolean visible) {
        buyerL.setVisible(visible);
        companyNameL.setVisible(visible);
        companyNameTF.setVisible(visible);
        streetL.setVisible(visible);
        streetTF.setVisible(visible);
        houseNumberL.setVisible(visible);
        houseNumberTF.setVisible(visible);
        flatNumberL.setVisible(visible);
        flatNumberTF.setVisible(visible);
        townL.setVisible(visible);
        townTF.setVisible(visible);
        postCodeL.setVisible(visible);
        postCodeTF.setVisible(visible);
        postL.setVisible(visible);
        postTF.setVisible(visible);
        nipNumberL.setVisible(visible);
        nipNumberTF.setVisible(visible);
        requirFieldsL.setVisible(visible);
        OK_DataB.setVisible(visible);
        backToStartWindowB.setVisible(visible);
    }

    /**
     * The Method responsible for displaying fields in proof of purchase window.
     *
     * @param visible Visibility-defining parameter.
     */
    public void setVisibleProofOfPurchase(boolean visible) {
        proofOfPurchaseL.setVisible(visible);
        proodOfPurchaseSP.setVisible(visible);
        backToShopWindowB.setVisible(visible);
        exitB.setVisible(visible);
    }

    /**
     * Displays panel with a message for a user.
     *
     * @param message Message for a user.
     */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Wiadomość", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays panel asking to confirm the operation.
     *
     * @param message Message for a user.
     * @return Returns selected answer as a number.
     */
    public int showMessageYesOrNo(String message) {
        return JOptionPane.showConfirmDialog(this, message, "Wiadomość", JOptionPane.YES_NO_OPTION);
    }

    /**
     * The method fills the list of flowers in the shop.
     *
     * @param list The list of available flowers in the shop.
     */
    public void setFlowers(List<String> list) {
        chooseFlowerCB.removeAllItems();
        for (int i = 0; i < list.size(); i++) {
            chooseFlowerCB.addItem(list.get(i));
        }
    }

    /**
     * The method fills the list of flower decorations in the shop.
     *
     * @param list The list of available flower decorations in the shop.
     */
    public void setAccessories(List<String> list) {
        chooseAccessoriesCB.removeAllItems();
        for (int i = 0; i < list.size(); i++) {
            chooseAccessoriesCB.addItem(list.get(i));
        }
    }

    /**
     *
     * @return Returns the company name given by business customer.
     */
    public String getCompanyName() {
        return companyNameTF.getText();
    }

    /**
     *
     * @return Returns the street name given by business customer.
     */
    public String getStreet() {
        return streetTF.getText();
    }

    /**
     *
     * @return Returns the house number given by business customer.
     */
    public String getHouseNumber() {
        return houseNumberTF.getText();
    }

    /**
     *
     * @return Returns the flat number given by business customer.
     */
    public String getFlatNumber() {
        return flatNumberTF.getText();
    }

    /**
     *
     * @return Returns the town given by business customer.
     */
    public String getTown() {
        return townTF.getText();
    }

    /**
     *
     * @return Returns the post code given by business customer.
     */
    public String getPostCode() {
        return postCodeTF.getText();
    }

    /**
     *
     * @return Returns the post office name given by business customer.
     */
    public String getPost() {
        return postTF.getText();
    }

    /**
     *
     * @return Returns the NIP number given by business customer.
     */
    public String getNipNumber() {
        return nipNumberTF.getText();
    }

    /**
     *
     * @return Returns the number of flowers selected by the customer.
     */
    public String getHowMany() {
        return howManyTF.getText();
    }

    /**
     * The method accepts and displays an inscription that will be the default
     * number of items.
     *
     * @param inscription Displays the inscription.
     */
    public void setHowManyTF(String inscription) {
        howManyTF.setText(inscription);
    }

    /**
     * The method accepts and displays the text that will be displayed on the
     * proof of purchase.
     *
     * @param inscription Content of the proof of purchase.
     */
    public void setProofOfPurchase(String inscription) {
        proofPurchaseTA.setText(inscription);
    }

    /**
     *
     * @return Returns selected by customer flower.
     */
    public String getFlower() {
        return (String) chooseFlowerCB.getSelectedItem();
    }

    /**
     *
     * @return Returns selected by customer flower dekorations.
     */
    public String getAccessories() {
        return (String) chooseAccessoriesCB.getSelectedItem();
    }

    /**
     * The method takes the name of the currently selected flower to display its
     * price.
     *
     * @param inscription Flower name.
     */
    public void setFlowerPrice(String inscription) {
        flowerPriceL.setText(inscription);
    }

    /**
     * The method takes the name of the currently selected flower decorations to
     * display its price.
     *
     * @param inscription Accessory name.
     */
    public void setAccessoriesPrice(String inscription) {
        accessoriesPriceL.setText(inscription);
    }
}
