public abstract class Ingresso {
    Partida partida;
    TipoIngresso tipo;
    Assento assento;
    double preco;

    Ingresso(Partida partida, TipoIngresso tipo, Assento assento, double preco) {
        this.partida = partida;
        this.tipo = tipo;
        this.assento = assento;
        this.preco = preco;
    }

    public double getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return this.partida + "\n" + "Tipo: " + this.tipo + "\n" + "Assento: " + this.assento + "\n" + "Preço: R$" + this.preco + "\n";
    }
} 
