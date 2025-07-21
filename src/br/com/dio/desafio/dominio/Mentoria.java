package br.com.dio.desafio.dominio;

import java.time.LocalDate;

/**
 * Representa uma mentoria com data específica.
 */
public class Mentoria extends Conteudo {

    private LocalDate data;

    public Mentoria() {
    }

    /**
     * Construtor com parâmetros para criação segura.
     */
    public Mentoria(String titulo, String descricao, LocalDate data) {
        setTitulo(titulo);
        setDescricao(descricao);
        setData(data);
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("Data da mentoria não pode ser nula");
        }
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data da mentoria não pode ser no passado");
        }
        this.data = data;
    }

    /**
     * Verifica se a mentoria já aconteceu.
     */
    public boolean jaAconteceu() {
        return data != null && data.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                ", xp=" + calcularXp() +
                '}';
    }
}
