package Modelo;

public class ModeloNovedad {
    private String documento,temperatura,enfermedades,conviveme,ultimositio,cedulafunc;

    public ModeloNovedad(String documento, String temperatura, String enfermedades, String conviveme, String ultimositio, String cedulafunc) {
        this.documento = documento;
        this.temperatura = temperatura;
        this.enfermedades = enfermedades;
        this.conviveme = conviveme;
        this.ultimositio = ultimositio;
        this.cedulafunc = cedulafunc;
    }

    public ModeloNovedad() {
    }

    public String getCedulafunc() {
        return cedulafunc;
    }

    public void setCedulafunc(String cedulafunc) {
        this.cedulafunc = cedulafunc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getConviveme() {
        return conviveme;
    }

    public void setConviveme(String conviveme) {
        this.conviveme = conviveme;
    }

    public String getUltimositio() {
        return ultimositio;
    }

    public void setUltimositio(String ultimositio) {
        this.ultimositio = ultimositio;
    }
    
}
