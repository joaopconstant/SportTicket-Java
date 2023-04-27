import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Partida partida = new Partida("Partida de Futebol", "28/04/2023 19:00", "Estádio do Pacaembu", 100, 50);
        System.out.println("Bem-vindo ao sistema de venda de ingressos!");

        while(true) {
            System.out.println("\nDigite uma opção:");
            System.out.println("1 - Cadastrar nova partida");
            System.out.println("2 - Vender ingresso");
            System.out.println("3 - Exibir informações da partida");
            System.out.println("4 - Exibir número de ingressos restantes");
            System.out.println("5 - Exibir informações do último ingresso vendido");
            System.out.println("6 - Sair" + "\n");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                // cadastra uma nova partida
                System.out.println("Insira o nome da Partida: ");
                String nome = scanner.nextLine();
                System.out.println("Insira a data da Partida: ");
                String data = scanner.nextLine();
                System.out.println("Insira o local da Partida: ");
                String local = scanner.nextLine();
                System.out.println("Insira o número de Ingressos tipo Inteira disponíveis: ");
                int ingressosInteira = scanner.nextInt();
                System.out.println("Insira o número de Ingressos tipo Meia disponíveis: ");
                int ingressosMeia = scanner.nextInt();
                
                partida = new Partida(nome, data, local, ingressosMeia, ingressosInteira);
                System.out.println("Partida cadastrada com sucesso!");
                break;

                case 2:
                // realiza a venda de um ingresso
                System.out.println("Digite a fila do Assento desejado: ");
                char fila = scanner.next().charAt(0);
                System.out.println("Digite o número do Assento desejado: ");
                int numero = scanner.nextInt();
                System.out.println("Informe o tipo do Ingresso (Inteira - I / Meia - M): ");
                char tipoIngresso = scanner.next().charAt(0);
                TipoIngresso tipo;
                // verifica o tipo do ingresso
                if (tipoIngresso == 'I') {
                    tipo = TipoIngresso.INTEIRA;
                } else if (tipoIngresso == 'M') {
                    tipo = TipoIngresso.MEIA;
                } else {
                    System.out.println("Tipo de Ingresso inválido!");
                    break;
                }
                System.out.println("Informe a quantidade de ingressos desejada: ");
                int quantidade = scanner.nextInt();
                System.out.println("Confirma a compra do ingresso? (S/N)");
                char confirmacao = scanner.next().charAt(0);
                if (confirmacao == 'S') {
                // verifica se o ingresso está disponível
                    if (partida.isIngressoDisponivel(tipo, quantidade)) {
                // gera o ingresso e exibe as informações
                        Assento assento = new Assento(fila, numero);
                        double preco = tipo == TipoIngresso.INTEIRA ? 50.0 : 25.0;
                        Ingresso ingresso;
                        if (tipo == TipoIngresso.INTEIRA) {
                            ingresso = new IngressoInteira(partida, assento, preco);
                        } else {
                            ingresso = new IngressoMeia(partida, assento, preco);
                        }
                        System.out.println("Ingresso gerado:");
                        System.out.println(ingresso);
                // realiza a venda do ingresso
                        double valorVenda = partida.venderIngresso(tipo, quantidade);
                        System.out.println(String.format("Ingresso vendido por R$%.2f.", valorVenda));
                    } else {
                        System.out.println("Ingressos esgotados para o tipo selecionado.");
                    }
                }
                break;

                case 3:
                // exibe as informações da partida
                System.out.println("------ Informações da partida ------");
                System.out.println(partida);
                System.out.println("-----------------------------------");
                break;

                case 4:
                System.out.println("-----------------------------------");
                System.out.println("Número de ingressos restantes: " + partida.getIngressos());
                System.out.println("-----------------------------------");
                break;

                case 5:
                break;
                
                case 6:
                System.out.println("Saindo...");
                break;

                default:
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}