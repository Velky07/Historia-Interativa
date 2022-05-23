public class Personagens {
  private String nome;
  private int vida;

  public Personagens(String nome, int vida) 
  {
    this.nome = nome;
    this.vida = vida;
  }

  public void incrementarVida(int vidaGanha) 
  {
    int vidaInicial = vida;
    int vidaMostrada = 0;
    
    if (vidaGanha != 0) 
    {
      setVida(this.vida + vidaGanha);
      
      if (vidaGanha < -30) 
      {
        vidaMostrada = vidaGanha - (vidaGanha * 2);
        System.out.println("\nO " + nome + " perdeu " + vidaMostrada + " de vida.\n");
      }
      
      if (!(vidaMostrada >= vidaInicial)) 
      {
        System.out.println(nome + " está com " + vida + " de vida.");
      }
      
      if (vida <= 0) 
      {
        System.out.println("O " + nome + " morreu.\n");
      }
    }
  }

  public void resetarVidaProt() 
  {
    int vidaPadrãoProt = 20;
    vida = vidaPadrãoProt;
    
    System.out.println("O " + nome + " está com a vida cheia.");
  }

  public String getNome() 
  {
    return this.nome;
  }

  public int getVida() 
  {
    return this.vida;
  }

  private void setVida(int vida) 
  {
    this.vida = vida;
    
    if (vida < 0) 
    {
      this.vida = 0;
    }
  }
}