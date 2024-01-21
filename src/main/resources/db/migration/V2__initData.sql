insert into client_token_settings(ttl,type) values(2,'reference');
insert into clients(client_id, client_id_issued_at,client_secret, client_name,client_authentication_methods,authorization_grant_types,redirect_uris,scopes,token_settings_id)
values('clientid-1',NOW(), 'client-1-secret-1','client-1' ,'client_secret_basic','authorization_code','http://127.0.0.1:4200','openid',1);