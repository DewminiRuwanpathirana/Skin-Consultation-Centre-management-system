//Reference: https://youtu.be/nzUealgF0hs
//Creating a class called Encryption for the user input encryption
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

class Encryption {
    //creating method for generate secret key
    public static SecretKey generateKey(String encryptionType){
        try{
            KeyGenerator generator = KeyGenerator.getInstance(encryptionType);
            SecretKey myKey = generator.generateKey();
            return myKey;
        }catch (Exception e){
            return null;
        }
    }

    //creating a method for encryption
    public static byte[] encryptString(String textoEncrypt, SecretKey myKey, Cipher cipher){
        try {
            byte[] text = textoEncrypt.getBytes(StandardCharsets.UTF_8);
            cipher.init(Cipher.ENCRYPT_MODE,myKey);
            byte[] textEncrypted = cipher.doFinal(text);
            return textEncrypted;
        }catch (Exception e){
            return null;
        }
    }

    //creating a method for decryption
    public static String decryptData(byte[] dataToDecrypt,SecretKey myKey,Cipher cipher){
        try {
            cipher.init(Cipher.DECRYPT_MODE,myKey);
            byte[] textDecrypted = cipher.doFinal(dataToDecrypt);
            String result = new String(textDecrypted);

            return result;
        }catch (Exception e ){
            System.out.println(e);
            return null;
        }
    }
}
