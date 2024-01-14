package com.django.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;


@Entity
public class Client extends BaseId  {
    private String clientId;
    private Instant clientIdIssuedAt;
    private String clientSecret;
    private Instant clientSecretExpiresAt;
    private String clientName;
    private String clientAuthenticationMethods;
    private String authorizationGrantTypes;
    private String redirectUris;
    private String postLogoutRedirectUris;
    private String scopes;
    @OneToOne(mappedBy = "client")
    private ClientTokenSettings tokenSettings;

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

    public ClientTokenSettings getTokenSettings() {
        return tokenSettings;
    }

    public void setTokenSettings(ClientTokenSettings tokenSettings) {
        this.tokenSettings = tokenSettings;
    }

    public static RegisteredClient fromClient(Client client){
        return RegisteredClient.withId(String.valueOf(client.getId()))
                .clientId(client.getClientId())
                .clientSecret(client.getClientSecret())
                .clientAuthenticationMethods(authenticationMethod(client.getClientAuthenticationMethods()))
                .authorizationGrantTypes(authorizationGrantType(client.getAuthorizationGrantTypes()))
                .redirectUris(redirectUris(client.getRedirectUris()))
                .tokenSettings(settings(client.getTokenSettings()))
                .build();
    }


    public static Consumer<Set<ClientAuthenticationMethod>> authenticationMethod(String value){
        return s ->Arrays.stream(value.split(",")).map(method -> new ClientAuthenticationMethod(method)).collect(Collectors.toUnmodifiableSet());
    }
    public static Consumer<Set<AuthorizationGrantType>> authorizationGrantType(String value){
        return s ->Arrays.stream(value.split(",")).map(method -> new AuthorizationGrantType(method)).collect(Collectors.toUnmodifiableSet());
    }
    public static Consumer<Set<String>> redirectUris(String value){
        return s ->Arrays.stream(value.split(",")).collect(Collectors.toUnmodifiableSet());
    }
    public static TokenSettings settings(ClientTokenSettings setting){
        return TokenSettings.builder()
                .accessTokenTimeToLive(Duration.ofHours(setting.getTtl()))
                .accessTokenFormat(new OAuth2TokenFormat(setting.getType())).build();
    }

}
