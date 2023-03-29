import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Map;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Fazer uma conexão http e buscar os top 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //Cria um endereço unico
        URI endereco = URI.create(url);
        //Faz uma requisição
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        // Para saber mais: olhar no JavaDoc - httpRequest
        //Cliente pegará o request e escolherá como ler os dados -- Response
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        //Extrair título, poster e classificação
        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaDeFilmes = parser.parse(body);
        //Exibir e manipular
        for (Map<String,String> filme: listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("rating"));
            System.out.println();
        }
    }
}
