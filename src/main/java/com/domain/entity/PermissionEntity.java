package com.domain.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permission")
public class PermissionEntity {

    @Id
    @Column(name = "permission_key", length = 50)
    private String permissionKey;

    @Column(name = "description", length = 100)
    private String description;
}
