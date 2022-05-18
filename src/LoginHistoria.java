import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginHistoria {

    @FXML
    private Button botaoIniciar;

    @FXML
    private Label mostarNick;

    @FXML
    private TextField txFieldNick;

    @FXML
    void iniciarHist(ActionEvent event) {
        String nome = txFieldNick.getText();
        mostarNick.setText(nome);
    }

}
