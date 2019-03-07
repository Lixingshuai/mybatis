package com.mybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.mybatis.pojo.SysRole;
import com.mybatis.provider.RoleProvider;

public interface RoleMapper {

	@Select({
			"select id,role_name roleName,enabled enabled,create_by createBy,create_time createTime from sys_role where id = #{id}" })
	SysRole selectRoleById(int id);

	@Insert({
			"insert into sys_role (role_name,enabled,create_by,create_time) values (#{roleName},#{enabled},#{createBy},#{createTime})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(SysRole role);

	@SelectProvider(type = RoleProvider.class, method = "selectById")
	SysRole selectRoleById2(int id);

	@Delete({ "delete from sys_role where id = #{id} and enabled is #{enabled}" })
	int deleteById(@Param("id") int id, @Param("enabled") Integer enabled);

}
