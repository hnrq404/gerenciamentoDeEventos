public class Sistema{
    public static void main(String[] args){
        Participante participante = new Participante("Henrique", 15, "1234123", "daniel@hotmai.com", "espectador");
        System.out.println(participante.getTipo());
    }
}