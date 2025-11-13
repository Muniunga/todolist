package com.muniunga.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

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
    private String username;
    private String name;
    private String password;

    // Anotacão para definir que esse campo será preenchido automaticamente com a data e hora de criação do registro
    @CreationTimestamp
    private LocalDateTime createdAt;

}
