package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

import model.Parametro;

public class LeitorBatimentos {
	
	static final String DIRETORIO = "..\\LiveSignal\\beats\\";
	
	
	/**
	 * M�todo reposns�vel por ler os valores de batimento atrav�s de um arquivo texto
	 * @param nmArquivo
	 * @return
	 */
	@SuppressWarnings("resource")
	public ArrayList<Parametro> getParameters(String nmArquivo)
	{
		File arquivo = new File(DIRETORIO + nmArquivo);
		
		ArrayList<Parametro> parametros = new ArrayList<Parametro>();
		
		try{
		
			FileReader arquivoLeitura = new FileReader(DIRETORIO + nmArquivo);

			
			LineNumberReader qtdLinhas = new LineNumberReader(new FileReader(DIRETORIO + nmArquivo));
			
			qtdLinhas.skip(arquivo.length());
	
			BufferedReader lerArq = new BufferedReader(arquivoLeitura);
			
			String[] linha = new String[qtdLinhas.getLineNumber() + 1];			
			

			for (int i = 0; i <= qtdLinhas.getLineNumber(); i++) 
			{
				linha[i] = lerArq.readLine();
				
				String txt[] = linha[i].split(",");
				
				Parametro parametro = new Parametro();
				
				parametro.setX(Float.parseFloat(txt[0]));
				
				parametro.setY(Float.parseFloat(txt[1]));
				
				parametros.add(parametro);
			}
			
		}catch(IOException ex)
		{
			System.err.println("Erro ao abrir o arquivo texto");
			System.out.println(DIRETORIO + nmArquivo);
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			System.err.println("Erro ao aplicar o regex");
		}
		
		return parametros;
	}
}
