package reparebem;

public class OrdemServico {
    private Reparo[] reparos;
    private int nextReparo;
    private String status;
    private int id;
    private String nomeCliente;
    private String telefone;
    private String roupa;

    public OrdemServico(int id, String nomeCliente, String telefone, String roupa){
        this.reparos = new Reparo[10];
        this.nextReparo = 0;
        this.status = "Não iniciada";

        this.id = id;
        this.nomeCliente = nomeCliente;
        this.roupa = roupa;
        this.telefone = telefone;
    }

    public void addReparo(Reparo reparo){
        if (this.nextReparo >= 9){
            return;
        }
          
        this.reparos[this.nextReparo++] = reparo;
    }

    public double getValorTotal(){
        double total = 0;
        for(Reparo r : this.reparos){
            total += r.getPreco();
        }

        return total;
    }

    public String toString(){
        return "#" + this.id + "; cliente: " + this.nomeCliente + "; roupa: " + this.roupa + 
                "; reparos: " + this.nextReparo + "; total: R$" + this.getValorTotal();
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}