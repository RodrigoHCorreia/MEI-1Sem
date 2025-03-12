# Aula Prática 8

N queremos static configurations (como tinhamos no primeiro trabalho com um configFile.txt)

Digamos que o client quer se autenticar no servidor,

ver etc. files do linux para guardar passwords.

Só temos de ter o signal da autoridade que confiamos. Desta maneira chega enviar a chave pública do cliente para o servidor, e o servidor verifica se a chave pública é válida, tendo somente o certificado da autoridade que confiamos.

Rest request para fazer a autenticação ou usando sockets mandando msg. 
**USAR REST PORQUE TENHO MAIS CONHECIMENTO**

Nos docs do telemovel está o diagrama complexo de autenticação de um exemplo para o segundo trabalho. 

Neste lab vamos ver como fazer cada peça individual, depois no trabalho é juntar tudo.

Meter:

Cipher.getInstance("DESede/CBC/PKCS7Padding", "BC") - para usar o Bouncy Castle (BC), temos é de lhe passar a biblioteca.


PBE - Password Based Encryption Scheme.

lab 3 tem exemplos de PBEncryption

WITH PARAMETERS: meto a password, obtenho o keyspec, depois meto o salt e o iteration count, e obtenho a key.

PBEOtherExample, mais seguro.

**Tem um algoritmo de encriptação, e um algoritmo de hashing.**

meter a biblioteca do bcprov diretamente no comando do java.

Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

**Vir ao próximo lab de segurança.**

Lab 3 Public Key Encryption

No sense to talk about modes in asymmetric encryption.

encriptar com public key - estamos a falar de algo que só o rapaz é suposto conseguir desencriptar.
quando encriptamos com private key é para provar autenticação que fomos mesmo nós que encriptamos.

só conseguimos encriptar coisas com RSA, se as coisas que estamos a encriptar forem mais pequenas ou iguais ao tamanho da chave.
Por isso usamos symetric key para encriptar algo maior e depois a chave simétrica encriptamos com a chave pública.