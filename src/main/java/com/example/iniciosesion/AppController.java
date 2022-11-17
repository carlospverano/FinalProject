package com.example.iniciosesion;


import model.FincaRaiz;

public enum AppController {

    INSTANCE;
    private  final FincaRaiz fincaRaiz;

    AppController (){
        fincaRaiz = new FincaRaiz();}

    public FincaRaiz getFincaRaiz() {
        return fincaRaiz;
    }
}

