import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {
    public String buscaDados(String url) {
        // Essa é uma checked exception, o Java nos obriga a tratá-la
        try{
            //Cria um endereço unico
            URI endereco = URI.create(url);
            //Faz uma requisição
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(endereco).GET().build();
            // Para saber mais: olhar no JavaDoc - httpRequest
            //Cliente pegará o request e escolherá como ler os dados -- Response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            return body;
        } catch(IOException | InterruptedException ex) {
            //Joga a exceção para uma outra exceção que não seja necessariamente tratá-la
            throw new RuntimeException(ex);
        }
    }
}
