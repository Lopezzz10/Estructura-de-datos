package serie_numeros;
import java.util.Scanner;
import java.util.Random;
public class Class_Acciones {
    public int Valor(int n, String etiqueta){
        do{
            try{
                Scanner leer = new Scanner(System.in);
                System.out.print(etiqueta+": ");
                n = leer.nextInt();
                if (n <= 0)
                    System.out.println("   Error! debe ser número positivo y mayor a 0");
            }
            catch (Exception e) {
                System.out.println("   Error! debe ser número entero positivo");
            }
        }while(n <= 0);
        return n;
    }

    public void Inicializar(int [] arreglo){
        for (int i=0; i<arreglo.length; i++)    //encerar o inicializar el arreglo
            arreglo[i] = 0;
    }

    public int NuevoElementoTeclado(int [] numeros, int m){
        int i=0;
        char siguiente;

        do{
            Scanner leer = new Scanner(System.in);
            do{
                numeros[i] = Valor(0,"Ingresar un número múltiplo de "+m);
                if ((numeros[i] % m != 0)||(numeros[i] == 0))
                    System.out.println("Error! el número "+numeros[i]+" ingresado debe ser múltiplo de "+m);
            }while ((numeros[i] % m != 0)||(numeros[i] == 0));

            System.out.print("Ingresar otro elemento s/n: ");
            siguiente = leer.next().charAt(0);
            if (siguiente == 's' || siguiente == 'S') i++;

        }while((siguiente == 's' || siguiente == 'S') &&(i < numeros.length));

        return i+1;
    }

    public int IngresaPValido(int n, int p){
        do{
            p = Valor(p, "Ingresar p válidos");
            if (p > n) System.out.println("Error! p debe ser menor que n");
        }while(p > n);
        return p;
    }

    public void NuevoElementoGenera(int [] numeros, int m, int p){
        for (int i = 0; i < p; i++)
            numeros[i] = (i + 1) * m;
    }

    public void NuevoElementoAleatorio(int [] numeros, int m, int p){
        for (int i=0; i < p; i++){
            do{
                numeros[i] = new Random().nextInt(100);
            }while((numeros[i] % m != 0)||(numeros[i] == 0));
        }
    }

    public void MayorMenorNumero(int p, int [] numeros){
        int mayor = numeros[0];
        int menor = numeros[0];

        // Recorrer el arreglo para encontrar el mayor y menor de los numeros
        for (int i = 1; i < p; i++){
            if (numeros[i] > mayor)
                mayor = numeros[i];
            if (numeros[i] < menor)
                menor = numeros[i];
        }
        System.out.println("\nEl numero mayor es: " + mayor);
        System.out.println("El numero menor es: " + menor);
    }

    public int BuscarElemento(int [] numeros, int p, int posicion){
        int buscar = 0;
        boolean encontro = false;

        buscar = Valor(buscar, "Ingresar valor a buscar");

        for (posicion = 0 ; posicion < p ; posicion++){
            if (numeros[posicion] == buscar){
                encontro = true;
                break;
            }
        }

        if (encontro == false){
            System.out.println(buscar + " no existe en arreglo!");
            posicion = -1;
        }
        return posicion;
    }

    public int InsertarElementoDespues(int posicion, int [] numeros, int p){
        for(int j = p ; j > posicion + 1 ; j--)  // recorre una posición a la derecha
            numeros[j] = numeros[j-1];

        numeros[posicion + 1] = Valor(0, "número a insertar");
        return p + 1;
    }

    public int InsertarElementoAntes(int posicion, int [] numeros, int p){
        for(int j = p ; j > posicion ; j--)  // recorre una posición a la derecha
            numeros[j] = numeros[j - 1];

        numeros[posicion] = Valor(0, "número a insertar");
        return p + 1;
    }

    public int EliminarElemento(int posicion, int [] numeros, int p){
        for (int j = posicion ; j < p-1 ; j++)
            numeros[j] = numeros[j + 1];
        numeros[p - 1] = 0;   // excepción por arreglo lleno

        return p - 1;
    }

    public void ModificarElemento(int posicion, int [] numeros){
        numeros[posicion] = Valor(0, "por modificar");
    }

    public int SeleccionElementos(int [] numeros, int [] snumeros, int p)  {
        int q = Valor(0, "q múltiplo");
        int j = 0;
        for (int i=0; i<p; i++) {
            if (numeros[i]%q == 0) {
                snumeros[j] = numeros[i];
                j++;
            }
        }
        return j;
    }

    public void SalidaPantallaCompleto(int [] arreglo, String etiqueta){
        System.out.println("\n"+etiqueta);
        for (int i=0; i<arreglo.length; i++)
            System.out.print(arreglo[i]+", ");
    }

    public void SalidaPantallaValidos(int [] numeros, String etiqueta, int p){
        System.out.println("\n"+etiqueta);
        for (int i=0; i<p; i++)
            System.out.print(numeros[i]+", ");
    }

    // ===================== NUEVO: PACIENTES =====================

    public String LeerNombre(){
        String nombre;
        Scanner leer = new Scanner(System.in);
        do{
            System.out.print("Nombre del paciente: ");
            nombre = leer.nextLine().trim();
            if (!nombre.matches("\\p{L}+( \\p{L}+)*"))
                System.out.println("   Error! el nombre solo puede contener letras (ej. Pedro o Maria Jose)");
        }while(!nombre.matches("\\p{L}+( \\p{L}+)*"));
        return nombre;
    }

    public double LeerTemperatura(String etiqueta){
        double t = 0;
        Scanner leer = new Scanner(System.in);
        do{
            System.out.print(etiqueta + ": ");
            String texto = leer.nextLine().trim();
            if (!texto.matches("\\d+(\\.\\d+)?")){
                System.out.println("   Error! formato double con punto (ej. 36.1)");
                continue;
            }
            t = Double.parseDouble(texto);
            if (t < 30 || t > 45){
                System.out.println("   Error! temperatura válida entre 30 y 45");
                t = 0;
            }
        }while(t == 0);
        return t;
    }

    public int IngresarPacientes(String [] nombres, double [] temperaturas, int p, int cantidad){
        for (int i = 0; i < cantidad; i++){
            nombres[p] = LeerNombre();
            temperaturas[p] = LeerTemperatura("Temperatura de " + nombres[p]);
            p++;
        }
        return p;
    }

    public void NominaPacientes(String [] nombres, double [] temperaturas, int p){
        System.out.println("\n===== NÓMINA DE PACIENTES =====");
        if (p == 0){
            System.out.println("No hay pacientes registrados");
            return;
        }
        for (int i = 0; i < p; i++)
            System.out.println("Paciente: " + nombres[i] + " | Temperatura: " + temperaturas[i]);
    }

    public int BuscarNombre(String [] nombres, int p){
        Scanner leer = new Scanner(System.in);
        System.out.print("Nombre a buscar: ");
        String buscar = leer.nextLine().trim();
        for (int i = 0; i < p; i++)
            if (nombres[i].equalsIgnoreCase(buscar))
                return i;
        System.out.println(buscar + " no existe en la nómina!");
        return -1;
    }

    public int EliminarPaciente(String [] nombres, double [] temperaturas, int posicion, int p){
        for (int j = posicion; j < p - 1; j++){
            nombres[j] = nombres[j + 1];
            temperaturas[j] = temperaturas[j + 1];
        }
        nombres[p - 1] = "";
        temperaturas[p - 1] = 0;
        return p - 1;
    }

    public void ModificarTemperatura(String [] nombres, double [] temperaturas, int posicion){
        temperaturas[posicion] = LeerTemperatura("Nueva temperatura de " + nombres[posicion]);
    }

    public void PromedioTemperaturas(double [] temperaturas, int p){
        if (p == 0){
            System.out.println("No hay pacientes registrados");
            return;
        }
        double suma = 0;
        for (int i = 0; i < p; i++)
            suma += temperaturas[i];
        System.out.println("\nPromedio de temperaturas: " + suma / p);
    }

    public void MayorMenorTemperatura(String [] nombres, double [] temperaturas, int p){
        if (p == 0){
            System.out.println("No hay pacientes registrados");
            return;
        }
        int mayor = 0, menor = 0;
        for (int i = 1; i < p; i++){
            if (temperaturas[i] > temperaturas[mayor]) mayor = i;
            if (temperaturas[i] < temperaturas[menor]) menor = i;
        }
        System.out.println("\nTemperatura más alta: " + temperaturas[mayor] + " (" + nombres[mayor] + ")");
        System.out.println("Temperatura más baja: " + temperaturas[menor] + " (" + nombres[menor] + ")");
    }

    // ===================== NUEVO: AGENDA DE CONTACTOS =====================

    public String LeerNombreContacto(){
        String nombre;
        Scanner leer = new Scanner(System.in);
        do{
            System.out.print("Nombre del contacto: ");
            nombre = leer.nextLine().trim();
            if (!nombre.matches("\\p{L}+( \\p{L}+)*"))
                System.out.println("   Error! el nombre solo puede contener letras (ej. Pedro o Maria Jose)");
        }while(!nombre.matches("\\p{L}+( \\p{L}+)*"));
        return nombre;
    }

    public String LeerTelefono(String etiqueta){
        String telefono;
        Scanner leer = new Scanner(System.in);
        do{
            System.out.print(etiqueta + ": ");
            telefono = leer.nextLine().trim();
            if (!telefono.matches("\\d{10}"))
                System.out.println("   Error! el teléfono debe tener 10 dígitos numéricos (ej. 0991234567)");
        }while(!telefono.matches("\\d{10}"));
        return telefono;
    }

    public int LeerEdad(){
        int edad = 0;
        Scanner leer = new Scanner(System.in);
        do{
            System.out.print("Edad: ");
            String texto = leer.nextLine().trim();
            if (!texto.matches("\\d{1,3}")){
                System.out.println("   Error! la edad debe ser un número entero");
                continue;
            }
            edad = Integer.parseInt(texto);
            if (edad < 1 || edad > 100){
                System.out.println("   Error! edad válida entre 1 y 100");
                edad = 0;
            }
        }while(edad == 0);
        return edad;
    }

    public int IngresarContactos(String [] nombres, String [] telefonos, int [] edades, int p, int cantidad){
        for (int i = 0; i < cantidad; i++){
            nombres[p] = LeerNombreContacto();
            telefonos[p] = LeerTelefono("Teléfono de " + nombres[p]);
            edades[p] = LeerEdad();
            p++;
        }
        return p;
    }

    public int BuscarContacto(String [] nombres, int p){
        Scanner leer = new Scanner(System.in);
        System.out.print("Nombre a buscar: ");
        String buscar = leer.nextLine().trim();
        for (int i = 0; i < p; i++)
            if (nombres[i].equalsIgnoreCase(buscar))
                return i;
        System.out.println(buscar + " no existe en la agenda!");
        return -1;
    }

    public void ReporteContacto(String [] nombres, String [] telefonos, int [] edades, int posicion){
        System.out.println("\n===== DATOS DEL CONTACTO =====");
        System.out.println("Nombre: " + nombres[posicion]);
        System.out.println("Teléfono: " + telefonos[posicion]);
        System.out.println("Edad: " + edades[posicion]);
    }

    public int EliminarContacto(String [] nombres, String [] telefonos, int [] edades, int posicion, int p){
        for (int j = posicion; j < p - 1; j++){
            nombres[j] = nombres[j + 1];
            telefonos[j] = telefonos[j + 1];
            edades[j] = edades[j + 1];
        }
        nombres[p - 1] = "";
        telefonos[p - 1] = "";
        edades[p - 1] = 0;
        return p - 1;
    }

    public void ModificarTelefono(String [] nombres, String [] telefonos, int posicion){
        telefonos[posicion] = LeerTelefono("Nuevo teléfono de " + nombres[posicion]);
    }
}