import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application 
{
    
    public static void main(String[] args)
    {    
        Scanner scan = new Scanner(System.in, "CP850");
        Leitor ler = new Leitor();

        Map<String,Personagens> dicionarioDePersonagens = ler.carregarPersonagens("rsc/Personagens.txt");
        
        Map<String,Capitulo> dicionarioDeCapitulos = ler.carregarCapitulos("rsc/Capitulo.txt", dicionarioDePersonagens, scan);
        
        System.out.println("Carregamento finalizado.\n\nIniciando História...\n");
        Capitulo raiz = dicionarioDeCapitulos.get("Raiz");    
    
        
        scan.close();
        
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
    
}



