package br.org.fiergs.civilstatus.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

    @Size(max = 20, message = "Chave deve ser menor que 21 caracteres")
    private String key;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 30, message = "Nome deve ter no maxímo 50 caracteres")
    private String name;

    @NotEmpty(message = "Identificador é obrigatório")
    @Size(max = 11, message = "Código deve ter no maxímo 12 caracteres")
    private String code;

    private boolean active = true;
}
