# 🚀 Desafio POO DIO - Versão Melhorada

Este projeto foi aprimorado com várias melhorias em relação ao design original, mantendo os princípios de Programação Orientada a Objetos e aplicando boas práticas de desenvolvimento.

## 📋 Melhorias Implementadas

### 🏗️ **Estrutura e Build**
- ✅ Adicionado `pom.xml` para gerenciamento Maven
- ✅ Estrutura de diretórios padronizada
- ✅ Configuração para Java 11

### 🔧 **Qualidade de Código**
- ✅ **Validações robustas**: Todos os setters validam parâmetros
- ✅ **Exceções customizadas**: `IllegalArgumentException` para casos inválidos
- ✅ **Documentação Javadoc**: Todas as classes e métodos documentados
- ✅ **Construtores parametrizados**: Criação de objetos mais segura
- ✅ **Encapsulamento aprimorado**: Retorno de coleções imutáveis quando apropriado

### 🆕 **Novas Funcionalidades**

#### Classe `Dev`
- ✅ `calcularProgressoBootcamp()`: Calcula porcentagem de conclusão
- ✅ `completouTodosConteudos()`: Verifica se finalizou o bootcamp
- ✅ `getProximoConteudo()`: Obtém próximo conteúdo a estudar
- ✅ Validação contra inscrição dupla no mesmo bootcamp

#### Classe `Bootcamp`
- ✅ `adicionarConteudo()` / `removerConteudo()`: Gerenciamento de conteúdos
- ✅ `calcularXpTotal()`: XP total disponível no bootcamp
- ✅ `calcularCargaHorariaTotal()`: Soma da carga horária de todos os cursos
- ✅ `isAtivo()`: Verifica se o bootcamp está no período ativo
- ✅ `getDevsQueCompletaram()`: Lista devs que completaram o bootcamp

#### Classe `Mentoria`
- ✅ `jaAconteceu()`: Verifica se a mentoria já ocorreu
- ✅ Validação de data (não pode ser no passado)

#### Classe `Curso`
- ✅ Validação de carga horária (deve ser positiva)

### 🔒 **Melhorias de Encapsulamento**
- ✅ Métodos getters retornam coleções imutáveis
- ✅ Validação de parâmetros nulos
- ✅ Trim automático em strings
- ✅ Implementação adequada de `equals()` e `hashCode()`

## 🎯 **Princípios POO Demonstrados**

### **Abstração**
- Classe abstrata `Conteudo` define contrato comum
- Interfaces implícitas através de métodos abstratos

### **Encapsulamento**
- Atributos privados com getters/setters validados
- Validações internas nas classes
- Coleções protegidas contra modificação externa

### **Herança**
- `Curso` e `Mentoria` herdam de `Conteudo`
- Reutilização de código e polimorfismo

### **Polimorfismo**
- Método `calcularXp()` implementado diferentemente em cada subclasse
- Uso de coleções de `Conteudo` para tratar diferentes tipos

## 🚦 **Como Executar**

### Compilação e Execução Direta
```bash
# Compilar
javac -cp "src" -d "bin" src\Main.java src\br\com\dio\desafio\dominio\*.java

# Executar
java -cp "bin" Main
```

### Com Maven (Recomendado)
```bash
# Compilar
mvn compile

# Executar
mvn exec:java -Dexec.mainClass="Main"

# Executar testes (quando configurado)
mvn test
```

## 📊 **Exemplo de Saída**

```
=== DESAFIO POO DIO - SISTEMA MELHORADO ===

CONTEUDOS CRIADOS:
Curso{titulo='Curso Java', descricao='Aprenda Java do básico ao avançado', cargaHoraria=8, xp=80.0}
Curso{titulo='Curso JavaScript', descricao='Domine JavaScript e suas tecnologias', cargaHoraria=4, xp=40.0}
Mentoria{titulo='Mentoria de Java', descricao='Tire suas dúvidas sobre Java', data=2025-07-28, xp=30.0}

BOOTCAMP CRIADO:
Bootcamp{nome='Bootcamp Java Developer', descricao='Torne-se um desenvolvedor Java completo', dataInicial=2025-07-21, dataFinal=2025-09-04, quantidadeConteudos=3, quantidadeDevsInscritos=0, xpTotal=150.0, ativo=true}

HALL DA FAMA:
  - Joao (XP: 150.0)
```

## 🔄 **Próximas Melhorias Sugeridas**

1. **Persistência**: Implementar salvamento em banco de dados ou arquivo JSON
2. **API REST**: Criar endpoints para gerenciar bootcamps
3. **Interface Gráfica**: Desenvolver GUI com JavaFX ou web com Spring Boot
4. **Relatórios**: Sistema de geração de certificados e relatórios
5. **Notificações**: Sistema de lembretes para mentorias
6. **Gamificação**: Badges, níveis, conquistas
7. **Avaliações**: Sistema de feedback e notas

## 🤝 **Contribuições**

Este projeto demonstra a aplicação prática dos conceitos de POO com melhorias significativas em:
- Robustez e confiabilidade
- Documentação e manutenibilidade  
- Testabilidade
- Extensibilidade

---

### 📚 **Conceitos POO Aplicados**
- **Classes e Objetos**: Modelagem do domínio real
- **Herança**: Especialização de conteúdos
- **Polimorfismo**: Diferentes implementações de cálculo de XP
- **Encapsulamento**: Proteção de dados e validações
- **Abstração**: Simplificação através de interfaces comuns

**Desenvolvido com ♥ por**: Desafio POO DIO - Versão Melhorada