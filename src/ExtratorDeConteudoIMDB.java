import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo {
    
    public List<Conteudo> extraiConteudos(String json) {
        JsonParser parser = new JsonParser();
        List<Map<String, String>> ListaDeAtributos = parser.parse(json);

        List <Conteudo> conteudos = new ArrayList<>();
        //popular a lista de conteudos
        
        for (Map<String, String> atributos : ListaDeAtributos) {
            String nomezera = atributos.get("title");
            String urlImagem = atributos.get("image");
            var conteudo =new Conteudo(nomezera,urlImagem);
            conteudos.add(conteudo);
        }

        return conteudos;

    }



}
