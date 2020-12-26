package com.jvm.class02;

/**
 * @ClassName T02ClassLoaderScope
 * @Description TODO
 * @Author CJ
 * @Date 2020/12/18 018 13:56
 * @Version 1.0
 **/
public class T02ClassLoaderScope {

	public static void main(String[] args) {
		String pathBoot = System.getProperty("sun.boot.class.path");
		System.out.println(pathBoot.replaceAll(";", System.lineSeparator()));
		System.out.println("===============================================");
		String pathExt = System.getProperty("java.ext.dirs");
		System.out.println(pathExt.replaceAll(";", System.lineSeparator()));
		System.out.println("===============================================");
		String pathApp = System.getProperty("java.class.path");
		System.out.println(pathApp.replaceAll(";", System.lineSeparator()));

		/**
		 * D:\jdk8\jre\lib\resources.jar
		 * D:\jdk8\jre\lib\rt.jar
		 * D:\jdk8\jre\lib\sunrsasign.jar
		 * D:\jdk8\jre\lib\jsse.jar
		 * D:\jdk8\jre\lib\jce.jar
		 * D:\jdk8\jre\lib\charsets.jar
		 * D:\jdk8\jre\lib\jfr.jar
		 * D:\jdk8\jre\classes
		 * ===============================================
		 * D:\jdk8\jre\lib\ext
		 * C:\Windows\Sun\Java\lib\ext
		 * ===============================================
		 * D:\jdk8\jre\lib\charsets.jar
		 * D:\jdk8\jre\lib\deploy.jar
		 * D:\jdk8\jre\lib\ext\access-bridge-64.jar
		 * D:\jdk8\jre\lib\ext\cldrdata.jar
		 * D:\jdk8\jre\lib\ext\dnsns.jar
		 * D:\jdk8\jre\lib\ext\jaccess.jar
		 * D:\jdk8\jre\lib\ext\jfxrt.jar
		 * D:\jdk8\jre\lib\ext\localedata.jar
		 * D:\jdk8\jre\lib\ext\nashorn.jar
		 * D:\jdk8\jre\lib\ext\sunec.jar
		 * D:\jdk8\jre\lib\ext\sunjce_provider.jar
		 * D:\jdk8\jre\lib\ext\sunmscapi.jar
		 * D:\jdk8\jre\lib\ext\sunpkcs11.jar
		 * D:\jdk8\jre\lib\ext\zipfs.jar
		 * D:\jdk8\jre\lib\javaws.jar
		 * D:\jdk8\jre\lib\jce.jar
		 * D:\jdk8\jre\lib\jfr.jar
		 * D:\jdk8\jre\lib\jfxswt.jar
		 * D:\jdk8\jre\lib\jsse.jar
		 * D:\jdk8\jre\lib\management-agent.jar
		 * D:\jdk8\jre\lib\plugin.jar
		 * D:\jdk8\jre\lib\resources.jar
		 * D:\jdk8\jre\lib\rt.jar
		 * D:\IDEA\JavaSE\target\classes
		 * D:\IDEA\JavaSE\lib\commons-io-2.7.jar
		 * D:\MavenRepository\cglib\cglib\3.3.0\cglib-3.3.0.jar
		 * D:\MavenRepository\org\ow2\asm\asm\7.1\asm-7.1.jar
		 * D:\IntelliJ IDEA 2019.1.4\lib\idea_rt.jar
		 */
	}
}
