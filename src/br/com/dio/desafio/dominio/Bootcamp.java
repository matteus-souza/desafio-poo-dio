package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Representa um bootcamp que contém vários conteúdos educacionais.
 */
public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp() {
    }

    /**
     * Construtor com parâmetros para criação segura.
     */
    public Bootcamp(String nome, String descricao) {
        setNome(nome);
        setDescricao(descricao);
    }

    /**
     * Adiciona um conteúdo ao bootcamp.
     */
    public void adicionarConteudo(Conteudo conteudo) {
        if (conteudo == null) {
            throw new IllegalArgumentException("Conteúdo não pode ser nulo");
        }
        this.conteudos.add(conteudo);
    }

    /**
     * Remove um conteúdo do bootcamp.
     */
    public boolean removerConteudo(Conteudo conteudo) {
        return this.conteudos.remove(conteudo);
    }

    /**
     * Calcula o XP total disponível no bootcamp.
     */
    public double calcularXpTotal() {
        return conteudos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    /**
     * Calcula a carga horária total (apenas cursos).
     */
    public int calcularCargaHorariaTotal() {
        return conteudos.stream()
                .filter(conteudo -> conteudo instanceof Curso)
                .mapToInt(conteudo -> ((Curso) conteudo).getCargaHoraria())
                .sum();
    }

    /**
     * Verifica se o bootcamp está ativo (no período).
     */
    public boolean isAtivo() {
        LocalDate hoje = LocalDate.now();
        return !hoje.isBefore(dataInicial) && !hoje.isAfter(dataFinal);
    }

    /**
     * Obtém os desenvolvedores que completaram o bootcamp.
     */
    public List<Dev> getDevsQueCompletaram() {
        return devsInscritos.stream()
                .filter(Dev::completouTodosConteudos)
                .collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do bootcamp não pode ser nulo ou vazio");
        }
        this.nome = nome.trim();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição do bootcamp não pode ser nula ou vazia");
        }
        this.descricao = descricao.trim();
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos; // Para uso interno (inscrição)
    }

    public Set<Dev> getDevsInscritosImutavel() {
        return Collections.unmodifiableSet(devsInscritos);
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = new HashSet<>(devsInscritos != null ? devsInscritos : Collections.emptySet());
    }

    public Set<Conteudo> getConteudos() {
        return conteudos; // Para uso interno (inscrição)
    }

    public Set<Conteudo> getConteudosImutavel() {
        return Collections.unmodifiableSet(conteudos);
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = new LinkedHashSet<>(conteudos != null ? conteudos : Collections.emptySet());
    }

    /**
     * Obtém a quantidade de conteúdos.
     */
    public int getQuantidadeConteudos() {
        return conteudos.size();
    }

    /**
     * Obtém a quantidade de desenvolvedores inscritos.
     */
    public int getQuantidadeDevsInscritos() {
        return devsInscritos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && 
               Objects.equals(dataInicial, bootcamp.dataInicial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataInicial);
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", quantidadeConteudos=" + getQuantidadeConteudos() +
                ", quantidadeDevsInscritos=" + getQuantidadeDevsInscritos() +
                ", xpTotal=" + calcularXpTotal() +
                ", ativo=" + isAtivo() +
                '}';
    }
}
