
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ParqueFantastico parque = new ParqueFantastico(
                "Reino Encantado", "Cali, Colombia");

        Dragon dragon = new Dragon("Drako", 120, 80, 900, true);

        Fenix fenix = new Fenix("Fira", 80, 90, true, "Rojo y dorado");

        Unicornio unicornio = new Unicornio(
                "Luna", 50, 100, "Curacion", 1);

        Pixie pixie = new Pixie(
                "Campanita", 25, 75, "Pixie", 15,
                "Vestido verde", "Alegre", "Rubio",
                12.5f, "Dorado", true);

        Leprechaun leprechaun = new Leprechaun(
                "Finn", 300, 65, "Leprechaun", 30,
                100, "Artesano", "Traje verde", 3);

        Trasgo trasgo = new Trasgo(
                "Grok", 90, 70, "Trasgo", 80,
                "Verde", "Ropa vieja", 85, 60,
                "Esconder objetos");

        parque.agregarCriatura(dragon);
        parque.agregarCriatura(fenix);
        parque.agregarCriatura(unicornio);
        parque.agregarCriatura(pixie);
        parque.agregarCriatura(leprechaun);
        parque.agregarCriatura(trasgo);

        parque.mostrarInformacion();
        parque.mostrarCriaturas();

        System.out.println("\n===== ACTIVIDADES =====");

        for (CriaturaFantastica criatura : parque.getCriaturas()) {
            criatura.realizarActividadPrin();
        }

        System.out.println("\n===== ALIMENTACION Y DESCANSO =====");

        dragon.alimentar();
        pixie.descansar();
    }
}

class ParqueFantastico {

    private String nombre;
    private String ubicacion;
    private List<CriaturaFantastica> criaturas;

    public ParqueFantastico(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        criaturas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void agregarCriatura(CriaturaFantastica criatura) {
        criaturas.add(criatura);
    }

    public List<CriaturaFantastica> getCriaturas() {
        return criaturas;
    }

    public void mostrarInformacion() {
        System.out.println("PARQUE: " + nombre);
        System.out.println("UBICACION: " + ubicacion);
    }

    public void mostrarCriaturas() {
        System.out.println("\n===== CRIATURAS DEL PARQUE =====");

        for (CriaturaFantastica criatura : criaturas) {
            System.out.println(
                    criatura.getNombre() + " - "
                    + criatura.getClass().getSimpleName());
        }
    }
}

abstract class CriaturaFantastica {

    protected String nombre;
    protected int edad;
    protected int nivelEnergia;

    public CriaturaFantastica(
            String nombre, int edad, int nivelEnergia) {

        this.nombre = nombre;
        this.edad = edad;
        this.nivelEnergia = nivelEnergia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public void alimentar() {
        nivelEnergia = Math.min(100, nivelEnergia + 20);
        System.out.println(nombre + " ha sido alimentado.");
        System.out.println("Energia: " + nivelEnergia);
    }

    public void descansar() {
        nivelEnergia = Math.min(100, nivelEnergia + 10);
        System.out.println(nombre + " esta descansando.");
        System.out.println("Energia: " + nivelEnergia);
    }

    public abstract void realizarActividadPrin();
}

class Dragon extends CriaturaFantastica {

    private int temperaturaFuego;
    private boolean puedeVolar;

    public Dragon(String nombre, int edad, int energia,
                  int temperaturaFuego, boolean puedeVolar) {

        super(nombre, edad, energia);
        this.temperaturaFuego = temperaturaFuego;
        this.puedeVolar = puedeVolar;
    }

    public int getTemperaturaFuego() {
        return temperaturaFuego;
    }

    public boolean getPuedeVolar() {
        return puedeVolar;
    }

    public void volar() {
        if (puedeVolar) {
            System.out.println(nombre + " esta volando.");
        } else {
            System.out.println(nombre + " no puede volar.");
        }
    }

    public void lanzarFuego() {
        System.out.println(nombre + " lanza fuego a "
                + temperaturaFuego + " grados.");
    }

    @Override
    public void realizarActividadPrin() {
        lanzarFuego();
    }
}

abstract class Duende extends CriaturaFantastica {

    protected String tipoDuende;
    protected int tamano;

    public Duende(String nombre, int edad, int energia,
                  String tipoDuende, int tamano) {

        super(nombre, edad, energia);
        this.tipoDuende = tipoDuende;
        this.tamano = tamano;
    }

    public int getTamano() {
        return tamano;
    }

    public String getTipoDuende() {
        return tipoDuende;
    }
}

class Fenix extends CriaturaFantastica {

    private boolean puedeResurgir;
    private String colorPlumas;

    public Fenix(String nombre, int edad, int energia,
                 boolean puedeResurgir, String colorPlumas) {

        super(nombre, edad, energia);
        this.puedeResurgir = puedeResurgir;
        this.colorPlumas = colorPlumas;
    }

    public boolean getPuedeResurgir() {
        return puedeResurgir;
    }

    public String getColorPluma() {
        return colorPlumas;
    }

    public void resucitar() {
        if (puedeResurgir) {
            System.out.println(nombre + " resurge de sus cenizas.");
        } else {
            System.out.println(nombre + " no puede resurgir.");
        }
    }

    public void volar() {
        System.out.println(nombre + " vuela con sus plumas "
                + colorPlumas + ".");
    }

    @Override
    public void realizarActividadPrin() {
        resucitar();
    }
}

class Unicornio extends CriaturaFantastica {

    private String poderMagico;
    private int numCuernos;

    public Unicornio(String nombre, int edad, int energia,
                     String poderMagico, int numCuernos) {

        super(nombre, edad, energia);
        this.poderMagico = poderMagico;
        this.numCuernos = numCuernos;
    }

    public String getPoderMagico() {
        return poderMagico;
    }

    public int getNumCuernos() {
        return numCuernos;
    }

    public void usarMagia() {
        System.out.println(nombre + " utiliza su poder magico: "
                + poderMagico);
    }

    @Override
    public void realizarActividadPrin() {
        usarMagia();
    }
}

class Pixie extends Duende {

    private String vestimenta;
    private String tipoPersonalidad;
    private String colorCabello;
    private float tamanoAlas;
    private String colorPolvoMagico;
    private boolean puedeVolar;

    public Pixie(String nombre, int edad, int energia,
                 String tipoDuende, int tamano,
                 String vestimenta, String tipoPersonalidad,
                 String colorCabello, float tamanoAlas,
                 String colorPolvoMagico, boolean puedeVolar) {

        super(nombre, edad, energia, tipoDuende, tamano);

        this.vestimenta = vestimenta;
        this.tipoPersonalidad = tipoPersonalidad;
        this.colorCabello = colorCabello;
        this.tamanoAlas = tamanoAlas;
        this.colorPolvoMagico = colorPolvoMagico;
        this.puedeVolar = puedeVolar;
    }

    public String getVestimenta() {
        return vestimenta;
    }

    public String getTipoPersonalidad() {
        return tipoPersonalidad;
    }

    public String getColorCabello() {
        return colorCabello;
    }

    public float getTamanoAlas() {
        return tamanoAlas;
    }

    public String getColorPolvoMagico() {
        return colorPolvoMagico;
    }

    public void volar() {
        if (puedeVolar) {
            System.out.println(nombre
                    + " vuela dejando polvo magico "
                    + colorPolvoMagico + ".");
        } else {
            System.out.println(nombre + " no puede volar.");
        }
    }

    @Override
    public void realizarActividadPrin() {
        volar();
    }
}

class Leprechaun extends Duende {

    private int monedasOro;
    private String ocupacion;
    private String vestimenta;
    private int cantidadDeseos;

    public Leprechaun(String nombre, int edad, int energia,
                      String tipoDuende, int tamano,
                      int monedasOro, String ocupacion,
                      String vestimenta, int cantidadDeseos) {

        super(nombre, edad, energia, tipoDuende, tamano);

        this.monedasOro = monedasOro;
        this.ocupacion = ocupacion;
        this.vestimenta = vestimenta;
        this.cantidadDeseos = cantidadDeseos;
    }

    public void darMonedasOro() {
        System.out.println(nombre + " entrega "
                + monedasOro + " monedas de oro.");
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public String getVestimenta() {
        return vestimenta;
    }

    public int getCantidadDeseos() {
        return cantidadDeseos;
    }

    public void darDeseos() {
        System.out.println(nombre + " puede conceder "
                + cantidadDeseos + " deseos.");
    }

    @Override
    public void realizarActividadPrin() {
        darMonedasOro();
        darDeseos();
    }
}

class Trasgo extends Duende {

    private String colorPiel;
    private String vestimenta;
    private int agilidad;
    private int fuerza;
    private String tipoTravesura;

    public Trasgo(String nombre, int edad, int energia,
                  String tipoDuende, int tamano,
                  String colorPiel, String vestimenta,
                  int agilidad, int fuerza, String tipoTravesura) {

        super(nombre, edad, energia, tipoDuende, tamano);

        this.colorPiel = colorPiel;
        this.vestimenta = vestimenta;
        this.agilidad = agilidad;
        this.fuerza = fuerza;
        this.tipoTravesura = tipoTravesura;
    }

    public String getColorPiel() {
        return colorPiel;
    }

    public String getVestimenta() {
        return vestimenta;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public String getTipoTravesura() {
        return tipoTravesura;
    }

    public void hacerTravesura() {
        System.out.println(nombre + " hace una travesura: "
                + tipoTravesura + ".");
    }

    @Override
    public void realizarActividadPrin() {
        hacerTravesura();
    }
}
