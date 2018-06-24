package com.projetoOO.projetoOO.Input;

import com.projetoOO.projetoOO.projModel.Evento;
import java.util.List;

public class EventInput {

    private Long id;
    private String nevento;
    private String usuaid;
    private String dtevento;
    private String dtiinscr;
    private String dtfinscr;

    private List<Evento> evento;

    public List<Evento> getEventos() {
        return evento;
    }

    public void setEventos(List<Evento> evento) {
        this.evento = evento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNevento() {
        return nevento;
    }

    public void setNevento(String nevento) {
        this.nevento = nevento;
    }

    public String getUsuaId() {
        return usuaid;
    }

    public void setUsuaId(String usuaid) {
        this.usuaid = usuaid;
    }

    public String getDtEvento() {
        return dtevento;
    }

    public void setDtEvento(String dtEvento) { this.dtevento = dtEvento; }

    public String getDtIinscr() {
        return dtiinscr;
    }

    public void setDtIinscr(String dtIinscr) {
        this.dtiinscr = dtIinscr;
    }

    public String getDtFinscr() {
        return dtfinscr;
    }

    public void setDtFinscr(String dtFinscr) {
        this.dtfinscr = dtFinscr;
    }
}

