import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //Fazer uma conexão http e buscar os top 250 filmes
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        //Criar a instância de clienteHttp
        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        //Extrair título, poster e classificação
        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaDeConteudos = parser.parse(json);
        //Exibir e manipular
        for (Map<String,String> conteudo: listaDeConteudos) {
            String urlImagem = conteudo.get("url");
            String titulo = conteudo.get("title")
                    .replaceAll(":","");
            String nomeDoArquivo = "images/saida/" + titulo + ".png";
            InputStream inputStream = new URL(urlImagem).openStream();
            var geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream,nomeDoArquivo);
            //Impressoes
            System.out.println(conteudo.get("title"));
            System.out.println(conteudo.get("url"));
            System.out.println();
        }
    }
}
