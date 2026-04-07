# 📔 Agenda Telefônica em Java - POO & Clean Code

Este projeto foi desenvolvido para demonstrar sólidos conhecimentos em **Programação Orientada a Objetos (POO)** e boas práticas de desenvolvimento em Java. É uma aplicação de console que gerencia contatos, focando em segurança de dados e sustentabilidade do código.

## 🚀 Diferenciais Técnicos (Vaga Júnior)

Para tornar este projeto robusto e preparado para o mercado, apliquei os seguintes conceitos:

* **Encapsulamento Forte:** Atributos privados com métodos de acesso controlados.
* **Validação de Dados:** O sistema não permite a criação de contatos com nomes vazios ou telefones em formatos inválidos (RegEx).
* **Imutabilidade:** A lista de contatos retornada pela Agenda é imutável (`Collections.unmodifiableList`), impedindo alterações externas não autorizadas.
* **Java Streams & Optional:** Uso de tecnologias modernas do Java para buscas eficientes e tratamento seguro de valores nulos (evitando o famoso `NullPointerException`).
* **Sobrescrita de Métodos:** Implementação customizada de `equals`, `hashCode` e `toString` para garantir a integridade da comparação de objetos.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **IDE:** IntelliJ IDEA
* **Paradigma:** Orientação a Objetos

## 📖 Como Executar

1. Clone o repositório.
2. Certifique-se de ter o JDK 17 ou superior instalado.
3. Abra o projeto no IntelliJ IDEA.
4. Execute a classe `Main.java` localizada no pacote `com.portfolio.agenda`.