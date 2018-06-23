package com.projetoOO.projetoOO.Input;

import com.projetoOO.projetoOO.projModel.Eventos;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

public class EventInput {

    private Long id;

    private String nome_evento;
    private String usua_id;
    private Date dt_evento;
    private Date dt_iinscr;
    private Date dt_finscr;

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

    public String getUsua_Id() {
        return usua_id;
    }

    public void setUsua_Id(String Usua_id) {
        this.usua_id = usua_id;
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

