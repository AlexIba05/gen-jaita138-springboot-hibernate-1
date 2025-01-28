package service;

import java.util.List;
import java.util.Optional;

import org.generation.jaita138.hibernate1.Repo.UtenteRepository;
import org.generation.jaita138.hibernate1.entity.Utente;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }

    public Utente save(Utente utente) {
        return utenteRepository.save(utente);
    }

    public void deleteById(Long id) {
        if (utenteRepository.existsById(id)) {
            utenteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Utente con ID " + id + " non trovato.");
        }
    }

    // Trova un utente a partire dall'ID
    public Optional<Utente> findById(Long id) {
        return utenteRepository.findById(id);
    }
}