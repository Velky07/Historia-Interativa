import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Capitulo {
  private String texto;
  protected ArrayList<Escolha> escolhas;
  private Personagens personagem1;
  private Personagens personagem2;
  private int incrementoVida1;
  private int incrementoVida2;

  public Capitulo(String texto,
      Personagens personagem1,
      Personagens personagem2,
      int incrementoVida1,
      int incrementoVida2) {
    this.texto = texto;
    this.personagem1 = personagem1;
    this.personagem2 = personagem2;
    this.incrementoVida1 = incrementoVida1;
    this.incrementoVida2 = incrementoVida2;
    this.escolhas = new ArrayList<Escolha>();
  }

  protected Capitulo() {
    this.texto = "";
    this.escolhas = new ArrayList<Escolha>();
  }

  public Capitulo(
      Map<String, Personagens> dicionarioDePersonagens,
      Scanner scan) {
    this.LerCapitulos(dicionarioDePersonagens, scan);
    this.escolhas = new ArrayList<Escolha>();
  }
  
  public void addEscolha(Escolha escolha) {
    escolhas.add(escolha);
  }
  
  public String getTexto() {
    return this.texto;
  }

  public ArrayList<Escolha> getEscolhas() {
    return escolhas;
  }

  protected void LerCapitulos(
      Map<String, Personagens> dicionarioDePersonagens,
      Scanner scan) {
    scan.nextLine(); // PERSONAGENS
    String idPerson1 = scan.nextLine();
    String idPerson2 = scan.nextLine();
    this.personagem1 = dicionarioDePersonagens.get(idPerson1);
    this.personagem2 = dicionarioDePersonagens.get(idPerson2);

    scan.nextLine(); // TEXTO

    String linha = scan.nextLine();
    this.texto = "";
    while (!linha.equals("VARIACOES")) {
      if (linha.equals(idPerson1)) {
        texto = texto + personagem1.getNome();

      } else if (linha.equals(idPerson2)) {
        texto = texto + personagem2.getNome();
      } else {
        texto = texto + linha;
      }
      linha = scan.nextLine();

    }

    this.incrementoVida1 = Integer.parseInt(scan.nextLine());
    this.incrementoVida2 = Integer.parseInt(scan.nextLine());

  }


  // public void executar() {
  //   mostrar();

  //   if (escolhas.size() > 0) {
  //     int idCapituloEsc = escolher();
  //     escolhas.get(idCapituloEsc - 1).getProximo().executar();
  //   } else {
  //     System.out.println("Sua aventura acabou, reicinie o programa para novas expêriencias");
  //   }
  // }

  // protected void mostrar() {
  //   System.out.println();
  //   System.out.println("===");
  //   System.out.println();

  //   System.out.println(texto + "\n");
  //   personagem1.incrementarVida(incrementoVida1);
  //   personagem2.incrementarVida(incrementoVida2);
  //   if (incrementoVida2 != 0) {
  //     System.out.println();
  //   }

  //   for (int i = 0; i < escolhas.size(); i++) {
  //     if (!escolhas.get(i).getTextoDisplay().equals("Aperte Enter para continuar...")) {
  //       System.out.println(escolhas.get(i).getTextoDisplay());
  //     }
  //   }
  // }

  // private int escolher() {
  //   int resultado = 0;

  //   String escolha;

  //   boolean validação = false;

  //   while (!validação) {
  //     if (escolhas.size() == 1) {
  //       personagem1.resetarVidaProt();
  //       System.out.println("\nAperte Enter para continuar...");

  //     }

  //     escolha = "";

  //     for (int i = 0; i < escolhas.size(); i++) {

  //       if (escolha.equalsIgnoreCase(escolhas.get(i).getTextoDigitado())) {
  //         validação = true;
  //         resultado = i + 1;
  //       }
  //     }

  //     if (!validação) {
  //       System.out.println("A escolha digitada não é válida, digite novamente");
  //       validação = false;
  //     }

  //   }
  //   return resultado;
  // }

}
