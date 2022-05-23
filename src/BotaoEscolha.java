import javafx.scene.control.Button;

public class BotaoEscolha extends Button
{
  private Escolha escolha;

  public BotaoEscolha(Escolha escolha)
  {
    super(escolha.getTextoDisplay());
    this.escolha = escolha;
  }  

  public Escolha getEscolha()
  {
    return this.escolha;
  }
}
