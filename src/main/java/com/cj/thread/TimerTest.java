package com.cj.thread;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName TimerTest
 * @Description TODO 定时调度
 * @Author CJ
 * @Date 2020/6/22 022 12:47
 * @Version 1.0
 **/
public class TimerTest {

	public static void main(String[] args) {
		Timer timer = new Timer();
		MyTimerTask myTimerTask = new MyTimerTask();
		// 两秒后执行
//		timer.schedule(myTimerTask, 2000);
		// 五秒后每隔两秒执行一次
//		timer.schedule(myTimerTask, 5000L, 2000L);
		// 在指定日期时间开始执行，每隔两秒一次
		Calendar calendar = new GregorianCalendar(2020, 5, 22, 12, 58);
//		timer.schedule(myTimerTask, calendar.getTime(), 2000L);
	}
}

class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("hahahaha....");
	}
}
