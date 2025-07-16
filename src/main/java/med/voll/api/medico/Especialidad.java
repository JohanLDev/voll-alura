package med.voll.api.medico;

import java.util.EnumSet;

public enum Especialidad {
    ORTOPEDIA("ortopedia"),
    CARDIOLOGIA("cargiologia"),
    GINECOLOGIA("ginecologia"),
    DERMATOLOGIA("dermatologia");

    private String especialidad;

    Especialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return  especialidad;
    }


}
