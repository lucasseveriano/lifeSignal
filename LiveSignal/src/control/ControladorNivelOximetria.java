package control;

import model.Oximetria;

public class ControladorNivelOximetria {
	
	Oximetria oximetria;
	ControladorPrograma ctrlPrograma;
	LeitorBatimentos batimentos = new LeitorBatimentos();
	
	public ControladorNivelOximetria (ControladorPrograma ctrl){
		this.ctrlPrograma = ctrl;
		
	}
	
	/**
	 * M�TODO RESPONS�VEL POR RETORNAR UM OBJETO DE OXIMETRIA
	 * @param nome
	 * @return
	 */
	public Oximetria getOximetria(String nome){
		
		oximetria = Oximetria.getOximetria();
		
		oximetria = atualizarParametrosOximetria(nome, oximetria);
		
		return oximetria;
	}

	
	/**
	 * M�TODOS RESPONS�VEIS POR DEFINIR OS VALORES DE PARAMETROS DO N�VEL DE OXIMETRIA
	 */
	@SuppressWarnings("static-access")
	protected Oximetria atualizarParametrosOximetria(String ritmo, Oximetria oximetria) {
		
		switch(ritmo)
		{
		case "Baixa Perfus�o":
			oximetria.setIndiceDesenhoOximetria(0);
			oximetria.setParametrosOxi(batimentos.getParameters("oxiBaixaPerfus�o.txt"));
			oximetria.setRangeOximetria(322);
			oximetria.setVelocidadePlotOximetria(40);
			oximetria.setValorOximetria("80");
			oximetria.setNomeOximetria("Baixa Perfus�o");
			break;

		case "Ru�do Artefato":
			oximetria.setIndiceDesenhoOximetria(0);
			oximetria.setParametrosOxi(batimentos.getParameters("oxiRu�doArtefato.txt"));
			oximetria.setRangeOximetria(322);
			oximetria.setVelocidadePlotOximetria(40);
			oximetria.setValorOximetria("0");
			oximetria.setNomeOximetria("Ru�do Artefato");
			break;
		
		case "Sinal Normal":
			oximetria.setIndiceDesenhoOximetria(0);
			oximetria.setParametrosOxi(batimentos.getParameters("oxiSinalNormal.txt"));
			oximetria.setRangeOximetria(350);
			oximetria.setVelocidadePlotOximetria(11);
			oximetria.setValorOximetria("95");
			oximetria.setNomeOximetria("Sinal Normal");
			break;		
			
		case "Artefato de Movimento":
			oximetria.setIndiceDesenhoOximetria(0);
			oximetria.setParametrosOxi(batimentos.getParameters("oxiArtefatodeMovimento.txt"));
			oximetria.setRangeOximetria(350);
			oximetria.setVelocidadePlotOximetria(40);
			oximetria.setValorOximetria("0");
			oximetria.setNomeOximetria("Artefato de Movimento");
			break;
		}
		
		return oximetria;
		
	}
}
