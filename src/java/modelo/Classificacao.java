/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author aluno
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Classificacao.findAll", query = "SELECT c FROM Classificacao c"),
    @NamedQuery(name = "Classificacao.findFilter", query = "SELECT c FROM Classificacao c WHERE c.clas like :filtro")
})
public class Classificacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String clas;
    private String endFoto;

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getEndFoto() {
        return endFoto;
    }

    public void setEndFoto(String endFoto) {
        this.endFoto = endFoto;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classificacao)) {
            return false;
        }
        Classificacao other = (Classificacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Classificacao[ id=" + id + " ]";
    }
    
}
