package com.sogou.api.sem.v1.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.4.1 2013-03-24T11:36:13.415+08:00
 * Generated source version: 2.4.1
 * 
 */
@WebService(targetNamespace = "https://api.sogou.com/sem/sms/v1", name = "ReportService")
@XmlSeeAlso({ ObjectFactory.class })
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ReportService {

	@WebResult(name = "getReportStateResponse", targetNamespace = "https://api.sogou.com/sem/sms/v1", partName = "parameters")
	@WebMethod(action = "https://api.sogou.com/sem/sms/v1/ReportService/getReportState")
	public GetReportStateResponse getReportState(
			@WebParam(partName = "parameters", name = "getReportStateRequest", targetNamespace = "https://api.sogou.com/sem/sms/v1") GetReportStateRequest parameters);

	@WebResult(name = "getReportPathResponse", targetNamespace = "https://api.sogou.com/sem/sms/v1", partName = "parameters")
	@WebMethod(action = "https://api.sogou.com/sem/sms/v1/ReportService/getReportPath")
	public GetReportPathResponse getReportPath(
			@WebParam(partName = "parameters", name = "getReportPathRequest", targetNamespace = "https://api.sogou.com/sem/sms/v1") GetReportPathRequest parameters);

	@WebResult(name = "getReportIdResponse", targetNamespace = "https://api.sogou.com/sem/sms/v1", partName = "parameters")
	@WebMethod(action = "https://api.sogou.com/sem/sms/v1/ReportService/getProfessionalReportId")
	public GetReportIdResponse getReportId(
			@WebParam(partName = "parameters", name = "getReportIdRequest", targetNamespace = "https://api.sogou.com/sem/sms/v1") GetReportIdRequest parameters);
}