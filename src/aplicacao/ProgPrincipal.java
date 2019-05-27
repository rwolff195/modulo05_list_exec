package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;

public class ProgPrincipal {

	public static void main(String[] args) {
		/*
		﻿Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de N funcionários. Não deve haver repetição de id.
		Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
		Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
		mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários,conforme exemplos.
		Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa ser mudado livremente. Um salário só pode ser 
		aumentado com base em uma operação de aumento por porcentagem dada.
		*/
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> funcionario = new ArrayList<>();
		
		// PARTE I - LENDO OS DADOS
		
		System.out.print("Quantos funcionários quer cadastrar: ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println();
			System.out.println("Funcionário #" + i + ": ");
			System.out.print("ID: ");
			int id = sc.nextInt();
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			double salario = sc.nextDouble();
			
			funcionario.add(new Funcionario(id,nome,salario));			
		}
		
		// PARTE II - AUMENTO DO SALÁRIO
		System.out.println();
		System.out.print("Entre com o Id do funcionario para o aumento do salário: ");
		int id = sc.nextInt();
		
		Funcionario empregado = funcionario.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if(empregado == null) {
			System.out.println();
			System.out.println("Este empregado não existe!!!");
		}
		else {
			System.out.print("Entre com a porcentagem de aumento: ");
			double porcentagem = sc.nextDouble();
			empregado.NovoSalario(porcentagem);
		}
		
		
		System.out.println();
		System.out.print("*** Lista de Funcionários ***");
		System.out.println();
		
		for (Funcionario x : funcionario) {
			System.out.println();
			System.out.println(x);
		}
		
		sc.close();
	}

}
