public class IngressoMeia extends Ingresso {
    IngressoMeia(Partida partida, Assento assento, double preco) {
        super(partida, TipoIngresso.MEIA, assento, preco);
        this.preco = 25.0;
        this.tipo = TipoIngresso.MEIA;
    }
}
