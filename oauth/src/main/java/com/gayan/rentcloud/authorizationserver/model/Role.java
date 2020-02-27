package com.gayan.rentcloud.authorizationserver.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Gayan Samuditha
 * @created 27/02/2020 - 1:14 AM
 */

@Entity
@Table(name = "role")
@Data
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_role", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private List<Permission> permissions;
}
