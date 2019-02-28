package com.mybatis.mapper;

import com.mybatis.pojo.SysUser;

public interface UserMapper {
	SysUser selectById(Integer id);
}
