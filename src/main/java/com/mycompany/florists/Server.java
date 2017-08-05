package com.mycompany.florists;

import com.mycompany.florists.model.PriceList;
import com.mycompany.florists.model.ProofOfPurchase;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.florists.model.BussinesCustomer;
import com.mycompany.florists.model.IndividualCustomer;
import com.mycompany.florists.model.Customer;
import com.mycompany.florists.model.Flower;

/**
 * The class operating a server at the customer's.
 *
 * @author Sławomir Kowalczyk
 */
public class Server implements ServerInterface {

    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private String serverAdres;
    private int portNumber;

    /**
     * Creates a server.
     *
     * @param serverAdres The server address.
     * @param portNumber The port number.
     */
    public Server(String serverAdres, int portNumber) {
        this.serverAdres = serverAdres;
        this.portNumber = portNumber;
    }

    /**
     * The method responsible for connecting the server.
     */
    @Override
    public void connect() {
        try {
            socket = new Socket(serverAdres, portNumber);
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("Połączono z serverem");
        } catch (IOException ex) {
            System.out.println("Blad polaczenia z serverem");
        }
    }

    /**
     * The method responsible for disconnecting the server.
     */
    @Override
    public void disconnect() {
        try {
            socket.close();
            inputStream.close();
            outputStream.close();
        } catch (IOException ex) {

        }
    }

    /**
     *
     * @return Returns the price list of the articles in the shop.
     */
    @Override
    public PriceList getPriceList() {
        try {
            outputStream.writeObject("PRICE_LIST");
            PriceList priceList = (PriceList) inputStream.readObject();
            return priceList;
        } catch (IOException ex) {
            System.out.println("Błąd pobrania cennika");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param customer The shop customer.
     * @return Returns a receipt for an individual client, a business customer
     * invoice, for an undefined client returns null.
     */
    @Override
    public ProofOfPurchase getReceiptInvoice(Customer customer) {
        try {

            outputStream.writeObject("TO_CASH_BOX");
            Customer c = customer;
            if (customer instanceof IndividualCustomer) {
                c = new IndividualCustomer();
            } else if (customer instanceof BussinesCustomer) {
                BussinesCustomer b = (BussinesCustomer) customer;
                c = new BussinesCustomer(b.getCompanyName(), b.getStreet(), b.getHouseNumber(),
                        b.getFlatNumber(), b.getTown(), b.getPostCode(),
                        b.getPost(), b.getNipNumber());
            }

            for (Flower flower : customer.getList()) {
                c.add(flower);
            }
            outputStream.writeObject(c);
            ProofOfPurchase proofOfPurchase = (ProofOfPurchase) inputStream.readObject();
            return proofOfPurchase;
        } catch (IOException ex) {
            System.out.println("Błąd pobrania dowodu zakupu");
        } catch (ClassNotFoundException ex) {

        }
        return null;
    }

}
