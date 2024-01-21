package com.django.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@Entity
@Table(name="client_token_settings")
public class ClientTokenSettings  extends BaseId{
    private int ttl;
    private String type;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public ClientTokenSettings() {
    }

    public ClientTokenSettings(int ttl, String type) {
        this.ttl = ttl;
        this.type = type;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
