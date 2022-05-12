import java.util.Map;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in, "CP850");
        
        
        //------------------------------------------------------------------------------------------
        Leitor ler = new Leitor();
        Map<String,Personagens> dicionarioDePersonagens = ler.carregarPersonagens("rsc/Personagens.txt");
        
        Map<String,Capitulo> dicionarioDeCapitulos = ler.carregarCapitulos("rsc/Capitulo.txt", dicionarioDePersonagens, scan);
        
        System.out.println("Carregamento finalizado.\n\nIniciando História...\n");
        System.out.println("Nota:\nPara que nossa história funcione, favor digite a palavra destacada\nBom proveito :]");
        System.out.println();
        Capitulo raiz = dicionarioDeCapitulos.get("Raiz");    
        raiz.executar();
        
        scan.close();
    }
}

