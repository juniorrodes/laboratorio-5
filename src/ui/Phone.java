package ui;

import controllers.ContactController;
import controllers.LostCallsController;
import utils.ContactInfo;

import java.util.Scanner;

public class Phone {

    public static void main(String[] args) {
        ContactController contacts = new ContactController();
        LostCallsController lostCalls = new LostCallsController();

        contacts.insertNewContact("123", new ContactInfo("Carlos", "Souza"));
        contacts.insertNewContact("456", new ContactInfo("Jose", "Rodes"));
        lostCalls.registerLostCall("123");
        lostCalls.registerLostCall("456");
        lostCalls.registerLostCall("789");

        Scanner sc = new Scanner(System.in);

        int input = 0;
        do {
            System.out.println("Por gentileza, escolha uma das opções a seguir:");
            System.out.println("1 - Cadastrar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Cadastrar chamada não atendida");
            System.out.println("4 - Mostrar lista de chamadas não atendidas");
            System.out.println("5 - Excluir chamadas não atendidas");
            System.out.println("6 - Sair");

            try {
                input = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro, tente novamente");
                sc.nextLine(); //Sem isso o Scanner fica travado
            }

            switch (input) {
                case 1:
                    registerContact(contacts);
                    break;
                case 2:
                    System.out.println("Qual contato você deseja remover?");
                    contacts.deleteContact(sc.next());
                    break;
                case 3:
                    System.out.println("Digite o número da chamada");
                    lostCalls.registerLostCall(registerNumber());
                    break;
                case 4:
                    System.out.println("Lista de chamadas perdidas:");
                    printLostCalls(lostCalls, contacts);
                    break;
                case 5:
                    System.out.println(lostCalls.deleteCalls() ? "Chamadas deletadas" : "Nenhuma chamada para deletar");
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
            }

        } while (input != 6);
    }

    private static void registerContact(ContactController contact) {
        Scanner sc = new Scanner(System.in);
        String number = "";
        String firstName = "";
        String secondName = "";
        String aux = "";

        System.out.println("Qual o número do contato?");
        number = registerNumber();

        System.out.println("Qual o nome do contato?");
        firstName = sc.next();
        System.out.println("Qual o sobrenome do contato?");
        secondName = sc.next();

        if (!contact.insertNewContact(number, new ContactInfo(firstName, secondName))) {
            System.out.println("Já existe um contato com este número, deseja substituí-lo? S/N");
            aux = "";
            while (!aux.equalsIgnoreCase("S") && !aux.equalsIgnoreCase("N")) {
                aux = sc.next();
                if (!aux.equalsIgnoreCase("S") && !aux.equalsIgnoreCase("N")) {
                    System.out.println("Por gentileza, responda com S ou N");
                }
            }
            if (aux.equalsIgnoreCase("S")) {
                contact.replaceContact(number, new ContactInfo(firstName, secondName));
            }

        }
    }

    private static String registerNumber() {
        Scanner sc = new Scanner(System.in);
        String number = "";
        while (true) {
            try {
                number = sc.next();
                Integer.parseInt(number);
                return number;
            } catch (Exception e) {
                System.out.println("Por gentileza, insira um número válido");
                sc.nextLine(); //Sem isso o Scanner fica travado
            }
        }
    }

    private static void printLostCalls(LostCallsController lostCalls, ContactController contacts) {
        int i = 1;
        for (String call : lostCalls.getLostCalls()) {
            ContactInfo info = contacts.getContact(call);
            System.out.printf("%d - ", i++);
            if (info != null) {
                System.out.println(info.toString());
            } else {
                System.out.println(call);
            }

        }
    }

}
