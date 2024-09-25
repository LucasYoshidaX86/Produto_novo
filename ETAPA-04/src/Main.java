public class Main {
    public static void main(String[] args) {
        // Atributos com todas informações.
        Produto produto1 = new Produto("Água de coco", 2.0, 3.50, "25/07/2024", "25/07/2025");
        
        // Atributos com nome, preço de custo, preço de venda e data de fabricação.
        Produto produto2 = new Produto("Feijão", 8.0, 15.0, "01/08/2024");
        
        // Atributos com nome e preço de custo. 
        Produto produto3 = new Produto("Salgadinho", 10.0);
        
        // Exibindo informações dos produtos
        produto1.Produtos();
        produto2.Produtos();
        produto3.Produtos();
    }
}