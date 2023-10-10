package Iniciar;

import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        switch (Menu()){
            case 1:
            System.out.println("CadastrarAula");
            //CadastrarAula();
            break;
            case 2:
            System.out.println("ExcluirAula");
            //ExcluirAula();
            break;
            case 3:
            System.out.println("EditarAula");
            //EditarAula();
            break;
        }
    }

    public static int Menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
        System.out.println("Bem vindo ao sistema de gerenciamento de horários de salas de aulas!");
        System.out.println("Qual opção você deseja?");

        System.out.println("1- Cadastrar uma nova aula.");
        System.out.println("2- Excluir uma aula.");
        System.out.println("3- Editar uma aula existente.");
        
        opcao = scanner.nextInt();

        if (opcao != 1 && opcao != 2 && opcao != 3){
            System.out.println("Digite uma opção valida!");
        }
        
        } while ((opcao != 1) && (opcao != 2) && (opcao != 3));

        return opcao;
    }
}
