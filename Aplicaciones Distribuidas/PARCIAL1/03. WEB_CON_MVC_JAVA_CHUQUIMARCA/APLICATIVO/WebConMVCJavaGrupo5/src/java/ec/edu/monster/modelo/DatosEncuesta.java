/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ec.edu.monster.modelo;

import javax.ejb.Stateless;

/**
 *
 * @author santi
 */
@Stateless
public class DatosEncuesta {

    private String txtNombre;
    private String txtApellido;
    private String[] chkProgLeng;
    private String imgProfile;

    public DatosEncuesta() {
    }

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(String txtApellido) {
        this.txtApellido = txtApellido;
    }

    public String[] getChkProgLeng() {
        return chkProgLeng;
    }

    public void setChkProgLeng(String[] chkProgLeng) {
        this.chkProgLeng = chkProgLeng;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(String imgProfile) {
        this.imgProfile = imgProfile;
    }

}
