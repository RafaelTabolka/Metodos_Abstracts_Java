package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.CommonsAttributes;
import entities.FisicPeople;
import entities.LegalPeople;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<CommonsAttributes> list = new ArrayList<>();
		
		char register;
		do {
		System.out.print("Insira a quantidade de pessoas, físicas ou jurídicas, a cadastrar os dados: ");
		int n = sc.nextInt();

		while (n < 0) {
			System.out.print("Quantidade inválida. Digite novamente: ");
			n = sc.nextInt();
		}
			for (int i = 0; i < n; i++) {
				System.out.println();

				System.out.println("Funcionário #" + (i + 1) + ":");
				System.out.print("Pessoa física ou jurídica? (f/j) ");
				char people = sc.next().charAt(0);

				while (people != 'f' && people != 'j') {
					System.out.println("Opção inválida. Digite novamente: ");
					people = sc.next().charAt(0);
				}
				System.out.print("Nome: ");
				sc.nextLine();
				String name = sc.nextLine();

				System.out.print("Renda anual: ");
				float annualIncome = sc.nextFloat();

				if (people == 'f') {
					System.out.print("Gastos com saúde: ");
					float healthSpending = sc.nextFloat();

					while (annualIncome < healthSpending) {
						System.out.println("Saldo não possível. Digite outra renda anual: ");
						annualIncome = sc.nextFloat();
					}
					list.add(new FisicPeople(name, annualIncome, healthSpending));
				} else {
					System.out.print("Número de funcionários: ");
					int numberOfEmployee = sc.nextInt();
					list.add(new LegalPeople(name, annualIncome, numberOfEmployee));
				}
			}
			System.out.println();
			System.out.print("Deseja fazer outro cadastro? (s/n) ");
			register = sc.next().charAt(0);

			while (register != 's' && register != 'n') {
				System.out.print("Opção inválida. Digite novamente: ");
				register = sc.next().charAt(0);
			}
		} while (register == 's');
		System.out.println();
		System.out.println("Taxas pagas:");

		float total = 0;
		for (CommonsAttributes x : list) {
			System.out.println(x.toString());
			total += x.impost();
		}
		System.out.println();
		System.out.print("Total de taxas pagas: R$ ");
		System.out.println(total);

		sc.close();
	}
}
