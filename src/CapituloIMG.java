import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CapituloIMG extends Capitulo {
    private String img;

    public CapituloIMG(
            Map<String, Personagens> dicionarioDePersonagens,
            Scanner scanDeCapitulos,
            Scanner scan) {
        super();
        this.LerCapitulos(dicionarioDePersonagens, scan);
        this.scan = scanDeCapitulos;
        this.escolhas = new ArrayList<Escolha>();
    }

    protected void LerCapitulos(
            Map<String, Personagens> dicionarioDePersonagens,
            Scanner scan)
    {
        super.LerCapitulos(dicionarioDePersonagens, scan);

        scan.nextLine(); //IMAGEM
        String linha = scan.nextLine();
        this.img = "";
        while (!linha.equals("IMAGEM_FIM")) 
            {
                this.img = img + "\n" + linha;
                linha = scan.nextLine();
            }
    }

    protected void mostrar()
    {
        System.out.println(this.img);
        System.out.println();
        super.mostrar();
    }
}
