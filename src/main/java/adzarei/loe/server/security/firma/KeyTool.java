package adzarei.loe.server.security.firma;

import lombok.AllArgsConstructor;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import sun.security.tools.keytool.CertAndKeyGen;
import sun.security.x509.X500Name;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateCrtKey;
import java.util.Date;

@AllArgsConstructor
public class KeyTool {

    private static final int keysize = 1024;
    private static final String commonName = "Loe-Server";
    private static final String organizationalUnit = "IT";
    private static final String organization = "APP LOE";
    private static final String city = "Valencia";
    private static final String state = "Valencia";
    private static final String country = "ES";
    private static final long validity = 1096; // 3 years
    private static final String alias = "loe-server";
    private static final char[] keyPass = "password".toCharArray();
    //private static final char[] keyStorePass = "password".toCharArray();



    public void generateCertificate() throws Exception {

        //We Create a new KeyStore.
        //KeyStore keyStore = KeyStore.getInstance("JKS");
        KeyStore keyStore = KeyStore.getInstance("pkcs12");
        keyStore.load(null, keyPass); // No pwd.


        CertAndKeyGen keypair = new CertAndKeyGen("RSA", "SHA1WithRSA", null);
        X500Name x500Name = new X500Name(commonName, organizationalUnit, organization, city, state, country);
        keypair.generate(keysize);
        PrivateKey privKey = keypair.getPrivateKey();
        X509Certificate[] chain = new X509Certificate[1];
        chain[0] = keypair.getSelfCertificate(x500Name, new Date(), (long) validity * 24 * 60 * 60);
        keyStore.setKeyEntry(alias, privKey, keyPass, chain);

        //We Save the KeyStore to the file system
        keyStore.store(new FileOutputStream("MyKeyStore.jks"), keyPass);





        X509Certificate certificate = (X509Certificate) keyStore.getCertificate("loe-server");
        RSAPrivateCrtKey pKey = (RSAPrivateCrtKey) keyStore.getKey("loe-server","password".toCharArray());

        RSAPrivateCrtKeyParameters caPrivateKey = new RSAPrivateCrtKeyParameters(pKey.getModulus(), pKey.getPublicExponent(), pKey.getPrivateExponent(),
                pKey.getPrimeP(), pKey.getPrimeQ(), pKey.getPrimeExponentP(), pKey.getPrimeExponentQ(), pKey.getCrtCoefficient());


        System.out.println(certificate.getSerialNumber().toString());

        //System.out.println(key.toString());


    }


}
