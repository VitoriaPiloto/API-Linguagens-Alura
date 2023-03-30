import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //Fazer uma conexão http e buscar os top 250 filmes
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        //Criar a instância de clienteHttp
        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        //Extração de dados
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        //Exibir e manipular
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        for (Conteudo conteudo: conteudos) {
            String nomeDoArquivo = "images/saida/" + conteudo.getTitulo() + ".png";
            InputStream inputStream = new URL(conteudo.getUrl()).openStream();
            var geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream,nomeDoArquivo);
            //Impressoes
            System.out.println(conteudo.getTitulo());
            System.out.println(conteudo.getUrl());
            System.out.println();
        }
    }
}
