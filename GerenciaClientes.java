import java.util.Scanner;

public class GerenciaClientes {

    public static void main(String[] args) {
        String urlPasta = "caminho/para/a/pasta"; //Alterar o caminho da pasta aqui
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 – Cadastrar Cliente");
            System.out.println("2 – Exibir Cliente");
            System.out.println("3 – Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            // Chama o método correspondente à opção escolhida
            if (opcao == 1) {
                cadastrarCliente(scanner, urlPasta);
            } else if (opcao == 2) {
                exibirCliente(scanner, urlPasta);
            } else if (opcao == 3) {
                System.out.println("Finalizando");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        private static void cadastrarCliente(Scanner scanner, String urlPasta){
            System.out.print("Informe o CPF do cliente: ");
            String cpf = scanner.nextLine();
            GerenciaArquivosTxt gerenciaArquivos = new GerenciaArquivosTxt(cpf, urlPasta);

            if (gerenciaArquivos.verificaArquivo()) {
                System.out.println("Cliente já cadastrado. \n1 – Atualizar cadastro \n2 – Exibir dados");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
            }
            if (opcao == 2) {
                System.out.println(gerenciaArquivos.leArquivo());
            } else if (opcao == 1) {
                salvarCliente(scanner, cpf, gerenciaArquivos);
            }
        }

    }
}

