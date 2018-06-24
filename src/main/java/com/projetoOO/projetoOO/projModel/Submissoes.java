package com.projetoOO.projetoOO.projModel;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Submissoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long even_id;

    @Column(nullable = false)
    private Long usua_id;

    @Column(nullable = false)
    private String nome_art;

    @Column(nullable = false)
    private String resumo_art;
	
    @Column(nullable = false)
    private Date dt_submissao;
	
    @Column(nullable = false)
    private String anexo_art;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEven_Id() {
        return even_id;
    }

    public void setEven_Id(Long id) {
        this.even_id = id;
    }

    public Long getUsua_Id() {
        return usua_id;
    }

    public void setUsua_Id(Long id) {
        this.usua_id = id;
    }

    public String getNome_Art() {
        return nome_art;
    }

    public void setNome_Art(String nomeArt) {
        this.nome_art = nomeArt;
    }

    public String getResumo_Art() {
        return resumo_art;
    }

    public void setResumo_Art(String resumoArt) {
        this.resumo_art = resumoArt;
    }

    public Date getDt_Submissao() {
        return dt_submissao;
    }

    public void setDt_Submissao(Date dtSubmissao) {
        this.dt_submissao = dtSubmissao;
    }

    public String getAnexo_Art() {
        return anexo_art;
    }

    public void setAnexo_Art(String anexoArt) {
        this.anexo_art = anexoArt;
    }

}
