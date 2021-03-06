
package control;

import model.Respiratorio;

public class ControladorRitmoRespiratorio {

	Respiratorio respiratorio;
	ControladorPrograma ctrlPrograma;
	LeitorBatimentos batimentos = new LeitorBatimentos();
	
	//M�todo contrutor
	public ControladorRitmoRespiratorio(ControladorPrograma ctrlPrograma){
		this.ctrlPrograma = ctrlPrograma;
	}
	
	/**
	 * M�TODO RESPONS�VEL POR RETORNAR UM OBJETO RESPIRATORIO
	 * @param nome
	 * @return
	 */
	public Respiratorio getRespiratorio(String nome){
		respiratorio = Respiratorio.getRespiratorio();
		respiratorio = atualizarParametrosRespiratorio(nome, respiratorio);
		return respiratorio;
	}
	
	
	private Respiratorio atualizarParametrosRespiratorio(String ritmo, Respiratorio respiratorio) {
		switch(ritmo)
		{
		case "Eupneia":
			Integer valorRitmoRespiratorio = 12 + (int)(Math.random() * 9);
			
			respiratorio.setParametrosResp1(batimentos.getParameters("resEupneia.txt"));
			respiratorio.setParametrosResp2(null);
			respiratorio.setParametrosResp3(null);
			respiratorio.setRetaRespiratorio(15);
			respiratorio.setRetaRespiratorio1(0);
			respiratorio.setRetaRespiratorio2(0);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setValorRespiratorio(valorRitmoRespiratorio.toString());
			respiratorio.setNomeRespiratorio("Eupneia");
			respiratorio.setVelocidadePlotDesenho(20);
			break;
			
		case "Taquipneia":
			respiratorio.setParametrosResp1(batimentos.getParameters("resTaquipneia.txt"));
			respiratorio.setParametrosResp2(null);
			respiratorio.setParametrosResp3(null);
			respiratorio.setRetaRespiratorio(10);
			respiratorio.setRetaRespiratorio1(0);
			respiratorio.setRetaRespiratorio2(0);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setValorRespiratorio("30");
			respiratorio.setNomeRespiratorio("Taquipneia");
			break;
		
		case "Bradipneia":
			respiratorio.setParametrosResp1(batimentos.getParameters("resBradipneia.txt"));
			respiratorio.setParametrosResp2(null);
			respiratorio.setParametrosResp3(null);
			respiratorio.setRetaRespiratorio(100);
			respiratorio.setRetaRespiratorio1(0);
			respiratorio.setRetaRespiratorio2(0);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setVelocidadePlot(20);
			respiratorio.setVelocidadePlotDesenho(50);
			respiratorio.setValorRespiratorio("08");
			respiratorio.setNomeRespiratorio("Bradipneia");
			break;
		
		case "Apneia":
//			respiratorio.setParametrosResp1(null);
//			respiratorio.setParametrosResp2(null);
//			respiratorio.setParametrosResp3(null);
			respiratorio.setRetaRespiratorio(10000);
			respiratorio.setRetaRespiratorio1(0);
			respiratorio.setRetaRespiratorio2(0);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setDesenho(false);
			respiratorio.setValorRespiratorio("0");
			respiratorio.setNomeRespiratorio("Apneia");
			respiratorio.setVelocidadePlotDesenho(20);
			break;			
			
			
		case "Cheyne - Stoke":
			respiratorio.setParametrosResp1(batimentos.getParameters("resCheyneStokes.txt"));
			respiratorio.setParametrosResp2(null);
			respiratorio.setParametrosResp3(null);
			respiratorio.setRetaRespiratorio(30);
			respiratorio.setRetaRespiratorio1(0);
			respiratorio.setRetaRespiratorio2(0);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setValorRespiratorio("14");
			respiratorio.setVelocidadePlotDesenho(20);
			respiratorio.setNomeRespiratorio("Cheyne - Stoke");
			break;
		
		case "Biot's":
			respiratorio.setParametrosResp1(batimentos.getParameters("resBiots.txt"));
			respiratorio.setParametrosResp2(batimentos.getParameters("resBiots2.txt"));
			respiratorio.setParametrosResp3(batimentos.getParameters("resBiots3.txt"));
			respiratorio.setRetaRespiratorio(80);
			respiratorio.setRetaRespiratorio1(80);
			respiratorio.setRetaRespiratorio2(20);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setValorRespiratorio("10");
			respiratorio.setNomeRespiratorio("Biot's");
			respiratorio.setVelocidadePlotDesenho(10);
			break;
		
		case "Apneustic":
			respiratorio.setParametrosResp1(batimentos.getParameters("resApneustic.txt"));
			respiratorio.setParametrosResp2(batimentos.getParameters(null));
			respiratorio.setParametrosResp3(batimentos.getParameters(null));
			respiratorio.setRetaRespiratorio(0);
			respiratorio.setRetaRespiratorio1(0);
			respiratorio.setRetaRespiratorio2(0);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setValorRespiratorio("20");
			respiratorio.setNomeRespiratorio("Apneustic");
			respiratorio.setVelocidadePlotDesenho(20);
			break;	
		}
		return respiratorio;
	}
}