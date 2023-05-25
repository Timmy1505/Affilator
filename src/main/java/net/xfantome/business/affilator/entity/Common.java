package net.xfantome.business.affilator.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@MappedSuperclass
@Data
public abstract class Common implements Serializable {
    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updatedAt;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdAt;

    @Column
    private boolean deleted;

    public Common() {
        id();
    }

    @PrePersist
    public void prePersist() {
        id();
        setCreatedAt(LocalDateTime.now());
    }

    private void id() {
        if (id == null) {
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }

    @PreUpdate
    public void preUpdate() {
        setUpdatedAt(LocalDateTime.now());
    }
}
