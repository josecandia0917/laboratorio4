
package com.emergentes;


public class Almacen {
    private int id;
    private String tarea;
    
    public Almacen() {
    }
    public Almacen(int id, String tarea) {
        this.id = id;
        this.tarea = tarea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

}
