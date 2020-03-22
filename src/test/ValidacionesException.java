package test;

import java.util.ArrayList;

public class ValidacionesException {
    private Math Match;

    public ValidacionesException(){}

    public void validarValor(int valor,int modulo) throws CustomException
    {
        if (valor < 1)
        {
            throw new CustomException("el valor no puede ser negativo o neutro");
        }

        if (!isPrimeRelative(valor,modulo))
        {
            throw new CustomException("la constante aditiva no es valor primo");
        }
    }

    private boolean isPrimeRelative(int valor, int modulo)
    {
        ArrayList<Integer>divisoresAditiva = new ArrayList<Integer>();
        ArrayList<Integer>divisoresModulo = new ArrayList<Integer>();
        /*
         * almacenar los divisores del valor y el modulo
         * */
        for (int x = 1; x <= valor; x++){
            if (valor % x == 0){
                divisoresAditiva.add(x);
            }
        }

        for (int x = 1; x <= modulo; x++){
            if (modulo % x == 0) {
                divisoresModulo.add(x);
            }
        }

        /*sacar valor menor*/
        int valorMenor = 0;
        if(divisoresAditiva.size() < divisoresModulo.size()){
            valorMenor = divisoresAditiva.size();
        }else{
            valorMenor = divisoresModulo.size();
        }

        /*relacionar divisores y definir si son primos relativos*/
        int contador = 0;
        for (int x = 0; x < valorMenor; x++) {
            if(divisoresAditiva.get(x) == divisoresModulo.get(x)){
                contador++;
            }
        }

        if (contador > 1) {
            return false;
        }else{
            return true;
        }
    }
}
