package com.mybatis.provider;

import org.apache.ibatis.jdbc.SQL;

public class RoleProvider {
	public String selectById() {
		return new SQL() {
			{
				SELECT("id,role_name roleName,enabled,create_by createBy,create_time createTime");
				FROM("sys_role");
				WHERE("id=#{id}");
			}

		}.toString();
	}
}
