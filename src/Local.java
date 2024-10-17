public class Local {
    private String rua;
    private String cidade;
    private String estado;
    private int capacidade;
    private int quantidade;
    private int numero;

    public Local(String rua, String cidade,String estado,int capacidade,int numero){
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.capacidade = capacidade;
        this.numero = numero;
    }
    public void setRua(String var){
        this.rua = var;
    }
    public String getRua(){
        return this.rua;
    }
    public void setCidade(String var){
        this.cidade = var;
    }
    public String getCidade(){
        return this.cidade;
    }
    public void setEstado(String var){
        this.estado = var;
    }
    public String getEstado(){
        return this.estado;
    }

    public void setCapacidade(int var){
        this.capacidade = var;
    }
    public int getCapacidade(){
        return this.capacidade;
    }
    public void setNumero(int var){
        this.numero = var;
    }
    public int getNumero(){
        return this.numero;
    }
    public void addQuantidade(){
        this.quantidade++;
    }
    public int getQuantidade(){
        return this.quantidade;
    }
    public void exibirDados(){
        System.out.println("Rua: " + this.rua);
        System.out.println("Número: " + this.numero);
        System.out.println("Cidade: " + this.cidade);
        System.out.println("Estado: " + this.estado);
    }
}
