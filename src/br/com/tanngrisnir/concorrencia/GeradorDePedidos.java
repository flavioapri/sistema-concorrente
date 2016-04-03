package br.com.tanngrisnir.concorrencia;

import java.util.Random;

/**
 * Gera pedidos com dados aleat�rios. A classe gera as informa��es dos pedidos
 * utilizando <b>StringBuilder</b> para ganhar em performance na gera��o destas
 * informa��es. Seu uso plaus�vel para a aplica��o porque seram geradas muitas
 * strings durante a execu��o do processamento de todos os pedidos. Foram usadas
 * as constantes que fazem refer�ncia a tabela ASCII porque estas representam o
 * intervalo na tabela ASCII de caracteres que pode ser impressos na codifica��o
 * Java. A tabela possui muitos caracteres que n�o podem ser impressos em Java.
 * Para entender o motivo do uso das constantes na classe veja a classe
 * <b>Pedido</b>.
 * 
 * @see Pedido
 * @see {@link} http://www.asciitable.com/
 * @author Fl�vio Aparecido Ribeiro
 *
 */
public class GeradorDePedidos {
	private Random random;
	private int numeroAleatorio;
	private final static int primeiroAlgarismoNaTabelaASCII = 33;
	private final static int ultimoAlgarismoNaTabelaASCII = 127;
	private final static int caracteresNoPacoteDeDados = 1000;
	private final static int digitosNoIdentificador = 20;

	public GeradorDePedidos() {
		this.random = new Random();
	}

	public Pedido gerar() {
		return new Pedido(gerarId(), gerarDados());
	}

	/**
	 * Gera uma string aleat�ria de mil caracteres.
	 * 
	 * @return Uma string de mil caracteres aleat�rios
	 */
	private StringBuilder gerarDados() {
		StringBuilder dados = new StringBuilder();

		// Enquanto a string dos dados n�o a quantidade de caracteres do pacote
		// de dados...
		while (dados.length() < caracteresNoPacoteDeDados) {
			// Gera um n�mero aleat�rio at� o que representa o �ltimo caractere
			// que pode ser impresso na tabela ASCII
			numeroAleatorio = random.nextInt(ultimoAlgarismoNaTabelaASCII);
			if (numeroAleatorio < primeiroAlgarismoNaTabelaASCII) {
				// Se o n�mero gerado for menor que o que representea primeiro
				// que pode ser impresso na tabela ASCII continua no la�o
				continue;
			} else {
				// Converte o n�mero no respectivo caractere da tabela ASCII e
				// adiciona a string
				dados.append((char) numeroAleatorio);
			}
		}
		return dados;
	}

	/**
	 * Gera uma string aleat�ria de 20 d�gitos.
	 * 
	 * @return Uma string aleat�ria de 20 d�gitos.
	 */
	private StringBuilder gerarId() {
		StringBuilder id = new StringBuilder();

		// Segue a mesma l�gica do m�todo que gera os dados mas converte os
		// n�meros para os respectivos na tabela ASCII
		while (id.length() < digitosNoIdentificador) {
			numeroAleatorio = random.nextInt(10);
			id.append(numeroAleatorio);
		}
		return id;
	}
}
