package br.org.fiergs.civilstatus.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAD_CIVILSTATUS")
@SequenceGenerator(name = "seqCad_civilstatus", sequenceName = "SEQCAD_CIVILSTATUS", allocationSize = 1)
public class CivilStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCad_civilstatus")
    private Long id;

    @NotEmpty(message = "Nome é obrigatório")
    private String name;

    @NotNull(message = "Identificador é obrigatório")
    private Long identifier;

    private boolean status;
}
