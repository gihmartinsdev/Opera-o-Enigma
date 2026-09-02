public class DecodificadorCesar {

    public String decodificar(String texto, int chave) {
        StringBuilder resultado = new StringBuilder();

        for (char caracter : texto.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = Character.isUpperCase(caracter) ? 'A' : 'a';
               
                char decodificado = (char) ((caracter - base - chave + 26) % 26 + base);
                resultado.append(decodificado);
            } else {
               
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }
}