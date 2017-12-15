/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.inventorymodels;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ekaranja
 */
@Entity
@Table(name = "user_profiles")
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String profileCode;
    private String profileName;

    @Column(name = "inventory_Access")
    @Enumerated(EnumType.STRING)
    private YesNo inventoryAccess;

    @Column(name = "studentmanagement_Access")
    @Enumerated(EnumType.STRING)
    private YesNo studentManagementAccess;

    @Column(name = "feesmanagement_Access")
    @Enumerated(EnumType.STRING)
    private YesNo feesManagementAccess;

    @Column(name = "gamesandsports_Access")
    @Enumerated(EnumType.STRING)
    private YesNo gamesAndSportsAccess;

    @Column(name = "admin_Access")
    @Enumerated(EnumType.STRING)
    private YesNo adminAccess;

    public YesNo getAdminAccess() {
        return adminAccess;
    }

    public void setAdminAccess(YesNo adminAccess) {
        this.adminAccess = adminAccess;
    }
    

    public String getProfileCode() {
        return profileCode;
    }

    public void setProfileCode(String profileCode) {
        this.profileCode = profileCode;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public YesNo getInventoryAccess() {
        return inventoryAccess;
    }

    public void setInventoryAccess(YesNo inventoryAccess) {
        this.inventoryAccess = inventoryAccess;
    }

    public YesNo getStudentManagementAccess() {
        return studentManagementAccess;
    }

    public void setStudentManagementAccess(YesNo studentManagementAccess) {
        this.studentManagementAccess = studentManagementAccess;
    }

    public YesNo getFeesManagementAccess() {
        return feesManagementAccess;
    }

    public void setFeesManagementAccess(YesNo feesManagementAccess) {
        this.feesManagementAccess = feesManagementAccess;
    }

    public YesNo getGamesAndSportsAccess() {
        return gamesAndSportsAccess;
    }

    public void setGamesAndSportsAccess(YesNo gamesAndSportsAccess) {
        this.gamesAndSportsAccess = gamesAndSportsAccess;
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
        if (!(object instanceof UserProfile)) {
            return false;
        }
        UserProfile other = (UserProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sms.inventorymodels.UserProfile[ id=" + id + " ]";
    }

}
