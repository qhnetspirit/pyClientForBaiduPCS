import java.io.File;
import java.util.LinkedList;

/**
 * 
 */

/**
 * @author 007
 * 百度云的客户端
 */
public class BaiduYunOperations implements Operations {

	public BaiduYunOperations()
	{
		
		//Config environment
		String userHome=System.getProperty("user.home");
		String configDir=userHome+"\\.bypy";
		if(!new File(userHome).isDirectory())
		{
		    System.err.println("请拷贝tokens\\baiduYunTokens\\。bypy目录到当前用户目录"+userHome);
		}		
	}
	
	/* (non-Javadoc)
	 * @see Operations#acquireFileInfo(java.lang.String)
	 */
	@Override
	public void acquireFileInfo(String fileName_cloud) {
		// TODO Auto-generated method stub
		String path="/";
		String shortName=fileName_cloud;
		int index=fileName_cloud.replace('\\', '/').lastIndexOf('/');
		if(index!=-1)
		{
			path=fileName_cloud.substring(0, index);
			shortName=fileName_cloud.substring(index);
		}
		
		LinkedList<String> outputStringList=CommandRunner.run("python .\\lib\\baiduYunLib.py list "+path , false);
		for (int i = 0; i < outputStringList.size(); i++) {
			String str=outputStringList.get(i);
			if (str.contains(shortName)&&(str.startsWith("F")))
			{
				System.out.println("File Metadata: "+str);
			}
		} 

	}

	/* (non-Javadoc)
	 * @see Operations#acquireFileList(java.lang.String)
	 */
	@Override
	public void acquireFileList(String path) {
		// TODO Auto-generated method stub
		path.replace('\\', '/');
				
		LinkedList<String> outputStringList=CommandRunner.run("python .\\lib\\baiduYunLib.py list "+path , false);
		for (int i = 0; i < outputStringList.size(); i++) {
			String str=outputStringList.get(i);
			if (str.startsWith("F"))
			{
				System.out.println("File Metadata: "+str);
			}
		} 
	}

	/* (non-Javadoc)
	 * @see Operations#uploadFiletoCloud(java.lang.String, java.lang.String)
	 */
	@Override
	public void uploadFiletoCloud(String fileName_client, String fileName_cloud) {
		// TODO Auto-generated method stub
        if(!new File(fileName_client).isFile())
        {
        	System.err.println("要上传的文件不存在：");
        }
        else
        {
        	CommandRunner.run("python  .\\lib\\baiduYunLib.py upload "+fileName_client+ " "+ fileName_cloud , false);
        	 System.out.println("Uploaded File: " + fileName_client);
        }
	}

	/* (non-Javadoc)
	 * @see Operations#downloadFilefromCloud(java.lang.String, java.lang.String)
	 */
	@Override
	public void downloadFilefromCloud(String fileName_client,
			String fileName_cloud) {
		// TODO Auto-generated method stub

		LinkedList<String> outputStringList = CommandRunner.run(
				"python .\\lib\\baiduYunLib.py downfile " + fileName_cloud + " " + fileName_client,
				false);
		 System.out.println("Downloaded File: " + fileName_client);
		
	}

	/* (non-Javadoc)
	 * @see Operations#deleteFileinCloud(java.lang.String)
	 */
	@Override
	public void deleteFileinCloud(String fileName_cloud) {
		// TODO Auto-generated method stub
		LinkedList<String> outputStringList = CommandRunner.run(
				"python .\\lib\\baiduYunLib.py delete " + fileName_cloud ,
				false);
		 System.out.println("delete File in cloud: " + fileName_cloud);
		
	}

	

	/* (non-Javadoc)
	 * @see Operations#createFolderinCloud(java.lang.String)
	 */
	@Override
	public void createFolderinCloud(String folderName_cloud) {
		// TODO Auto-generated method stub
		LinkedList<String> outputStringList = CommandRunner.run(
				"python .\\lib\\baiduYunLib.py mkdir " + folderName_cloud ,
				false);
		 System.out.println("mkdir in cloud: " + folderName_cloud);
	}


	
}
