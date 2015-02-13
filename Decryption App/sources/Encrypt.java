/****************************************************************************
    Encryption Tool : A set of applications to encrypt or decrypt the file on the basis of the application authorization.
    Copyright (C) 2012  Anubhav Arun <dr.xperience@gmail.com>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

*****************************************************************************/

/** *********************************************************************************
 * TITLE        : THE CLASS TO ENCRYPT AND DECRYPT THE FILE AND TO CREATE ENCRYPTION AND DECRYPTION KEY
 * AUTHOR       : RK10R04A01;11000527;ANUBHAV ARUN GUPTA
 * DATE/TIME    : AD 2012.11.16.20.59
 * EDITOR       : VIM
 * JAVA VERSION : 1.6.0_22
 * JRE          : OpenJDK Runtime Environment (IcedTea6 1.10.3) (fedora-59.1.10.3.fc16-x86_64)
 * VERSION      : $Id: Encrypt.java,v 1.10 2012/11/22 09:12:42 Dr.Xperience Exp Dr.Xperience $
 * *********************************************************************************** */
import java.io.*;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.NoSuchAlgorithmException;
//import java.security.PrivateKey;
//import java.security.PublicKey;

import java.security.*;
import javax.crypto.Cipher;

public class Encrypt
{
  FileInputStream vInFile;
  FileOutputStream vOutFile;


 /**
  * String to hold name of the encryption algorithm.
  */
  public static final String ALGORITHM = "RSA";

  /**
   * String to hold the name of the private key file.
   */

  public static final String PRIVATE_KEY_FILE = "private.key";

  /**
   * String to hold name of the public key file.
   */
  public static final String PUBLIC_KEY_FILE = "public.key";

  /**
  * Generate key which contains a pair of private and public key using 1024
  * bytes. Store the set of keys in Prvate.key and Public.key files.
  *
  * @throws NoSuchAlgorithmException
  * @throws IOException
  * @throws FileNotFoundException
  */
  public void generateKey ()
  {
    try
    {
      if (areKeysPresent (3))
	{
	  //throw new Exception ("Keys Not Present");
	  return;
}
      final KeyPairGenerator vKeyGen =
	KeyPairGenerator.getInstance (ALGORITHM);
        vKeyGen.initialize (1024);
      final KeyPair vKeyPair = vKeyGen.generateKeyPair ();

      File vPrivateKeyFile = new File (PRIVATE_KEY_FILE);
      File vPublicKeyFile = new File (PUBLIC_KEY_FILE);

        vPrivateKeyFile.createNewFile ();

        vPublicKeyFile.createNewFile ();

      ObjectOutputStream vPublicKeyOS =
	new ObjectOutputStream (new FileOutputStream (vPublicKeyFile));
        vPublicKeyOS.writeObject (vKeyPair.getPublic ());
        vPublicKeyOS.close ();

      ObjectOutputStream vPrivateKeyOS =
	new ObjectOutputStream (new FileOutputStream (vPrivateKeyFile));
        vPrivateKeyOS.writeObject (vKeyPair.getPrivate ());
        vPrivateKeyOS.close ();
    } catch (Exception e)
    {
      e.printStackTrace ();
    }

  }

  /**
 *    * The method checks if the pair of public and private key has been generated.
 *       *
 *          * @return flag indicating if the pair of keys were generated.
 *             */
  public boolean areKeysPresent (int i)
  {
if( i ==0 )
{
    File vPrivateKey = new File (PRIVATE_KEY_FILE);
    if (vPrivateKey.exists () )
      {
	return true;
      }
    return false;
}
else if( i==1)
{
    File vPublicKey = new File (PUBLIC_KEY_FILE);

    if (vPublicKey.exists ())
      {
	return true;
      }
    return false;
}
else
{
    File vPrivateKey = new File (PRIVATE_KEY_FILE);
    File vPublicKey = new File (PUBLIC_KEY_FILE);

    if (vPublicKey.exists ()&&vPrivateKey.exists())
      {
	return true;
      }
    return false;


}

}
  public void encrypt (File inFile, File outFile)
  {
    try
    {
      if (!areKeysPresent (1))
	{
	  throw new Exception ("Keys Not Present");
	}
      ObjectInputStream vInputStream =
	new ObjectInputStream (new FileInputStream (PUBLIC_KEY_FILE));

      final PublicKey vPublicKey = (PublicKey) vInputStream.readObject ();

      vInputStream.close ();
      final Cipher vCipher = Cipher.getInstance (ALGORITHM);
      vCipher.init (Cipher.ENCRYPT_MODE, vPublicKey);

      vInFile = new FileInputStream (inFile);
      vOutFile = new FileOutputStream (outFile);

      byte[] vInput = new byte[100];
      int bytesRead;
      while ((bytesRead = vInFile.read (vInput,0,100)) != -1)
	{
	  byte[] vOutput = vCipher.doFinal (vInput, 0, bytesRead);
	  if (vOutput != null)
	    vOutFile.write (vOutput);
	}
      vInFile.read(vInput);
      byte[] vOutput = vCipher.doFinal (vInput);
      if (vOutput != null)
	vOutFile.write (vOutput);

      vInFile.close ();
      vOutFile.flush ();
      vOutFile.close ();
    }
    catch (Exception e)
    {
      e.printStackTrace ();
    }
  }


  public void decrypt (File inFile, File outFile)
  {
    try
    {
      if (!areKeysPresent (0))
	{
	  throw new  Exception ("Keys Not Present");
	}
      ObjectInputStream vInputStream =
	new ObjectInputStream (new FileInputStream (PRIVATE_KEY_FILE));

      final PrivateKey vPrivateKey = (PrivateKey) vInputStream.readObject ();

      vInputStream.close ();
      // get an RSA cipher object and print the provider
      final Cipher vCipher = Cipher.getInstance (ALGORITHM);
      // encrypt the plain text using the public key
      vCipher.init (Cipher.DECRYPT_MODE, vPrivateKey);

      vInFile = new FileInputStream (inFile);
      vOutFile = new FileOutputStream (outFile);

      byte vInput[] = new byte[128];
      int bytesRead;
      while ((bytesRead = vInFile.read(vInput,0,128)) != -1)
	{
	  byte vOutput[] = vCipher.doFinal(vInput, 0, 128);
	  if (vOutput != null)
	    vOutFile.write (vOutput);
	}

      byte vOutput[] = vCipher.doFinal (vInput);
      if (vOutput != null)
	vOutFile.write (vOutput);

      vInFile.close ();
      vOutFile.flush ();
      vOutFile.close ();
    }
    catch (Exception e)
    {
      e.printStackTrace ();
    }
  }
}
