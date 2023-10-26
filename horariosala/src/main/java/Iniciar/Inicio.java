package Iniciar;

import java.util.Scanner;

import javax.persistence.EntityManager;

import EntityFactory.EntityFactory;

public class Inicio {
    public static void main(String[] args) {
        switch (Menu()) {
            case 1:
                CadastrarAula();
                break;
            case 2:
                ExcluirAula();
                break;
            case 3:
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
            System.out.println("3- Sair");

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

        int opcao;
        int dia;
        int turno;
        int sala;
        int professor;
        String aula;

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
            if (dia != 1 && dia != 2 && dia != 3 && dia != 4 && dia != 5 && dia != 6) {
                System.out.println("Digite um dia válido! (1-6)");
            }
        } while (dia != 1 && dia != 2 && dia != 3 && dia != 4 && dia != 5 && dia != 6);
        do {
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
            System.out.println("(1-10)");
            sala = scanner.nextInt();
            if (sala < 1 || sala > 10) {
                System.out.println("Digite um número de sala válido! (1-10)");
            }
        } while (sala < 1 || sala > 10);

        do {
            System.out.println("Qual professor você quer cadastrar para a aula?");
            System.out.println("1- Vitor");
            System.out.println("2- Talita");
            System.out.println("3- Heleno");

            professor = scanner.nextInt();
            if (professor != 1 && professor != 2 && professor != 3) {
                System.out.println("Digite uma opção valida! (1-3)");
            }

        } while ((professor != 1) && (professor != 2) && (professor != 3));

        System.out.println("Escolha o nome da aula: ");
        aula = scanner.next();

        boolean validaSala = EntityFactory.validaSala(dia, turno, sala, em);
        boolean validaProfessor = EntityFactory.validaProfessor(dia, turno, professor, em);

        if (validaSala) {
            if (validaProfessor) {
                EntityFactory.cadastroAula(aula, dia, turno, professor, sala, em);
            } else {
                System.out.println("Esse professor já está dando aula nesse horário!");
                System.out.println("Deseja tentar cadastrar outra aula?");
                System.out.println("1- SIM");
                System.out.println("2- NÃO");
                opcao = scanner.nextInt();

                if (opcao == 1) {
                    CadastrarAula();
                }
            }
        } else {
            System.out.println("Essa sala está ocupada nesse horário!");
            System.out.println("Deseja tentar cadastrar outra aula?");
            System.out.println("1- SIM");
            System.out.println("2- NÃO");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                CadastrarAula();
            }
        }
    }

    public static void ExcluirAula() {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = EntityFactory.getEntityFactory();

        int opcao;
        int dia;
        int turno;
        int sala;
        Long id;
        
        System.out.println("Vamos excluir uma aula!");

        do {
            System.out.println("Qual o dia da aula que você deseja excluir?");
            System.out.println("1- Segunda");
            System.out.println("2- Terça");
            System.out.println("3- Quarta");
            System.out.println("4- Quinta");
            System.out.println("5- Sexta");
            System.out.println("6- Sábado");
            dia = scanner.nextInt();
            if (dia != 1 && dia != 2 && dia != 3 && dia != 4 && dia != 5 && dia != 6) {
                System.out.println("Digite um dia válido! (1-6)");
            }
        } while (dia != 1 && dia != 2 && dia != 3 && dia != 4 && dia != 5 && dia != 6);
        do {
            System.out.println("Qual o turno da aula que você deseja excluir?");
            System.out.println("1- Matutino");
            System.out.println("2- Vespentino");
            System.out.println("3- Noturno");

            turno = scanner.nextInt();
            if (turno != 1 && turno != 2 && turno != 3) {
                System.out.println("Digite uma opção valida! (1-3)");
            }

        } while ((turno != 1) && (turno != 2) && (turno != 3));

        do {
            System.out.println("Qual a sala da aula que você deseja excluir?");
            System.out.println("(1-10)");
            sala = scanner.nextInt();
            if (sala < 1 || sala > 10) {
                System.out.println("Digite um número de sala válido! (1-10)");
            }
        } while (sala < 1 || sala > 10);

        id = EntityFactory.puxarID(dia, turno, sala, em);

        if (id == 0){
            System.out.println("Não existe nenhuma aula cadastrada com essas informações");
            System.out.println("Deseja tentar excluir outra aula?");
            System.out.println("1- SIM");
            System.out.println("2- NÃO");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                ExcluirAula();
            }
        }else{
            EntityFactory.excluirAula(id, em);
        }
    }
}
