/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

/**
 *
 * @author santi
 */
public class Correo {
    private String _emisor, _receptor, _asunto, _cuerpo;

    public Correo() {
    }

    public Correo(String _emisor, String _receptor, String _asunto, String _cuerpo) {
        this._emisor = _emisor;
        this._receptor = _receptor;
        this._asunto = _asunto;
        this._cuerpo = _cuerpo;
    }

    public String getEmisor() {
        return _emisor;
    }

    public void setEmisor(String _emisor) {
        this._emisor = _emisor;
    }

    public String getReceptor() {
        return _receptor;
    }

    public void setReceptor(String _receptor) {
        this._receptor = _receptor;
    }

    public String getAsunto() {
        return _asunto;
    }

    public void setAsunto(String _asunto) {
        this._asunto = _asunto;
    }
    
    public String getCuerpo() {
        return _cuerpo;
    }

    public void setCuerpo(String _cuerpo) {
        this._cuerpo = _cuerpo;
    }
}
