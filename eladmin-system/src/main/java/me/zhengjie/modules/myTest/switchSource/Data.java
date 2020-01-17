package me.zhengjie.modules.myTest.switchSource;

import java.util.Date;

/**
 * 功能参数对象
 * @author MaiChiHang
 * @date 2019-11-08
 * @version 0.1
 */
public class Data {
    /**开始时间 */
    private Date startdate;
    /**截止时间 */
    private Date enddate;
    /**纳税人识别号 */
    private String nsrbh;

    /**
     * 获取纳税人识别号
     * @return nsrbh
     */
    public String getNsrbh() {
        return nsrbh;
    }

    /**
     * 设置纳税人识别号
     * @param nsrbh
     */
    public void setNsrbh(String nsrbh) {
        this.nsrbh = nsrbh;
    }

    /**
     * 获取开始时间
     * @return startdate
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * 设置开始时间
     * @param startdate
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * 获取截止时间
     * @return enddate
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * 设置截止时间
     * @param enddate
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * 构造方法
     * @param startdate
     * @param enddate
     * @param nsrbh
     */
    public Data(Date startdate, Date enddate, String nsrbh) {
        this.startdate = startdate;
        this.enddate = enddate;
        this.nsrbh = nsrbh;
    }
}
