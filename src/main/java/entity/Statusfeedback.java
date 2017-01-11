/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "statusfeedback")
@NamedQueries({
    @NamedQuery(name = "Statusfeedback.findAll", query = "SELECT s FROM Statusfeedback s")})
public class Statusfeedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StatusFeedbackId")
    private Integer statusFeedbackId;
    @Column(name = "status")
    private String status;
    @OneToMany( cascade =  CascadeType.MERGE   ,mappedBy = "statusFeedbackId")
      @LazyCollection(LazyCollectionOption.FALSE)
    private List<Feedback> feedbackList;

    public Statusfeedback() {
    }

    public Statusfeedback(Integer statusFeedbackId) {
        this.statusFeedbackId = statusFeedbackId;
    }

    public Integer getStatusFeedbackId() {
        return statusFeedbackId;
    }

    public void setStatusFeedbackId(Integer statusFeedbackId) {
        this.statusFeedbackId = statusFeedbackId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusFeedbackId != null ? statusFeedbackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statusfeedback)) {
            return false;
        }
        Statusfeedback other = (Statusfeedback) object;
        if ((this.statusFeedbackId == null && other.statusFeedbackId != null) || (this.statusFeedbackId != null && !this.statusFeedbackId.equals(other.statusFeedbackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Statusfeedback[ statusFeedbackId=" + statusFeedbackId + " ]";
    }
    
}
