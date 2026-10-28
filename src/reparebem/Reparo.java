package reparebem;

public class Reparo {
    private String id;
    private String descricao;
    private double preco;

    public Reparo(String id, String descricao, double preco){
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    public void reajustarPreco(double valor){
    	this.preco *= valor;
    }

    public int hashcode(){
        return this.id.hashCode();
    }

    public boolean equals(Object obj){
        if (obj == null){ return false; }
        if (this.getClass() != obj.getClass()) { return false; }

        return this.id.equals(((Reparo) obj).id);
    }    

    public double getPreco(){
        return this.preco;
    }

    public String getId() {
        return id;
    }
}