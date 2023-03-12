/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

/**
 *
 * @author santi
 */
public class EmisorCorreo {
     private String _correo;
    private String _host;
    private String _password;
    private int _port;
    private boolean _ssl;

    public String getCorreo() {
        return _correo;
    }

    public void setCorreo(String _correo) {
        this._correo = _correo;
    }

    public String getHost() {
        return _host;
    }

    public void setHost(String _host) {
        this._host = _host;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public int getPort() {
        return _port;
    }

    public void setPort(int _port) {
        this._port = _port;
    }

    public boolean isSsl() {
        return _ssl;
    }

    public void setSsl(boolean _ssl) {
        this._ssl = _ssl;
    }
}
