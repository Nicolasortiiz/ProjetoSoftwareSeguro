package model;

public class Vaquinha {
    private int idVaquinha;
    private int idUsuario;
    private String nomeVaquinha;
    private String descricao;
    private float valorMeta;
    private float valorArrecadado;
    private String data;

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

    public int getIdVaquinha() {
        return idVaquinha;
    }

    public void setIdVaquinha(int idVaquinha) {
        this.idVaquinha = idVaquinha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

}
