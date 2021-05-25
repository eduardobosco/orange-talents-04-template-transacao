package com.ot4.transacoes.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ot4.transacoes.cartao.TransactionCardResponse;
import com.ot4.transacoes.estabelecimento.TransactionEstablishmentResponse;

public class TransactionResponse {
    private long id;
    private String transactionNumber;
    private BigDecimal value;
    private TransactionEstablishmentResponse establishment;
    private TransactionCardResponse card;
    private LocalDateTime effectiveOn;

    public TransactionResponse(Transaction transaction) {
        this.transactionNumber = transaction.getTransactionNumber();
        this.value = transaction.getValue();
        this.establishment = new TransactionEstablishmentResponse(transaction.getEstablishment());
        this.card = new TransactionCardResponse(transaction.getCard());
        this.effectiveOn = transaction.getEffectiveOn();
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

    public TransactionEstablishmentResponse getEstablishment() {
        return establishment;
    }

    public TransactionCardResponse getCard() {
        return card;
    }

    public LocalDateTime getEffectiveOn() {
        return effectiveOn;
    }

}
