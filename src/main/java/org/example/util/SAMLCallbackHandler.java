package org.example.util;

import java.io.IOException;
import java.io.StringReader;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.saml.SAMLCallback;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class SAMLCallbackHandler implements CallbackHandler {

	@SuppressWarnings("restriction")
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof SAMLCallback) {
                SAMLCallback callback = (SAMLCallback) callbacks[i];
                
                // Hand-jam SAML Assertion to simulate calling external service and inserting into DOM element.
                String assertion = "<saml:Assertion xmlns:saml=\"urn:oasis:names:tc:SAML:1.0:assertion\" AssertionID=\"AID_ASLDFKAEFIJAS\" IssueInstant=\"2017-10-19T21:00:00Z\" Issuer=\"librarian\" MajorVersion=\"1\" MinorVersion=\"1\">\n" + 
                		"  <saml:Conditions NotBefore=\"2017-10-19T20:00:00Z\" NotOnOrAfter=\"2017-10-19T22:00:00Z\"/>\n" + 
                		"  <saml:AuthenticationStatement AuthenticationInstant=\"2017-10-19T21:00:00Z\" AuthenticationMethod=\"urn:ietf:rfc:3075\">\n" + 
                		"    <saml:Subject>\n" + 
                		"      <saml:NameIdentifier Format=\"urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified\">CN=masteruser, OU=Library</saml:NameIdentifier>\n" + 
                		"      <saml:SubjectConfirmation>\n" + 
                		"        <saml:ConfirmationMethod>urn:oasis:names:tc:SAML:1.0:cm:holder-of-key</saml:ConfirmationMethod>\n" + 
                		"        <dsig:KeyInfo xmlns:dsig=\"http://www.w3.org/2000/09/xmldsig#\">\n" + 
                		"          <dsig:X509Data>\n" + 
                		"            <dsig:X509Certificate>adflkafdlk....asdlfkjalsfd</dsig:X509Certificate>\n" + 
                		"            <dsig:X509IssuerSerial>\n" + 
                		"              <dsig:X509IssuerName>CN=masteruser, OU=Library</dsig:X509IssuerName>\n" + 
                		"              <dsig:X509SerialNumber>9345872435</dsig:X509SerialNumber>\n" + 
                		"            </dsig:X509IssuerSerial>\n" + 
                		"            <dsig:X509SubjectName>CN=masteruser, OU=Library</dsig:X509SubjectName>\n" + 
                		"            <dsig:X509SKI>245782495alkdfad</dsig:X509SKI>\n" + 
                		"          </dsig:X509Data>\n" + 
                		"        </dsig:KeyInfo>\n" + 
                		"      </saml:SubjectConfirmation>\n" + 
                		"    </saml:Subject>\n" + 
                		"  </saml:AuthenticationStatement>\n" + 
                		"  <saml:AttributeStatement>\n" + 
                		"    <saml:Subject>\n" + 
                		"      <saml:NameIdentifier Format=\"urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified\">CN=masteruser, OU=Library</saml:NameIdentifier>\n" + 
                		"      <saml:SubjectConfirmation>\n" + 
                		"        <saml:ConfirmationMethod>urn:oasis:names:tc:SAML:1.0:cm:holder-of-key</saml:ConfirmationMethod>\n" + 
                		"        <dsig:KeyInfo xmlns:dsig=\"http://www.w3.org/2000/09/xmldsig#\">\n" + 
                		"          <dsig:X509Data>\n" + 
                		"            <dsig:X509Certificate>adflkafdlk....asdlfkjalsfd</dsig:X509Certificate>\n" + 
                		"            <dsig:X509IssuerSerial>\n" + 
                		"              <dsig:X509IssuerName>CN=masteruser, OU=Library</dsig:X509IssuerName>\n" + 
                		"              <dsig:X509SerialNumber>9345872435</dsig:X509SerialNumber>\n" + 
                		"            </dsig:X509IssuerSerial>\n" + 
                		"            <dsig:X509SubjectName>CN=masteruser, OU=Library</dsig:X509SubjectName>\n" + 
                		"            <dsig:X509SKI>245782495alkdfad</dsig:X509SKI>\n" + 
                		"          </dsig:X509Data>\n" + 
                		"        </dsig:KeyInfo>\n" + 
                		"      </saml:SubjectConfirmation>\n" + 
                		"    </saml:Subject>\n" + 
                		"    <saml:Attribute AttributeName=\"dn\" AttributeNamespace=\"http://www.example.org/saml/2000/01/attributes\">\n" + 
                		"      <saml:AttributeValue>uid=masteruser, ou=Library</saml:AttributeValue>\n" + 
                		"    </saml:Attribute>\n" + 
                		"  </saml:AttributeStatement>\n" + 
                		"  <dsig:Signature xmlns:dsig=\"http://www.w3.org/2000/09/xmldsig#\">\n" + 
                		"    <dsig:SignedInfo>\n" + 
                		"      <dsig:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/>\n" + 
                		"      <dsig:SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>\n" + 
                		"      <dsig:Reference URI=\"#AID_ASLDFKAEFIJAS\">\n" + 
                		"        <dsig:Transforms>\n" + 
                		"          <dsig:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>\n" + 
                		"          <dsig:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/>\n" + 
                		"        </dsig:Transforms>\n" + 
                		"        <dsig:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>\n" + 
                		"        <dsig:DigestValue>P235423ADF92485FD=</dsig:DigestValue>\n" + 
                		"      </dsig:Reference>\n" + 
                		"    </dsig:SignedInfo>\n" + 
                		"    <dsig:SignatureValue>ADSLFJ923482LIJF4984FJ</dsig:SignatureValue>\n" + 
                		"    <dsig:KeyInfo>\n" + 
                		"      <dsig:X509Data>\n" + 
                		"        <dsig:X509Certificate>MISDCKLMWEIJ2938J892</dsig:X509Certificate>\n" + 
                		"        <dsig:X509IssuerSerial>\n" + 
                		"          <dsig:X509IssuerName>UID=librarian, OU=Faculty, O=School</dsig:X509IssuerName>\n" + 
                		"          <dsig:X509SerialNumber>34604983059</dsig:X509SerialNumber>\n" + 
                		"        </dsig:X509IssuerSerial>\n" + 
                		"        <dsig:X509SubjectName>UID=librarian, OU=Faculty, O=School</dsig:X509SubjectName>\n" + 
                		"        <dsig:X509SKI>f/209aldfj209rjf29</dsig:X509SKI>\n" + 
                		"      </dsig:X509Data>\n" + 
                		"    </dsig:KeyInfo>\n" + 
                		"  </dsig:Signature>\n" + 
                		"</saml:Assertion>";
                              
                try {
                    DOMParser domParser = new DOMParser();
					domParser.parse(new InputSource(new StringReader(assertion)));
					
	                callback.setAssertionElement(domParser.getDocument().getDocumentElement());
	                
				} 
                catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
	}

//    protected KeyInfoBean createKeyInfo() throws Exception {
//        Crypto crypto =  CryptoFactory.getInstance("client_sign.properties");
//        CryptoType cryptoType = new CryptoType(CryptoType.TYPE.ALIAS);
//        cryptoType.setAlias("selfsigned");
//        X509Certificate[] certs = crypto.getX509Certificates(cryptoType);
//
//        KeyInfoBean keyInfo = new KeyInfoBean();
//        keyInfo.setCertificate(certs[0]);
//        keyInfo.setCertIdentifer(CERT_IDENTIFIER.X509_CERT);
//
//        return keyInfo;
//    }
}