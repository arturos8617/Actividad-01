package src;

public class Paquete {
    private int id;
    private String origen;
    private String destino;
    private String peso;

    public String toString() {
        return "Id: " + this.id + " Origen: " + this.origen + " Destino: " + this.destino + " Peso: "
                + this.peso;
    }

    public Paquete() {

    }

    public Paquete(int id, String origen, String destino, String peso) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}