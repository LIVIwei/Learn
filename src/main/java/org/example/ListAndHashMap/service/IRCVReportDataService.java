/*
package org.example.ListAndHashMap.service;

import org.example.ListAndHashMap.Mapper.RcvMrchTradeReportDOMapper;
import org.example.ListAndHashMap.Mapper.RcvOrderMapper;
import org.example.ListAndHashMap.Mapper.RcvRefundOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

*/
/**
 * @Author: LIVI
 * @Time: 2022/12/08  14:46
 * @Description:
 *//*

@Service
public interface IRCVReportDataService {

    @Autowired
    private RcvRefundOrderMapper rcvRefundOrderMapper;
    @Autowired
    private RcvOrderMapper rcvOrderMapper;
    @Autowired
    private RcvMrchTradeReportDOMapper rcvMrchTradeReportDoMapper;

    public void rcvmrchtradereport(String reportDate) {
        rcvMrchTradeReportInfo(reportDate);
    }

    */
/**
     *商户交易统计报表
     * @param reportDat
    *//*

    private void rcvMrchTradeReportInfo(String reportDate) {//商户交易统计实体类
    RcVMrchTradeReportDo rcVMrchTradeReportDo = new RcvMrchTradeReportDo();//删除原有日期数据
    rcvMrchTradeReportDOMapper,deleteRcvMrchTradeReportDOByBatchId(reportDate);
    //获取订单表相关信息
    //根据报表日期获取交易总笔数，交易总金额，交易成功笔数，交易成功金额，商户号，报表日期
    List<RcvMrchTradeReportDo> rcvorderInfolist = rcvorderMapper, selectRcvorderinfoByReportDate(reportDate);
    //获取退款表相关信息//根据报表日期获取退款总笔数，退款总金额，商户号，报表日期
    List<RcvMrchTradeReportD0> rcvRefundorderInfolist = rcvRefund0rderMapper ,selectRcvRefund0rderinfoByReportDate(reportDate);
    HashMap<String，List<RcvMrchTradeReportD0>> mrchidHashMap = new HashMap<>();//hashMap的key不能重复
//以商户号，报表日期，运营机构编号，作为key进行对比
for (int i= 0;i < rcvorderInfoList.size();i++){
        String mrchId = rcvOrderInfoList.get(i).getMrchId() ;
        String sysType = rcvOrderInfoList.get(i).getSysType();
        String orderReportDate = rcvOrderInfoList.get(i).getReportDate();
        String key = orderReportDate + "-" + mrchId + ":" + sysType;
        List<RcvMrchTradeReportDo> list = mrchidHashMap.get(key);
        if (list == null) {
            list = new ArrayList<>();
            mrchidHashMap.put(key, list);
            list.add(rcvOrderInfoList.get(i));
        }
    }

    fon(int j=0;j < rcvRefundorderInfolist.size();j++){
        String mrchId = rcvRefundOrderInfoList.get(i).getMrchId();
        String sysType = rcvRefundOrderInfoList.get(i).getSysType();
        String refundOrderReportDate = rcvRefundOrderInfoList,get(i).getReportDate();
        String key = refundOrderReportDate + "-" + mrchId +":"+ sysType;
        List<RcvMrchTradeReportDO> list = mrchidHashMap.get(key);
        if (list == null) {
            list = new ArrayList<>();
            mrchidHashMap.put(key, list);
            list.add(rcvRefundOrderInfoList.get(i));
        }
    }

//效果:
// 1、key: 商户号，日期，运营机构;value: 交易总笔数，交易总金额，交易成功笔数，交易成功金额，商户号，报表日期，退款总笔数，退款总金额，运营机构
// 2、key: 商户号，日期，运营机构;value: 交易总笔数，交易总金额，交易成功笔数，交易成功金额，商户号，报表日期，退款数据数据库设默认值为0，运营机构
// 3、不会存在这种情况，退款有的话就一定会有交易
//把mrchidHashMap的数据放到RcVMrchTradeReportDo实体对应的RCV MRCHTRADE REPORT表中
for (Map,Entry<String, List<RcvMrchTradeReportD0>> tradeReport : mrchidHashMap.entrySet()){
        List<RcVMrchTradeReportD0> list = tradeReport.getValue();
        if (list != null && !list.isEmpty()) {
            RcvMrchTradeReportDO mrchTradeReportDO = new RcVMrchTradeReportDo();
            int orderTotalCount =0;
            int orderTotalAmt = 0;
            int orderSuccCount = 0;
            int orderSuccAmt = 0;
            int refundCount = 0;
            int refundAmt = 0;
            int value = 0;
            int idx = tradeReport.getKey().index0f("-");
            int idx0 = tradeReport.getKey().index0f(":");
            String date = tradeReport.getKey().substring(0, idx);
            String mrchId = tradeReport.getKey().substring(idx+1,idx0);
            String sysType = tradeReport.getKey().substring(idx0+1);
            for (RcvMrchTradeReportDO tradeReportDO : list){
                value = toNumber(tradeReportDO.getTxnNumber()):
                orderTotalCount += value;
                yvalue = toNumber(tradeReportDO.getTxnAmount());
                orderTotalAmt += value;
                value = toNumber(tradeReportDO,getTxnSuccessNumber());
                orderSuccCount += value;
                value = toNumber(tradeReportDO.getTxnSuccessAmount());
                orderSuccAmt += yalue;
                value = toNumber(tradeReportDo,getRefundNumber());
                refundCount += value;
                value = toNumber(tradeReportDO.getRefundAmount());
                refundAmt += value;
            }
            mrchTradeReportDO.setReportDate(date)
            mrchTradeReportDO.setMrchId(mrchId):
            mrchTradeReportDO.setSysType(sysType);
            mrchTradeReportDO.setTxnNumber(String.valueof(orderTotalCount))
            mrchTradeReportDo.setTxnAmount(String.valueof(orderTotalAmt));
            mrchTradeReportDO.setTxnSuccessNumber(String.valueof(ordenSuccCount));
            mrchTradeReportDO.setTxnSuccessAmount(String.value0f(orderSuccAmt));
            mrchTradeReportDO.setRefundNumber(String.valueOf(refundCount));
            mrchTradeReportDO.setRefundAmount(String.value0f(refundAmt));
            rcvMrchTradeReportDO.MapperinsertRcvMrchTradeReportDO(mrchTradeReportDO);
        }
    }
}
    private int toNumber(string txt) {
        if(stringUtils,isEmpty(txt)) {
            return 0;
        }
        return Integer.parseInt(txt);
    }

}
*/
