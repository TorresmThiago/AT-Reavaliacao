package infnet.edu.br.at.model.enums;

import lombok.Getter;

@Getter
public enum OwaspTop10Enum {
    A1("A01:2021 - Quebra de Controle de Acesso"),
    A2("A02:2021 - Falhas Criptográficas"),
    A3("A03:2021 - Injeção"),
    A4("A04:2021 - Design Inseguro"),
    A5("A05:2021 - Configuração Insegura"),
    A6("A06:2021 - Componente Desatualizado e Vulnerável"),
    A7("A07:2021 - Falha de Identificação e Autenticação"),
    A8("A08:2021 - Falha na Integridade de Dados e Software"),
    A9("A09:2021 - Monitoramento de Falhas e Registros de Segurança"),
    A10("A010:2021 - Falsificação de Solicitação do Lado do Servidor");

    private final String description;

    OwaspTop10Enum(String description) {
        this.description = description;
    }

}
