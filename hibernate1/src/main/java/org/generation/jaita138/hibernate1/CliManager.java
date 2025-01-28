package org.generation.jaita138.hibernate1;

import java.util.Optional;
import java.util.Scanner;

import org.generation.jaita138.hibernate1.Repo.UtenteRepository;
import org.generation.jaita138.hibernate1.entity.Utente;

public class CliManager {

    private final UtenteRepository utenteRepository;

    public CliManager(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public void printOptions() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nScegli un'opzione:");
            System.out.println("1. Stampa tutti gli utenti");
            System.out.println("2. Inserisci un nuovo utente");
            System.out.println("3. Modifica un utente esistente");
            System.out.println("4. Elimina un utente");
            System.out.println("5. Esci");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consuma la newline

            switch (choice) {
                case 1:
                    printAllUsers();
                    break;
                case 2:
                    addUser(scanner);
                    break;
                case 3:
                    updateUser(scanner);
                    break;
                case 4:
                    deleteUser(scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    private void printAllUsers() {
        System.out.println("\nUtenti presenti:");
        utenteRepository.findAll().forEach(System.out::println);
    }

    private void addUser(Scanner scanner) {
        System.out.println("\nInserisci i dettagli del nuovo utente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cognome: ");
        String cognome = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Credito (in centesimi): ");
        int credito = scanner.nextInt();
        scanner.nextLine(); // Consuma la newline

        Utente newUser = new Utente(nome, cognome, username, password, credito);
        utenteRepository.save(newUser);
        System.out.println("Utente aggiunto con successo.");
    }

    private void updateUser(Scanner scanner) {
        System.out.print("\nInserisci l'ID dell'utente da modificare: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consuma la newline

        Optional<Utente> optionalUtente = utenteRepository.findById(id);
        if (optionalUtente.isPresent()) {
            Utente utente = optionalUtente.get();
            System.out.println("Utente trovato: " + utente);

            System.out.print("Nuovo nome (lascia vuoto per mantenere il valore attuale): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) utente.setNome(nome);

            System.out.print("Nuovo cognome (lascia vuoto per mantenere il valore attuale): ");
            String cognome = scanner.nextLine();
            if (!cognome.isEmpty()) utente.setCognome(cognome);

            System.out.print("Nuovo username (lascia vuoto per mantenere il valore attuale): ");
            String username = scanner.nextLine();
            if (!username.isEmpty()) utente.setUsername(username);

            System.out.print("Nuova password (lascia vuoto per mantenere il valore attuale): ");
            String password = scanner.nextLine();
            if (!password.isEmpty()) utente.setPassword(password);

            System.out.print("Nuovo credito (in centesimi, lascia vuoto per mantenere il valore attuale): ");
            String creditoInput = scanner.nextLine();
            if (!creditoInput.isEmpty()) utente.setCredito(Integer.parseInt(creditoInput));

            utenteRepository.save(utente);
            System.out.println("Utente aggiornato con successo.");
        } else {
            System.out.println("Utente con ID " + id + " non trovato.");
        }
    }

    private void deleteUser(Scanner scanner) {
        System.out.print("\nInserisci l'ID dell'utente da eliminare: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consuma la newline

        if (utenteRepository.existsById(id)) {
            utenteRepository.deleteById(id);
            System.out.println("Utente eliminato con successo.");
        } else {
            System.out.println("Utente con ID " + id + " non trovato.");
        }
    }
}
