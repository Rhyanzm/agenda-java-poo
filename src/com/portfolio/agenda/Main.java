package com.portfolio.agenda;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Sistema de Agenda ===\n");

        Agenda minhaAgenda = new Agenda();

        try {
            // 1. Criando instâncias de Pessoas (Contatos) válidas
            Contato pessoa1 = new Contato("Ana Silva", "11988887777", "ana@email.com");
            Contato pessoa2 = new Contato("Carlos Souza", "21977776666", "carlos@email.com");
            Contato pessoa3 = new Contato("Beatriz Lima", "31966665555", null); // Sem email teste

            // 2. Adicionando na Agenda
            minhaAgenda.adicionarContato(pessoa1);
            minhaAgenda.adicionarContato(pessoa2);
            minhaAgenda.adicionarContato(pessoa3);

            // 3. Testando segurança: Tentando adicionar duplicidade
            System.out.println("\n[Teste de Segurança: Duplicidade]");
            Contato cloneAna = new Contato("Ana Falsa", "11988887777", "fake@email.com");
            minhaAgenda.adicionarContato(cloneAna); // Isso vai disparar a Exception

        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Bloqueado pelo sistema: " + e.getMessage());
        }

        try {
            // 4. Testando segurança: Tentando criar um contato com telefone inválido
            System.out.println("\n[Teste de Segurança: Validação de Dados]");
            Contato pessoaInvalida = new Contato("João", "123", "joao@email.com");
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Bloqueado pelo sistema: " + e.getMessage());
        }

        // 5. Listando Contatos
        System.out.println("\n=== Lista de Contatos ===");
        for (Contato c : minhaAgenda.listarContatos()) {
            System.out.println(c.toString());
        }

        // 6. Buscando um contato específico (Testando o Optional)
        System.out.println("\n=== Buscando Contato ===");
        String nomeBusca = "Carlos Souza";
        Optional<Contato> resultado = minhaAgenda.buscarPorNome(nomeBusca);

        // Se encontrou (isPresent), imprime. Se não, avisa.
        resultado.ifPresentOrElse(
                c -> System.out.println("🔍 Encontrado: " + c),
                () -> System.out.println("❌ Contato não encontrado.")
        );

        // 7. Removendo um contato
        System.out.println("\n=== Removendo Contato ===");
        minhaAgenda.removerContato("21977776666"); // Remove o Carlos

        System.out.println("\n=== Lista Final de Contatos ===");
        minhaAgenda.listarContatos().forEach(System.out::println);
    }
}