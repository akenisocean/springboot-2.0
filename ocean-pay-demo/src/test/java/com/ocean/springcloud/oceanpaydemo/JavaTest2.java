package com.ocean.springcloud.oceanpaydemo;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

import java.util.HashMap;

/**
 * @author chao
 * @version 1.0
 * @desc java测试
 * @date 2019年09月15日 11:51
 */
public class JavaTest2 {
    public static void main(String[] args) {


        HashMap<String, String> map = new HashMap<>();
        map.put("alipay_trade_pay_response","{\"alipay_trade_pay_response\":{\"code\":\"10003\",\"msg\":\" order success pay inprocess\",\"buyer_logon_id\":\"186******90\",\"buyer_pay_amount\":\"0.00\",\"buyer_user_id\":\"2088702308530404\",\"invoice_amount\":\"0.00\",\"out_trade_no\":\"UPY1909200001119\",\"point_amount\":\"0.00\",\"receipt_amount\":\"0.00\",\"total_amount\":\"0.01\",\"trade_no\":\"2019092022001430400595768073\"},\"sign\":\"CwGtblVzC0J96npDXLBLOeZs0cVTitbNnXAvwWW2lPfl09euh9sXoVOUai2zsm2Q4NmTlAH1OC+1TfT5z/1gg1IhVkTR7KtJl/jqp7lsCcCk2X1JmpLpFoi2c40nhgLVEwftyh93pGrcsVhQUDTmrHdkavqyseSNgOmqxrDNr/SQ7UxlU/KZ9gtrD1xeiziTZVeAsU/tnGA69U7OAQM/iQZ1vbcrR4Fqa4Lk2aO9Wa2C6NoO0i8v47nh8p8civ9r9w8eXnGU18LIb0ovwacbjO/qCniMaS4ftFDgI6yoQ5XHqBJ90LZwevfGTqX85Yjzsm4COquxWLjgLa6FqwqHkQ==\"}");
        map.put("sign","CwGtblVzC0J96npDXLBLOeZs0cVTitbNnXAvwWW2lPfl09euh9sXoVOUai2zsm2Q4NmTlAH1OC+1TfT5z/1gg1IhVkTR7KtJl/jqp7lsCcCk2X1JmpLpFoi2c40nhgLVEwftyh93pGrcsVhQUDTmrHdkavqyseSNgOmqxrDNr/SQ7UxlU/KZ9gtrD1xeiziTZVeAsU/tnGA69U7OAQM/iQZ1vbcrR4Fqa4Lk2aO9Wa2C6NoO0i8v47nh8p8civ9r9w8eXnGU18LIb0ovwacbjO/qCniMaS4ftFDgI6yoQ5XHqBJ90LZwevfGTqX85Yjzsm4COquxWLjgLa6FqwqHkQ==");

        String key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnU0zYEHWQSYrnOJYzQHp4LdLsG2bZ3mftDKCe45uU/h2HVXxu3ZtGTJpS9n/ptS1sQkyBFf4vKUErOrOAN9v3eappXICQR5/0//lm3h6INDM+P6zneDNPAKuHt/s8Z8pKGT5kTBNTulOPYu8ESwybV6ZXh/u1Yoi27yBRrOC+akeL40EiTBHF2FpmOFRV42aIb3TIgdgiMWpgDUO2YR+qA7sDEiodnwSoWrFbv7sJtIBj6gMUpsVQUiTt3zGLUGekdrawR4bFRxvE4T7yYQ0E744HURuICnbbFUQappeULIAfmofy6tiNgBez6ukXoenBaXDRsrSK2DD+F7rvbC+sQIDAQAB";
        try {
            boolean rsa2 = AlipaySignature.rsaCheckV1(map, key, "UTF-8", "RSA2");
            System.out.println(rsa2);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }


    }




}
