package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        File backup = new File("backup.txt");
        try {
            backup.createNewFile();
        } catch (IOException e) {
            System.out.println("An error Ocurred");
            e.printStackTrace();
        }
        Paqueteria paquetero = new Paqueteria();
        Scanner myInput = new Scanner(System.in);
        Scanner maininput = new Scanner(System.in);
        char mained = '1';
        while (mained != '0') {
            System.out.println("1.-Agregar paquete");
            System.out.println("2.-Eliminar paquete");
            System.out.println("3.-Mostrar todos los paquetes");
            System.out.println("4.-Guardar paquetes");
            System.out.println("5.-Recuperar paquetes");
            System.out.println("Elige la opcion: ");
            mained = maininput.nextLine().charAt(0);
            if (mained == '1') {
                System.out.println("¿Cual es el origen?");
                String origen = myInput.nextLine();
                System.out.println("¿Cual es el destino?");
                String destino = myInput.nextLine();
                System.out.println("¿Cual es el peso?");
                String peso = myInput.nextLine();
                paquetero.addPaquete(origen, destino, peso);
            } else if (mained == '2') {
                if (paquetero.size == 0) {
                    continue;
                }
                paquetero.deletePaquete();

            } else if (mained == '3') {
                System.out.println(paquetero.size);
                paquetero.show();
            } else if (mained == '4') {
                FileWriter writer;
                try {
                    writer = new FileWriter("backup.txt");
                    int cont = 0;
                    while (cont < paquetero.size) {
                        writer.write(paquetero.save()[cont]);
                        cont++;
                    }
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (mained == '5') {
                try {
                    BufferedReader br = new BufferedReader(new FileReader("backup.txt"));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    try {
                        line = br.readLine();
                        while (line != null) {
                            sb.append(line);
                            sb.append(System.lineSeparator());
                            line = br.readLine();
                        }
                        String everything = sb.toString();

                        int cont = 0;
                        String[] row = new String[everything.split("\\*").length];
                        while (cont < row.length - 1) {
                            row[cont] = everything.split("\\*")[cont].replaceFirst("\\*", "");
                            paquetero.addPaquete(Integer.parseInt(row[cont].split("\\|")[0]),
                                    row[cont].split("\\|")[1],
                                    row[cont].split("\\|")[2],
                                    row[cont].split("\\|")[3]);
                            cont++;
                        }
                    } finally {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
        myInput.close();
        maininput.close();
    }

}
