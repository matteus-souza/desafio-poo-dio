package br.com.dio.desafio.dominio;

import java.util.*;

/**
 * Representa um desenvolvedor que pode se inscrever em bootcamps.
 */
public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev() {
    }

    /**
     * Construtor com nome para criação segura.
     */
    public Dev(String nome) {
        setNome(nome);
    }

    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp == null) {
            throw new IllegalArgumentException("Bootcamp não pode ser nulo");
        }
        if (bootcamp.getDevsInscritos().contains(this)) {
            throw new IllegalArgumentException("Dev já está inscrito neste bootcamp");
        }
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            throw new RuntimeException("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    /**
     * Calcula a porcentagem de progresso no bootcamp.
     */
    public double calcularProgressoBootcamp() {
        int totalConteudos = conteudosInscritos.size() + conteudosConcluidos.size();
        if (totalConteudos == 0) {
            return 0.0;
        }
        return (conteudosConcluidos.size() * 100.0) / totalConteudos;
    }

    /**
     * Verifica se o dev completou todos os conteúdos.
     */
    public boolean completouTodosConteudos() {
        return conteudosInscritos.isEmpty() && !conteudosConcluidos.isEmpty();
    }

    /**
     * Obtém o próximo conteúdo a ser estudado.
     */
    public Optional<Conteudo> getProximoConteudo() {
        return conteudosInscritos.stream().findFirst();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome.trim();
    }

    public Set<Conteudo> getConteudosInscritos() {
        return Collections.unmodifiableSet(conteudosInscritos);
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = new LinkedHashSet<>(conteudosInscritos != null ? conteudosInscritos : Collections.emptySet());
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return Collections.unmodifiableSet(conteudosConcluidos);
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = new LinkedHashSet<>(conteudosConcluidos != null ? conteudosConcluidos : Collections.emptySet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + nome + '\'' +
                ", conteudosInscritos=" + conteudosInscritos.size() +
                ", conteudosConcluidos=" + conteudosConcluidos.size() +
                ", xpTotal=" + calcularTotalXp() +
                ", progresso=" + String.format("%.1f", calcularProgressoBootcamp()) + "%" +
                '}';
    }
}
