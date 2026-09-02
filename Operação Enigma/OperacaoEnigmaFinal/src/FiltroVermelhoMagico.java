import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FiltroVermelhoMagico implements FiltroImagem {

    @Override
    public void aplicarFiltro(String caminhoEntrada, String caminhoSaida) {
        try {
            BufferedImage imagem = ImageIO.read(new File(caminhoEntrada));
            int largura = imagem.getWidth();
            int altura = imagem.getHeight();

            BufferedImage imagemResultado = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < largura; x++) {
                for (int y = 0; y < altura; y++) {
                    int rgb = imagem.getRGB(x, y);
                    Color cor = new Color(rgb);

                    int vermelho = cor.getRed();

                    if (vermelho % 2 != 0) {
                        imagemResultado.setRGB(x, y, Color.BLACK.getRGB());
                    } else {
                        imagemResultado.setRGB(x, y, Color.WHITE.getRGB());
                    }
                }
            }

            ImageIO.write(imagemResultado, "bmp", new File(caminhoSaida));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}