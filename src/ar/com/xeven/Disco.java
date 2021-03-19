package ar.com.xeven;

public class Disco {
    //atributos
    private String codigo;
    private String autor;
    private String titulo;
    private String genero;
    private int duracion; //en minutos

    //constructor
    public Disco(String codigo, String autor, String titulo, String genero, int duracion) {
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }

    //getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    //toString
    @Override
    public String toString() {
        String cadena = "\n-------------------------------------"; //\n inserta linea desp de el
        cadena += "\nCodigo: "+this.codigo;
        cadena += "\nAutor: "+this.autor;
        cadena += "\nTitulo: "+this.titulo;
        cadena += "\nGenero: "+this.genero;
        cadena += "\nDuracion: "+this.duracion;
        cadena += "\n--------------------------------------";

        return cadena;
    }

    //considero que dos discos son iguales si tienen el mismo codigo
    //es obligatorio pasar un objeto generico como parametro
    @Override
    public boolean equals(Object disco) {
        return (this.codigo).equals(((Disco)disco).getCodigo());
    }

}
