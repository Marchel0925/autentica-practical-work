package dev.autentica.autenticapractical.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "technologies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "ram")
    private Integer ram;

    @Column(name = "cores")
    private Integer cores;

    @Column(name = "motherboard")
    private String motherboard;

    @Column(name = "gpu")
    private String gpu;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "technology")
    private Application application;
}
