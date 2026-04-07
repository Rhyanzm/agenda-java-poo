package com.portfolio.agenda;

import java.util.Objects;

public class Contato {
    private String nome;
    private String telefone;
    private String email;

    // O Construtor blinda a classe. Não é possível instanciar um Contato inválido.
    public Contato(String nome, String telefone, String email) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do contato não pode ser vazio.");
        }
        if (telefone == null || !telefone.matches("\\d{10,11}")) {
            throw new IllegalArgumentException("Telefone inválido: '" + telefone + "'. Use apenas 10 ou 11 números (com DDD).");
        }

        this.nome = nome;
        this.telefone = telefone;
        this.email = email != null ? email : ""; // Email é opcional, mas evitamos null
    }

    // Getters
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }

    // Setters com validação para manter a sustentabilidade
    public void setTelefone(String telefone) {
        if (telefone == null || !telefone.matches("\\d{10,11}")) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        this.telefone = telefone;
    }

    // Sobrescrita do toString para exibir os dados de forma legível no console
    @Override
    public String toString() {
        return String.format("Contato: %s | Tel: %s | E-mail: %s", nome, telefone, email);
    }

    // equals e hashCode são essenciais em POO para comparar objetos corretamente.
    // Aqui, definimos que dois contatos são iguais se tiverem o mesmo telefone.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(telefone, contato.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefone);
    }
}