package com.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator {
	public static void main(String[] args)
			throws InvalidConfigurationException, SQLException, IOException, InterruptedException, XMLParserException {
//		MBG执行过程中的警告信息
		List<String> warnings = new ArrayList<>();
		// 当生成代码重复时，覆盖原代码
		boolean overwrite = true;
//		读取MBG配置文件
		InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");

		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration configuration = null;
		configuration = cp.parseConfiguration(is);
		is.close();
		DefaultShellCallback shellCallback = new DefaultShellCallback(overwrite);
//		创建MBG
		MyBatisGenerator mybatisGenerator = new MyBatisGenerator(configuration, shellCallback, warnings);
//		执行生成代码
		mybatisGenerator.generate(null);
//		打印警告信息
		for (String warning : warnings) {
			System.out.println(warning);
		}

	}
}
