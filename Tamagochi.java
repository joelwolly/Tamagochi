import java.util.Scanner;

public class Tamagochi {

    private String nome;
    private int energia;
    private int felicidade;
    private int fome;
    private int sono;

    public Tamagochi(String nome) {
        this.nome = nome;
        this.energia = 50;
        this.felicidade = 100;
        this.fome = 50;
        this.sono = 50;
    }

    public String getNome() {
        return nome;
    }

    public void alimentar() {
        if (fome == 0) {
            System.out.println(nome + " está de barriguinha cheia!");
        } else {
            System.out.println(nome + " comeu seu prato de aveia!");
            fome -= 10;
            if (fome < 0)
                fome = 0;
        }
    }

    public void dormir() {
        if (energia < 100) {
            energia += 10;
            sono -= 10;
            if (sono < 0)
                sono = 0;
            System.out.println(nome + " tirou uma soneca...");
        } else {
            System.out.println(nome + " não está com sono!");
        }
    }

    public void brincar() {
        if (felicidade < 100) {
            felicidade += 10;
            energia -= 10;
            fome += 20;
            sono += 10;
            if (energia < 0)
                energia = 0;
            if (fome > 100)
                fome = 100;
            if (sono > 100)
                sono = 100;
            System.out.println(
                    nome + " brincou! Felicidade: " + felicidade + ", Energia: " + energia + ", Fome: " + fome);
        } else {
            System.out.println(nome + " já está muito feliz!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tamagochi meuTamagochi = new Tamagochi("Carrerinha");

        while (true) {

            System.out.flush();

            System.out.println("\nEscolha uma açao para " + meuTamagochi.getNome() + ":");
            System.out.println("1. Brincar");
            System.out.println("2. Alimentar");
            System.out.println("3. Dormir");
            System.out.println("4. Sair");
            System.out.print("Digite o número da açao: ");

            int acao = scanner.nextInt();

            switch (acao) {
                case 1:
                    meuTamagochi.brincar();
                    break;
                case 2:
                    meuTamagochi.alimentar();
                    break;
                case 3:
                    meuTamagochi.dormir();
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Açao inválida. Por favor, escolha novamente.");
            }
        }
    }
}
