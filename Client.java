import java.io.*;
import java.net.*;
import java.lang.System;
import java.util.Scanner;


public class Client{
	public static void main(String[] args) throws Exception{				
		String msg = "";
		String host = "";

		int port = 0;
		int len = 0;
		long tempoIda = 0;
		long tempoVolta = 0;

		Socket client = null;
		InputStream entrada = null;
		OutputStream saida = null;
		ByteArrayOutputStream os = null;
		Scanner teclado = null;
		byte [] buffer = null;

		//Host e porta
		host = args[0];
		port = Integer.parseInt(args[1]);

		client = new Socket(host, port);
		System.out.println("\nO cliente se conectou ao servidor \n");

		// Le do teclado
		teclado = new Scanner(System.in);

		System.out.print("Mensagem a enviar: ");
		msg = teclado.nextLine();

		// Checa tempo ao enviar
		tempoIda = System.currentTimeMillis();
		System.out.println("\nTempo atual na ida: " + tempoIda + "ms\n");

		// Escreve array de bytes no stream de saida
		saida = client.getOutputStream();
		saida.write(msg.getBytes("UTF-8"));

		// Prepara o stream de entrada
		entrada = client.getInputStream();

		buffer = new byte[1024];
		os = new ByteArrayOutputStream();

		// Joga o resultado da entrada em um ByteArrayOutputStream
		while( (len = entrada.read(buffer)) != -1){
			os.write(buffer, 0, len);
		}
		System.out.println("Mensagem recebida: " + os.toString() + "\n");

		// Checa tempo ao receber
		tempoVolta = System.currentTimeMillis();
		System.out.println("Tempo atual na volta: " + tempoVolta + "ms\n");

		System.out.println("RTT: " + (tempoVolta-tempoIda) + "ms");

		saida.close();
		entrada.close();
		os.close();
		client.close();

	}
}