package com.gayan.rentcloud.authorizationserver.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Gayan Samuditha
 * @created 27/02/2020 - 1:14 AM
 */

@Entity
@Table(name = "permission")
@Data
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
}
