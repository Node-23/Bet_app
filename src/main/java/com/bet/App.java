package com.bet;

import java.util.Locale;

import com.bet.View.MainView;

public class App {
    public static void main(String[] args) {
        Locale locale = new Locale("en_US");
        Locale.setDefault(locale);
        new MainView();
    }
}
