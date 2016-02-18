package com.sogou.api.sem.v1.report.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.sogou.api.sem.v1.report.ObjectFactory;

/**
 * This class was generated by Apache CXF 2.4.1 2013-03-24T11:36:13.415+08:00
 * Generated source version: 2.4.1
 * 
 */
@WebService(targetNamespace = "https://api.sogou.com/sem/nms/v1", name = "ReportService")
@XmlSeeAlso({ ObjectFactory.class })
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ReportService {

	@WebResult(name = "getReportStateResponse", targetNamespace = "https://api.sogou.com/sem/nms/v1", partName = "parameters")
	@WebMethod(action = "https://api.sogou.com/sem/nms/v1/ReportService/getReportState")
	public GetReportStateResponse getReportState(
			@WebParam(partName = "parameters", name = "getReportStateRequest", targetNamespace = "https://api.sogou.com/sem/nms/v1") GetReportStateRequest parameters);

	@WebResult(name = "getReportFileUrlRequest", targetNamespace = "https://api.sogou.com/sem/nms/v1", partName = "parameters")
	@WebMethod(action = "https://api.sogou.com/sem/nms/v1/ReportService/getReportFileUrl")
	public GetReportFileUrlResponse getReportFileUrl(
			@WebParam(partName = "parameters", name = "getReportFileUrlRequest", targetNamespace = "https://api.sogou.com/sem/nms/v1") GetReportFileUrlRequest parameters);

	@WebResult(name = "getReportIdResponse", targetNamespace = "https://api.sogou.com/sem/nms/v1", partName = "parameters")
	@WebMethod(action = "https://api.sogou.com/sem/nms/v1/ReportService/getReportId")
	public GetReportIdResponse getReportId(
			@WebParam(partName = "parameters", name = "getReportIdRequest", targetNamespace = "https://api.sogou.com/sem/nms/v1") GetReportIdRequest parameters);

	@WebResult(name = "deleteReportResponse", targetNamespace = "https://api.sogou.com/sem/nms/v1", partName = "parameters")
	@WebMethod(action = "https://api.sogou.com/sem/nms/v1/ReportService/deleteReport")
	public DeleteReportResponse deleteReport(
			@WebParam(partName = "parameters", name = "getReportIdRequest", targetNamespace = "https://api.sogou.com/sem/nms/v1") DeleteReportRequest parameters);
}
