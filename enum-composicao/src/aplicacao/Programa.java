package aplicacao;

import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("Entre com o nome do departamento:");
		String nomeDepartamento = sc.nextLine();
		System.out.print("Entre com os dados do empregado:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nivel: ");
		String nivel = sc.nextLine();
		System.out.print("Sal�rio base: ");
		double salarioBase = sc.nextDouble();

	}

}
