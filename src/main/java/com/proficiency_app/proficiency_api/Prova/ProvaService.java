package com.proficiency_app.proficiency_api.Prova;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvaService {
    @Autowired
    private ProvaRepository provaRepository;

    public ProvaService(
        ProvaRepository provaRepository
    ) {
        this.provaRepository = provaRepository;
    }

    public Optional<Prova> findById(String id) throws Exception {
        Optional<Prova> prova = provaRepository.findById(id);

        if(prova.isEmpty()) {
            throw new Exception("Data not found");
        }

        return prova;
    }

    public List<Prova> findAll() throws Exception {
        List<Prova> provas = provaRepository.findAll();

        if(provas.isEmpty()) {
            throw new Exception("Data not found");
        }

        return provas;
    }

    public List<Prova> findByProfessorId(String professor_id) {
        return provaRepository.findByProfessorId(professor_id);
    }

    /*
    public List<Prova> findByQuestaoId(String questao_id) {
        return provaRepository.findByQuestaoId(questao_id);
    }
    */

    public List<Prova> saveAll(List<Prova> provas) {
        return provaRepository.saveAll(provas);
    }

    public Prova save(Prova prova) {
        return provaRepository.save(prova);
    }
}
