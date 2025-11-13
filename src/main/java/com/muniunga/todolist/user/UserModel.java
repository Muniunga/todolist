package com.muniunga.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_users")
public class UserModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

//  Entende que os nomes das colunas no banco de dados serão os que estão abaixo mas caso eu queira mudar posso usar @Column(name = "nome_da_coluna")


// a Anontação @Column serve para definir características específicas para a coluna no banco de dados
//a propriedade unique faz com que não haja dois usuários com o mesmo username no banco de dados
//a propriedade nullable define se o campo pode ser nulo ou não
    @Column(unique = true, nullable = false)
    private String username;
    private String name;
    private String password;

    // Anotacão para definir que esse campo será preenchido automaticamente com a data e hora de criação do registro
    @CreationTimestamp
    private LocalDateTime createdAt;

}
