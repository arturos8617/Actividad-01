package src;

import java.util.LinkedList;

public class Paqueteria {

    private LinkedList<Paquete> paqueteria;
    public int size;

    public Paqueteria() {
        this.paqueteria = new LinkedList<Paquete>();
        this.size = paqueteria.size();
    }

    public void addPaquete(String origen, String destino, String peso) {
        Paquete paq = new Paquete(this.size + 1, origen, destino, peso);
        this.size++;
        this.paqueteria.add(paq);
    }

    public void addPaquete(int id, String origen, String destino, String peso) {
        Paquete paq = new Paquete(id, origen, destino, peso);
        this.size++;
        this.paqueteria.add(paq);
    }

    public void deletePaquete() {
        this.paqueteria.removeFirst();
        this.size--;
    }

    public String[] show() {
        String allPack[] = new String[10];
        this.paqueteria.forEach((p) -> {
            System.out.println(p);
            allPack[p.getId() - 1] = p.getId() + "|" + p.getOrigen() + "|" + p.getDestino() + "|" + p.getPeso() + "*";
        });
        return allPack;
    }

    public String[] save() {
        String allPack[] = new String[10];
        this.paqueteria.forEach((p) -> {
            allPack[p.getId() - 1] = p.getId() + "|" + p.getOrigen() + "|" + p.getDestino() + "|" + p.getPeso() + "*";
        });
        return allPack;
    }

}
