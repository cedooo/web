package tk.cedoo.common;

import java.io.Serializable;
/**
 * Action执行结果
 * @author Administrator
 *
 */
public class DoActionResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2972389207397839175L;
	public static int STAT_NOT_EXE = -1;
	public static int STAT_SUCCESS = 1;
	public static int STAT_HALF_SUCCESS = 2;
	public static int STAT_FAIL = 0;
	private int state = STAT_NOT_EXE;    //执行结果
	private String info = "";    //提示信息
	private Object obj = null;    //
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "DoActionResult [state=" + state + ", info=" + info + ", obj="
				+ obj + "]";
	}
	public void reset(){
		info = "";
		obj = null;
		state = STAT_NOT_EXE;
	}
	
}
