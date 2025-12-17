package reparebem;

import java.util.ArrayList;
import java.util.HashMap;

public class RepareBem {
    private ArrayList<OrdemServico> ordens;
    private HashMap<String, Reparo> reparos;


    public RepareBem(){
        this.ordens = new ArrayList<>();
        this.reparos = new HashMap<>();
    }
    
	public void cadastrarReparo(String idReparo, String descricao, double preco) {
	    if (!this.reparos.containsKey(idReparo)){
            this.reparos.put(idReparo, new Reparo(idReparo, descricao, preco));
        }
	}

	public void reajustarPrecoReparo(String idReparo, double percentual) {
		getReparo(idReparo).reajustarPreco(percentual);
	}

	public int cadastrarOrdemDeServico(String cliente, String telefone, String roupa) {
		this.ordens.add(new OrdemServico(this.ordens.size() + 1, cliente, telefone, roupa));
		return this.ordens.size();
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
		for (OrdemServico o : this.ordens){
			if (o.getStatus().equals(status)){
				out += "\n" + o.toString();
			}
		}
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
		OrdemServico ordem = this.ordens.get(id);
		if (ordem != null) {
			return ordem;
		}
		throw new IllegalArgumentException("ORDEM DE SERVIÇO INEXISTENTE");
	}

	private Reparo getReparo(String id){
	    Reparo reparo = this.reparos.get(id);
		if (reparo != null){
			return reparo;
		}
		throw new IllegalArgumentException("REPARO INEXISTENTE");
	}
}
