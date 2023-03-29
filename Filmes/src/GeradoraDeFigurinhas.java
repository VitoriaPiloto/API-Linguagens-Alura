import java.awt.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
public class GeradoraDeFigurinhas {
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        //Fazer leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("images/shawshank.jpg"));
        //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        //Criar nova imagem em memória com transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura+200;
        BufferedImage novaImagem = new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);
        //Copiar imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,0,0,null);
        //Configurar fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setColor(Color.BLACK);
        //Setando o texto na imagem com nova fonte
        graphics.setFont(fonte);
        //Escrever frase
        graphics.drawString("TOPZERA",90,novaAltura-100);
        //Novo arquivo para nova imagem
        ImageIO.write(novaImagem,"png",new File(nomeArquivo));
    }
}
