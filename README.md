**grant type**
- authorization_code
- refresh_token
- client_credentials
- jwt_bearer

**scopes**
- openid
- read
- write
**client authentication method**
- client_secret_basic
- client_secret_post
- client_secret_jwt
- private_key_jwt
- none

**token settings**
- ttl (hours)
- tokenFormat (reference)

**redirect  uri**
- http://127.0.0.1:8080/login/oauth2/code/myoauth2
- http://127.0.0.1:4200

**code challenge method**
- S256

http://<auth-server-host>:<auth-server-port>/.well-known/oauth-authorization-server

issuer|                  http://<auth-server-host>:<auth-server-port>
authorization endpoint|  http://<auth-server-host>:<auth-server-port>/oauth2/authorize
token endpoint|          http://<auth-server-host>:<auth-server-port>/oauth2/token
jwks uri |               http://<auth-server-host>:<auth-server-port>/oauth2/jwks
revocation-endpoint |    http://<auth-server-host>:<auth-server-port>/oauth2/revoke
introspection endpoint | http://<auth-server-host>:<auth-server-port>/oauth2/introspect

**oauth2 debugger**


**Eureka client** 
* authorization server will try to fetch registry from eureka server and cache it, fetch-registry is true by default
* authorization server will register itself with eureka server, register-with-eureka is true by default



