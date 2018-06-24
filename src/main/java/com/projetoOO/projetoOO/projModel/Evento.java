package com.projetoOO.projetoOO.projModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nevento", nullable = false)
    private String nevento;

    @Column(name = "usuaid", nullable = false)
    private String usuaid;

    @Column(name = "dtevento", nullable = false)
    private String dtevento;

    @Column(name = "dtiinscr", nullable = false)
    private String dtiinscr;

    @Column(name = "dtfinscr", nullable = false)
    private String dtfinscr;

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
