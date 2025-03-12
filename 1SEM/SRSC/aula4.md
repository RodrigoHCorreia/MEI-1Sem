# Encryption librarys etc.

**Symmetric Crypto and Asymmetric Crypto** to solve **encryption problems**
**Digital signature constructions** for **digital signature** (based on asymmetric crypto)
**Sec. Hash Functions, HMACs or CMACs** for **data integrity**
**Authentication and Key Distribution Protocols** For **authentication exchange**

novo TLS só usa AES w/ GCM, porque é o mais seguro

**AES w/GCM**

SM = (Signature || SE (Secure Envelop) || Encrypted(M) || MessageIntegrityProof

Signature: AsymPrypto KprivA (SecureHash (X || Padding))
SE (Secure Envoelope for key K1 and K2 Distribution): AsymCrypto KpubB (k1,k2)
EncryptedM: SymCrypto k (M)
Message IntegrityProof: HMAC k2 (X)
