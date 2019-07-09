package br.org.fiergs.civilstatus.services;

import br.org.fiergs.civilstatus.entities.CivilStatus;
import br.org.fiergs.civilstatus.repositories.CivilStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CivilStatusService {

    @Autowired
    private CivilStatusRepository civilStatusRepository;

    public List<CivilStatus> list(){
        return civilStatusRepository.findAll();
    }

    public Optional<CivilStatus> findByName(String name){
        Optional<CivilStatus> civilStatusExists = civilStatusRepository.findByNameContainingIgnoreCase(name);
        if(civilStatusExists.isPresent() && civilStatusExists != null) {
            return civilStatusRepository.findByNameContainingIgnoreCase(name);
        }else{
            throw new RuntimeException("Nenhum estado civil encontrado");
        }
    }

    public CivilStatus save(CivilStatus civilStatus) {
        Optional<CivilStatus> civilStatus1Exists = civilStatusRepository.findByNameContainingIgnoreCase(civilStatus.getName());
        if(civilStatus1Exists.isPresent()){
            throw new RuntimeException("Estado civil já está cadastrado");
        }

        return this.civilStatusRepository.save(civilStatus);
    }

    public CivilStatus edit(CivilStatus civilStatus) {
        Optional<CivilStatus> optionalCivilStatus = civilStatusRepository.findByNameContainingIgnoreCaseAndIdIsNot(civilStatus.getName(), civilStatus.getId());

        if(optionalCivilStatus.isEmpty()){
            civilStatusRepository.save(civilStatus);
        }else {
            throw new RuntimeException("Estado civil já está cadastrado");
        }
        return civilStatus;
    }

    public void delete(Long id) {
        this.civilStatusRepository.deleteById(id);
    }
}
