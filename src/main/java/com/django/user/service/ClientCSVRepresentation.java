package com.django.user.service;

import com.opencsv.bean.CsvBindByName;

import java.time.Instant;

public class ClientCSVRepresentation {
    @CsvBindByName(column =  "client_id")
    private String clientId;
    @CsvBindByName(column = "client_id_issued_at")
    private Instant clientIdIssuedAt;
    @CsvBindByName(column = "client_secret")
    private String clientSecret;
    @CsvBindByName(column = "client_secret_expires_at")
    private Instant clientSecretExpiresAt;
    @CsvBindByName(column = "client_name")
    private String clientName;
    @CsvBindByName(column = "client_authentication_methods")
    private String clientAuthenticationMethods;
    @CsvBindByName(column = "authorization_grant_types")
    private String authorizationGrantTypes;
    @CsvBindByName(column = "redirect_uris")
    private String redirectUris;
    @CsvBindByName(column = "post_logout_redirect_uris")
    private String postLogoutRedirectUris;
    @CsvBindByName(column = "scopes")
    private String scopes;
    @CsvBindByName(column = "ttl")
    private int ttl;
    @CsvBindByName(column = "type")
    private String type;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Instant getClientIdIssuedAt() {
        return clientIdIssuedAt;
    }

    public void setClientIdIssuedAt(Instant clientIdIssuedAt) {
        this.clientIdIssuedAt = clientIdIssuedAt;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public Instant getClientSecretExpiresAt() {
        return clientSecretExpiresAt;
    }

    public void setClientSecretExpiresAt(Instant clientSecretExpiresAt) {
        this.clientSecretExpiresAt = clientSecretExpiresAt;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAuthenticationMethods() {
        return clientAuthenticationMethods;
    }

    public void setClientAuthenticationMethods(String clientAuthenticationMethods) {
        this.clientAuthenticationMethods = clientAuthenticationMethods;
    }

    public String getAuthorizationGrantTypes() {
        return authorizationGrantTypes;
    }

    public void setAuthorizationGrantTypes(String authorizationGrantTypes) {
        this.authorizationGrantTypes = authorizationGrantTypes;
    }

    public String getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    public String getPostLogoutRedirectUris() {
        return postLogoutRedirectUris;
    }

    public void setPostLogoutRedirectUris(String postLogoutRedirectUris) {
        this.postLogoutRedirectUris = postLogoutRedirectUris;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
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
}
