package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.ContratoHora;
import entidade.Departamento;
import entidade.Empregados;
import entidade.numeracao.NivelEmpregado;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		System.out.print("Entre com o nome do departamento:");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Entre com os dados do empregado:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nivel: ");
		String nivel = sc.nextLine();
		System.out.print("Sal?rio base: ");
		double salarioBase = sc.nextDouble();

		Empregados emp = new Empregados(nome, NivelEmpregado.valueOf(nivel), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.println("Quantos contratos esse trabalhador tem? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Entre com os dados do contrato #" + i + ":");
			System.out.print("Data DD/MM/YYYY: ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Dura??o do contrato(horas): ");
			int horas = sc.nextInt();
			ContratoHora contrato = new ContratoHora(dataContrato, valorPorHora, horas);
			emp.addContrato(contrato);		
		}
		
		System.out.println();
		System.out.println("Entre com o mes e ano para calcular o valor a receber (MM/YYYY):");
		
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome: " + emp.getNome());
		System.out.println("Departamento: " + emp.getDepartamento().getNome());
		System.out.print("Ganho para o mes " + mesAno + " : " + String.format("%.2f", emp.valorGanho(ano, mes)));
		
		sc.close();
	}

}
