package com.crowdfunding.web.action.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.crowdfunding.core.exception.FileUtilException;
import com.crowdfunding.core.util.PropertyUtils;
import com.crowdfunding.web.common.BaseAction;

/**
 * 文件上传action
 * 
 * @author wxliu
 * 
 */
public class DownloadAction extends BaseAction {
	private Logger logger = Logger.getLogger(DownloadAction.class);
	private static final String remoteRoot=PropertyUtils.getString("linux.fileupload.share.rootpath");
	//private static final String remoteRoot="e://";
	private String file;//请求下载的文件路径----相对路径
	
	private String fileName;
	
	private InputStream inputStream;
	
	/**
	 * 默认从本地服务器上下载
	 */
	public String execute(){
		return fromLocal();
	}
	
	/**
	 * 从本地服务器下载文件
	 * @throws FileUtilException 
	 */
	public String fromLocal(){
		String projectRoot=this.getServletRequest().getSession().getServletContext().getRealPath("/");
		return download(projectRoot+file);
	}

	/**
	 * 从远程服务器--共享磁盘{RemoteRootDir} 下载文件
	 * @return String
	 */
	public String fromRemote(){
		return download(remoteRoot+file);
	}
	
	private String download(String filePath){
		try {
			File file = new File(filePath);
			
			if (file.exists()&&file.isFile()){
				inputStream=new FileInputStream(file);
				fileName=file.getName();
			}else{
				addActionMessage("你访问的资源不存在!");
				return "message";
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("下载文件出错!");
			return "message";
		}
		return "file-download";
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
}
