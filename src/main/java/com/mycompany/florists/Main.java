package com.mycompany.florists;

import com.mycompany.florists.controller.Controller;
import com.mycompany.florists.view.MainFrame;
import java.awt.EventQueue;

/**
 * @author Sławomir Kowalczyk
 */
public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame();
                ServerInterface server = new Server("localhost",50000);
                Controller controller = new Controller(server, mainFrame);
            }
        });

    }

}
