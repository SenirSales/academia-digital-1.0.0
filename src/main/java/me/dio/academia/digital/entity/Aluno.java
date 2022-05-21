package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data                 // Get e Set
@NoArgsConstructor    // construtor vasio
@AllArgsConstructor   // sonstrutor todos os atributos
@Entity               // Resposavel por criar nossas tabelas, obs: com esta anotacoes requer um ID
@Table(name = "tb_alunos")   //  da nome a tabela
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})   // excption ignorados do json
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Column(unique = true)
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)    // Anotaceos de relacionamento  - LAZY = so carrega o relacionamento se chama o medado abaixo
  @JsonIgnore   // excption ignorados do json
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
