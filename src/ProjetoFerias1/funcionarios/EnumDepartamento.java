package funcionarios;

public enum EnumDepartamento implements StringValueEnum{
    DEPARTAMENTO1("DEPARTAMENTO1","Administrativo"),
    DEPARTAMENTO2("DEPARTAMENTO2","Financeiro"),
    DEPARTAMENTO3("DEPARTAMENTO3","Comercial"),
    DEPARTAMENTO4("DEPARTAMENTO4","Recursos Humanos"),
    DEPARTAMENTO5("DEPARTAMENTO5","Operacional");

    private final String value;
    private final String displayName;

    EnumDepartamento(String departamento, String tipo) {
        this.value = departamento;
        this.displayName = tipo;
    }


    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }
}
