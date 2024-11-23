import java.util.Scanner;

public class ReservaDeVuelos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombre, cedula, origen, destino, fechaNacimiento, fechaEmision, rutaAsignada = "";
        int tipoBoleto, opcionCancelacion, numeroBoleto = 123456;
        double precioBoleto = 0, precioFinal = 0, pesoTotalMaletas = 0, pesoMaleta1 = 0, pesoMaleta2 = 0;
        int cantidadMaletas = 0;
        final int maxCantidadMaletas = 2;
        final double maxPesoEquipaje = 32.0;
        int asientosDisponiblesPrimera = 15, asientosDisponiblesEjecutiva = 30, asientosDisponiblesEconomica = 100;
        final double tiempoMaximoCancelacion = 24.0;

        System.out.println("Ingrese la fecha de emisión del boleto (DD/MM/AAAA):");
        fechaEmision = sc.nextLine();

        System.out.println("Ingrese su Nombre Completo:");
        nombre = sc.nextLine();
        System.out.println("Ingrese su Cédula:");
        cedula = sc.nextLine();
        System.out.println("Ingrese su Fecha de Nacimiento (DD/MM/AAAA):");
        fechaNacimiento = sc.nextLine();
        System.out.println("Ingrese el lugar de origen:");
        origen = sc.nextLine();
        System.out.println("Ingrese el destino:");
        destino = sc.nextLine();

        do {
            System.out.println("¿Qué tipo de boleto desea?");
            System.out.println("(1) Primera Clase - $900 - Asientos Disponibles: " + asientosDisponiblesPrimera);
            System.out.println("(2) Clase Ejecutiva - $700 - Asientos Disponibles: " + asientosDisponiblesEjecutiva);
            System.out.println("(3) Clase Económica - $500 - Asientos Disponibles: " + asientosDisponiblesEconomica);
            tipoBoleto = sc.nextInt();

            if (tipoBoleto == 1) {
                precioBoleto = 900;
                rutaAsignada = "Ruta N1 (Primera Clase)";
                if (asientosDisponiblesPrimera > 0) {
                    asientosDisponiblesPrimera--;
                    System.out.println("Asientos restantes en Primera Clase: " + asientosDisponiblesPrimera);
                } else {
                    System.out.println("No hay asientos disponibles en Primera Clase");
                }
            } else if (tipoBoleto == 2) {
                precioBoleto = 700;
                rutaAsignada = "Ruta N2 (Clase Ejecutiva)";
                if (asientosDisponiblesEjecutiva > 0) {
                    asientosDisponiblesEjecutiva--;
                    System.out.println("Asientos restantes en Clase Ejecutiva: " + asientosDisponiblesEjecutiva);
                } else {
                    System.out.println("No hay asientos disponibles en Clase Ejecutiva");
                }
            } else if (tipoBoleto == 3) {
                precioBoleto = 500;
                rutaAsignada = "Ruta N3 (Clase Económica)";
                if (asientosDisponiblesEconomica > 0) {
                    asientosDisponiblesEconomica--;
                    System.out.println("Asientos restantes en Clase Económica: " + asientosDisponiblesEconomica);
                } else {
                    System.out.println("No hay asientos disponibles en Clase Económica");
                }
            } else {
                System.out.println("El número ingresado no es válido. Intente de nuevo.");
            }
        } while (tipoBoleto != 1 && tipoBoleto != 2 && tipoBoleto != 3);

        do {
            System.out.println("Ingrese la cantidad de maletas (máximo " + maxCantidadMaletas + "):");
            cantidadMaletas = sc.nextInt();
            if (cantidadMaletas <= maxCantidadMaletas) {
                System.out.println("Ingrese el peso de cada maleta (peso total máximo: " + maxPesoEquipaje + " kg)");
                System.out.println("Peso de la primera maleta:");
                pesoMaleta1 = sc.nextDouble();
                if (cantidadMaletas == 2) {
                    System.out.println("Peso de la segunda maleta:");
                    pesoMaleta2 = sc.nextDouble();
                }

                pesoTotalMaletas = (cantidadMaletas == 1) ? pesoMaleta1 : (pesoMaleta1 + pesoMaleta2);

                if (pesoTotalMaletas <= maxPesoEquipaje) {
                    System.out.println(pesoTotalMaletas + " kg es un peso válido.");
                } else {
                    System.out.println(pesoTotalMaletas + " kg excede el límite de peso. Reduzca el peso de las maletas.");
                }
            } else {
                System.out.println("La cantidad de maletas excede el límite permitido.");
            }
        } while (cantidadMaletas > maxCantidadMaletas || pesoTotalMaletas > maxPesoEquipaje);

        do {
            System.out.println("¿Desea cancelar su reserva? (1 para Sí, 0 para No)");
            opcionCancelacion = sc.nextInt();

            if (opcionCancelacion == 1) {
                System.out.println("Ingrese las horas restantes para su vuelo:");
                double horasAntesCancelacion = sc.nextDouble();

                if (horasAntesCancelacion >= tiempoMaximoCancelacion) {
                    System.out.println("Cancelación permitida sin costo adicional.");
                    precioFinal = precioBoleto;
                } else {
                    precioFinal = precioBoleto * 0.80;
                    System.out.println("Cancelación fuera del tiempo permitido. Multa aplicada: $" + (precioBoleto - precioFinal));
                }
            } else if (opcionCancelacion == 0) {
                precioFinal = precioBoleto;
                System.out.println("No se aplicará multa.");
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionCancelacion != 1 && opcionCancelacion != 0);

        System.out.println("===========================");
        System.out.println("       BOLETO EMITIDO      ");
        System.out.println("===========================");
        System.out.println("Número de Boleto: " + numeroBoleto);
        System.out.println("Fecha de Emisión: " + fechaEmision);
        System.out.println("Nombre del Pasajero: " + nombre);
        System.out.println("Cédula: " + cedula);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Origen: " + origen + " - Destino: " + destino);
        System.out.println("Tipo de Boleto: " + tipoBoleto);
        System.out.println("Precio del Boleto: $" + precioBoleto);
        System.out.println("Precio Final (con multa si aplica): $" + precioFinal);
        System.out.println("Ruta Asignada: " + rutaAsignada);
        System.out.println("Cantidad de Maletas: " + cantidadMaletas);
        System.out.println("Peso Total del Equipaje: " + pesoTotalMaletas + " kg");
        System.out.println("===========================");
        System.out.println("Gracias por su preferencia. ¡Buen viaje!");
        
    }
}
