import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get("OperacaoEnigmaFinal/src/pista_01.jpg"));
      
        String conteudo = new String(bytes, StandardCharsets.ISO_8859_1);
        
        String mensagemOculta = "=QHe05SbldWYz5WZtBiOvZHbBBCfgcDI6IXYzV2QfVmdhh2Q";
        
        DecodificadorReverso decodificador = new DecodificadorReverso();
        String mensagemReversa = decodificador.decodificar(mensagemOculta);
      
        System.out.println(mensagemReversa);

        String textoCriptografado = Files.readString(Paths.get("OperacaoEnigmaFinal/src/mensagem.txt"));

        DecodificadorCesar cesar = new DecodificadorCesar();
        String mensagemFinal = cesar.decodificar(textoCriptografado, 7);

        System.out.println("--- MENSAGEM DESCRIPTOGRAFADA ---");
        System.out.println(mensagemFinal);
    FiltroImagem filtro = new FiltroVermelhoMagico();
    filtro.aplicarFiltro("OperacaoEnigmaFinal/src/ruido.bmp", "OperacaoEnigmaFinal/src/revelado.bmp");
    System.out.println("Imagem processada com sucesso! Verifique o arquivo revelado.bmp.");
    }
}