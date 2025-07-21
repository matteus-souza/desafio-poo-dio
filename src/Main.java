import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

/**
 * Classe principal demonstrando as melhorias no sistema de bootcamp.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== DESAFIO POO DIO - SISTEMA MELHORADO ===\n");
        
        try {
            // Criando cursos usando construtores melhorados
            Curso curso1 = new Curso("Curso Java", "Aprenda Java do básico ao avançado", 8);
            Curso curso2 = new Curso("Curso JavaScript", "Domine JavaScript e suas tecnologias", 4);
            
            // Criando mentoria
            Mentoria mentoria = new Mentoria("Mentoria de Java", "Tire suas dúvidas sobre Java", LocalDate.now().plusDays(7));

            System.out.println("CONTEUDOS CRIADOS:");
            System.out.println(curso1);
            System.out.println(curso2);
            System.out.println(mentoria);
            System.out.println();

            // Criando bootcamp usando construtor melhorado
            Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Torne-se um desenvolvedor Java completo");
            bootcamp.adicionarConteudo(curso1);
            bootcamp.adicionarConteudo(curso2);
            bootcamp.adicionarConteudo(mentoria);

            System.out.println("BOOTCAMP CRIADO:");
            System.out.println(bootcamp);
            System.out.println();

            // Criando desenvolvedores usando construtores melhorados
            Dev devCamila = new Dev("Camila");
            Dev devJoao = new Dev("Joao");

            System.out.println("DESENVOLVEDORES CRIADOS:");
            System.out.println(devCamila);
            System.out.println(devJoao);
            System.out.println();

            // Inscrevendo desenvolvedores
            System.out.println("INSCRICOES:");
            devCamila.inscreverBootcamp(bootcamp);
            System.out.println("Camila inscrita no bootcamp");
            System.out.println("Proximo conteudo: " + devCamila.getProximoConteudo().map(c -> c.getTitulo()).orElse("Nenhum"));
            
            devJoao.inscreverBootcamp(bootcamp);
            System.out.println("Joao inscrito no bootcamp");
            System.out.println();

            // Demonstrando progresso da Camila
            System.out.println("PROGRESSO DA CAMILA:");
            devCamila.progredir(); // Completa curso Java
            System.out.println("Completou: Curso Java");
            System.out.println("Progresso: " + String.format("%.1f", devCamila.calcularProgressoBootcamp()) + "%");
            System.out.println("XP atual: " + devCamila.calcularTotalXp());
            
            devCamila.progredir(); // Completa curso JavaScript
            System.out.println("Completou: Curso JavaScript");
            System.out.println("Progresso: " + String.format("%.1f", devCamila.calcularProgressoBootcamp()) + "%");
            System.out.println("XP atual: " + devCamila.calcularTotalXp());
            System.out.println();

            System.out.println("-------------------");

            // Demonstrando progresso do João (completa tudo)
            System.out.println("PROGRESSO DO JOAO:");
            devJoao.progredir(); // Curso Java
            devJoao.progredir(); // Curso JavaScript  
            devJoao.progredir(); // Mentoria
            
            System.out.println("Joao completou todos os conteudos!");
            System.out.println("Progresso: " + String.format("%.1f", devJoao.calcularProgressoBootcamp()) + "%");
            System.out.println("XP final: " + devJoao.calcularTotalXp());
            System.out.println("Completou bootcamp: " + (devJoao.completouTodosConteudos() ? "SIM" : "NAO"));
            System.out.println();

            // Estatísticas finais
            System.out.println("ESTATISTICAS FINAIS:");
            System.out.println("Bootcamp ativo: " + (bootcamp.isAtivo() ? "SIM" : "NAO"));
            System.out.println("Total de inscritos: " + bootcamp.getQuantidadeDevsInscritos());
            System.out.println("XP total disponivel: " + bootcamp.calcularXpTotal());
            System.out.println("Carga horaria total: " + bootcamp.calcularCargaHorariaTotal() + "h");
            System.out.println("Desenvolvedores que completaram: " + bootcamp.getDevsQueCompletaram().size());
            
            if (!bootcamp.getDevsQueCompletaram().isEmpty()) {
                System.out.println("\nHALL DA FAMA:");
                bootcamp.getDevsQueCompletaram().forEach(dev -> 
                    System.out.println("  - " + dev.getNome() + " (XP: " + dev.calcularTotalXp() + ")")
                );
            }

        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
