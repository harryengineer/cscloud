package com.cscloud.common.base.constant;

/**
 * 全局的常量
 * 
 * @author Administrator
 *
 */
public class GlobalConstants {

	/**
	 * 根的路径
	 */
	public final static int ROOT = -1;
	/**
	 * 默认的组的类型
	 */
	public final static int DEFAULT_GROUP_TYPE = 0;

	public static final String ROOT_PREFIX = "cscloud";

	public static final String SWAGGER2_PREFIX = "swagger2";

	/**
	 * 权限菜单资源的按钮
	 */
	public final static String RESOURCE_TYPE_MENU = "menu";

	/**
	 * 权限关联类型
	 */
	public final static String AUTHORITY_TYPE_GROUP = "group";

	/**
	 * 权限按钮
	 */
	public final static String RESOURCE_TYPE_BTN = "button";

	/**
	 * 资源请求的方法
	 */
	public final static String RESOURCE_REQUEST_METHOD_GET = "GET";

	/**
	 * JWT的key的userId
	 */
	public static final String JWT_KEY_USER_ID = "userId";

	public static final String JWT_KEY_NAME = "name";

	public static final String CONTEXT_KEY_USER_ID = "currentUserId";

	public static final String CONTEXT_KEY_USER_NAME = "currentUserName";

	public static final String CONTEXT_KEY_USERNAME = "currentUserName";

	public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";

	public static final String CONTEXT_KEY_CLIENT_TOKEN = "currentClientToken";

	/**
	 * 权限认证 服务实例的header默认标识
	 */
	public static final String CLIENT_AUTH_HEADER = "Client-Auth";

	/**
	 * 权限认证 服务实例的header默认标识 (使用的了http默认的标识）
	 */
	public static final String USER_AUTH_HEADER = "Authorization";

	public final static String RESOURCE_ACTION_VISIT = "访问";

}
