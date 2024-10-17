import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private String descricao;
    private Local local;
    private List <Participante> participantes = new ArrayList<>();
    public Evento(String nome,String descricao,Local local){
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
    }
    public void cadastrarParticipante(Participante participante){
        if (local.getQuantidade() == local.getCapacidade()){
            System.out.println("O evento já atingiu a capacidade máxima");
            return;
        }
        participantes.add(participante);
        local.addQuantidade();
    }

    public void setNome(String var){
        this.nome = var;
    }
    public String getNome(){
        return this.nome;
    }
    public void setDescricao(String var){
        this.descricao = var;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public void setLocal(Local var){
        this.local = var;
    }
    public Local getLocal(){
        return this.local;
    }
    public void exibirDados(){
        System.out.println("Nome do evento: " + this.nome);
        System.out.println("Descrição do evento: " + this.descricao);
        local.exibirDados();
        System.out.println("Palestrantes: ");
        for (Participante pessoa : participantes) {
            if (pessoa.getTipo() == "palestrante"){
                System.out.println(pessoa.getNome());
            }
        }
    }
    public List <Participante> getParticipantes(){
        return participantes;
    }
}
