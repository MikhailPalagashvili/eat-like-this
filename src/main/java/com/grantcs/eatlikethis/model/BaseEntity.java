package com.grantcs.eatlikethis.model;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/*
createdAt: The timestamp when the row was inserted in the database
createdBy: The current logged-in user(s) who triggered the insertion of this row
lastModifiedAt: The timestamp of the last update of this row
lastModifiedBy: The current logged-in user(s) who triggered the last update

AuditingEntityListener uses callback methods annotated with PrePersist and PreUpdate
to persist and update the following four fields
 */
@MappedSuperclass
@Getter
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity<U> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = this.lastModifiedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void setLastModifiedAt() {
        this.lastModifiedAt = LocalDateTime.now();
    }
}
