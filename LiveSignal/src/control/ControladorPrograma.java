package control;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.jfree.ui.ExtensionFileFilter;

import model.Cardiaco;
import model.DTOJanelaPrincipal;
import model.Oximetria;
import model.Respiratorio;
import view.JanelaMenu;
import view.JanelaPrincipal;
import view.JanelaSecundaria;

public class ControladorPrograma {
	
	JanelaPrincipal janelaPrincipal;
	JanelaSecundaria janelaSecundaria;
	JanelaMenu janelaMenu;
	
	Cardiaco cardiaco;
	Oximetria oximetria;
	Respiratorio respiratorio;
 	
	ControladorRitmoCardiaco controladorRitmoCardiaco;
	ControladorNivelOximetria controladorNivelOximetria;
	ControladorRitmoRespiratorio controladorRitmoRespiratorio;
	
	/**
	 * Método contrutor responsável por iniciar a abertura da aplicação
	 */
	public ControladorPrograma()
	{		
		controladorRitmoCardiaco = new ControladorRitmoCardiaco(this);
		controladorNivelOximetria = new ControladorNivelOximetria(this);
		controladorRitmoRespiratorio = new ControladorRitmoRespiratorio(this);
		iniciarAplicacao();	
	}

	
	/**
	 * Método resposável por abrir a janela principal
	 */
	private void iniciarAplicacao() 
	{			
		janelaMenu = new JanelaMenu(this);
		instanciarObjetos();
		
		janelaPrincipal = new JanelaPrincipal(this, cardiaco, oximetria, respiratorio);
		janelaSecundaria = new JanelaSecundaria(this, cardiaco, oximetria, respiratorio);
		
		janelaPrincipal.frmMaingraph.setVisible(true);	
	}
	
	public void instanciarObjetos()
	{		
		cardiaco = controladorRitmoCardiaco.getCardiaco(janelaMenu.cbxRitmoCardiaco.getSelectedItem().toString());
		oximetria = controladorNivelOximetria.getOximetria(janelaMenu.cbxNivelOximetria.getSelectedItem().toString());
		respiratorio = controladorRitmoRespiratorio.getRespiratorio(janelaMenu.cbxRitmoRespiratorio.getSelectedItem().toString());
	}
	
	public void abrirMenu()
	{		
		janelaMenu.setTelas();
		janelaMenu.jframe.setVisible(true);
	}
	
	/**
	 * ATUALIZA OBJETO CARDIÁCO DE ACORDO COM O NOME
	 * ESTE MÉTODO É CHAMADO QUANDO ALTERAMOS O VALOR DA COMBOX NA JANELA MENU
	 * @param ritmo
	 */
	public void atualizarRitmoCardiaco(String ritmo){
		cardiaco = controladorRitmoCardiaco.getCardiaco(ritmo);	
		atualizarValorCardiaco(cardiaco.getValorBatimentoCardiaco());
	}
	
	/**
	 * ATUALIZA OBJETO CARDIÁCO DE ACORDO COM O NOME
	 * ESTE MÉTODO É CHAMADO QUANDO ALTERAMOS O VALOR DA COMBOX NA JANELA MENU
	 * @param ritmo
	 */
	public void atualizarNivelOximetria(String ritmo){
		oximetria = controladorNivelOximetria.getOximetria(ritmo);	
		atualizarValorOximetria(oximetria.getValorOximetria());
	}
	
	/**
	 * ATUALIZA OBJETO CARDIÁCO DE ACORDO COM O NOME
	 * ESTE MÉTODO É CHAMADO QUANDO ALTERAMOS O VALOR DA COMBOX NA JANELA MENU
	 * @param ritmo
	 */
	public void atualizarRitmoRespiratorio(String ritmo){
		respiratorio = controladorRitmoRespiratorio.getRespiratorio(ritmo);
		atualizarValorRespiratorio(respiratorio.getValorRespiratorio());
	}

	/**
	 * ATALIZA AS LABEL'S COM O VALOR DO BATIMENTO
	 * @param valor
	 */
	public void atualizarValorCardiaco(String valor){
		janelaPrincipal.setLbValorCardiaco(valor);
		janelaSecundaria.setLbValorCardiaco(valor);
	}
	
	/**
	 * ATALIZA AS LABEL'S COM O VALOR DO BATIMENTO
	 * @param valor
	 */
	public void atualizarValorOximetria(String valor){
		janelaPrincipal.setLblValorOximetria(valor);
		janelaSecundaria.setLblValorOximetria(valor);
	}
	
	/**
	 * ATALIZA AS LABEL'S COM O VALOR DO BATIMENTO
	 * @param valor
	 */
	public  void atualizarValorRespiratorio(String valor){
		janelaPrincipal.setLblValorRespiratorio(valor);
		janelaSecundaria.setLblValorRespiratorio(valor);
	}
		
	
	public void atualizarValorRitmoRespiratorio(String valor){		
		janelaPrincipal.setLblValorRespiratorio(valor);
	}

	/**
	 * RESPONÁVEL POR DEIXAR A JANELA SECUNDÁRIA (ALUNO) VISIVEL
	 * @param ctrlProg
	 * @param cardiaco
	 * @param oximetria
	 */
	public void abrirJanelaAluno(ControladorPrograma ctrlProg, Cardiaco cardiaco, Oximetria oximetria) 
	{		
		janelaSecundaria.exibeTelaSec();
		janelaSecundaria.frmAluno.setVisible(true);
	}

	/**
	 * RESPONSÁVEL POR FECHAR A JANELA SECUNDÁRIA (ALUNO)
	 */
	public void fecharJanelaAluno()
	{
		janelaSecundaria.frmAluno.dispose();
	}

	/**
	 * RESPONSÁVEL POR PLOTAR O GRAFICO NA JANELA SECUNDÁRIA
	 * @param x
	 * @param y
	 */
	public void plotOximetriaJanelaAluno(float x, float y){
		janelaSecundaria.plotOximetria(x, y);
	}

	/**
	 * RESPONSÁVEL POR PLOTAR O GRAFICO NA JANELA SECUNDÁRIA
	 * @param x
	 * @param y
	 */
	public void plotCardiacoJanelaAluno(float x, float y){
		janelaSecundaria.plotCardiaco(x, y);
	}

	/**
	 * RESPONSÁVEL POR PLOTAR O GRAFICO NA JANELA SECUNDÁRIA
	 * @param x
	 * @param y
	 */
	public void plotRespiratorioJanelaSecundaria(float x, float y){
		janelaSecundaria.plotRespiratorio(x, y);
	}
	
	/**
	 * RESPONSÁVEL POR LIMPAR O GRÁFICO QUANDO O PLOT CHEGA AO FIM DA TELA
	 */
	public void limparOximetriaJanelaSegundaria() {
		janelaSecundaria.seriesNivelOximetria.clear();		
	}

	/**
	 * RESPONSÁVEL POR LIMPAR O GRÁFICO QUANDO O PLOT CHEGA AO FIM DA TELA
	 */
	public void limparCardiacoJanelaSegundaria() {
		janelaSecundaria.seriesRitmoCardiaco.clear();		
	}
	
	/**
	 * RESPONSÁVEL POR LIMPAR O GRÁFICO QUANDO O PLOT CHEGA AO FIM DA TELA
	 */
	public void limparRespiratorioJanelaSecundaria(){
		janelaSecundaria.seriesRitmoRespiratorio.clear();
	}


	@SuppressWarnings("deprecation")
	public void pararThreadCardiaco() {
		janelaPrincipal.threadCardiaco.suspend();		
	}
	
	@SuppressWarnings("deprecation")
	public void iniciarThreadCardiaco() {
		janelaPrincipal.threadCardiaco.resume();		
	}
	
	@SuppressWarnings("deprecation")
	public void pararThreadOximetria() {
		janelaPrincipal.threadOximetria.suspend();		
	}
	
	@SuppressWarnings("deprecation")
	public void iniciarThreadOximetria() {
		janelaPrincipal.threadOximetria.resume();		
	}
	
	@SuppressWarnings("deprecation")
	public void pararThreadRespiratorio() {
		janelaPrincipal.threadRespiratorio.suspend();		
	}
	
	@SuppressWarnings("deprecation")
	public void iniciarThreadRespiratorio() {
		janelaPrincipal.threadRespiratorio.resume();		
	}


	/**
	 * MÉTODO RESPONSÁVEL POR CALCULAR A MÉDIA DA PRESSÃO ARTERIAL
	 * @param pMaxima
	 * @param pMinima
	 */
	public void atualizarMmHg(String pMaxima, String pMinima){
		
		int PressaoMaxima = Integer.parseInt(pMaxima);
		int PressaoMinima = Integer.parseInt(pMinima);
		int resultado = (((PressaoMaxima) + (PressaoMinima * 2)) / 3);
		
		janelaPrincipal.setLblValorMmHg(""+resultado);
		janelaSecundaria.setLblValorMmHg(""+resultado);
	}


	public void atualizarPressaoMaxima(String valor) {
		janelaPrincipal.setLblPressaoMaxima(valor);
		janelaSecundaria.setLblPressaoMaxima(valor);
		
		atualizarMmHg(valor, janelaPrincipal.getLblPressaoMinima());
	}


	public void atualizarPressaoMinima(String valor) {
		janelaPrincipal.setLblPressaoMinima(valor);	
		janelaSecundaria.setLblPressaoMinima(valor);
		atualizarMmHg(janelaPrincipal.getLblPressaoMaxima(), valor);
	}


	public void atualizarTemperatura1(String valor) {
		janelaPrincipal.setLblTemperatura1(valor);		
		janelaSecundaria.setLblTemperatura1(valor);
	}


	public void atualizarTemperatura2(String valor) {
		janelaPrincipal.setLblTemperatura2(valor);
		janelaSecundaria.setLblTemperatura2(valor);
		
	}
	
	/**
	 * Métodos responsável por retornar o valor do batimento/nivel/ritmo de cada objeto
	 * para enviar para a janela Menu
	 */
	
	public String lerValorBatimentoBatimento(){
		return cardiaco.getValorBatimentoCardiaco();
	}
	
	public String lerValorOximetria(){
		System.out.println(oximetria.getValorOximetria());
		return oximetria.getValorOximetria();
	}
	
	public String lerValorRespiratorio(){
		return respiratorio.getValorRespiratorio();
	}
	
	
	
	
	/**
	 * MÉTODO RESPONSÃ�VEL POR SERIALIZAR OS DADOS
	 */
	public void salvarDados(){
		DTOJanelaPrincipal dto = new DTOJanelaPrincipal();
		
		
		dto.setNomeCardiaco(cardiaco.getNomeCardiaco());
		dto.setNomeOximetria(oximetria.getNomeOximetria());
		dto.setNomeRespiratorio(respiratorio.getNomeRespiratorio());
		dto.setValorCardiaco(cardiaco.getValorBatimentoCardiaco().toString());
		dto.setValorOximetria(oximetria.getValorOximetria().toString());
		dto.setValorRespiratorio(respiratorio.getValorRespiratorio().toString());
		dto.setPressaoMaxima(janelaPrincipal.getLblPressaoMaxima());
		dto.setPressaoMinima(janelaPrincipal.getLblPressaoMinima());
		dto.setTemperatura1(janelaPrincipal.getLblTemperatura1());
		dto.setTemperatura2(janelaPrincipal.getLblTemperatura2());
		
		JFileChooser chooser = new JFileChooser();
		String ext = "dat";
		String caminho = "";
		
		File file = null;
		chooser.setFileFilter(new ExtensionFileFilter("Aquivos DAT", "dat"));
		
		// showSaveDialog retorna um inteiro , e ele ira determinar que o chooser serÃ¡ para salvar.
		int retorno = chooser.showSaveDialog(null); 
		if (retorno == JFileChooser.APPROVE_OPTION){
			// o getSelectedFile pega o arquivo e o getAbsolutePath retorna uma string contendo o endereÃ§o.
		      caminho = chooser.getSelectedFile().getPath();   
		      //file = chooser.getSelectedFile();
		      
		      Boolean containsExt = caminho.contains(".");		      
		      if(containsExt)
		      {
		    	  String currrentExt = caminho.substring(caminho.lastIndexOf(".") + 1);
		            if(!ext.equalsIgnoreCase(currrentExt)) caminho = caminho + "." + ext;		        
		        }
		        else
		        {
		            caminho = caminho + "." + ext;          
		        }		      
		           
		      try 
		      {
		    	  FileOutputStream arquivoGrav = new FileOutputStream(caminho);
		    	  ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
		    	  objGravar.writeObject(dto);
		    	  objGravar.flush();
		    	  objGravar.close();
		    	  arquivoGrav.flush();
		    	  arquivoGrav.close();
		    	  

		    	  JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso");
			} 
			catch (FileNotFoundException e) 
	      	{			
				JOptionPane.showMessageDialog(null, "Erro ao Salvar o Arquivo", "ERRO", JOptionPane.OK_OPTION, null);
				e.printStackTrace();
			} 
	      	catch (IOException e) 
		    {			
	      		JOptionPane.showMessageDialog(null, "Erro ao Salvar o Arquivo", "ERRO", JOptionPane.OK_OPTION, null);
				e.printStackTrace();
			}
		}	
	}
	
	/**
	 * MÉTODO RESPONSÃ�VEL POR DESERIALIZAR OS DADOS
	 */
	public void carregarDados(){
		DTOJanelaPrincipal dto = new DTOJanelaPrincipal();
		
		JFileChooser chooser;
		UIManager.put("FileChooser.openButtonText", "Abrir");  
		chooser = new JFileChooser();
		String caminho = "";
		
		File file = null;
		chooser.setFileFilter(new ExtensionFileFilter("Texto", "dat"));
		
		// showSaveDialog retorna um inteiro , e ele ira determinar que o chooser serÃ¡ para salvar.
		int retorno = chooser.showOpenDialog(null); 
		
		if (retorno==JFileChooser.APPROVE_OPTION){
			// o getSelectedFile pega o arquivo e o getAbsolutePath retorna uma string contendo o endereÃ§o.
		     file = chooser.getSelectedFile();		     
			caminho = chooser.getSelectedFile().getPath();   
			
			System.out.println(file);
		      
		      try {
					FileInputStream	inFile = new FileInputStream(file);
					ObjectInputStream d = new ObjectInputStream(inFile);
					dto = (DTOJanelaPrincipal) d.readObject();			
					d.close();
					
				} catch (FileNotFoundException e) {			
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		      
		      	this.atualizarRitmoCardiaco(dto.getNomeCardiaco());
		      	this.atualizarNivelOximetria(dto.getNomeOximetria());
		      	this.atualizarRitmoRespiratorio(dto.getNomeRespiratorio());		      	
	      		this.atualizarValorCardiaco(dto.getValorCardiaco());
		      	this.atualizarValorOximetria(dto.getValorOximetria());
		      	this.atualizarValorRespiratorio(dto.getValorRespiratorio());
		      	janelaPrincipal.setLblPressaoMaxima(dto.getPressaoMaxima());
		      	janelaSecundaria.setLblPressaoMaxima(dto.getPressaoMaxima());
		      	janelaPrincipal.setLblPressaoMinima(dto.getPressaoMinima());
		      	janelaSecundaria.setLblPressaoMinima(dto.getPressaoMinima());
		      	
		      	janelaPrincipal.setLblTemperatura1(dto.getTemperatura1());
		      	janelaSecundaria.setLblTemperatura1(dto.getTemperatura1());
		      	janelaPrincipal.setLblTemperatura2(dto.getTemperatura2());
		      	janelaSecundaria.setLblTemperatura2(dto.getTemperatura2());
		      	
		      	this.atualizarMmHg(dto.getPressaoMaxima(), dto.getPressaoMinima());
		      	
		      	
		     }
	}

	
	public int getTelas(){		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] devices = ge.getScreenDevices();	
		return devices.length;
	}


	public String getTelaAluno() {
		return janelaMenu.cbxSegundaTela.getSelectedItem().toString();		
	}



}
