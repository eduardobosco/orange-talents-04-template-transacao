package com.ot4.transacoes.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ot4.transacoes.cartao.TransactionCard;
import com.ot4.transacoes.estabelecimento.TransactionEstablishment;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String transactionNumber;

    @NotNull
    private BigDecimal value;

    @Embedded
    @NotNull
    private TransactionEstablishment establishment;

    @Embedded
    @NotNull
    private TransactionCard card;

    @NotNull
    private LocalDateTime effectiveOn;

    @Deprecated
    public Transaction() {
    }

    public Transaction(
            @NotBlank String transactionNumber,
            @NotNull BigDecimal value,
            @NotNull TransactionEstablishment establishment,
            @NotNull TransactionCard card,
            @NotNull String effectiveOn
    ) {
        this.transactionNumber = transactionNumber;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.effectiveOn = LocalDateTime.parse(effectiveOn);
    }

    public long getId() {
        return id;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public BigDecimal getValue() {
        return value;
    }

    public TransactionEstablishment getEstablishment() {
        return establishment;
    }

    public TransactionCard getCard() {
        return card;
    }

    public LocalDateTime getEffectiveOn() {
        return effectiveOn;
    }
}
