package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import control.ControladorPrograma;
import control.ControladorRitmoCardiaco;
import control.LeitorBatimentos;
import model.Cardiaco;
import model.Oximetria;
import model.Parametro;
import model.Respiratorio;

public class JanelaPrincipal{

	public JFrame frmMaingraph;
	ControladorPrograma ctrlProg;
	ControladorRitmoCardiaco ctrlRitmoCardiaco;
	
	Cardiaco cardiaco;
	Oximetria oximetria;
	Respiratorio respiratorio;
	
	/**
	 * PONTEIRO PARA AS THREADS
	 */
	public Thread threadCardiaco;
	public Thread threadRespiratorio;
	public Thread threadOximetria;

	/**
	 * ATRIBUTOS REFERÊNTES AO MÉTODO CARDIACO
	 */	
	int indiceDesenho = 0;	
	static float carPosicaoX = 0;
	String nomeRitmoCardiaco;
	//String valorBatimentoCardiaco = "80";
	JComboBox<String> cbxRitmoCardiaco;	
	JLabel lblImgCoracao;	
	JPanel painelCardiaco;
	

	/**
	 * ATRIBUTOS REFERÊNTES AO MÉTODO RESPIRATORIO
	 */
	//double retaRespiratorio = 0;
	int valorRespiratorio = 20;
//	int espessuraLinha = 3;
//	int indiceDesenhoResp = 0;
//	float frequencia = 0; //Quantidade de ciclos no gráfico
//	boolean plotDesenho = false;
	JPanel painelRespiratorio;
	JComboBox<String> cbxRitmoRespiratorio;	
	//private static float resPosicaoX = 0;
	
	
	/**
	 * ATRIBUTOS REFERÊNTES AO MÉTODO DE OXIMETRIA
	 */
	JPanel painelOximetria;	
	JComboBox<String> cbxNivelOximetria;
	int indiceDesenhoOximetria = 0;
	static float oxiPosicaoX = 0;
	
	
	/**
	 * ATRIBUTOS REFERENTES A LEITURA DOS PARAMETROS
	 */
	LeitorBatimentos batimentos;
	
	//private ArrayList<Parametro> parametrosResp1;

	JLabel lbValorCardiaco;	
	JLabel lblValorOximetria;
	JLabel lblValorRespiratorio;
	
	JLabel lblValorMmHg;
	JLabel lblTemperatura1;
	JLabel lblTemperatura2;
	JLabel lblPressaoMaxima;
	JLabel lblPressaoMinima;
	

	/**
	 * MÉTODOS NECESSÁRIOS PARA CRIAÇÃO DOS GRÁFICOS
	 */
	final XYSeries seriesRitmoCardiaco;
	final XYSeries seriesNivelOximetria;
	final XYSeries seriesRitmoRespiratorio;

	XYSeriesCollection datasetRitmoCardiaco;
	XYSeriesCollection datasetRitmoRespiratorio;
	XYSeriesCollection datasetNivelOximetria;

	final JFreeChart chartRitmoCardiaco;
	final JFreeChart chartRitmoRespiratorio;
	final JFreeChart chartNivelOximetria;

	final ChartPanel chartPanelRitmoCardiaco;
	final ChartPanel chartPanelRitmoRespiratorio;
	final ChartPanel chartPanelNivelOximetria;

	XYPlot plotRitmoCardiaco;
	ValueAxis yAxisRitmoCardiaco;
	NumberAxis axisRitmoCardiaco;

	XYPlot plotRitmoRespiratorio;
	ValueAxis yAxisRitmoRespiratorio;
	NumberAxis axisRitmoRespiratorio;
	
	XYPlot plotNivelOximetria;
	ValueAxis yAxisNivelOximetria;
	NumberAxis axisNivelOximetria;

	XYLineAndShapeRenderer renderer;
	
	/**
	 * ATRIBUTOS PARA CONTROLE DA DIMENSÃO DOS GRÁFICOS
	 */
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension scrnSize = toolkit.getScreenSize();	
	int widthTelaComputados = (int) scrnSize.getWidth();
	int heightTelaComputados = (int) scrnSize.getHeight();
		
	
	/**
	 * MÉTODOS CONSTRUTOR DA CLASSE 
	 */
	public JanelaPrincipal(ControladorPrograma ctrl, Cardiaco _cardiaco, Oximetria _oximetria, Respiratorio _respiratorio) {
		
		this.ctrlProg = ctrl;	
		this.cardiaco = _cardiaco;
		this.oximetria = _oximetria;
		this.respiratorio = _respiratorio;

		seriesRitmoCardiaco = new XYSeries("");
		seriesRitmoRespiratorio = new XYSeries("");
		seriesNivelOximetria = new XYSeries("");

		datasetRitmoCardiaco = new XYSeriesCollection(seriesRitmoCardiaco);
		datasetRitmoRespiratorio = new XYSeriesCollection(seriesRitmoRespiratorio);
		datasetNivelOximetria = new XYSeriesCollection(seriesNivelOximetria);

		chartRitmoCardiaco = ChartFactory.createXYLineChart(null, null, null, datasetRitmoCardiaco);
		chartRitmoRespiratorio = ChartFactory.createXYLineChart(null, null, null, datasetRitmoRespiratorio);
		chartNivelOximetria = ChartFactory.createXYLineChart(null, null, null, datasetNivelOximetria);

		chartPanelRitmoCardiaco = new ChartPanel(chartRitmoCardiaco);
		chartPanelRitmoCardiaco.setBounds(0, 10, (widthTelaComputados - 110), 110);
		
		chartPanelRitmoRespiratorio = new ChartPanel(chartRitmoRespiratorio);
		chartPanelRitmoRespiratorio.setBounds(0, 230, (widthTelaComputados - 110), 110);
		
		chartPanelNivelOximetria = new ChartPanel(chartNivelOximetria);
		chartPanelNivelOximetria.setBounds(0, 120, (widthTelaComputados - 110), 110);

		plotRitmoCardiaco = (XYPlot) chartRitmoCardiaco.getPlot();
		yAxisRitmoCardiaco = plotRitmoCardiaco.getRangeAxis();
		axisRitmoCardiaco = (NumberAxis) chartRitmoCardiaco.getXYPlot().getDomainAxis();

		plotRitmoRespiratorio = (XYPlot) chartRitmoRespiratorio.getPlot();
		yAxisRitmoRespiratorio = plotRitmoRespiratorio.getRangeAxis();
		axisRitmoRespiratorio = (NumberAxis) chartRitmoRespiratorio.getXYPlot().getDomainAxis();
		
		
		plotNivelOximetria = (XYPlot) chartNivelOximetria.getPlot();
		yAxisNivelOximetria = plotNivelOximetria.getRangeAxis();
		axisNivelOximetria = (NumberAxis)chartNivelOximetria.getXYPlot().getDomainAxis();		
		

		renderer = new XYLineAndShapeRenderer();
		
		batimentos = new LeitorBatimentos();

		initialize();

	}

	private void initialize() {						
		frmMaingraph = new JFrame();
		frmMaingraph.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaPrincipal.class.getResource("/img/Heart beat.png")));
		frmMaingraph.getContentPane().setBackground(Color.BLACK);
		frmMaingraph.setBackground(Color.BLACK);
		frmMaingraph.setTitle("Live Signal Java");
		frmMaingraph.setSize((int)scrnSize.getWidth(), (int)scrnSize.getHeight());
		//frmMaingraph.setBounds(0, 0, 1200, 680);
		frmMaingraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMaingraph.getContentPane().setLayout(null);
		frmMaingraph.setExtendedState(JFrame.MAXIMIZED_BOTH);


		/**
		 * CONFIGURAÇÃO DO RITMO CARDIACO
		 */
		chartRitmoCardiaco.setBackgroundPaint(Color.BLACK);// setando a cor do gráfico
		chartRitmoCardiaco.removeLegend(); // Remove a legenda		
		chartPanelRitmoCardiaco.setBackground(Color.BLACK); //setando a cor do painel
		
		chartPanelRitmoCardiaco.setPopupMenu(null); //retirando o meni
		chartPanelRitmoCardiaco.setMouseZoomable(false); //retirando o zoom
		
		yAxisRitmoCardiaco.setRange(-1, 4); // Define o tamanho do eixo Y
		yAxisRitmoCardiaco.setVisible(false); // Remove a barra do eixo Y

		plotRitmoCardiaco.setBackgroundPaint(Color.BLACK); // Define a cor de fundo
		plotRitmoCardiaco.setDomainGridlinesVisible(false); // Remove as linhas do eixo x
		plotRitmoCardiaco.setRangeGridlinesVisible(false); // Remove as linhas do eixo y

		axisRitmoCardiaco.setRange(0, 322); // Define o tamanho do eixo X
		axisRitmoCardiaco.setVisible(false); // Remove a barra do eixo X

		plotRitmoCardiaco.getRenderer().setSeriesPaint(0, Color.decode("#00CD00")); // Alterando a cor do Gráfico para Verde
		plotRitmoCardiaco.getRenderer().setSeriesStroke(0, new BasicStroke(3)); // Alterando a Largura do gráfico
		
		frmMaingraph.getContentPane().add(chartPanelRitmoCardiaco); //adicionando o gráfico na tela inicial

		/**
		 * CONFIGURAÇÃO DO RITMO RESPIRATORIO
		 */
		chartRitmoRespiratorio.setBackgroundPaint(Color.BLACK);// setando a cor do gráfico
		chartRitmoRespiratorio.removeLegend(); // Remove a legenda
		
		chartPanelRitmoRespiratorio.setBackground(Color.BLACK); //setando a cor de fundo do painel
		chartPanelRitmoRespiratorio.setMouseZoomable(false); //retirando o zoom
		chartPanelRitmoRespiratorio.setPopupMenu(null); //retirando o menu
		
		yAxisRitmoRespiratorio.setRange(-3, 3.4); // Define o tamanho do eixo Y
		yAxisRitmoRespiratorio.setVisible(false); // Remove a barra do eixo Y

		axisRitmoRespiratorio.setRange(0, 150); // Define o tamanho do eixo X
		axisRitmoRespiratorio.setVisible(false); // Remove a barra do eixo X

		plotRitmoRespiratorio.setBackgroundPaint(Color.BLACK); // Define a cor de fundo
		plotRitmoRespiratorio.setDomainGridlinesVisible(false); // Remove as linhas do eixo x
		plotRitmoRespiratorio.setRangeGridlinesVisible(false); // Remove as linhas do eixo y

		plotRitmoRespiratorio.getRenderer().setSeriesPaint(0, Color.WHITE);
		plotRitmoRespiratorio.getRenderer().setSeriesStroke(0, new BasicStroke(2));
		
		frmMaingraph.getContentPane().add(chartPanelRitmoRespiratorio);
		
		
		/**
		 * CONFIGURAÇÃO DO NÍVEL DE OXIMETRIA
		 */
		chartNivelOximetria.setBackgroundPaint(Color.BLACK); //Setando a cor do gráfico
		chartNivelOximetria.removeLegend(); //Removendo a legenda
		
		chartPanelNivelOximetria.setBackground(Color.BLACK); //Adicionando a cor de fundo do painel
		chartPanelNivelOximetria.setMouseZoomable(false); //Retirando o zoom
		chartPanelNivelOximetria.setPopupMenu(null); //Retirando o menu
		
		yAxisNivelOximetria.setRange(-1, 4); //Definindo o tamanho do eixo Y
		yAxisNivelOximetria.setVisible(false); //Removendo a barrado eixo Y
		
		axisNivelOximetria.setRange(0, 322); //Define o tamanho do eixo X
		axisNivelOximetria.setVisible(false); //Remove a barra do eixo X
		
		plotNivelOximetria.setBackgroundPaint(Color.BLACK); //Define a cor de fundo
		plotNivelOximetria.setDomainGridlinesVisible(false); //Remove as linhas do eixo X
		plotNivelOximetria.setRangeGridlinesVisible(false); //RRemove as linhas do eixo Y
		
		plotNivelOximetria.getRenderer().setSeriesPaint(0, Color.decode("#00BFFF"));
		plotNivelOximetria.getRenderer().setSeriesStroke(0, new BasicStroke(2));
		
		frmMaingraph.getContentPane().add(chartPanelNivelOximetria);
		
		
		/**
		 * COMPONENTES DO PAINEL
		 */

		painelCardiaco = new JPanel();
		painelCardiaco.setBounds( (widthTelaComputados - 110), 10, 103, 110);
		painelCardiaco.setBackground(Color.BLACK);
		frmMaingraph.getContentPane().add(painelCardiaco);
		painelCardiaco.setLayout(null);
		
		lblImgCoracao = new JLabel("");
		lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts20.png")));
		lblImgCoracao.setBounds(69, 11, 46, 24);
		painelCardiaco.add(lblImgCoracao);

		lbValorCardiaco = new JLabel();
		lbValorCardiaco.setText("80");
		lbValorCardiaco.setForeground(Color.GREEN);
		lbValorCardiaco.setBackground(Color.BLACK);
		lbValorCardiaco.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lbValorCardiaco.setBounds(10, 11, 83, 47);
		painelCardiaco.add(lbValorCardiaco);

		JLabel lblBpm = new JLabel("BPM");
		lblBpm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBpm.setForeground(Color.GREEN);
		lblBpm.setBounds(20, 52, 46, 14);
		painelCardiaco.add(lblBpm);
				
		painelOximetria = new JPanel();
		painelOximetria.setLayout(null);
		painelOximetria.setBackground(Color.BLACK);
		painelOximetria.setBounds( (widthTelaComputados - 110), 123, 103, 110);
		frmMaingraph.getContentPane().add(painelOximetria);
		
		lblValorOximetria = new JLabel("100");
		lblValorOximetria.setForeground(new Color(70, 130, 180));
		lblValorOximetria.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblValorOximetria.setBackground(Color.BLACK);
		lblValorOximetria.setBounds(10, 11, 89, 47);
		painelOximetria.add(lblValorOximetria);
		
		JLabel lblSPO2 = new JLabel("SPO2");
		lblSPO2.setForeground(new Color(70, 130, 180));
		lblSPO2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSPO2.setBounds(20, 52, 46, 14);
		painelOximetria.add(lblSPO2);

		painelRespiratorio = new JPanel();
		painelRespiratorio.setLayout(null);
		painelRespiratorio.setBackground(Color.BLACK);
		painelRespiratorio.setBounds((widthTelaComputados - 110), 230, 103, 110);
		frmMaingraph.getContentPane().add(painelRespiratorio);
		
		lblValorRespiratorio = new JLabel(Integer.toString(valorRespiratorio));
		lblValorRespiratorio.setForeground(Color.WHITE);
		lblValorRespiratorio.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblValorRespiratorio.setBackground(Color.BLACK);
		lblValorRespiratorio.setBounds(10, 11, 89, 47);
		painelRespiratorio.add(lblValorRespiratorio);
				
		JLabel LblRESP = new JLabel("RESP");
		LblRESP.setForeground(Color.WHITE);
		LblRESP.setFont(new Font("Tahoma", Font.BOLD, 14));
		LblRESP.setBounds(20, 52, 46, 14);
		painelRespiratorio.add(LblRESP);
		
		JPanel painelMenu = new JPanel();
		painelMenu.setBackground(Color.BLACK);
		painelMenu.setBounds(45, 666, 1293, 52);
		frmMaingraph.getContentPane().add(painelMenu);
		painelMenu.setLayout(null);
		
		
		JPanel panelTemperatura = new JPanel();
		panelTemperatura.setBackground(Color.BLACK);
		panelTemperatura.setBounds(358, 536, 228, 84);
		frmMaingraph.getContentPane().add(panelTemperatura);
		panelTemperatura.setLayout(null);
		
		lblTemperatura1 = new JLabel("36");
		lblTemperatura1.setBounds(0, 0, 74, 84);
		panelTemperatura.add(lblTemperatura1);
		lblTemperatura1.setFont(new Font("Dialog", Font.BOLD, 66));
		lblTemperatura1.setForeground(Color.WHITE);
		
		JLabel label = new JLabel(",");
		label.setBounds(70, 0, 18, 84);
		panelTemperatura.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 66));
		label.setBackground(Color.WHITE);
		
		lblTemperatura2 = new JLabel("0");
		lblTemperatura2.setBounds(86, 0, 74, 84);
		panelTemperatura.add(lblTemperatura2);
		lblTemperatura2.setFont(new Font("Dialog", Font.BOLD, 66));
		lblTemperatura2.setForeground(Color.WHITE);
		
		JLabel lblc = new JLabel("ºC");
		lblc.setBounds(154, 0, 91, 84);
		panelTemperatura.add(lblc);
		lblc.setForeground(Color.WHITE);
		lblc.setFont(new Font("Dialog", Font.BOLD, 66));
		lblc.setBackground(Color.WHITE);
		
		JPanel panelPressao = new JPanel();
		panelPressao.setLayout(null);
		panelPressao.setBackground(Color.BLACK);
		panelPressao.setBounds(744, 536, 283, 118);
		frmMaingraph.getContentPane().add(panelPressao);
		
		lblValorMmHg = new JLabel("93");
		lblValorMmHg.setForeground(Color.WHITE);
		lblValorMmHg.setFont(new Font("Dialog", Font.BOLD, 30));
		lblValorMmHg.setBackground(Color.WHITE);
		lblValorMmHg.setBounds(175, 54, 110, 84);
		panelPressao.add(lblValorMmHg);
		
		lblPressaoMaxima = new JLabel("120");
		lblPressaoMaxima.setForeground(Color.WHITE);
		lblPressaoMaxima.setFont(new Font("Dialog", Font.BOLD, 66));
		lblPressaoMaxima.setBounds(12, 0, 123, 84);
		panelPressao.add(lblPressaoMaxima);
		
		JLabel label_3 = new JLabel("/");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.BOLD, 66));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(131, 0, 18, 84);
		panelPressao.add(label_3);
		
		lblPressaoMinima = new JLabel("80");
		lblPressaoMinima.setForeground(Color.WHITE);
		lblPressaoMinima.setFont(new Font("Dialog", Font.BOLD, 66));
		lblPressaoMinima.setBounds(161, 0, 96, 84);
		panelPressao.add(lblPressaoMinima);
		
		JLabel lblMmhg = new JLabel("mmHg");
		lblMmhg.setForeground(Color.WHITE);
		lblMmhg.setFont(new Font("Dialog", Font.BOLD, 30));
		lblMmhg.setBackground(Color.WHITE);
		lblMmhg.setBounds(53, 52, 110, 84);
		panelPressao.add(lblMmhg);
		
		JLabel label_2 = new JLabel("(        )");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.BOLD, 30));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(155, 52, 84, 84);
		panelPressao.add(label_2);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/open.png")));
		btnCarregar.setBounds(574, 12, 118, 27);
		painelMenu.add(btnCarregar);
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlProg.carregarDados();						
			}
		});
								
	
		
		JButton btnAbrirJanelaAluno = new JButton("Abrir Janela Aluno");
		btnAbrirJanelaAluno.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/openinwindow.png")));
		btnAbrirJanelaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlProg.abrirJanelaAluno(ctrlProg, cardiaco, oximetria);
			}
		});
		btnAbrirJanelaAluno.setBounds(704, 12, 162, 26);
		painelMenu.add(btnAbrirJanelaAluno);
		
		JButton btnFecharJanelaAluno = new JButton("Fechar Janela Aluno");
		btnFecharJanelaAluno.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/closewindow.png")));
		btnFecharJanelaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlProg.fecharJanelaAluno();
			}
		});
		btnFecharJanelaAluno.setBounds(878, 12, 169, 26);
		painelMenu.add(btnFecharJanelaAluno);
		
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/settings.png")));
		btnMenu.setBounds(349, 12, 98, 26);
		painelMenu.add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlProg.abrirMenu();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/save.png")));
		btnSalvar.setBounds(459, 12, 103, 26);
		painelMenu.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlProg.salvarDados();
			}
		});
		
		final JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/play.png")));
		btnIniciar.setBounds(234, 12, 103, 27);
		//btnIniciar.setIcon(arg0);
		painelMenu.add(btnIniciar);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ctrlProg.instanciarObjetos();
				//ctrlProg.iniciarJanelaAluno();
				
				executarGraficoCardiaco();
				executarGraficoRespiratorio();
				executarGraficoOximetria();
				btnIniciar.setEnabled(false);
			}
		});
	}
	

	/**
	 * MÉTODOS REFERÊNTES A EXECUÇÃO DO GRÁFICO CARDIACO
	 */
	protected void executarGraficoCardiaco() {
		threadCardiaco = new Thread() 
		{
			@SuppressWarnings("static-access")
			@Override
			public void run() 
			{			
				boolean desenho = false;
				int indiceReta = 0;				
				float plotX;				
				Parametro plot;				
				int reta = 0;								
				int par = 1; //VariÃ¡vel para indicar qual parametro desenhar

				try 
				{					
					while (true) 
					{				
						if (desenho) 
						{		
							Thread.sleep(cardiaco.getVelocidadeDesenhoCardiaco()); 
							
							switch(par){
							
							case 1:
								int totalParametros1 = cardiaco.getParametrosCar1().size();								
								lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts30.png")));
								
								plot = cardiaco.getParametrosCar1().get(cardiaco.getIndiceDesenho());
								plotX = calcularDesenhoXCardiaco(cardiaco.getParametrosCar1(), cardiaco.getIndiceDesenho());	
								
								seriesRitmoCardiaco.add(plotX, plot.getY());
								ctrlProg.plotCardiacoJanelaAluno(plotX, plot.getY());
								
								carPosicaoX = plotX;													
								
								if ((cardiaco.getIndiceDesenho() == totalParametros1 -1))
								{
									desenho = false;	
									cardiaco.setIndiceDesenho(0);
									//indiceDesenho = 0;									
									indiceReta = 0;			
									par = cardiaco.getParametrosCar2() != null ? 2 : 1;
								}								
								else if ((cardiaco.getIndiceDesenho() == totalParametros1 -1) && cardiaco.getRetaCardiaco0() != 0){
									desenho = true;
								}									
								else
									cardiaco.setIndiceDesenho(cardiaco.getIndiceDesenho()+1);
									//indiceDesenho++;								
								break;
								
							case 2:
								try{
									int totalParametros2 = cardiaco.getParametrosCar2().size();									
									lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts30.png")));
									
									plot = cardiaco.getParametrosCar2().get(cardiaco.getIndiceDesenho());									
									plotX = calcularDesenhoXCardiaco(cardiaco.getParametrosCar2(), cardiaco.getIndiceDesenho());
									
									seriesRitmoCardiaco.add(plotX, plot.getY());	
									ctrlProg.plotCardiacoJanelaAluno(plotX, plot.getY());
									
									carPosicaoX = plotX;				
									
									if ((cardiaco.getIndiceDesenho() == totalParametros2 -1))
									{
										desenho = false;		
										cardiaco.setIndiceDesenho(0);
										//indiceDesenho = 0;										
										indiceReta = 0;										
										par = cardiaco.getParametrosCar3() != null ?  3 : 1;
									}
									else
										cardiaco.setIndiceDesenho(cardiaco.getIndiceDesenho()+1);
										//indiceDesenho++;
								}
								catch(NullPointerException ex){
									par = 1;
								}catch(IndexOutOfBoundsException ex){
									par = 1;
								}								
								break;
								
							case 3:
								try{
									int totalParametros3 = cardiaco.getParametrosCar3().size();
									lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts30.png")));	
									
									plot = cardiaco.getParametrosCar3().get(cardiaco.getIndiceDesenho());									
									plotX = calcularDesenhoXCardiaco(cardiaco.getParametrosCar3(), cardiaco.getIndiceDesenho());
									
									seriesRitmoCardiaco.add(plotX, plot.getY());	
									ctrlProg.plotCardiacoJanelaAluno(plotX, plot.getY());
									
									carPosicaoX = plotX;															
									
									if ((cardiaco.getIndiceDesenho() == totalParametros3 -1))
									{
										desenho = false;
										cardiaco.setIndiceDesenho(0);
										//indiceDesenho = 0;										
										indiceReta = 0;										
										par = cardiaco.getParametrosCar4() != null ? 4 : 1;
									}
									else
										cardiaco.setIndiceDesenho(cardiaco.getIndiceDesenho()+1);
										//indiceDesenho++;
									
								}catch(NullPointerException ex){
									par = 1;
								}catch(IndexOutOfBoundsException ex){
									par = 1;
								}								
								break;
								
							case 4:
								try{
									int totalParametros4 = cardiaco.getParametrosCar4().size();								
									lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts30.png")));		
									
									plot = cardiaco.getParametrosCar4().get(cardiaco.getIndiceDesenho());									
									plotX = calcularDesenhoXCardiaco(cardiaco.getParametrosCar4(), cardiaco.getIndiceDesenho());	
									
									seriesRitmoCardiaco.add(plotX, plot.getY());
									ctrlProg.plotCardiacoJanelaAluno(plotX, plot.getY());
									
									carPosicaoX = plotX;															
									
									if ((cardiaco.getIndiceDesenho() == totalParametros4 -1))
									{
										desenho = false;		
										cardiaco.setIndiceDesenho(0);
										//indiceDesenho = 0;										
										indiceReta = 0;										
										par = 1;
									}
									else
										cardiaco.setIndiceDesenho(cardiaco.getIndiceDesenho()+1);
										//indiceDesenho++;
								
								}catch(NullPointerException ex){
									par = 1;					
								}catch(IndexOutOfBoundsException ex){
									par = 1;
								}								
								break;								
							}
						}
						else 
						{								
							Thread.sleep(cardiaco.getVelocidadeRetaCardiaco());  
							
							switch(reta)
							{				
														
							case 0:
								if(cardiaco.getRetaCardiaco0() == 0)
									desenho = true;
								
								else if(indiceReta <= cardiaco.getRetaCardiaco0())
								{
									lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts20.png")));									
									seriesRitmoCardiaco.add(carPosicaoX, 0);
									ctrlProg.plotCardiacoJanelaAluno(carPosicaoX, 0);
									carPosicaoX++;										
									indiceReta++;								}
								else
								{								
									desenho = true;
									reta = cardiaco.getRetaCardiaco1() != 0 ? 1 : 1;
								}
								
							break;
							
								case 1:
									if(indiceReta <= cardiaco.getRetaCardiaco1())
									{
										lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts20.png")));										
										seriesRitmoCardiaco.add(carPosicaoX, 0);			
										ctrlProg.plotCardiacoJanelaAluno(carPosicaoX, 0);
										carPosicaoX++;											
										indiceReta++;
									}
									else{								
										desenho = true;	
										reta = cardiaco.getRetaCardiaco2() != 0 ? 2 : 1;
									}
									
								break;
								
								case 2:
									if(indiceReta <= cardiaco.getRetaCardiaco2())
									{
										lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts20.png")));
										seriesRitmoCardiaco.add(carPosicaoX, 0);		
										ctrlProg.plotCardiacoJanelaAluno(carPosicaoX, 0);
										carPosicaoX++;											
										indiceReta++;
									}
									else
									{									
										desenho = true;											
										reta = cardiaco.getRetaCardiaco3() != 0 ? 3 : 1;										
									}
									
								break;
								
								case 3:
									if(indiceReta <= cardiaco.getRetaCardiaco3())
									{
										lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts20.png")));										
										seriesRitmoCardiaco.add(carPosicaoX, 0);	
										ctrlProg.plotCardiacoJanelaAluno(carPosicaoX, 0);
										carPosicaoX++;											
										indiceReta++;
									}
									else
									{						
										desenho = true;									
										reta = cardiaco.getRetaCardiaco4() != 0 ? 4 : 1;
									}
									
								break;
								
								case 4:
									if(indiceReta<= cardiaco.getRetaCardiaco4())
									{
										lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts20.png")));										
										seriesRitmoCardiaco.add(carPosicaoX, 0);	
										ctrlProg.plotCardiacoJanelaAluno(carPosicaoX, 0);
										carPosicaoX++;											
										indiceReta++;
									}
									else
									{						
										desenho = true;
										reta = 1;
									}																		
								break;
							}
						}
						
						/**
						 * SE O GRÃ�FICO CHEGAR AO FINAL DO CHART, VOLTO PARA POSIÃ‡ÃƒO INICIAL
						 */
						if (carPosicaoX >= 322) 
						{
							carPosicaoX = 0;
							reta = 0;
							seriesRitmoCardiaco.clear();	
							ctrlProg.limparCardiacoJanelaSegundaria();
						}						
					}
				} 
				catch(IndexOutOfBoundsException ex ){
					System.err.println("Erro ao capiturar o objeto");
					ex.printStackTrace();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}		
		};

		threadCardiaco.start(); 
	}
	
	protected void executarGraficoOximetria() {
		threadOximetria = new Thread() {
			@SuppressWarnings("static-access")
			@Override
			public void run() 
			{				
				boolean update = false;				
				
				float plotX;
				
				Parametro plotY ;

				try 
				{
					while (true) 
					{					
						Thread.sleep(oximetria.getVelocidadePlotOximetria());
						axisNivelOximetria.setRange(0, oximetria.getRangeOximetria()); // Define o tamanho do eixo X
						int totalParametros = oximetria.getParametrosOxi().size();
												
							if(update){
								plotY = oximetria.getParametrosOxi().get(oximetria.getIndiceDesenhoOximetria());
								plotX = calcularDesenhoXOximetria(oximetria.getParametrosOxi(), oximetria.getIndiceDesenhoOximetria());
								seriesNivelOximetria.add(plotX, plotY.getY());		
								ctrlProg.plotOximetriaJanelaAluno(plotX, plotY.getY());
								oxiPosicaoX = plotX;
								
								if ((oximetria.getIndiceDesenhoOximetria() == totalParametros -1))
								{
									oximetria.setIndiceDesenhoOximetria(0);
									//indiceDesenhoOximetria = 0;
								}
								else
									oximetria.setIndiceDesenhoOximetria(oximetria.getIndiceDesenhoOximetria()+1);
									//indiceDesenhoOximetria++;
							}else
							{
								plotY = oximetria.getParametrosOxi().get(oximetria.getIndiceDesenhoOximetria());								
								seriesNivelOximetria.add(plotY.getX(), plotY.getY());
								ctrlProg.plotOximetriaJanelaAluno(plotY.getX(), plotY.getY());
								
								oxiPosicaoX = plotY.getX();						
																
								if ((oximetria.getIndiceDesenhoOximetria() == totalParametros -1))
								{
									oximetria.setIndiceDesenhoOximetria(0);
									//indiceDesenhoOximetria = 0;
								}
								else
									oximetria.setIndiceDesenhoOximetria(oximetria.getIndiceDesenhoOximetria()+1);
									//indiceDesenhoOximetria++;
								update = true;
							}
							
						/**
						 * SE O GRÃ�FICO CHEGAR AO FINAL DO CHART, VOLTO PARA POSIÃ‡ÃƒO INICIAL
						 */
						if (oxiPosicaoX >= oximetria.getRangeOximetria() ) 
						{
							update = true;
							oxiPosicaoX = 0;							
							seriesNivelOximetria.clear();		
							ctrlProg.limparOximetriaJanelaSegundaria();
						}						
					}
				} 
				catch(IndexOutOfBoundsException ex ){
					System.err.println("Erro ao capiturar o objeto");
					ex.printStackTrace();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		};
		threadOximetria.start();
	}
	
	
	protected void executarGraficoRespiratorio() {
 		threadRespiratorio = new Thread()
 		{
 			@SuppressWarnings("static-access")
 			@Override
 			public void run() 
 			{			
 				//int indiceDesenho = 0;
 				int indiceReta = 0;
 				float plotX;
 				Parametro plot = null;
 				
 				int reta = 0;
 				float valorDesenhoReta;
 				plot = respiratorio.getParametrosResp1().get(respiratorio.getIndiceDesenhoResp());
 				
 			//	 VariÃ¡vel para indicar qual parametro desenhar
 				int par = 1;
 				try 
 				{
 					while (true) 
 					{			
 						Thread.sleep(respiratorio.getVelocidadePlot()); 	 
 						if (respiratorio.isDesenho()) 
 						{		
 							Thread.sleep(respiratorio.getVelocidadePlotDesenho());
 							switch(par){
 							case 1:
 								int totalParametros1 = respiratorio.getParametrosResp1().size();
 								plot = respiratorio.getParametrosResp1().get(respiratorio.getIndiceDesenhoResp());
 								
 								
 								plotX = calcularDesenhoXRespiratorio(respiratorio.getParametrosResp1(), respiratorio.getIndiceDesenhoResp());
 								seriesRitmoRespiratorio.add(plotX, plot.getY());
 								ctrlProg.plotRespiratorioJanelaSecundaria(plotX, plot.getY());
 								
 								respiratorio.setResPosicaoX(plotX);						
 								
 								if ((respiratorio.getIndiceDesenhoResp() == totalParametros1 -1))
 								{
 									respiratorio.setDesenho(false);	 									
 									respiratorio.setIndiceDesenhoResp(0);
 									indiceReta = 0;
 									
 									if(respiratorio.getParametrosResp2() != null){
 										par = 2;
 									}
 									else 
 										par = 1;
 								}
 								else
 									respiratorio.setIndiceDesenhoResp(respiratorio.getIndiceDesenhoResp()+1); 									
 								
 								break;
 								
 							case 2:
 								try{
 									int totalParametros2 = respiratorio.getParametrosResp2().size();	 									
 									plot = respiratorio.getParametrosResp2().get(respiratorio.getIndiceDesenhoResp());	 									
 									plotX = calcularDesenhoXRespiratorio(respiratorio.getParametrosResp2(), respiratorio.getIndiceDesenhoResp());	 									
 									seriesRitmoRespiratorio.add(plotX, plot.getY());
 									ctrlProg.plotRespiratorioJanelaSecundaria(plotX, plot.getY());
 									respiratorio.setResPosicaoX(plotX);						
 									
 									
 									if ((respiratorio.getIndiceDesenhoResp() == totalParametros2 -1))
 									{
 										respiratorio.setDesenho(false);
 										respiratorio.setIndiceDesenhoResp(0);
 										
 										indiceReta = 0;
 										
 										if(respiratorio.getParametrosResp3() != null){
 											par = 3;
 										}
 										else 
 											par = 1;
 									}
 									else
 										respiratorio.setIndiceDesenhoResp(respiratorio.getIndiceDesenhoResp()+1);
 								}
 								catch(NullPointerException ex){
 									par = 1;
 								}catch(IndexOutOfBoundsException ex){
 									par = 1;
 								}
 								
 								break;
 								
 							case 3:
 								try{
 									int totalParametros3 = respiratorio.getParametrosResp3().size();								
 									plot = respiratorio.getParametrosResp3().get(respiratorio.getIndiceDesenhoResp());									
 									plotX = calcularDesenhoXRespiratorio(respiratorio.getParametrosResp3(), respiratorio.getIndiceDesenhoResp());									
 									seriesRitmoRespiratorio.add(plotX, plot.getY());
 									ctrlProg.plotRespiratorioJanelaSecundaria(plotX, plot.getY());
 									respiratorio.setResPosicaoX(plotX);															
 									
 									if ((respiratorio.getIndiceDesenhoResp() == totalParametros3 -1))
 									{
 										respiratorio.setDesenho(false);
 										respiratorio.setIndiceDesenhoResp(0);
 										indiceReta = 0;										
 										par = 1;
 									}
 									else
 										respiratorio.setIndiceDesenhoResp(respiratorio.getIndiceDesenhoResp()+1);
 								
 								}catch(NullPointerException ex){
 									par = 1;					
 								}catch(IndexOutOfBoundsException ex){
 									par = 1;
 								}
 								break;
 							}
 						}
 						else 
 						{	
 							valorDesenhoReta = plot.getY();
 							switch(reta)
 							{				
 							
 							case 0:
 								if(respiratorio.getRetaRespiratorio() == 0)
 									respiratorio.setDesenho(true);
 								
 								if(indiceReta <= respiratorio.getRetaRespiratorio())
 								{									
 									seriesRitmoRespiratorio.add(respiratorio.getResPosicaoX(), valorDesenhoReta);
 									ctrlProg.plotRespiratorioJanelaSecundaria(respiratorio.getResPosicaoX(), valorDesenhoReta);
									respiratorio.setResPosicaoX(respiratorio.getResPosicaoX() + (float) 0.1);	
									indiceReta ++;
 								}
 								else{								
 									respiratorio.setDesenho(true);
 								
 									if(respiratorio.getRetaRespiratorio1() != 0)
 										reta = 1;		
 								}
 								
 							break;
 								case 1:
 									if(indiceReta <= respiratorio.getRetaRespiratorio1())
 									{
 										seriesRitmoRespiratorio.add(respiratorio.getResPosicaoX(), valorDesenhoReta);
 										ctrlProg.plotRespiratorioJanelaSecundaria(respiratorio.getResPosicaoX(), valorDesenhoReta);
										respiratorio.setResPosicaoX(respiratorio.getResPosicaoX() + (float) 0.1);	
										indiceReta ++;
 									}
 									else{								
 										respiratorio.setDesenho(true);
 									
 										if(respiratorio.getRetaRespiratorio2() != 0)
 											reta = 2;		
 									}
 									
 								break;
 								case 2:
 									if(indiceReta <= respiratorio.getRetaRespiratorio2())
 									{										
 										seriesRitmoRespiratorio.add(respiratorio.getResPosicaoX(), valorDesenhoReta);
 										ctrlProg.plotRespiratorioJanelaSecundaria(respiratorio.getResPosicaoX(), valorDesenhoReta);
										respiratorio.setResPosicaoX(respiratorio.getResPosicaoX() + (float) 0.1);	
										indiceReta ++;
 									}
 									else{		
 										respiratorio.setDesenho(true);
 										reta = 1;
 									}
 									
 								break;
 							}
 						}
 						
 						/**
 						 * SE O GRÃ�FICO CHEGAR AO FINAL DO CHART, VOLTO PARA POSIÃ‡ÃƒO INICIAL
 						 */
 						if (respiratorio.getResPosicaoX() >= 150) 
 						{
 							respiratorio.setResPosicaoX(0);
 							reta = 0;
 							seriesRitmoRespiratorio.clear();	
 							ctrlProg.limparRespiratorioJanelaSecundaria();
 						}						
 					}
 				} 
 				catch(IndexOutOfBoundsException ex ){
 					System.err.println("Erro ao capiturar o objeto");
 					ex.printStackTrace();
 				}
 				catch (Exception e) 
 				{
 					e.printStackTrace();
 				}
 			}		
 		};
 
 		threadRespiratorio.start(); 
 	}
		
	@SuppressWarnings("deprecation")
	public void threadOptionCardiaco(String nome)
	{
		if(nome == "Play") 
			threadCardiaco.resume();
		else 
			threadCardiaco.suspend();
	}
	
	@SuppressWarnings("deprecation")
	public void threadOptionOximetria(String nome)
	{
		if(nome == "Play") 
			threadOximetria.resume();
		else 
			threadOximetria.suspend();
	}
	
	@SuppressWarnings("deprecation")
	public void threadOptionRespiratorio(String nome)
	{
		if(nome == "Play") 
			threadRespiratorio.resume();
		else 
			threadRespiratorio.suspend();
	}
	
	
	/**
	 * MÉTODO RESPONSÁVEL POR CALCULAR ONDE SERÁ O PLOT DO MEU X A PARTIR DA POSIÇÃO ATUAL DO MEU GRÁFICO
	 * @param parametros
	 * @param indice
	 * @return
	 */
	public float calcularDesenhoXOximetria(ArrayList<Parametro> parametros, int indice)
	{
		//Valor que irá retornar no método
		float resultado = 0;
		
		//Valor do meu X para o indice anterior
		float xAnterior = 0;
		
		//Valor do meu X para a posição desejada pelo meu indice
		float xAtual = 0;
		
		//Se o valor do meu indice for 0 o valor da variável X anterior continua sendo 0 
		if(indice == 0)
			xAnterior = 0;
		else
			//Se o valor do indice não for 0, a variável X anterior receberá o valor do indice anterior
			xAnterior = parametros.get(indice - 1).getX();
		
		//X Atual receberá o valor do X do indice desejado
		xAtual = parametros.get(indice).getX();
		
		//A variavel resultado receberar o valor da expressão abaixo
		//Valor da posição X do meu grafico cardiaco atual + Valor da variável X do meu indice - o Valor do X do meu indice anterior
		resultado = ((oxiPosicaoX + xAtual) - xAnterior);
		
		//Retorno do método
		return resultado;		
	}
	
	/**
	 * MÉTODO RESPONSÁVEL POR CALCULAR ONDE SERÁ O PLOT DO MEU X A PARTIR DA POSIÇÃO ATUAL DO MEU GRÁFICO
	 * @param parametros
	 * @param indice
	 * @return
	 */
	public float calcularDesenhoXCardiaco(ArrayList<Parametro> parametros, int indice)
	{
		//Valor que irá retornar no método
		float resultado = 0;
		
		//Valor do meu X para o indice anterior
		float xAnterior = 0;
		
		//Valor do meu X para a posição desejada pelo meu indice
		float xAtual = 0;
		
		//Se o valor do meu indice for 0 o valor da variável X anterior continua sendo 0 
		if(indice == 0)
			xAnterior = 0;
		else
			//Se o valor do indice não for 0, a variável X anterior receberá o valor do indice anterior
			xAnterior = parametros.get(indice - 1).getX();
		
		//X Atual receberá o valor do X do indice desejado
		xAtual = parametros.get(indice).getX();
		
		//A variavel resultado receberar o valor da expressão abaixo
		//Valor da posição X do meu grafico cardiaco atual + Valor da variável X do meu indice - o Valor do X do meu indice anterior
		resultado = ((carPosicaoX + xAtual) - xAnterior);
		
		//Retorno do método
		return resultado;		
	}

	 /**
	  *  MÉTODO RESPONSÁVEL POR CALCULAR ONDE SERÁ O PLOT DO MEU X A PARTIR DA POSIÇÃO ATUAL DO MEU GRÁFICO
	  * @param parametros
	  * @param indice
	  * @return
	  */
	public float calcularDesenhoXRespiratorio(ArrayList<Parametro> parametros, int indice)
	{
		//Valor que irá retornar no método
		float resultado = 0;
		
		//Valor do meu X para o indice anterior
		float xAnterior = 0;
		
		//Valor do meu X para a posição desejada pelo meu indice
		float xAtual = 0;
		
		//Se o valor do meu indice for 0 o valor da variável X anterior continua sendo 0 
		if(indice == 0)
			xAnterior = 0;
		else
			//Se o valor do indice não for 0, a variável X anterior receberá o valor do indice anterior
			xAnterior = parametros.get(indice - 1).getX();
		
		//X Atual receberá o valor do X do indice desejado
		xAtual = parametros.get(indice).getX();
		
		//A variavel resultado receberar o valor da expressão abaixo
		//Valor da posição X do meu grafico cardiaco atual + Valor da variável X do meu indice - o Valor do X do meu indice anterior
		resultado = ((respiratorio.getResPosicaoX() + xAtual) - xAnterior);
		
		//Retorno do método
		return resultado;		
	}
	

	/**
	 * MÉTODO RESPONSÁVEL POR AJUSTAR O TAMANHO DA RETA PELOS BATIMENTOS
	 * @param retaAtual
	 * @param batimentoAnterior
	 * @param batimentoAtual
	 * @return
	 */
	public int ajustarReta(int retaAtual, int batimentoAnterior, int batimentoAtual)
	{	
		int btm1 = batimentoAnterior;
		int btm2 = batimentoAtual;
		int reta1 = retaAtual;
		int reta2;
		
		reta2 = (btm1 * reta1) / batimentoAtual;
		
		return reta2;
	}
//	
//	/**
//	 * MÉTODO RESPONSÁVEL POR SERIALIZAR OS DADOS
//	 */
//	public void salvarDados(){
//		DTOJanelaPrincipal dto = new DTOJanelaPrincipal();
//		dto.setNomeCardiaco(cbxRitmoCardiaco.getSelectedItem().toString());
//		dto.setNomeOximetria(cbxNivelOximetria.getSelectedItem().toString());
//		dto.setNomeRespiratorio(cbxRitmoRespiratorio.getSelectedItem().toString());
//		dto.setValorCardiaco(lbValorCardiaco.getText());
//		dto.setValorOximetria(lblValorOximetria.getText());
//		dto.setValorRespiratorio(lblValorRespiratorio.getText());
//		dto.setPressaoMaxima(lblPressaoMaxima.getText());
//		dto.setPressaoMinima(lblPressaoMinima.getText());
//		dto.setTemperatura1(lblTemperatura1.getText());
//		dto.setTemperatura2(lblTemperatura2.getText());		
//
//		
//		JFileChooser chooser = new JFileChooser();
//		String ext = "dat";
//		String caminho = "";
//		
//		File file = null;
//		chooser.setFileFilter(new ExtensionFileFilter("Aquivos DAT", "dat"));
//		
//		// showSaveDialog retorna um inteiro , e ele ira determinar que o chooser será para salvar.
//		int retorno = chooser.showSaveDialog(null); 
//		if (retorno == JFileChooser.APPROVE_OPTION){
//			// o getSelectedFile pega o arquivo e o getAbsolutePath retorna uma string contendo o endereço.
//		      caminho = chooser.getSelectedFile().getPath();   
//		      //file = chooser.getSelectedFile();
//		      
//		      Boolean containsExt = caminho.contains(".");		      
//		      if(containsExt)
//		      {
//		    	  String currrentExt = caminho.substring(caminho.lastIndexOf(".") + 1);
//		            if(!ext.equalsIgnoreCase(currrentExt)) caminho = caminho + "." + ext;		        
//		        }
//		        else
//		        {
//		            caminho = caminho + "." + ext;          
//		        }		      
//		           
//		      try 
//		      {
//		    	  FileOutputStream arquivoGrav = new FileOutputStream(caminho);
//		    	  ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
//		    	  objGravar.writeObject(dto);
//		    	  objGravar.flush();
//		    	  objGravar.close();
//		    	  arquivoGrav.flush();
//		    	  arquivoGrav.close();
//		    	  
//
//		    	  JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso");
//			} 
//			catch (FileNotFoundException e) 
//	      	{			
//				JOptionPane.showMessageDialog(null, "Erro ao Salvar o Arquivo", "ERRO", JOptionPane.OK_OPTION, null);
//				e.printStackTrace();
//			} 
//	      	catch (IOException e) 
//		    {			
//	      		JOptionPane.showMessageDialog(null, "Erro ao Salvar o Arquivo", "ERRO", JOptionPane.OK_OPTION, null);
//				e.printStackTrace();
//			}
//		}	
//	}
//	
//	/**
//	 * MÉTODO RESPONSÁVEL POR DESERIALIZAR OS DADOS
//	 */
//	public void carregarDados(){
//		DTOJanelaPrincipal dto = new DTOJanelaPrincipal();
//		
//		JFileChooser chooser;
//		UIManager.put("FileChooser.openButtonText", "Abrir");  
//		chooser = new JFileChooser();
//		String caminho = "";
//		
//		File file = null;
//		chooser.setFileFilter(new ExtensionFileFilter("Texto", "dat"));
//		
//		// showSaveDialog retorna um inteiro , e ele ira determinar que o chooser será para salvar.
//		int retorno = chooser.showOpenDialog(null); 
//		
//		if (retorno==JFileChooser.APPROVE_OPTION){
//			// o getSelectedFile pega o arquivo e o getAbsolutePath retorna uma string contendo o endereço.
//		     file = chooser.getSelectedFile();		     
//			caminho = chooser.getSelectedFile().getPath();   
//			
//			System.out.println(file);
//		      
//		      try {
//					FileInputStream	inFile = new FileInputStream(file);
//					ObjectInputStream d = new ObjectInputStream(inFile);
//					dto = (DTOJanelaPrincipal) d.readObject();			
//					d.close();
//					
//				} catch (FileNotFoundException e) {			
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//			    
//				lbValorCardiaco.setText(dto.getValorCardiaco());
//				lblValorOximetria.setText(dto.getValorOximetria());
//				lblValorRespiratorio.setText(dto.getValorRespiratorio());
//				lblPressaoMaxima.setText(dto.getPressaoMaxima());
//				lblPressaoMinima.setText(dto.getPressaoMinima());
//				lblTemperatura1.setText(dto.getTemperatura1());
//				lblTemperatura2.setText(dto.getTemperatura2());
//				cbxRitmoCardiaco.setSelectedItem(dto.getNomeCardiaco());
//				cbxNivelOximetria.setSelectedItem(dto.getNomeOximetria());
//				cbxRitmoRespiratorio.setSelectedItem(dto.getNomeRespiratorio());
//				
//							
//		}
//	}
//	


	public void setLbValorCardiaco(String valor) {
		this.lbValorCardiaco.setText(valor);
	}

	public void setLblValorOximetria(String valor) {
		this.lblValorOximetria.setText(valor);
	}

	public void setLblValorRespiratorio(String valor) {
		this.lblValorRespiratorio.setText(valor);
	}

	public void setLblValorMmHg(String valor) {
		this.lblValorMmHg.setText(valor);
	}

	public void setLblTemperatura1(String valor) {
		this.lblTemperatura1.setText(valor);
	}

	public void setLblTemperatura2(String valor) {
		this.lblTemperatura2.setText(valor);
	}

	public void setLblPressaoMaxima(String valor) {
		this.lblPressaoMaxima.setText(valor);
	}

	public String getLblTemperatura1() {
		return lblTemperatura1.getText();
	}
	
	public String getLblTemperatura2() {
		return lblTemperatura2.getText();
	}
	
	public void setLblPressaoMinima(String valor) {
		this.lblPressaoMinima.setText(valor);
	}

	public JLabel getLblValorMmHg() {
		return lblValorMmHg;
	}

	public void setLblValorMmHg(JLabel lblValorMmHg) {
		this.lblValorMmHg = lblValorMmHg;
	}

	public String getLblPressaoMaxima() {
		return lblPressaoMaxima.getText();
	}

	public String getLblPressaoMinima() {
		return lblPressaoMinima.getText();
	}

	

	
	
	
}
