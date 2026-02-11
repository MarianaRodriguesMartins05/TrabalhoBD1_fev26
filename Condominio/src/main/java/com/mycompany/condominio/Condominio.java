package com.mycompany.condominio;

import com.mycompany.condominio.view.TelaLogin;


public class Condominio {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
        

    }
}
