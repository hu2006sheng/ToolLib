package org.husheng.toolslibrary;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 网络工具
 */
public class NetworkUtil {
	
	/**
	 * 检查是否有网络
	 */
	public static boolean isNetworkAvailable(Context context) {
		NetworkInfo info = getNetworkInfo(context);
		if (info != null) {
			return info.isAvailable();
		}
		return false;
	}

	/**
	 * 检查是否是WIFI
	 */
	public static boolean isWifi(Context context) {
		NetworkInfo info = getNetworkInfo(context);
		if (info != null) {
			if (info.getType() == ConnectivityManager.TYPE_WIFI)
				return true;
		}
		return false;
	}

	/**
	 * 检查是否是移动网络
	 */
	public static boolean isMobile(Context context) {
		NetworkInfo info = getNetworkInfo(context);
		if (info != null) {
			if (info.getType() == ConnectivityManager.TYPE_MOBILE)
				return true;
		}
		return false;
	}

	/**
	 * 获取NetworkInfo
	 */
	private static NetworkInfo getNetworkInfo(Context context) {
		ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		return cm.getActiveNetworkInfo();
	}
}
