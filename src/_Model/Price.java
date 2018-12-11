package _Model;

import java.io.Serializable;
import java.util.Date;

public class Price implements Serializable {

	private static final long serialVersionUID = 3160210962003385237L;

	public String orgcode;// 所属车站机构代码（由中心分配） String
	public String schedulecode;// 班次代码 String
	public String seattype;// 座型 String
	public Date departdate;// 发班日期 String
	public String reachstationcode;// 到达站代码 String
	public String reachstationname;// 终到站代码 String
	public String endstationname;// 终到站代码 String
	public String routename;// 线路名称 String
	public String routecode;// 线路编码 String
	public String direction;//线路方向
	public String scheduletype;// 班次类型 String
	public String areatype;// 区域类型 String
	public boolean isovertime;// 是否加班 String
	public boolean islineschedule;// 是否流水班 String
	public String starttime;// 始发时间 String
	public String endtime;// 末班时间 String
	public String departtime;// 发班时间 String
	public String endstationcode;// 终到站代码 String
	public String cansell;// 可售 String
	public int totalseats;// 载客总座位数 int
	public int remainseats;// 可售票总数 int
	public int remainkidseats;// 剩余携童票座数 int
	public String vehicleno;// 车牌号 String
	public String vehiclelvl;// 车辆等级 String
	public String vehicletype;// 车辆类型 String
	public String busbrand;// 车辆品牌 String
	public String ticketentrance;// 检票口 String
	public String waitingroom;// 候车厅号 String
	public double runtime;// 行驶时间 int
	public int rundistance;// 行驶里程 int
	public double fullprice;// 全票价 double
	public double halfprice;// 半票价 double
	public double studentprice;// 学生票价 double
	public double discountprice;// 优惠价 double
	public Double rebateprice;//折扣票价
	public Double returnprice;//往返票价
	public Double tripprice;//联程票价
	public String isrealname;//是否实名制
	public double topprice;// 最高限价 double
	public String schstatus;// 班次状态
	public String temp1;//保留字段1
	public String temp2;//保留字段2
	public Date updatetime;//更新时间(年月日时分秒)
	public String extendinfo;
	public String stopnames;//途径站信息

}
