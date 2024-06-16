import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Alunos:
// RA: 194211 - Gabriel Borba
// RA: 194210 - Nathan Calheiros

public class GerenciaArquivosTxt {
    private String urlPasta;
    private String nomeArquivo;

    public GerenciaArquivosTxt(String nomeArquivo, String urlPasta){
        this.nomeArquivo = nomeArquivo;
        this.urlPasta = urlPasta;
    }

    public Path getArquivo(){
        return Paths.get(urlPasta+"\\"+nomeArquivo+".txt");
    }
    public boolean verificaArquivo(){
       return Files.exists(getArquivo());
    }
    public void gravaArquivo(String conteudo){
        byte[] conteudoEmByte = conteudo.getBytes();
        try{
            Files.write(getArquivo(), conteudoEmByte);
            System.out.println("Arquivo gravado com sucesso!");
        }catch (Exception e){
            System.out.println("Erro ao gravar arquivo: "+e.getMessage());
        }
    }
    public String leArquivo(){
        try {
            return new String(Files.readAllBytes(getArquivo()));
        }catch (Exception e){
            System.out.println("Erro ao ler arquivo: "+ e.getMessage());
            return null;
        }
    }
}
