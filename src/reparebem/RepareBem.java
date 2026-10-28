package reparebem;

import java.util.ArrayList;
import java.util.HashMap;

public class RepareBem {
    private OrdemServico[] ordens;
    private Reparo[] reparos;
	private int qntdReparos;
	private int qntdOrdens;
	private static final int MAX_REPAROS = 100;
	private static final int MAX_ORDENS = 500;


    public RepareBem(){
        this.ordens = new OrdemServico[MAX_ORDENS];
        this.reparos = new Reparo[MAX_REPAROS];
		qntdReparos = 0;
		qntdOrdens = 0;
    }
    
	public void cadastrarReparo(String idReparo, String descricao, double preco) {
	    if (qntdReparos >= MAX_REPAROS) { return; }

		Reparo newReparo = new Reparo(idReparo, descricao, preco);
		for (Reparo reparo : reparos){
			if (newReparo.equals(reparo)){
				return;
			}
		}

		reparos[qntdReparos++] = newReparo;
	}

	public void reajustarPrecoReparo(String idReparo, double percentual) {
		getReparo(idReparo).reajustarPreco(percentual);
	}

	public int cadastrarOrdemDeServico(String cliente, String telefone, String roupa) {
		if (qntdOrdens >= MAX_ORDENS) { return -1; }

		ordens[qntdOrdens++] =  new OrdemServico(qntdOrdens + 1, cliente, telefone, roupa);
		return qntdOrdens;
	}

	public String exibirOrdemDeServico(int idOS) {
	    return getOrdem(idOS).toString();
	}

	public void incluirReparoOrdemDeServico(int idOS, String idReparo) {
	    getOrdem(idOS).addReparo(getReparo(idReparo));
	}

	public void mudarStatusOrdemDeServico(int idOS, String status) {
	    getOrdem(idOS).setStatus(status);
	}

	public double obterValorOrdemServico(int idOS) {
	    return getOrdem(idOS).getValorTotal();
	}

	public String listarOrdemDeServico(String status) {
	    String out = "Ordens de serviço - " + status;
		boolean vazio = true;
		for (OrdemServico o : this.ordens){
			if (o.getStatus().equals(status)){
				out += "\n" + o.toString();
				vazio = false;
			}
		}

		if (vazio){ return "Não há ordens de serviço do tipo " + status;}

	    return out;
	}

	public String listarOrdensDeServico() {
	    String out = "Ordens de serviço:";
		for (OrdemServico o : this.ordens){
			out += "\n" + o.toString();
		}
	    return out;
	}

	private OrdemServico getOrdem(int id){
		for (OrdemServico ordem : ordens){
			if (ordem != null && ordem.getId() == id ){
				return ordem;
			}
		}

		throw new IllegalArgumentException("ORDEM DE SERVIÇO INEXISTENTE");
	}

	private Reparo getReparo(String id){
		for (Reparo reparo : reparos){
			if (reparo != null && reparo.getId().equals(id)){
				return reparo;
			}
		}

		throw new IllegalArgumentException("REPARO INEXISTENTE");
	}
}
