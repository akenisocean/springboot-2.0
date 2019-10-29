package com.ocean.springcloud.oceanpaydemo.pay.vos;

import lombok.Data;

/**
 * @author chao
 * @version 1.0
 * @desc 支付宝付款码返回的视图层
 * @date 2019年09月11日 18:35
 */
@Data
public class AliPayBarCodePaymentVO {
    /**
     * alipay_trade_pay_response : {"code":"10003","msg":" order success pay inprocess","buyer_logon_id":"186******90","buyer_pay_amount":"0.00","buyer_user_id":"2088702308530404","invoice_amount":"0.00","out_trade_no":"089ff6fc-9fab-4fb2-8b94-bd50e27cb2bd","point_amount":"0.00","receipt_amount":"0.00","total_amount":"0.01","trade_no":"2019091922001430400590494791"}
     * sign : gij5U2vu0ZhPv3pxc9gIl1IoTQcV3oSWK7pNADPArVIPWZgns95evzoVM06D+WxlthYiXw7JWthPQI20r0Es09o1F1juBsazAkR53d2YEve+rqa59aKWiwapkvCNwj8MzinA9OlLOizCohN0+IMQeomwsAIQquSOVrJJCuh+OIn+v2TY+aEvhzvTwkj7u7Qstll4XoLvpwUBmNBIAntOCpst/B+cQMURLUjcaZ/xW82c2m/DBz3I3RVCv642z3TF6x/2MwWXCd9bATrH5KNIWMi1A63QcCnaLS1NWAzooUophVJ4VrLRML1NvU5pybCk2/X4O90bCwAUL9wrfR32Lw==
     */

    private AlipayTradePayResponseBean alipay_trade_pay_response;
    private String sign;


    public AlipayTradePayResponseBean getAlipay_trade_pay_response() {
        return alipay_trade_pay_response;
    }

    public void setAlipay_trade_pay_response(AlipayTradePayResponseBean alipay_trade_pay_response) {
        this.alipay_trade_pay_response = alipay_trade_pay_response;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


    public static class AlipayTradePayResponseBean {
        /**
         * code : 10003
         * msg :  order success pay inprocess
         * buyer_logon_id : 186******90
         * buyer_pay_amount : 0.00
         * buyer_user_id : 2088702308530404
         * invoice_amount : 0.00
         * out_trade_no : 089ff6fc-9fab-4fb2-8b94-bd50e27cb2bd
         * point_amount : 0.00
         * receipt_amount : 0.00
         * total_amount : 0.01
         * trade_no : 2019091922001430400590494791
         */

        private String code;
        private String msg;
        private String buyer_logon_id;
        private String buyer_pay_amount;
        private String buyer_user_id;
        private String invoice_amount;
        private String out_trade_no;
        private String point_amount;
        private String receipt_amount;
        private String total_amount;
        private String trade_no;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getBuyer_logon_id() {
            return buyer_logon_id;
        }

        public void setBuyer_logon_id(String buyer_logon_id) {
            this.buyer_logon_id = buyer_logon_id;
        }

        public String getBuyer_pay_amount() {
            return buyer_pay_amount;
        }

        public void setBuyer_pay_amount(String buyer_pay_amount) {
            this.buyer_pay_amount = buyer_pay_amount;
        }

        public String getBuyer_user_id() {
            return buyer_user_id;
        }

        public void setBuyer_user_id(String buyer_user_id) {
            this.buyer_user_id = buyer_user_id;
        }

        public String getInvoice_amount() {
            return invoice_amount;
        }

        public void setInvoice_amount(String invoice_amount) {
            this.invoice_amount = invoice_amount;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getPoint_amount() {
            return point_amount;
        }

        public void setPoint_amount(String point_amount) {
            this.point_amount = point_amount;
        }

        public String getReceipt_amount() {
            return receipt_amount;
        }

        public void setReceipt_amount(String receipt_amount) {
            this.receipt_amount = receipt_amount;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public String getTrade_no() {
            return trade_no;
        }

        public void setTrade_no(String trade_no) {
            this.trade_no = trade_no;
        }
    }
}
