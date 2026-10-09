package br.com.calculadora.dto;

public class CalculoResponse {

    private double resultado;

    public CalculoResponse(double resultado) {
        this.resultado = resultado;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}