import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        //System.out.println("Gelo quebrado.");
        
        //pegar os dados do imdb top 250 filmes, Fazer uma conexão http
        
        // String url = "https://api.mocki.io/v2/549a5d8b";
        // ExtratorDeConteudo extrai = new ExtratorDeConteudoIMDB();

        // String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        // ExtratorDeConteudo extrai = new ExtratorDeConteudoDaNasa();
        
        String url= "https://alura-linguagens-apilinux.herokuapp.com/linguagens";
        ExtratorDeConteudo extrai = new ExtratorDeConteudoIMDB();


        var http =new ClienteHttp();
        String json= http.buscaDados(url);


        // exibir e manipular os dados do jeito que achamos melhor
        
        List<Conteudo> conteudos2=extrai.extraiConteudos(json);


        var geradora =new GeradoraDeFigurinhas();
        for (Conteudo conteudo : conteudos2) {
            String Nomezin = conteudo.getTitulo()+".png";
            InputStream inputStream =new URL(conteudo.getUrlimagem()).openStream();
            geradora.cria(inputStream, Nomezin);

            System.out.println("Título: "+conteudo.getTitulo());
            // System.out.println("Link imagem: "+conteudo.get("image"));
            //System.out.println("Nota: "+conteudo.get("imDbRating"));
            System.out.println();
        }

    }
}
