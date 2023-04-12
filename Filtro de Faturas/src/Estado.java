public class Estado {
    String sigla;
    Regiao regiao;
    public Estado(String sigla) {
        this.sigla = sigla;
        if (sigla == null) {
            throw new IllegalArgumentException();
        }
        if (sigla.equals("")) {
            throw new IllegalArgumentException();
        }

        switch (sigla) {
            case "MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA" -> {
                this.regiao = Regiao.NORDESTE;
            }
            case "AM", "RR", "AP", "PA", "TO", "RO", "AC" -> {
                this.regiao = Regiao.NORTE;
            }
            case "MT", "MS", "GO" -> {
                this.regiao = Regiao.CENTRO_OESTE;
            }
            case "SP", "RJ", "ES", "MG" -> {
                this.regiao = Regiao.SUDESTE;
            }
            case "PR", "RS", "SC" -> {
                this.regiao = Regiao.SUL;
            }
            default -> {
                throw new IllegalArgumentException();
            }

        }
    }
}
