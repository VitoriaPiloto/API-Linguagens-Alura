import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo{
    public List<Conteudo> extraiConteudos(String json){
        //Extrair título, poster e classificação
        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaDeAtributos = parser.parse(json);
        //Lista é abastração e o ArrayList é o bloco de memória alocado para a Lista
        List<Conteudo> conteudos = new ArrayList<>();
        //Popular lista de conteudos
        for (Map<String,String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title")
                    .replaceAll(":","");
            String urlImagem = atributos.get("image");
            var conteudo = new Conteudo(titulo,urlImagem);
            //Lista dos objetos recebendo o objeto
            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
