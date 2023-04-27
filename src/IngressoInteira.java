public class IngressoInteira extends Ingresso {
    IngressoInteira(Partida partida, Assento assento, double preco) {
        super(partida, TipoIngresso.INTEIRA, assento, preco);
        this.preco = 50.0;
        this.tipo = TipoIngresso.INTEIRA;
    }
}