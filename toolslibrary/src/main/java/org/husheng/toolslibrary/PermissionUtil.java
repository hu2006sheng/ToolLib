package org.husheng.toolslibrary;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

/**
 * 6.0权限工具
 */
public class PermissionUtil {
    /**
     * 检查页面需要的权限
     * @param activity
     * @param permission
     * @return
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static List<String> findNeededPermissions(Activity activity, String... permission) {
        List<String> needPermissions = new ArrayList<>();
        for (String value : permission) {
            if (activity.checkSelfPermission(value) != PackageManager.PERMISSION_GRANTED) {
                needPermissions.add(value);
            }
        }
        return needPermissions;
    }

    /**
     * 获取用户在弹窗提示中手动拒绝的权限
     * @param permissions
     * @param grantResults
     * @return
     */
    public static List<String> getDeniedPermissions(String[] permissions, int[] grantResults) {
        List<String> deniedPermissions = new ArrayList<>();
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED)
            {
                deniedPermissions.add(permissions[i]);
            }
        }
        return deniedPermissions;
    }
}
