import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    
    public static void main(String[] args) throws Exception {
        
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI.fxml"));
        Parent root = loader.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("Golens Antigos");
        primaryStage.setScene(tela);
        primaryStage.show();
    }
    
    //     Scanner scan = new Scanner(System.in, "CP850");
        
        
    //     //------------------------------------------------------------------------------------------
    //     Leitor ler = new Leitor();
    //     Map<String,Personagens> dicionarioDePersonagens = ler.carregarPersonagens("rsc/Personagens.txt");
        
    //     Map<String,Capitulo> dicionarioDeCapitulos = ler.carregarCapitulos("rsc/Capitulo.txt", dicionarioDePersonagens, scan);
        
    //     System.out.println("Carregamento finalizado.\n\nIniciando História...\n");
    //     System.out.println("Nota:\nPara que nossa história funcione, favor digite a palavra destacada\nBom proveito :]");
    //     System.out.println();
    //     Capitulo raiz = dicionarioDeCapitulos.get("Raiz");    
    //     raiz.executar();
        
    //     scan.close();
    // }

}

