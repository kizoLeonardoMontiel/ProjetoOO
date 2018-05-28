package com.projetoOO.projetoOO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    
    @ManyToMany
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name = "eventos_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
