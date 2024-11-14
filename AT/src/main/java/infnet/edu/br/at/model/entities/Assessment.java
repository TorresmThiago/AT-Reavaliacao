package infnet.edu.br.at.model.entities;

import infnet.edu.br.at.model.enums.DemandEnum;
import infnet.edu.br.at.model.enums.EnvironmentEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private String client;

    @DateTimeFormat(pattern = "ddMMyyyy")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "ddMMyyyy")
    private LocalDate endDate;

    private EnvironmentEnum environment;

    private DemandEnum demand;

    private String URL;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vuln> vulns = new ArrayList<>();
}
