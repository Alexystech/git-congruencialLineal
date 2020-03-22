package com.alexis.main;

import test.CustomException;
import test.ValidacionOrdinariaException;
import test.ValidacionesException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Main
{
    private static ArrayList<Float> almacenR = new ArrayList<Float>();
    private static ArrayList<Integer> almacenZen = new ArrayList<Integer>();
    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);

    public static void main(String args[]) throws IOException
    {
        boolean switchMenu;
        int cantR = 0,semilla = 0,k = 0,g = 0,c = 0;

        ValidacionesException exceptions = new ValidacionesException();
        ValidacionOrdinariaException exceptionOrdinario = new ValidacionOrdinariaException();

        do{
            try{
                switchMenu = true;
                System.out.println("ingresa la cantidad de r:");
                cantR = Integer.parseInt(br.readLine());

                try{
                    exceptionOrdinario.validarValor(cantR);
                } catch (CustomException exception){
                    exception.printStackTrace();
                    switchMenu = false;
                }
            }catch(Exception e){
                e.printStackTrace();
                switchMenu = false;
            }
        }while(!switchMenu);

        do {
            try{
                switchMenu = true;
                System.out.println("ingresa la semilla x0:");
                semilla = Integer.parseInt(br.readLine());

                try {
                    exceptionOrdinario.validarValor(semilla);
                } catch (CustomException exception) {
                    exception.printStackTrace();
                    switchMenu = false;
                }
            }catch(Exception e){
                e.printStackTrace();
                switchMenu = false;
            }
        }while(!switchMenu);

        do {
            try{
                switchMenu = true;
                System.out.println("ingresa k:");
                k = Integer.parseInt(br.readLine());

                try {
                    exceptionOrdinario.validarValor(k);
                } catch (CustomException exception) {
                    exception.printStackTrace();
                    switchMenu = false;
                }
            }catch(Exception e){
                e.printStackTrace();
                switchMenu = false;
            }
        }while(!switchMenu);

        do {
            try{
                switchMenu = true;
                System.out.println("ingresa g:");
                g = Integer.parseInt(br.readLine());

                try {
                    exceptionOrdinario.validarValor(g);
                } catch (CustomException exception) {
                    exception.printStackTrace();
                    switchMenu = false;
                }
            }catch(Exception e){
                e.printStackTrace();
                switchMenu = false;
            }
        }while(!switchMenu);

        do {
            try{
                switchMenu = true;
                System.out.println("ingresa c:");
                c = Integer.parseInt(br.readLine());

                try {
                    exceptions.validarValor(c,modulo(g));
                } catch (CustomException exception) {
                    exception.printStackTrace();
                    switchMenu = false;
                }
            }catch(Exception e){
                e.printStackTrace();
                switchMenu = false;
            }

        }while(!switchMenu);

        newR(cantR,semilla,k,g,c);
        mostrarDatos();
    }

    public static void mostrarDatos(){
        for(int x = 0; x < almacenZen.size(); x++){
            System.out.println("x"+(x+1)+" = "+almacenZen.get(x)+" | r"+(x+1)+" = "+almacenR.get(x));
        }
    }

        private static float newR(int cantR, int semilla,int k,int g,int c)
        {
            if (cantR < 1)
            {
                return 0;
            }
            else
            {
                almacenR.add((float)(newZen(semilla, k, g, c)) / (modulo(g)-1));
                almacenZen.add(newZen(semilla, k, g, c));
                return newR(cantR-1,newZen(semilla, k, g, c),k,g,c);
            }
        }

        private static int newZen(int semilla,int k,int g, int c)
        {
            int valueNewZen = (constanteMultiplicativa(k) * semilla + c) % (modulo(g));
            return valueNewZen;
        }

        private static int constanteMultiplicativa(int k)
        {
            return 1 + (4*k);
        }

        private static int modulo(int g)
        {
            return (int)Math.pow(2, g);
        }
}
