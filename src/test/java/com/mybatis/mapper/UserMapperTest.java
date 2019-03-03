package com.mybatis.mapper;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis.pojo.SysRole;
import com.mybatis.pojo.SysUser;

public class UserMapperTest {
	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById(1);
			System.out.println(user.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void test2() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			SysUser user = userMapper.selectById(1);
			List<SysUser> users = userMapper.selectAll();
			for (SysUser user : users) {
				System.out.println(user.getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void test3() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			SysUser user = userMapper.selectById(1);
			List<SysRole> roles = userMapper.selectRolesByUserId(1);
			for (SysRole user : roles) {
				System.out.println(user.getUser().getUserEmail());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void insert() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setUserName("lixingshuai");
			int result = userMapper.insert(user);
			System.out.println(user.getId());
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			sqlSession.rollback();
			sqlSession.commit();
			sqlSession.close();
		}
	}

	@Test
	public void test5() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById(1001);
			user.setUserEmail("111111@qq.com");
			int result = userMapper.updateEmailById(user);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			sqlSession.rollback();
//			sqlSession.commit();
			sqlSession.close();
		}
	}

	@Test
	public void deleteById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			int result = userMapper.deleteById(1006);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			sqlSession.rollback();
//			sqlSession.commit();
			sqlSession.close();
		}
	}

	@Test
	public void selectRolesByUserIdAndEnabled() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysRole> result = userMapper.selectRolesByUserIdAndEnabled(1, 1);
			System.out.println(result.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			sqlSession.rollback();
			sqlSession.close();
		}
	}

	@Test
	public void selectRoleById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole result = roleMapper.selectRoleById2(1);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			sqlSession.rollback();
			sqlSession.close();
		}
	}
}
