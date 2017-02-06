package cn.comcyb.view;

import android.content.Context;

import cn.comcyb.MD5;


public class Util {

	public static Context _context;
	private final static String SIGN_KEY = "dherss_key";

	// 登录
	public static String getString(int id) {
		return _context.getResources().getString(id);
	}

	// 机组列表
	public static String getSign(String str) {

		return MD5.getMD5String(str + SIGN_KEY);
	}

	// 机组详细信息
	public static String getSigntwo(String str) {

		return MD5.getMD5String(str + SIGN_KEY);
	}
	
	/*public static String[] fanyichar = new String[]{"auto","zh","en","yue","wyw","jp","kor","fra","spa","th","ara","ru","pt",
													"de","it","el","nl","pl","bul","est","dan","fin","cs","rom","slo","swe","hu","cht"};
	
	public static String[] fanyistr = new String[]{"自动检测","中文","英语","粤语","文言文","日语","韩语","法语","西班牙语","泰语","阿拉伯语","俄语","葡萄牙语","德语","意大利语","希腊语",
													"荷兰语","波兰语","保加利亚语","爱沙尼亚语","丹麦语","芬兰语","捷克语","罗马尼亚语"
													,"斯洛文尼亚语","瑞典语","匈牙利语","繁体中文"};*/
	
	public static String[] fanyichar ;
	public static String[] fanyistr;
	
	static
	{
		//fanyichar = myApplication.getAppContext().getResources().getStringArray(R.array.fanyichar);
		//fanyistr = myApplication.getAppContext().getResources().getStringArray(R.array.fanyistr);
	}
	
	/**
	 * cyb
	 * @param
	 * @return 加密后的字符串
	 */
		public static String getfanyiSign(String str) {
			return MD5.getMD5String(str);
		}


}
