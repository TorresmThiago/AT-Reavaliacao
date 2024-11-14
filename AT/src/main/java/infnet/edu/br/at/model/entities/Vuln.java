package infnet.edu.br.at.model.entities;

import infnet.edu.br.at.model.enums.OwaspTop10Enum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vuln {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(length = 10000)
    private String description;
    @Column(length = 10000)
    private String remediation;

    private OwaspTop10Enum owaspTop10;

    private float scoreCVSS;

    private int CWE;

    private String affectedItem;

    private String reference;

    @ManyToOne
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;
}
