package br.com.dio.desafio.dominio;

/**
 * Representa um curso com carga horária específica.
 */
public class Curso extends Conteudo {

    private int cargaHoraria;

    public Curso() {
    }

    /**
     * Construtor com parâmetros para criação segura.
     */
    public Curso(String titulo, String descricao, int cargaHoraria) {
        setTitulo(titulo);
        setDescricao(descricao);
        setCargaHoraria(cargaHoraria);
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("Carga horária deve ser maior que zero");
        }
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", xp=" + calcularXp() +
                '}';
    }
}
