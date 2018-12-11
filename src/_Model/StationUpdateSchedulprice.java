package _Model;

import java.io.Serializable;
import java.util.Date;

public class StationUpdateSchedulprice implements Serializable {
	
	private static final long serialVersionUID = -2514553220432708476L;
	
	public String orgcode;// 所属车站机构代码（由中心分配） String
	public String schedulecode;// 班次代码 String
	public String seattype;// 座型 String
	public Date departdate;// 发班日期 String
	public String reachstationcode;// 到达站代码 String
	public String departtime;
	public int remainseats;
	public double fullprice;
}
