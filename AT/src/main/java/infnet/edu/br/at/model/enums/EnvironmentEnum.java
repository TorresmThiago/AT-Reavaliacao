package infnet.edu.br.at.model.enums;

import lombok.Getter;

@Getter
public enum EnvironmentEnum {
    HOMOLOG("Homologação"),
    DEVELOPMENT("Desenvolvimento"),
    PRODUCTION("Produção");

    private final String description;

    EnvironmentEnum(String description) {
        this.description = description;
    }

}
