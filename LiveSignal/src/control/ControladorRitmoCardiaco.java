package control;

import model.Cardiaco;

public class ControladorRitmoCardiaco {
		
	Cardiaco cardiaco;	
	ControladorPrograma ctrlPrograma;
	
	LeitorBatimentos batimentos = new LeitorBatimentos();
		
	
	/**
	 * MÉTODO CONSTRUTOR DA CLASSE
	 * @param ctrlPrograma
	 */
	public ControladorRitmoCardiaco(ControladorPrograma ctrlPrograma){
			this.ctrlPrograma = ctrlPrograma;
		
	}
	
	/**
	 * MÉTODO RESPONSÁVEL POR RETORNAR UM OBJETO CARDÍACO
	 * @param nome
	 * @return
	 */
	public Cardiaco getCardiaco(String nome){
		
		cardiaco = Cardiaco.getCardiaco();
		
		cardiaco = atualizarParametrosCardiaco(nome, cardiaco);
		
		return cardiaco;
	}
	
	/**
	 * MÉTODOS RESPONSÁVEIS POR DEFINIR OS VALORES DE PARAMETROS DO RITMO CARDÍACO
	 */
	@SuppressWarnings("static-access")
	private Cardiaco atualizarParametrosCardiaco(String ritmo, Cardiaco cardiaco) {
		
		switch(ritmo)
		{
		case "Ritmo Sinusal":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(12);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoSinusal.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Ritmo Sinusal");
			break;			
			

		case "Bradicardia Sinusal":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(12);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("40");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carBradicardiaSinusal.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Bradicardia Sinusal");
			break;

		case "Taquicardia Sinusal":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(9);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("130");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carTaquicardiaSinusal.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Taquicardia Sinusal");
			break;

		case "Arritimia Sinusal":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(9);
			cardiaco.setRetaCardiaco2(20);
			cardiaco.setRetaCardiaco3(20);
			cardiaco.setRetaCardiaco4(9);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("75");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carArritmiaSinusal.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);	
			cardiaco.setNomeCardiaco("Arritimia Sinusal");
			break;

		case "Bloqueio Sinoauricula":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(7);
			cardiaco.setRetaCardiaco2(37);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("50");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carBloqueioSinoauricula.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);	
			cardiaco.setNomeCardiaco("Bloqueio Sinoauricula");
			break;

		case "Pausa Sinusal":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(8);
			cardiaco.setRetaCardiaco2(70);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carPausaSinusal.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);	
			cardiaco.setNomeCardiaco("Pausa Sinusal");
			break;

		case "Ritmo Sinusal Com Extrassistoles Supraventriculares":
			cardiaco.setRetaCardiaco0(3);
			cardiaco.setRetaCardiaco1(22);
			cardiaco.setRetaCardiaco2(8);
			cardiaco.setRetaCardiaco3(8);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("80");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoSinusalComExtrassistolesSupraventricularesPR1.txt"));
			cardiaco.setParametrosCar2(batimentos.getParameters("carRitmoSinusalComExtrassistolesSupraventricularesPR2.txt"));
			cardiaco.setParametrosCar3(batimentos.getParameters("carRitmoSinusalComExtrassistolesSupraventricularesPR2.txt"));
			cardiaco.setParametrosCar4(null);		
			cardiaco.setNomeCardiaco("Ritmo Sinusal Com Extrassistoles Supraventriculares");
			break;

		case "Tarquicardia Supraventricular":
			cardiaco.setRetaCardiaco0(2);
			cardiaco.setRetaCardiaco1(5);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("150");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carTarquicardiaSupraventricular.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Tarquicardia Supraventricular");
			break;

		case "Fibrilação Auricular":			
			cardiaco.setRetaCardiaco0(0);
			cardiaco.setRetaCardiaco1(0);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("150");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carFibrilaçãoAuricular.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Fibrilação Auricular");
			break;

		case "Fluter Auricular":
			cardiaco.setRetaCardiaco0(0);
			cardiaco.setRetaCardiaco1(0);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("180");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carFluterAuricular.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Fluter Auricular");
			break;

		case "Sídrome de Wolff-Parkinson-White":
			cardiaco.setRetaCardiaco0(2);
			cardiaco.setRetaCardiaco1(11);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carSídromeDeWolff-Parkinson-White.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Sídrome de Wolff-Parkinson-White");
			break;

		case "Bloqueio Auriculo Ventricular de 1º Grau":
			cardiaco.setRetaCardiaco0(15);
			cardiaco.setRetaCardiaco1(15);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carBloqueioAuriculoVentricularDe1Grau.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);	
			cardiaco.setNomeCardiaco("Bloqueio Auriculo Ventricular de 1º Grau");
			break;

		case "Bloqueio Auriculo Ventricular de 2º Grau Tipo 2":
			cardiaco.setRetaCardiaco0(6);
			cardiaco.setRetaCardiaco1(17);
			cardiaco.setRetaCardiaco2(17);
			cardiaco.setRetaCardiaco3(40);
			cardiaco.setRetaCardiaco4(43);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("90");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carBloqueioAuriculoVentricularDe2GrauTipo2PR1.txt"));
			cardiaco.setParametrosCar2(batimentos.getParameters("carBloqueioAuriculoVentricularDe2GrauTipo2PR1.txt"));
			cardiaco.setParametrosCar3(batimentos.getParameters("carBloqueioAuriculoVentricularDe2GrauTipo2PR2.txt"));
			cardiaco.setParametrosCar4(batimentos.getParameters("carBloqueioAuriculoVentricularDe2GrauTipo2PR4.txt"));	
			cardiaco.setNomeCardiaco("Bloqueio Auriculo Ventricular de 2º Grau Tipo 2");
			break;

		case "Ritmo Sinusal com Extrassistoles Juncionais":
			cardiaco.setRetaCardiaco0(6);
			cardiaco.setRetaCardiaco1(13);
			cardiaco.setRetaCardiaco2(13);
			cardiaco.setRetaCardiaco3(26);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("65");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoSinusalComExtrassistolesJuncionaisPR1.txt"));
			cardiaco.setParametrosCar2(batimentos.getParameters("carRitmoSinusalComExtrassistolesJuncionaisPR1.txt"));
			cardiaco.setParametrosCar3(batimentos.getParameters("carRitmoSinusalComExtrassistolesJuncionaisPR2.txt"));
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Ritmo Sinusal com Extrassistoles Juncionais");
			break;

		case "Ritmo Juncional":
			cardiaco.setRetaCardiaco0(26);
			cardiaco.setRetaCardiaco1(50);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoJuncional.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Ritmo Juncional");
			break;

		case "Ritmo Juncional Acelerado":
			cardiaco.setRetaCardiaco0(5);
			cardiaco.setRetaCardiaco1(16);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoJuncionalAcelerado.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Ritmo Juncional Acelerado");
			break;

		case "Marcapasso Errante":
			cardiaco.setRetaCardiaco0(7);
			cardiaco.setRetaCardiaco1(26);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("75");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carMarcapassoErrantePR1.txt"));
			cardiaco.setParametrosCar2(batimentos.getParameters("carMarcapassoErrantePR1.txt"));
			cardiaco.setParametrosCar3(batimentos.getParameters("carMarcapassoErrantePR2.txt"));
			cardiaco.setParametrosCar4(batimentos.getParameters("carMarcapassoErrantePR2.txt"));
			cardiaco.setNomeCardiaco("Marcapasso Errante");
			break;
			
		case "Tarquicardia Juncional":
			cardiaco.setRetaCardiaco0(7);
			cardiaco.setRetaCardiaco1(13);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("130");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carTarquicardiaJuncional.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Tarquicardia Juncional");
			break;

		case "Ritmo Sinusal com Extrassistoles Venticulares":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(10);
			cardiaco.setRetaCardiaco2(10);
			cardiaco.setRetaCardiaco3(8);
			cardiaco.setRetaCardiaco4(12);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("65");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoSinusalComExtrassistolesVenticularesPR1.txt"));
			cardiaco.setParametrosCar2(batimentos.getParameters("carRitmoSinusalComExtrassistolesVenticularesPR1.txt"));
			cardiaco.setParametrosCar3(batimentos.getParameters("carRitmoSinusalComExtrassistolesVenticularesPR1.txt"));
			cardiaco.setParametrosCar4(batimentos.getParameters("carRitmoSinusalComExtrassistolesVenticularesPR2.txt"));
			cardiaco.setNomeCardiaco("Ritmo Sinusal com Extrassistoles Venticulares");
			break;

		case "Ritmo Idioventricular":
			cardiaco.setRetaCardiaco0(7);
			cardiaco.setRetaCardiaco1(52);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(20);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoIdioventricular.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Ritmo Idioventricular");
			break;

		case "Ritmo Idioventricular Acelerado":
			cardiaco.setRetaCardiaco0(7);
			cardiaco.setRetaCardiaco1(30);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(20);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoIdioventricularAcelerado.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Ritmo Idioventricular Acelerado");
			break;

		case "Taquicardia Ventricular":
			cardiaco.setRetaCardiaco0(0);
			cardiaco.setRetaCardiaco1(0);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("170");
			cardiaco.setVelocidadeDesenhoCardiaco(20);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carTarquicardiaVentricular.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Taquicardia Ventricular");
			break;

		case "Fibrilação Ventricular":
			cardiaco.setRetaCardiaco0(0);
			cardiaco.setRetaCardiaco1(0);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("0");
			cardiaco.setVelocidadeDesenhoCardiaco(15);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carFibrilaçãoVentricular.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Fibrilação Ventricular");
			break;

		case "Assistolia":
			cardiaco.setRetaCardiaco0(0);
			cardiaco.setRetaCardiaco1(0);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("0");
			cardiaco.setVelocidadeDesenhoCardiaco(15);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carAssistolia.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Assistolia");
			break;
		}
		return cardiaco;
	}
}
