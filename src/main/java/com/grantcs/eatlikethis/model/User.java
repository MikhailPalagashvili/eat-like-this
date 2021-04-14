package com.grantcs.eatlikethis.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity<String> {

}
