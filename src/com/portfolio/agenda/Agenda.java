package com.portfolio.agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Agenda {
    // A lista é privada e final (a referência da lista não muda)
    private final List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    // Método para adicionar um novo contato
    public void adicionarContato(Contato contato) {
        if (contato == null) {
            throw new IllegalArgumentException("O contato não pode ser nulo.");
        }

        // Verifica se já existe alguém com esse telefone usando Streams
        boolean jaExiste = contatos.stream()
                .anyMatch(c -> c.getTelefone().equals(contato.getTelefone()));

        if (jaExiste) {
            throw new IllegalArgumentException("Já existe um contato salvo com o telefone " + contato.getTelefone());
        }

        contatos.add(contato);
        System.out.println("✅ Contato '" + contato.getNome() + "' adicionado com sucesso!");
    }

    // Método para remover um contato pelo telefone
    public void removerContato(String telefone) {
        // removeIf é uma forma moderna e limpa de remover itens de uma lista
        boolean removido = contatos.removeIf(c -> c.getTelefone().equals(telefone));

        if (removido) {
            System.out.println("🗑️ Contato com telefone " + telefone + " removido.");
        } else {
            System.out.println("❌ Erro: Contato com telefone " + telefone + " não encontrado.");
        }
    }

    // Buscar contato. O uso do Optional mostra maturidade técnica (evita NullPointerException)
    public Optional<Contato> buscarPorNome(String nome) {
        return contatos.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    // Retorna a lista de contatos.
    // Collections.unmodifiableList impede que quem chame o método faça contatos.remove() ou .add()
    public List<Contato> listarContatos() {
        return Collections.unmodifiableList(contatos);
    }
}