import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// Alunos:
// RA: 194211 - Gabriel Borba
// RA: 194210 - Nathan Calheiros


public class GerenciaClientes {
    // Caminho da pasta onde os arquivos de clientes serão armazenados
    private static final String URL_PASTA = "C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Java";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:\n1 – Cadastrar Cliente\n2 – Exibir Cliente\n3 – Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha após a leitura do número

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    exibirCliente(scanner);
                    break;
                case 3:
                    System.out.println("Finalizando");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    // Método para cadastrar um novo cliente
    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Informe o CPF do cliente: ");
        String cpf = scanner.nextLine();

        GerenciaArquivosTxt gerenciaArquivos = new GerenciaArquivosTxt(cpf, URL_PASTA);

        // Verifica se o cliente já está cadastrado
        if (gerenciaArquivos.verificaArquivo()) {
            System.out.println("Cliente já cadastrado. \n1 – Atualizar cadastro \n2 – Exibir dados");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (opcao == 2) {
                exibirDadosCliente(cpf);
                return;
            }
        }

        // Coleta os dados do cliente
        Pessoa cliente = new Pessoa(cpf);
        System.out.print("Informe o nome: ");
        cliente.setNome(scanner.nextLine());

        // Valida e coleta a data de nascimento
        while (true) {
            System.out.print("Informe a data de nascimento (dd/mm/aaaa): ");
            String dataNascimento = scanner.nextLine();
            if (dataValida(dataNascimento)) {
                cliente.setDataNascimento(dataNascimento);
                break;
            } else {
                System.out.println("Data de nascimento inválida. Por favor, insira novamente.");
            }
        }

        System.out.print("Informe o email: ");
        cliente.setEmail(scanner.nextLine());

        // Formata o conteúdo a ser salvo no arquivo
        String conteudo = String.format("Nome: %s\nCPF: %s\nData de Nascimento: %s\nE-mail: %s",
                cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento(), cliente.getEmail());

        // Grava o conteúdo no arquivo
        gerenciaArquivos.gravaArquivo(conteudo);
    }

    // Método para exibir os dados de um cliente
    private static void exibirCliente(Scanner scanner) {
        System.out.print("Informe o CPF do cliente: ");
        String cpf = scanner.nextLine();

        GerenciaArquivosTxt gerenciaArquivos = new GerenciaArquivosTxt(cpf, URL_PASTA);

        // Verifica se o cliente está cadastrado
        if (gerenciaArquivos.verificaArquivo()) {
            exibirDadosCliente(cpf);
        } else {
            System.out.println("Cliente NÃO cadastrado, deseja cadastrar? 1 – SIM, 2 – NÃO");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (opcao == 1) {
                cadastrarCliente(scanner);
            }
        }
    }

    // Método auxiliar para exibir os dados de um cliente a partir do CPF
    private static void exibirDadosCliente(String cpf) {
        GerenciaArquivosTxt gerenciaArquivos = new GerenciaArquivosTxt(cpf, URL_PASTA);
        String conteudo = gerenciaArquivos.leArquivo();
        if (conteudo != null) {
            System.out.println(conteudo);
        } else {
            System.out.println("Erro ao ler os dados do cliente.");
        }
    }

    // Método para validar a data de nascimento
    private static boolean dataValida(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(date, dateFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
