public class Escolha {
  private String textoDigitado;
  private String textoDisplay;
  private Capitulo proximo;

  public Escolha(String textoDigitado, String textoDisplay, Capitulo proximo) {
    this.textoDigitado = textoDigitado;
    this.textoDisplay = textoDisplay;
    this.proximo = proximo;
  }

  public String getTextoDigitado() {
    return textoDigitado;
  }

  public String getTextoDisplay() {
    return textoDisplay;
  }

  public Capitulo getProximo() {
    return proximo;
  }
}
