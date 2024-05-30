package model;

public class Vaquinha {
    private String nomeVaquinha;
    private String descricao;
    private float valorMeta;
    private float valorArrecadado;
    private String data;
    private String nomeUsuario;

    public Vaquinha(String nomeVaquinha, String descricao, float valorMeta){
        this.nomeVaquinha = nomeVaquinha;
        this.descricao = descricao;
        this.valorMeta = valorMeta;
    }

    public String getNomeVaquinha() {
        return nomeVaquinha;
    }

    public void setNomeVaquinha(String nomeVaquinha) {
        this.nomeVaquinha = nomeVaquinha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorMeta() {
        return valorMeta;
    }

    public void setValorMeta(float valorMeta) {
        this.valorMeta = valorMeta;
    }

    public float getValorArrecadado() {
        return valorArrecadado;
    }

    public void setValorArrecadado(float valorArrecadado) {
        this.valorArrecadado = valorArrecadado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
