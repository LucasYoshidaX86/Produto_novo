import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//Classe Produto com atributos requisitados na atividade.
public class Produto {
    private String nome;
    private double precoCusto;
    private double precoVenda;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;

    // Formatação da data.
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Constructor que recebe todos os atributos
    public Produto(String nome, double precoCusto, double precoVenda, String dataFabricacaoStr, String dataValidadeStr) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.dataFabricacao = parseData(dataFabricacaoStr);
        this.dataValidade = parseData(dataValidadeStr);
    }

    // Constructor que recebe nome, preço de custo e data de fabricação e altera o vencimento para 1 mês depois da fabricação.
    public Produto(String nome, double precoCusto, double precoVenda, String dataFabricacaoStr) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.dataFabricacao = parseData(dataFabricacaoStr);
        this.dataValidade = dataFabricacao.plusMonths(1); 
    }

    // Construtor que recebe nome e preço de custo, adiciona 10% sobre o valor de custo e o vencimento para 1 mês depois da fabricação.
    public Produto(String nome, double precoCusto) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoCusto * 1.10; 
        this.dataFabricacao = LocalDate.now(); 
        this.dataValidade = dataFabricacao.plusMonths(1);
    }

    // Método criado para converter a String da data em LocalDate.
    private LocalDate parseData(String dataStr) {
        try {
            return LocalDate.parse(dataStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data inválida: " + dataStr);
        }
    }

    // Métodos getters para acessar atributos privados.
    public String getNome() {
        return nome;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    // Método para exibir da classe dentro do main. 
    public void Produtos() {
        System.out.println("Nome: " + getNome() +
                ", Preço de Custo: " + getPrecoCusto() +
                ", Preço de Venda: " + getPrecoVenda() +
                ", Data de Fabricação: " + getDataFabricacao().format(formatter) +
                ", Data de Validade: " + getDataValidade().format(formatter));
    }
}