package br.org.fiergs.civilstatus.controllers;

import br.org.fiergs.civilstatus.entities.CivilStatus;
import br.org.fiergs.civilstatus.services.CivilStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/civil-status")
public class CivilStatusController {

    @Autowired
    private CivilStatusService civilStatusService;

    @GetMapping
    public List<CivilStatus> list(){
        return civilStatusService.list();
    }

    @GetMapping("/{name}")
    public Optional<CivilStatus> listByName(@PathVariable("name")  String name){
        return civilStatusService.findByName(name);
    }

    @PostMapping
    public CivilStatus save(@Valid CivilStatus civilStatus){
        return civilStatusService.save(civilStatus);
    }

    @PutMapping
    public CivilStatus edit(@RequestBody @Valid CivilStatus civilStatus){
        return civilStatusService.edit(civilStatus);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        civilStatusService.delete(id);
    }
}
