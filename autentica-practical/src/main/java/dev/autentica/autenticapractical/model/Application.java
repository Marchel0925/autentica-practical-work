package dev.autentica.autenticapractical.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applications")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Application {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "description")
        private String description;

        @Column(name = "status")
        private String status;

        @Column(name = "email")
        private String email;

        @Column(name = "created")
        private Long created;

        @Column(name = "needed_till")
        private Long neededTill;

        @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "technology_id")
        private Technology technology;

}
