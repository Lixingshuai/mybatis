package com.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.pojo.SysRole;
import com.mybatis.pojo.SysUser;

public interface UserMapper {
	SysUser selectById(Integer id);

	List<SysUser> selectAll();

	List<SysRole> selectRolesByUserId(int id);

	int insert(SysUser user);

	int updateEmailById(SysUser user);

	int deleteById(int id);

	List<SysRole> selectRolesByUserIdAndEnabled(@Param("userId") int userId, @Param("enabled") int enabled);

	List<SysUser> selectByUser(SysUser user);

	int updateByUser(SysUser user);

	List<SysUser> selectByIdList(List<Integer> idList);

}
