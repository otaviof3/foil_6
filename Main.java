
import java.util.ArrayList;
import java.util.List;

class Pessoa {

    private final String nome;
    private int idade;
    private String faseVida;
    private final List<String> experiencias = new ArrayList<>();

    Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.faseVida = "Nascimento";
        experiencias.add("Nasceu");
    }

    public void crescer(int anos) {
        this.idade += anos;
        definirFaseVida();
    }

    private void definirFaseVida() {
        if (idade < 12) {
            faseVida = "Infância";
        } else if (idade < 18) {
            faseVida = "Adolescência";
        } else {
            faseVida = "Adulto";
        }
    }

    public void adicionarExperiencia(String experiencia) {
        experiencias.add(experiencia);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getFaseVida() {
        return faseVida;
    }

    @Override
    public String toString() {
        return nome + " (" + idade + " anos) - Fase: " + faseVida + " - Experiências: " + experiencias;
    }
}

class Pai extends Pessoa {

    List<Filho> filhos = new ArrayList<>();

    Pai(String nome, int idade) {
        super(nome, idade);
    }
}

class Mae extends Pessoa {

    List<Filho> filhos = new ArrayList<>();

    Mae(String nome, int idade) {
        super(nome, idade);
    }
}

class Filho extends Pessoa {

    Pai pai;
    Mae mae;

    Filho(String nome, int idade) {
        super(nome, idade);
    }
}

class Divorcio {

    Pai pai;
    Mae mae;
    List<Filho> filhos;

    Divorcio(Pai pai, Mae mae, List<Filho> filhos) {
        this.pai = pai;
        this.mae = mae;
        this.filhos = filhos;
    }

    @Override
    public String toString() {
        return "Divorciados, " + pai.getNome() + " e " + mae.getNome() + " têm filhos " + filhos;
    }
}

public class Main {

    public static void main(String[] args) {
        Pai pai = new Pai("Marcos", 31);
        Mae mae = new Mae("Marcilene", 36);
        Filho filho = new Filho("Otávio", 0);

        pai.filhos.add(filho);
        mae.filhos.add(filho);
        filho.pai = pai;
        filho.mae = mae;

        filho.adicionarExperiencia("Meu vô e eu nascemos no mesmo dia");
        filho.adicionarExperiencia("Comecei a falar");
        filho.crescer(5);
        pai.crescer(5);
        mae.crescer(5);
        filho.adicionarExperiencia("Divórcio dos meus pais");
        filho.adicionarExperiencia("Comecei a jogar");
        filho.crescer(2);
        pai.crescer(2);
        mae.crescer(2);
        filho.adicionarExperiencia("Aprendi inglês");
        filho.adicionarExperiencia("Conheci meu melhor amigo de sempre");
        filho.adicionarExperiencia("Comecei a usar óculos");
        filho.adicionarExperiencia("Brincava de carinho, olhava revistas de futebol e youtube, contava histórias com brinquedos");
        filho.adicionarExperiencia("Queria ser jogador de futebol ou youtuber");
        filho.crescer(3);
        pai.crescer(3);
        mae.crescer(3);
        filho.adicionarExperiencia("Morte de meu vô");
        filho.crescer(2);
        pai.crescer(2);
        mae.crescer(2);
        filho.adicionarExperiencia("9º Ano");
        filho.crescer(3);
        pai.crescer(3);
        mae.crescer(3);
        filho.adicionarExperiencia("Ensino Médio em SM, conheci pessoas novas");
        filho.adicionarExperiencia("Comecei academia e pandemia");
        filho.adicionarExperiencia("Minha gata Mitch apareceu em casa");
        filho.crescer(3);
        pai.crescer(3);
        mae.crescer(3);
        filho.adicionarExperiencia("CNH");
        filho.adicionarExperiencia("Primeiro trabalho");
        filho.adicionarExperiencia("Morar no Recanto");
        filho.adicionarExperiencia("SI na AMF");
        filho.crescer(3);
        pai.crescer(3);
        mae.crescer(3);

        List<Filho> filhos = new ArrayList<>();
        filhos.add(filho);
        Divorcio divorcio = new Divorcio(pai, mae, filhos);

        // Mostrando a história de vida
        System.out.println(divorcio);
    }
}
