package com.projetoOO.projetoOO.projModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Eventos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome_evento;

    @Column(nullable = false)
    private Long usua_id;

    @Column(nullable = false)
    private Date dt_evento;

    @Column(nullable = false)
    private Date dt_iinscr;

    @Column(nullable = false)
    private Date dt_finscr;

    @ManyToMany
    @JoinTable(name="submissoes",
            joinColumns = @JoinColumn(name = "even_id", referencedColumnName = "id")
    )

    private List<Eventos> eventos;

    public List<Eventos> getEventos() {
        return eventos;
    }

    public void setEventos(List<Eventos> eventos) {
        this.eventos = eventos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_Evento() {
        return nome_evento;
    }

    public void setNome_Evento(String nome) {
        this.nome_evento = nome;
    }

    public Long getUsua_Id() {
        return usua_id;
    }

    public void setUsua_Id(Long id) {
        this.usua_id = id;
    }

    public Date getDt_Evento() {
        return dt_evento;
    }

    public void setDt_Evento(Date dtEvento) { this.dt_evento = dtEvento; }

    public Date getDt_Iinscr() {
        return dt_iinscr;
    }

    public void setDt_Iinscr(Date dtIinscr) {
        this.dt_iinscr = dtIinscr;
    }

    public Date getDt_Finscr() {
        return dt_finscr;
    }

    public void setDt_Finscr(Date dtFinscr) {
        this.dt_finscr = dtFinscr;
    }
}
