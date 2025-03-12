# Authentication

Access Control breaks down into two steps:

1. **Authentication**: Verify the identity of the user. (Log in)
2. **Authorization**: Verify if the user has permission to access the resource.

**Como podemos fazer isto em cloud de maneira mais escalável e segura?**

**Cookie:** A cookie is a small piece of key value stored text that our browser will automatically manage between the client and the server in order to keep STATE. Servers wanna push as many things as possible to the client to keep the stateless nature of the server. So each client will send key value stores as text into the server.
One cookie that we can keep is a session identifier.
Server will send a session identifier on the first request, and the client will need to send it back.

We don't want to be so worried about the cookies as devs.

RequestFilter can be used in order to do this, and use TheadLocal Storage in order to store the information.

We have to add it to the list of resources in the web application

latter we can create an authentication class that will handle our authentication logic.

we are going to grab the cookie, and validate the session with the name of the expected user.

If the clear is null then we have no session, if there is a cookie we can look in the STORAGE cache (in our project is Redis cache) and check is we get a session based on the cookie given. If redis doesn't have the session we can return a 401 unauthorized. If we have a session but for some reason there is no user associated with the session (anonymous, meaning we have a session but the user is not yet logged in) we can return a 401 unauthorized. 

> The fact that we have an anonymous session is a privacy nightmare, because if we later log in all the actions that we did before will be associated with the user, even though a regular user thinks because he is not logged in, he is not being tracked. **This is a privacy problem.**

**New your times has a cookie called free articles, and this can be manipulated to keep using the free trial.**

IF WE CANNOT FIND A REASON TO REJECT, WE ACCEPT.

deploy tomcat, 

**O CÓDIGO ESTÁ COM ERRO NO POM FILE, NO TOMCAT7 PLUGIN, FALTA O USERNAME:maven E PASSWORD:s3cret**

only authenticated users should be able to upload and download blobs.

podemos dar download de um blob que não é nosso, mas o upload só é possível se for o user.

only authenticated 'admin' users should be able to delete blobs.

a cookie que o user fornece está guardada na Thread Local Storage.

Na cache está o que nós sabemos que nós criámos.
Quando recebemos a chave da sessão, vamos à cache e vemos se temos uma sessão com essa chave.