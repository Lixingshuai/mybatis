package com.mybatis.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.mybatis.pojo.SysRole;
import com.mybatis.provider.RoleProvider;

public interface RoleMapper {

	@Select({
			"select id,role_name roleName,enabled enabled,create_by createBy,create_time createTime from sys_role where id = #{id}" })
	SysRole selectRoleById(int id);

	@SelectProvider(type = RoleProvider.class, method = "selectById")
	SysRole selectRoleById2(int id);

}
