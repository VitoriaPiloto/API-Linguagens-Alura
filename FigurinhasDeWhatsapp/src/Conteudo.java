public class Conteudo {
    //O final ele não permite alteração
    private final String titulo;
    private final String url;

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }

    public Conteudo(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }


}
