package com.eltonfernandesdev.library_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EmprestimoRequestDTO {

    @NotNull(message = "O valor é obrigatório")
    @Positive
    private BigDecimal valor;
    @NotNull(message = "Informação obrigatória")
    private boolean devolvido;
    @NotNull(message = "Informação sobre pagamento é obrigatória")
    private boolean pago;
    @NotNull(message = "O id do livro é obrigatório")
    @Positive
    private Long idLivro;
    @NotNull(message = "O id do cliente é obrigatório")
    @Positive
    private Long idCliente;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
