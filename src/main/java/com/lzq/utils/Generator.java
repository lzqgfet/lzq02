package com.lzq.utils;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Generator {
	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("D:\\Java学习\\第三阶段\\案例\\EducationSystem\\src\\generator.xml");
		/*ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);*/
	}


}
