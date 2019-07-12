package br.org.fiergs.civilstatus.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CCOR_CIVILSTATUS")
@SequenceGenerator(name = "seqCCor_civilstatus", sequenceName = "SEQCCOR_CIVILSTATUS", allocationSize = 1)
public class CivilStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCCor_civilstatus")
    private Long id;

    @NotEmpty(message = "Nome é obrigatório")
    @Max(value = 30, message = "O nome deve conter no máximo 30 caracteres!")
    private String name;

    @Max(value = 30, message = "A chave deve conter no máximo 30 caracteres!")
    private String key;

    private boolean status;
}
