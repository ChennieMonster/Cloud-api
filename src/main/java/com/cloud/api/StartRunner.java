package com.cloud.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cloud.api.core.job.ZipLogJob;

/**
 * @author huang_kefei
 * @date 2018年10月26日 类说明 日志打包任务
 */
@Component
public class StartRunner implements CommandLineRunner {
	
	@Autowired
	private ZipLogJob zipLogJob;
	
	@Override
	public void run(String... args) throws Exception {
//		zipLogJob.start();
	}

}
