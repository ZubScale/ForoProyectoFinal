import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

// Enumeración para el género
enum Genero {
    MASCULINO, FEMENINO, OTRO
}

// Enumeración para el estatus
enum Estatus {
    ACTIVO, INACTIVO, BLOQUEADO
}

// Clase Usuario
public class Usuario {
    private String nombre;
    private String password;
    private String description;
    private Genero genero;
    private String email;
    private LocalDate fechaNacimiento;
    private Set<Usuario> followers;
    private Set<Usuario> usuariosBloqueados;
    private String usuario;
    private Estatus estatus;

    // Constructor
    public Usuario(String nombre, String password, String description, Genero genero, String email, LocalDate fechaNacimiento, String usuario) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El usuario no puede estar vacío.");
        }
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("El email no es válido.");
        }
        if (!validarPassword(password)) {
            throw new IllegalArgumentException("La contraseña no cumple con los requisitos.");
        }
        if (!validarEdad(fechaNacimiento)) {
            throw new IllegalArgumentException("El usuario debe ser mayor de 18 años.");
        }

        this.nombre = nombre;
        this.password = password;
        this.description = description;
        this.genero = genero;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.followers = new HashSet<>();
        this.usuariosBloqueados = new HashSet<>();
        this.usuario = usuario;
        this.estatus = Estatus.ACTIVO;
    }

    // Método para validar el email usando expresiones regulares
    private boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    // Método para validar la contraseña usando expresiones regulares
    private boolean validarPassword(String password) {
        String regex = "^(?=.*[0-9].*[0-9])(?=.*[@#$]).{8,}$";
        return Pattern.compile(regex).matcher(password).matches();
    }

    // Método para validar que el usuario sea mayor de 18 años
    private boolean validarEdad(LocalDate fechaNacimiento) {
        return ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now()) >= 18;
    }

    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", email='" + email + '\'' +
                ", estatus=" + estatus +
                '}';
    }
}