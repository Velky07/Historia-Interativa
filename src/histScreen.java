import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;

public class histScreen {

    @FXML
    private TextArea CapTx;

    @FXML
    private ButtonBar botaoEsc;

    @FXML
    private TextArea txASCI;

    public void mostarTextoCap(String texto)
    {
        CapTx.setText(texto);
    }
    
    public void mostarTextoASCII(String imgASCII)
    {
        txASCI.setText(imgASCII);
    }

    public void mostarEscolhas(ArrayList<Escolha> escolhas)
    {
        botaoEsc.setPadding(new Insets(10));

        for (int i = 0; i < escolhas.size(); i++) {
            botaoEsc.getButtons().add(new Button(escolhas.get(i).getTextoDisplay()));
        }

    }
}

