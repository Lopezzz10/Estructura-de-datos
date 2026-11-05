package serie_numeros;

public class Serie_numeros {

    public static void main(String[] args) {
        Class_Acciones f = new Class_Acciones();
        int opcion;

        do {
            System.out.println("\n<< Menú principal >>");
            System.out.println("1. Serie de números");
            System.out.println("2. Pacientes y temperaturas");
            System.out.println("3. Agenda de contactos");
            System.out.println("4. Salir");
            opcion = f.Valor(0, "Seleccionar la opción");

            switch (opcion) {
                case 1 -> Serie(f);
                case 2 -> Pacientes(f);
                case 3 -> Agenda(f);
                case 4 -> System.out.println("Fin del programa");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }

    public static void Serie(Class_Acciones f) {
        int n = 0, m = 0, p = 0, posicion = 0;
        int opcion1, opcion2;
        n = f.Valor(n, "Ingresar la dimensión del arreglo n");
        m = f.Valor(m, "Ingresar m múltiplo");

        int[] Anumeros = new int[n];  // declarar el arreglo
        f.Inicializar(Anumeros);

        System.out.println("\n<< Nuevos elementos en el arreglo >>");
        System.out.println("1. Por teclado");
        System.out.println("2. Generar serie");
        System.out.println("3. Generar aleatorio");
        opcion1 = f.Valor(0, "Seleccionar la opción");

        switch (opcion1) {
            case 1 -> {    //por teclado
                p = f.NuevoElementoTeclado(Anumeros, m);
            }
            case 2 -> {   //genera la serie
                p = f.IngresaPValido(n, p);
                f.NuevoElementoGenera(Anumeros, m, p);
            }
            case 3 -> {   //genera aleatorio
                p = f.IngresaPValido(n, p);
                f.NuevoElementoAleatorio(Anumeros, m, p);
            }
        }
        f.SalidaPantallaCompleto(Anumeros, "Arreglo resultado, completo");
        f.SalidaPantallaValidos(Anumeros, "Arreglo resultado, válidos", p);
        f.MayorMenorNumero(p, Anumeros);  //mayor y menor

        System.out.println("\n<<Operaciones con el arreglo: >>");
        System.out.println("1. Insertar, después de");
        System.out.println("2. Insertar, antes de");
        System.out.println("3. Eliminar");
        System.out.println("4. Modificar");
        System.out.println("5. Subarreglo");
        opcion2 = f.Valor(0, "Seleccionar la opción");

        if (opcion2 != 5) {
            posicion = f.BuscarElemento(Anumeros, p, posicion);

            if (posicion >= 0) {
                switch (opcion2) {
                    case 1 -> {
                        if (p == n)
                            System.out.println("El arreglo no tiene capacidad para insertar nuevos elementos");
                        else
                            p = f.InsertarElementoDespues(posicion, Anumeros, p);
                    }
                    case 2 -> {
                        if (p == n)
                            System.out.println("El arreglo no tiene capacidad para insertar nuevos elementos");
                        else
                            p = f.InsertarElementoAntes(posicion, Anumeros, p);
                    }
                    case 3 -> {
                        p = f.EliminarElemento(posicion, Anumeros, p);
                    }
                    case 4 -> {
                        f.ModificarElemento(posicion, Anumeros);
                    }
                }
                f.SalidaPantallaCompleto(Anumeros, "Arreglo resultado, completo");
                f.SalidaPantallaValidos(Anumeros, "Arreglo resultado, validos", p);
            }
        } else {
            //subarreglo
            int t = 0;  //t validos del subarreglo
            int[] SAnumeros = new int[n];  // declarar el subarreglo
            f.Inicializar(SAnumeros);
            t = f.SeleccionElementos(Anumeros, SAnumeros, p);
            f.SalidaPantallaCompleto(Anumeros, "Arreglo resultado, completo");
            f.SalidaPantallaValidos(Anumeros, "Arreglo resultado, validos", p);
            f.SalidaPantallaCompleto(SAnumeros, "Subarreglo resultado, completo");
            f.SalidaPantallaValidos(SAnumeros, "Subarreglo resultado, validos", t);
        }
    }

    public static void Pacientes(Class_Acciones f) {
        int n = 0, p = 0, opcion;

        n = f.Valor(n, "Ingresar la dimensión de los arreglos n");
        String[] Anombres = new String[n];
        double[] Atemperaturas = new double[n];

        p = f.IngresaPValido(n, p);
        p = f.IngresarPacientes(Anombres, Atemperaturas, 0, p);

        do {
            System.out.println("\n<< Menú de pacientes >>");
            System.out.println("1. Ver nómina");
            System.out.println("2. Agregar paciente");
            System.out.println("3. Buscar y eliminar");
            System.out.println("4. Buscar y modificar temperatura");
            System.out.println("5. Promedio de temperaturas");
            System.out.println("6. Temperatura más alta y más baja");
            System.out.println("7. Volver");
            opcion = f.Valor(0, "Seleccionar la opción");

            switch (opcion) {
                case 1 -> f.NominaPacientes(Anombres, Atemperaturas, p);
                case 2 -> {
                    if (p == n)
                        System.out.println("El arreglo no tiene capacidad para nuevos pacientes");
                    else
                        p = f.IngresarPacientes(Anombres, Atemperaturas, p, 1);
                }
                case 3 -> {
                    int pos = f.BuscarNombre(Anombres, p);
                    if (pos >= 0) {
                        p = f.EliminarPaciente(Anombres, Atemperaturas, pos, p);
                        f.NominaPacientes(Anombres, Atemperaturas, p);
                    }
                }
                case 4 -> {
                    int pos = f.BuscarNombre(Anombres, p);
                    if (pos >= 0) {
                        f.ModificarTemperatura(Anombres, Atemperaturas, pos);
                        f.NominaPacientes(Anombres, Atemperaturas, p);
                    }
                }
                case 5 -> f.PromedioTemperaturas(Atemperaturas, p);
                case 6 -> f.MayorMenorTemperatura(Anombres, Atemperaturas, p);
                case 7 -> System.out.println("Volviendo al menú principal");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 7);
    }

    public static void Agenda(Class_Acciones f) {
        int n = 0, p = 0, opcion;

        n = f.Valor(n, "Ingresar la dimensión de la agenda n");
        String[] Anombres = new String[n];
        String[] Atelefonos = new String[n];
        int[] Aedades = new int[n];

        do {
            System.out.println("\n<< Menú de agenda de contactos >>");
            System.out.println("1. Nuevos contactos");
            System.out.println("2. Buscar por nombre y reportar datos");
            System.out.println("3. Buscar por nombre y eliminar");
            System.out.println("4. Buscar por nombre y modificar teléfono");
            System.out.println("5. Volver");
            opcion = f.Valor(0, "Seleccionar la opción");

            switch (opcion) {
                case 1 -> {
                    if (p == n)
                        System.out.println("La agenda no tiene capacidad para nuevos contactos");
                    else {
                        int cantidad = f.Valor(0, "Cantidad de contactos a ingresar");
                        if (p + cantidad > n)
                            System.out.println("Error! solo hay capacidad para " + (n - p) + " contactos más");
                        else
                            p = f.IngresarContactos(Anombres, Atelefonos, Aedades, p, cantidad);
                    }
                }
                case 2 -> {
                    int pos = f.BuscarContacto(Anombres, p);
                    if (pos >= 0)
                        f.ReporteContacto(Anombres, Atelefonos, Aedades, pos);
                }
                case 3 -> {
                    int pos = f.BuscarContacto(Anombres, p);
                    if (pos >= 0) {
                        p = f.EliminarContacto(Anombres, Atelefonos, Aedades, pos, p);
                        System.out.println("Contacto eliminado");
                    }
                }
                case 4 -> {
                    int pos = f.BuscarContacto(Anombres, p);
                    if (pos >= 0) {
                        f.ModificarTelefono(Anombres, Atelefonos, pos);
                        f.ReporteContacto(Anombres, Atelefonos, Aedades, pos);
                    }
                }
                case 5 -> System.out.println("Volviendo al menú principal");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 5);
    }
}