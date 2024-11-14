package infnet.edu.br.at.model.enums;

import lombok.Getter;

@Getter
public enum DemandEnum {
    BLACK_BOX("Análise Black Box"),
    GRAY_BOX("Análise Gray Box"),
    WHITE_BOX("Análise White Box"),
    RETEST("Reteste");

    private final String description;

    DemandEnum(String description) {
        this.description = description;
    }

}
