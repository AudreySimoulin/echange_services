/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.entity;

import echangeservices.enumeration.TypeUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    private String mdp;

    @Enumerated(EnumType.STRING)
    private TypeUtil typeUtil;

    private Integer solde;

    @OneToMany(mappedBy = "postePar")
    private List<Annonce> annonces;

    @OneToMany(mappedBy = "postePar")
    private List<Commentaire> commentaires;

    @ManyToOne
    @JoinColumn(name = "Lieu_ID")
    private Lieu lieu;

    @OneToMany(mappedBy = "destinataire")
    private List<Message> messagesRecus;

    @OneToMany(mappedBy = "emetteur")
    private List<Message> messagesEnvoyes;

    @OneToMany(mappedBy = "destinataire")
    private List<Paiement> paiementsRecus;

    @OneToMany(mappedBy = "emetteur")
    private List<Paiement> paiementsEmis;

    public List<Paiement> getPaiementsRecus() {
        return paiementsRecus;
    }

    public void setPaiementsRecus(List<Paiement> paiementsRecus) {
        this.paiementsRecus = paiementsRecus;
    }

    public List<Paiement> getPaiementsEmis() {
        return paiementsEmis;
    }

    public void setPaiementsEmis(List<Paiement> paiementsEmis) {
        this.paiementsEmis = paiementsEmis;
    }

    public List<Message> getMessagesRecus() {
        return messagesRecus;
    }

    public void setMessagesRecus(List<Message> messagesRecus) {
        this.messagesRecus = messagesRecus;
    }

    public List<Message> getMessagesEnvoyes() {
        return messagesEnvoyes;
    }

    public void setMessagesEnvoyes(List<Message> messagesEnvoyes) {
        this.messagesEnvoyes = messagesEnvoyes;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public TypeUtil getTypeUtil() {
        return typeUtil;
    }

    public void setTypeUtil(TypeUtil typeUtil) {
        this.typeUtil = typeUtil;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur() {
    }

    public Utilisateur(Long id, String email, String mdp, TypeUtil typeUtil, Integer solde, Lieu lieu) {
        this.id = id;
        this.email = email;
        this.mdp = mdp;
        this.typeUtil = typeUtil;
        this.solde = solde;
        this.lieu = lieu;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "echangeservices.entity.Utilisateur[ id=" + id + " ]";
    }

}
