import java.util.ArrayList;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;

public class Controlador {

  @FXML
  public TextArea CapTx;

  @FXML
  public ButtonBar botaoEsc;

  @FXML
  public TextArea txASCI;

  @FXML
  public Button iniHist;

  private Capitulo raiz;

  @FXML
  void iniciaHist(ActionEvent event) {
    Leitor ler = new Leitor();

    Map<String, Personagens> dicionarioDePersonagens = ler.carregarPersonagens("rsc/Personagens.txt");

    Map<String, Capitulo> dicionarioDeCapitulos = ler.carregarCapitulos("rsc/Capitulo.txt", dicionarioDePersonagens);

    System.out.println("Carregamento finalizado.\n\nIniciando História...\n");
    raiz = dicionarioDeCapitulos.get("Raiz");

    mostarCap(raiz);
    iniHist.setVisible(false);

    //raiz.executar();
  }

  private void mostarCap(Capitulo capitulo) {
    mostarTextoCap(capitulo.getTexto());
    mostarEscolhas(capitulo.getEscolhas());
  }

  public void mostarTextoCap(String texto) {
    CapTx.setText(texto);
  }

  public void mostarTextoASCII(String imgASCII) {
    txASCI.setText(imgASCII);
  }

  public void mostarEscolhas(ArrayList<Escolha> escolhas) {
    botaoEsc.setPadding(new Insets(0));

    for (int i = 0; i < escolhas.size(); i++) {
      BotaoEscolha botao = new BotaoEscolha(escolhas.get(i));
      botao.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          botao.getEscolha().getProximo();
        }
      });
      botaoEsc.getButtons().add(botao);
    }
  }
}
