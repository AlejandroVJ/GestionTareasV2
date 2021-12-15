package com.mycompany.gestorpracticasprueba;

import models.Actividad;
import models.Alumno;

/**
 *
 * @author AlejandroVicenteJarn
 */
public class SessionData {
    private static Alumno alumnoActual;
    private static Actividad actividadActual;

    public static Alumno getAlumnoActual() {
        return alumnoActual;
    }

    public static void setAlumnoActual(Alumno alumno_actual) {
        SessionData.alumnoActual = alumno_actual;
    }    

    public static Actividad getActividadActual() {
        return actividadActual;
    }

    public static void setActividadActual(Actividad actividadActual) {
        SessionData.actividadActual = actividadActual;
    }
}
