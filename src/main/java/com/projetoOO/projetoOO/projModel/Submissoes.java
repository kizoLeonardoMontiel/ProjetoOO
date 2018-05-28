package com.projetoOO.projetoOO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Submissoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome_art;
	
	@Column(nullable = false)
    private String resumo;
	
	@Column(nullable = false)
    private Date data_sub;
	
	@Column(nullable = false)
    private String password;
	
    
    @ManyToMany
    @JoinTable(name="user",
            joinColumns = @JoinColumn(name = "Submissoes_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
            )
    private List<Submissoes> submissoes;

    public List<Submissoes> getSubmissoes() {
        return submissoes;
    }

    public void setSubmissoes(List<Submissoes> submissoes) {
        this.submissoes = submissoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_art() {
        return nome_art;
    }

    public void setNome_art(String nome_art) {
        this.nome_art = nome_art;
    }
	
	public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    
	public void setPassword(String password) {
        this.password = password;
    }

	public void setData_sub(Date data_sub) {
        this.data_sub = data_sub;
    }	
}
