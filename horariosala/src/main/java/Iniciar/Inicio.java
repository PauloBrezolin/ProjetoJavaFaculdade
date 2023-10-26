package Iniciar;

import java.util.Scanner;

import javax.persistence.EntityManager;

import EntityFactory.EntityFactory;

public class Inicio {
    public static void main(String[] args) {
        switch (Menu()) {
            case 1:
                System.out.println("CadastrarAula");
                CadastrarAula();
                break;
            case 2:
                System.out.println("ExcluirAula");
                // ExcluirAula();
                break;
            case 3:
                System.out.println("EditarAula");
                // EditarAula();
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

            if (opcao != 1 && opcao != 2 && opcao != 3) {
                System.out.println("Digite uma opção valida! (1-3)");
            }

        } while ((opcao != 1) && (opcao != 2) && (opcao != 3));

        return opcao;
    }

    public static void CadastrarAula() {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = EntityFactory.getEntityFactory();

        int dia;
        int turno;
        int sala;

        System.out.println("Vamos cadastrar uma nova aula!");

        do {
        System.out.println("Qual dia você quer cadastrar a aula?");
        System.out.println("1- Segunda");
        System.out.println("2- Terça");
        System.out.println("3- Quarta");
        System.out.println("4- Quinta");
        System.out.println("5- Sexta");
        System.out.println("6- Sábado");
        dia = scanner.nextInt();
        if (dia != 1 && dia != 2 && dia != 3 && dia != 4 && dia != 5 && dia !=6){
            System.out.println("Digite um dia válido! (1-6)");
        }
        } while(dia != 1 && dia != 2 && dia != 3 && dia != 4 && dia != 5 && dia !=6);
        do{
        System.out.println("Qual turno você quer cadastrar a aula?");
        System.out.println("1- Matutino");
        System.out.println("2- Vespentino");
        System.out.println("3- Noturno");

        turno = scanner.nextInt();
        if (turno != 1 && turno != 2 && turno != 3) {
                System.out.println("Digite uma opção valida! (1-3)");
            }

        } while ((turno != 1) && (turno != 2) && (turno != 3));

        do {
            System.out.println("Qual sala você quer cadastrar a aula?");
            System.out.println("(1-20)");
            sala = scanner.nextInt();
            if (sala < 1 || sala > 20) {
                System.out.println("Digite um número de sala válido! (1-20)");
            }
        } while (sala < 1 || sala > 20);

        
    }
}
