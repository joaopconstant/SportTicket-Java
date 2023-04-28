public class Partida {
    String nome, data, local;
    int ingressosInteira, ingressosMeia;

    Partida(String nome, String data, String local, int ingressosInteira, int ingressosMeia) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.ingressosInteira = ingressosInteira;
        this.ingressosMeia = ingressosMeia;
    }

    public String getNome() {
        return this.nome;
    }

    public String getData() {
        return this.data;
    }

    public String getLocal() {
        return this.local;
    }

    public int getIngressos() {
        return this.ingressosMeia + this.ingressosInteira;
    }

    public boolean isIngressoDisponivel(TipoIngresso tipo, int quantidade) {
        // verifica se há ingressos disponíveis para o tipo e quantidade especificado.
        if(tipo == TipoIngresso.INTEIRA) {
            if(quantidade <= ingressosInteira) {
                return true;
            }
        }
        
        else if (tipo == TipoIngresso.MEIA) {
            if (quantidade <= ingressosMeia) {
                return true;
            }
        }
        return false;
    }

    public double venderIngresso(TipoIngresso tipo, int quantidade) {
        // realiza a venda de ingressos do tipo e quantidade especificados e retorna o valor total da venda.
        double preco = 0.0;
        if (isIngressoDisponivel(tipo, quantidade)) {
            if (tipo == TipoIngresso.INTEIRA) {
                this.ingressosInteira -= quantidade;
                preco = 50.0;
            } else if (tipo == TipoIngresso.MEIA) {
                this.ingressosMeia -= quantidade;
                preco = 25.0;
            }
        }
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return "Nome da Partida: " + getNome() + "\n" + 
        "Data: " + getData() + "\n" + 
        "Local: " + getLocal();
    }
}
