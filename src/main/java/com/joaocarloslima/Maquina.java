package com.joaocarloslima;

import java.util.ArrayList;
import java.util.List;

public class Maquina {

    private double saldo;
    private double totalArrecadado;
    private List<Refrigerante> refrigerantes = new ArrayList<>();

    public Maquina(){
        for(Sabor sabor : Sabor.values()){
            refrigerantes.add( new Refrigerante(sabor + " 1", 4, sabor));
            refrigerantes.add( new Refrigerante(sabor + " 2", 6, sabor));
        }
    }

    public void inserirDinheiro(double valor){
        saldo += valor;
    }

    public void sacarDinheiro(){
        saldo = 0;
    }

    public void comprarRefrigerante(Refrigerante refrigerante){

        if (saldo < refrigerante.getPreco())
            throw new RuntimeException("Saldo insuficiente");

        saldo -= refrigerante.getPreco();

        refrigerantes.remove(refrigerante);

        totalArrecadado += refrigerante.getPreco();

    }

    public double getSaldo() {
        return saldo;
    }

    public double getTotalArrecadado() {
        return totalArrecadado;
    }

    public List<Refrigerante> getRefrigerantes() {
        return refrigerantes;
    }

    
    
    
}
