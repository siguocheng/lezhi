package com.lezhi.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author 凯凯
 *
 */
public class FtpClientUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FtpClientUtil.class);
	
	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",  
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",  
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",  
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",  
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
            "W", "X", "Y", "Z" };
	
	/**
	 * 获得连接FTP方式
	 * 
	 * @param hostname
	 *            FTP服务器地址
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录用户名
	 * @param password
	 *            FTP登录密码
	 * @return FTPClient
	 */
	public FTPClient getConnectionFTP(String hostName, int port, String userName, String passWord) {
		// 创建FTPClient对象
		FTPClient ftp = new FTPClient();
		try {
			// 连接FTP服务器
			ftp.connect(hostName, port);
			// 下面三行代码必须要，而且不能改变编码格式，否则不能正确下载中文文件
			ftp.setControlEncoding("GBK");
			FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
			conf.setServerLanguageCode("zh");
			// 登录ftp
			ftp.login(userName, passWord);
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				ftp.disconnect();
				LOGGER.error("连接服务器失败");
			}
			if(LOGGER.isInfoEnabled()) {
				LOGGER.info("登陆服务器成功");
			}
		} catch (IOException e) {
			LOGGER.error("Exception:",e);
		}
		return ftp;
	}

	/**
	 * 关闭连接FTP方式
	 * 
	 * @param ftp
	 *            FTPClient对象
	 * @return boolean
	 */
	public boolean closeFTP(FTPClient ftp) {
		if (ftp.isConnected()) {
			try {
				ftp.disconnect();
				if(LOGGER.isInfoEnabled()) {
					LOGGER.info("ftp已经关闭");
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 上传文件FTP方式
	 * 
	 * @param ftp
	 *            FTPClient对象
	 * @param path
	 *            FTP服务器上传地址
	 * @param filename
	 *            本地文件路径
	 * @param inputStream
	 *            输入流
	 * @return boolean
	 */
	public boolean uploadFile(FTPClient ftp, String path, String fileName, InputStream inputStream) {
		boolean success = false;
		try {
			// 转移到指定FTP服务器目录
			ftp.changeWorkingDirectory(path);
			FTPFile[] fs = ftp.listFiles();// 得到目录的相应文件列表
			
			fileName = FtpClientUtil.changeName(fileName, fs);
			fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
			path = new String(path.getBytes("GBK"), "ISO-8859-1");
			// 转到指定上传目录
			ftp.changeWorkingDirectory(path);
			// 将上传文件存储到指定目录
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();
			// 如果缺省该句 传输txt正常 但图片和其他格式的文件传输出现乱码
			boolean ret = ftp.storeFile(fileName, inputStream);
			
			// 关闭输入流
			inputStream.close();
			// 退出ftp
			ftp.logout();
			// 表示上传成功
			success = true;
			if(LOGGER.isInfoEnabled()) {
				LOGGER.info("上传成功......");
			}
		} catch (Exception e) {
			LOGGER.info("Exception:",e);
		}
		return success;
	}

	/**
	 * 删除文件FTP方式
	 * 
	 * @param ftp
	 *            FTPClient对象
	 * @param path
	 *            FTP服务器上传地址
	 * @param filename
	 *            FTP服务器上要删除的文件名
	 * @return
	 */
	public boolean deleteFile(FTPClient ftp, String path, String fileName) {
		boolean success = false;
		try {
			ftp.changeWorkingDirectory(path);// 转移到指定FTP服务器目录
			fileName = new String(fileName.getBytes("GBK"), "ISO88591");
			path = new String(path.getBytes("GBK"), "ISO88591");
			ftp.deleteFile(fileName);
			ftp.logout();
			success = true;
		} catch (Exception e) {
			LOGGER.info("Exception:",e);
		}
		return success;
	}

	/**
	 * 上传文件FTP方式
	 * 
	 * @param ftp
	 *            FTPClient对象
	 * @param path
	 *            FTP服务器上传地址
	 * @param fileName
	 *            本地文件路径
	 * @param localPath
	 *            本里存储路径
	 * @return boolean
	 */
	public boolean downFile(FTPClient ftp, String path, String fileName, String localPath) {
		boolean success = false;
		try {
			ftp.changeWorkingDirectory(path);// 转移到FTP服务器目录
			FTPFile[] fs = ftp.listFiles(); // 得到目录的相应文件列表
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + "\\" + ff.getName());
					OutputStream outputStream = new FileOutputStream(localFile);
					// 将文件保存到输出流outputStream中
					ftp.retrieveFile(new String(ff.getName().getBytes("GBK"), "ISO88591"), outputStream);
					outputStream.flush();
					outputStream.close();
					if(LOGGER.isInfoEnabled()) {
						LOGGER.info("下载成功......");
					}
				}
			}
			ftp.logout();
			success = true;
		} catch (Exception e) {
			LOGGER.info("Exception:",e);
		}
		return success;
	}

	/**
	 * 判断是否有重名文件
	 * 
	 * @param fileName
	 * @param fs
	 * @return
	 */
	public static boolean isFileExist(String fileName, FTPFile[] fs) {
		for (int i = 0; i < fs.length; i++) {
			FTPFile ff = fs[i];
			if (ff.getName().equals(fileName)) {
				return true; // 如果存在返回 正确信号
			}
		}
		return false; // 如果不存在返回错误信号
	}

	/**
	 * 根据重名判断的结果 生成新的文件的名称
	 * 
	 * @param fileName
	 * @param fs
	 * @return
	 */
	public static String changeName(String fileName, FTPFile[] fs) {
		int n = 0;
		// fileName = fileName.append(fileName);
		while (isFileExist(fileName.toString(), fs)) {
			n++;
			String a = "[" + n + "]";
			int b = fileName.lastIndexOf(".");// 最后一出现小数点的位置
			int c = fileName.lastIndexOf("[");// 最后一次"["出现的位置
			if (c < 0) {
				c = b;
			}
			StringBuffer name = new StringBuffer(fileName.substring(0, c));// 文件的名字
			StringBuffer suffix = new StringBuffer(fileName.substring(b + 1));// 后缀的名称
			fileName = name.append(a) + "." + suffix;
		}
		return fileName.toString();
	}

	/**
	 *
	 * @param args
	 * @throws IOException 
	 *
	 */
	public static void main(String[] args) throws IOException {

//		String path = "";
//		File f1 = new File("version1.txt");
//		String filename = f1.getName();
//		FtpClientUtil a = new FtpClientUtil();
//		InputStream input = new FileInputStream(f1);
//		
//		FTPClient ftp = a.getConnectionFTP("139.219.188.45", 21, "firmware_manager", "Zhaojin_version_#$123");
//		ftp.dele("version1.txt");
//		a.uploadFile(ftp, path, filename, input);
//		a.closeFTP(ftp);
//		createFile();
		
		System.out.println(generateShortUuid());
	}

	public static String generateShortUuid() {  
	    StringBuffer shortBuffer = new StringBuffer();  
	    String uuid = UUID.randomUUID().toString().replace("-", "");  
	    for (int i = 0; i < 8; i++) {  
	        String str = uuid.substring(i * 4, i * 4 + 4);  
	        int x = Integer.parseInt(str, 16);  
	        shortBuffer.append(chars[x % 0x3E]);  
	    }  
	    return shortBuffer.toString();  
	  
	}
	
	private static void createFile() {
		File f = new File("version1.txt");
		
		FileWriter fw = null;
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			
			fw = new FileWriter(f, false);
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("bbbb");
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}