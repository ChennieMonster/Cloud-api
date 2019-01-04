package com.cloud.api.core.job;


import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cloud.api.util.ZipFilesUtil;

import it.sauronsoftware.cron4j.Scheduler;

/**
 * @author huang_kefei
 * @date 2018年10月26日 类说明
 */
@Component
public class ZipLogJob {

	private static Scheduler zipScheduler = null;
	private static Scheduler delScheduler = null;
	private static final Logger logger = LoggerFactory.getLogger(ZipLogJob.class);

	public  void start() {

		String filePath = "./logs";

		zipScheduler = new Scheduler();
		// 6h/1time
		zipScheduler.schedule("0 */6 * * *", new Runnable() {
			// 前面五个*号按顺序分别代表：分钟、小时、日、月、星期
			public void run() {
				// TODO Auto-generated method stub
				logger.info("每6小时打包log");
				ZipFilesUtil.zipFiles(filePath);
			}
		});
		zipScheduler.setDaemon(true);// 设置为守护进程
		zipScheduler.start();

		delScheduler = new Scheduler();
		// 
		delScheduler.schedule("0 0 */1 * *", new Runnable() {// 前面五个*号按顺序分别代表：分钟、小时、日、月、星期
			public void run() {
				System.out.println("每天执行1次删除gz包");
				try {
					ZipFilesUtil.deleteZipFiles(filePath);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		delScheduler.setDaemon(true);// 设置为守护进程
		delScheduler.start();
	}
}
