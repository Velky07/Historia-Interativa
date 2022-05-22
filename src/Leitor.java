import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Leitor {
    public HashMap<String, Personagens> carregarPersonagens(String caminho) {
        HashMap<String, Personagens> dicionárioPerson = new HashMap<String, Personagens>();

        File arquivo = new File(caminho);
        try {
            Scanner scan = new Scanner(arquivo, "CESU8");

            System.out.println("Carregando Personagens...");
            int i = 0;
            while (scan.hasNextLine()) {
                i++;
                String id = scan.nextLine();
                String nome = scan.nextLine();
                int vida = Integer.parseInt(scan.nextLine());

                System.out.println("Personagem" + i);

                dicionárioPerson.put(id, new Personagens(nome, vida));
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return dicionárioPerson;
    }

    public HashMap<String, Capitulo> carregarCapitulos(String caminho,
            Map<String, Personagens> dicionarioDePersonagens) {
        HashMap<String, Capitulo> dicionárioCap = new HashMap<String, Capitulo>();

        File arquivo = new File(caminho);
        try {
            Scanner scan = new Scanner(arquivo, "CESU8");

            System.out.println("Carregando Capítulos...");

            String linha = scan.nextLine();
            while (scan.hasNextLine()) {
                if (linha.equals("CAPITULO")||
                    linha.equals("CAPITULO_COM_IMAGEM"))
                {
                    scan.nextLine(); // ID
                    String id = scan.nextLine();

                    if(linha.equals("CAPITULO"))
                    {
                        dicionárioCap.put(id, new Capitulo(dicionarioDePersonagens, scan));
                        scan.nextLine();
                    }
                    else if(linha.equals("CAPITULO_COM_IMAGEM"))
                    {
                        dicionárioCap.put(id, new CapituloIMG(dicionarioDePersonagens, scan));
                    }

                    System.out.println("Capítulo " + id);

                } else if (linha.equals("ESCOLHA")) {
                    LerEscolha(dicionárioCap, scan);
                }
                linha = scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return dicionárioCap;
    }

    private void LerEscolha(
            HashMap<String, Capitulo> dicionárioCap,
            Scanner scan) {
        scan.nextLine(); // DE
        String idCapituloDe = scan.nextLine();
        scan.nextLine(); // PARA
        String idCapituloPara = scan.nextLine();
        scan.nextLine(); // TEXTO DIGITADO
        String textoDigitado = scan.nextLine();
        scan.nextLine(); // TEXTO DISPLAY
        String textoDisplay = scan.nextLine();
        dicionárioCap.get(idCapituloDe).addEscolha(new Escolha(
                textoDigitado,
                textoDisplay,
                dicionárioCap.get(idCapituloPara)));
    }

}
