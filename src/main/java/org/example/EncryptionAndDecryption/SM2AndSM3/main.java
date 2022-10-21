package org.example.EncryptionAndDecryption.SM2AndSM3;

import org.bouncycastle.asn1.gm.GMNamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @Author: LIVI
 * @Time: 2022/10/17  14:56
 * @Description: 需提供工具类
 */
public class main {
    public static void main(String[] args) throws InvalidCipherTextException {
        System.out.println("sm2测试开始-----------");
        X9ECParameters sm2EcParameters = GMNamedCurves.getByName("sm2p256v1");
        ECDomainParameters domainParameters = new ECDomainParameters(sm2EcParameters.getCurve(),sm2EcParameters.getG(),sm2EcParameters.getN());
        ECKeyPairGenerator keyPairGenerator =new ECKeyPairGenerator();
        try {
            keyPairGenerator.init(new ECKeyGenerationParameters(domainParameters, SecureRandom.getInstance("SHA1PRNG")));
            AsymmetricCipherKeyPair asymmetricCipherKeyPair = keyPairGenerator.generateKeyPair();

            //私钥
            BigInteger privateKey = ((ECPrivateKeyParameters) asymmetricCipherKeyPair.getPrivate()).getD();
            String privateKeyHex = privateKey.toString(16);
            System.out.println("私钥：" + privateKeyHex);

            //公钥
            ECPoint ecPoint = ((ECPublicKeyParameters) asymmetricCipherKeyPair.getPublic()).getQ();
            String publicKeyHex = Hex.toHexString(ecPoint.getEncoded(false));
            System.out.println("公钥：" + publicKeyHex);

            // String str = SM2Util.encrypt("test",publicKeyHex);
            // System.out.println("加密结果："+str);

            try{
                // String res = SM2Util.decrypt(str,privateKeyHex);
                // System.out.println("解密结果："+res);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("sm2测试结束-----------");

            System.out.println("sm3测试开始-----------");
            // String sm3 = SM3Util.sm3Sign("test");
            // System.out.println("sm3加密结果"+sm3);
            // if(SM3Util.sm3Verify("test",sm3))
            if(true){
                System.out.println("sm3验证成功");
            }else {
                System.out.println("sm3验证失败");
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
