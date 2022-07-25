import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws IOException{

        //leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("/home/phellipe/Documents/Imersão JAVA/alura-stickers/Entrada/matheus.jpeg"));
        //BufferedImage imagemOriginal =ImageIO.read(new File("/home/phellipe/Documents/Imersão JAVA/alura-stickers/Entrada/matheus.jpeg"));
        //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal =ImageIO.read(inputStream);
        
        //cria nova imagem cem memória com transparencia e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaaltura= altura +200;
        BufferedImage novaImagem = new BufferedImage(largura,novaaltura,BufferedImage.TRANSLUCENT);


        // copiar a imagem original para nova imagem(em memória)

        Graphics2D graphics =  novaImagem.createGraphics();
        graphics.drawImage(imagemOriginal,0,0,null);

        //configurar a fonte
        var fonte =new Font(Font.SANS_SERIF,Font.BOLD,64);
        graphics.setColor(Color.BLACK);
        graphics.setFont(fonte);
    

        // escrever uma frase na nova imagem

        graphics.drawString("TOPDEMAIS",100, novaaltura-100);
        //graphics.drawString("vou dormir...",50, novaaltura-40);
        //escrever nova imagem em um arquivo
        String linhadonome= "/home/phellipe/Documents/Imersão JAVA/alura-stickers/saida/"+nomeArquivo;
        ImageIO.write(novaImagem,"png", new File(linhadonome));

    }

    // public static void main(String[] args) throws IOException {
    //     var geradora = new GeradoraDeFigurinhas();
    //     geradora.cria();
    // }


}
