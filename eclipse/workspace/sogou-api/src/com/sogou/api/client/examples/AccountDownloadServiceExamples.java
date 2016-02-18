package com.sogou.api.client.examples;

import java.io.IOException;

import com.sogou.api.client.utils.AccountDownloadUtils;
import com.sogou.api.client.utils.FileDownloadUtils;
import com.sogou.api.client.utils.ZipUtils;
import com.sogou.api.sem.v1.accountdownload.AccountFileType;
import com.sogou.api.sem.v1.accountdownload.GetAccountFileRequest;

public class AccountDownloadServiceExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GetAccountFileRequest getAccountFileRequest = new GetAccountFileRequest();
		AccountFileType type = new AccountFileType();
		type.setFormat(1);
		getAccountFileRequest.setAccoutFileRequest(type);
		String url = AccountDownloadUtils.getAccountDownloadURL(getAccountFileRequest, 100);

		try {
			String accountFile = "D:/logs/account.zip";
			FileDownloadUtils.downloadFile(url, accountFile);
			// 整账户文件使用的zip进行的压缩
			ZipUtils.unzipFile(accountFile, "D:/logs/");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
