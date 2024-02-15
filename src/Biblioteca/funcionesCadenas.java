package Biblioteca;

public class funcionesCadenas {

    /**
     * Función para comprobar si nuestra contraseña cumple con ciertos requisitos
     * @author Adrián Contreras Bueno y Alex Godino Bailen
     * @param pass como cadena
     * @return true si cumple los requisitos y false si no los cumple
     */
    public static boolean comprobarFortalezaPass(String pass){
        char[] abecedarioMay={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] abecedarioMin={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] numeros={'1','2','3','4','5','6','7','8','9','0'};
        char caracterMay, caracterMin,caracterNumero;
        boolean mayuscula=false, minuscula=false;
        if (pass.length()>=8){
            if (pass.contains("@")||pass.contains("-")||pass.contains("_")||pass.contains("*")||pass.contains("+")
                    ||pass.contains(".")||pass.contains(",")) {
                for (int i = 0; i < pass.length(); i++) {
                    caracterMay=pass.charAt(i);
                    for (int j = 0; j < abecedarioMay.length; j++) {
                        if(caracterMay==abecedarioMay[j]){
                            mayuscula=true;
                            break;
                        }
                    }
                }
                if (mayuscula){
                    for (int i = 0; i < pass.length(); i++) {
                        caracterMin=pass.charAt(i);
                        for (int j = 0; j < abecedarioMin.length; j++) {
                            if(caracterMin==abecedarioMin[j]){
                                minuscula=true;
                                break;
                            }
                        }
                    }
                }
                if(minuscula) {
                    for (int i = 0; i < pass.length(); i++) {
                        caracterNumero = pass.charAt(i);
                        for (int j = 0; j < numeros.length; j++) {
                            if (caracterNumero == numeros[j]) {
                                return true;
                            }
                        }
                    }
                }
                else{
                    System.out.println("La contraseña no cumple los requisitos\n-Debe tener una longitud mínima de 8 caracteres" +
                            "\n-Contener como mínimo una mayúscula y una minúscula " +
                            "\n-Contener como mínimo un número " +
                            "\n-Contener como mínimo un caracter especial (@ - _ * + . ,)");
                    return false;
                }
            }
            else{
                System.out.println("La contraseña no cumple los requisitos\n-Debe tener una longitud mínima de 8 caracteres" +
                        "\n-Contener como mínimo una mayúscula y una minúscula " +
                        "\n-Contener como mínimo un número " +
                        "\n-Contener como mínimo un caracter especial (@ - _ * + . ,)");
                return false;
            }
        }
        else{
            System.out.println("La contraseña no cumple los requisitos\n-Debe tener una longitud mínima de 8 caracteres" +
                    "\n-Contener como mínimo una mayúscula y una minúscula " +
                    "\n-Contener como mínimo un número " +
                    "\n-Contener como mínimo un caracter especial (@ - _ * + . ,)");
            return false;
        }
        return false;
    }
}
