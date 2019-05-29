package com.furui.ydfr.common.util;

import java.util.UUID;

public class UuidUtil {
    /**
     * 获得唯一的uuid
     * @return
     */
	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
}
