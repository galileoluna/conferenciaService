package com.galileo.conferenciaservice.model;

public class Conferencia {

    public Integer Id_evento;
    public String Nombre;
    public String Descripcion;
    public String HoraDeInicio;
    public String HoraDeFinalizacion;


    public Conferencia(){

    }

    public Conferencia(Integer id_evento, String Nombre, String descripcion, String HoraDeInicio, String HoraDeFinalizacion){
        this.Id_evento= id_evento;
        this.Nombre=Nombre;
        this.Descripcion=descripcion;
        this.HoraDeInicio=HoraDeInicio;
        this.HoraDeFinalizacion=HoraDeFinalizacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getHoraDeInicio() {
        return HoraDeInicio;
    }

    public void setHoraDeInicio(String horaDeInicio) {
        HoraDeInicio = horaDeInicio;
    }

    public String getHoraDeFinalizacion() {
        return HoraDeFinalizacion;
    }

    public void setHoraDeFinalizacion(String horaDeFinalizacion) {
        HoraDeFinalizacion = horaDeFinalizacion;
    }

    public Integer getId_evento() {
        return Id_evento;
    }

    public void setId_evento(Integer id_evento) {
        Id_evento = id_evento;
    }

    @Override
    public String toString() {
        return "Conferencia{" +
                "Id_evento=" + Id_evento +
                ", Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", HoraDeInicio='" + HoraDeInicio + '\'' +
                ", HoraDeFinalizacion='" + HoraDeFinalizacion + '\'' +
                '}';
    }
}
