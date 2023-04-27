public class Assento {
    char fila;
    int numero;

    Assento(char fila, int numero) {
        this.fila = fila;
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }

    public char getFila() {
        return this.fila;
    }

    @Override
    public String toString() {
        return "" + this.numero + this.fila;
    }
}