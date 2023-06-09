package com.testeunisomaweb.api.utils;

public class Utils {

    public static String valorFormatado(double valor) {
        if (valor == 0) {
            return "0.00";
        } else if (valor < 1) {
            String valorTemporario = "" + valor;
            if (valorTemporario.split("\\.")[1].length() >= 2) {
                return "0." + valorTemporario.split("\\.")[1].substring(0, 2);
            } else {
                return "0." + valorTemporario.split("\\.")[1] + "0";
            }
        } else {
            String valorComoString = "" + valor * 100;
            String[] valores = valorComoString.split("\\.");
            String valorTemporario = valores[0];
            return valorTemporario.substring(0, valorTemporario.length() - 2) + "."
                    + valorTemporario.substring(valorTemporario.length() - 2);
        }
    }

}
