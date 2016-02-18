
package com.sogou.api.sem.v1.report;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.sogou.api.sem.v1.common.AuthHeader;
import com.sogou.api.sem.v1.common.DoubleMapItemType;
import com.sogou.api.sem.v1.common.Failure;
import com.sogou.api.sem.v1.common.FloatMapItemType;
import com.sogou.api.sem.v1.common.IntMapItemType;
import com.sogou.api.sem.v1.common.LongMapItemType;
import com.sogou.api.sem.v1.common.OptType;
import com.sogou.api.sem.v1.common.ResHeader;
import com.sogou.api.sem.v1.common.StringMapItemType;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.sogou.api.sem.v1.report package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _AuthHeader_QNAME = new QName("http://api.sogou.com/sem/common/v1", "AuthHeader");
	private final static QName _ResHeader_QNAME = new QName("http://api.sogou.com/sem/common/v1", "ResHeader");
	private final static QName _Opt_QNAME = new QName("http://api.sogou.com/sem/common/v1", "opt");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.sogou.api.sem.v1.report
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link com.sogou.api.sem.v1.common.AuthHeader }
	 * 
	 */
	public AuthHeader createAuthHeader() {
		return new AuthHeader();
	}

	/**
	 * Create an instance of {@link com.baidu.api.sem.common.v2.ResHeader }
	 * 
	 */
	public ResHeader createResHeader() {
		return new ResHeader();
	}

	/**
	 * Create an instance of {@link com.baidu.api.sem.common.v2.OptType }
	 * 
	 */
	public OptType createOptType() {
		return new OptType();
	}

	/**
	 * Create an instance of {@link com.baidu.api.sem.common.v2.FloatMapItemType
	 * }
	 * 
	 */
	public FloatMapItemType createFloatMapItemType() {
		return new FloatMapItemType();
	}

	/**
	 * Create an instance of {@link com.baidu.api.sem.common.v2.IntMapItemType }
	 * 
	 */
	public IntMapItemType createIntMapItemType() {
		return new IntMapItemType();
	}

	/**
	 * Create an instance of
	 * {@link com.baidu.api.sem.common.v2.DoubleMapItemType }
	 * 
	 */
	public DoubleMapItemType createDoubleMapItemType() {
		return new DoubleMapItemType();
	}

	/**
	 * Create an instance of {@link com.baidu.api.sem.common.v2.Failure }
	 * 
	 */
	public Failure createFailure() {
		return new Failure();
	}

	/**
	 * Create an instance of
	 * {@link com.baidu.api.sem.common.v2.StringMapItemType }
	 * 
	 */
	public StringMapItemType createStringMapItemType() {
		return new StringMapItemType();
	}

	/**
	 * Create an instance of {@link com.baidu.api.sem.common.v2.LongMapItemType
	 * }
	 * 
	 */
	public LongMapItemType createLongMapItemType() {
		return new LongMapItemType();
	}

	/**
	 * Create an instance of
	 * {@link com.sogou.api.sem.v1.report.GetReportIdRequest }
	 * 
	 */
	public GetReportIdRequest createGetReportIdRequest() {
		return new GetReportIdRequest();
	}

	/**
	 * Create an instance of
	 * {@link com.sogou.api.sem.v1.report.ReportRequestType }
	 * 
	 */
	public ReportRequestType createReportRequestType() {
		return new ReportRequestType();
	}

	/**
	 * Create an instance of
	 * {@link com.sogou.api.sem.v1.report.GetReportPathResponse }
	 * 
	 */
	public GetReportPathResponse createGetReportPathResponse() {
		return new GetReportPathResponse();
	}

	/**
	 * Create an instance of
	 * {@link com.sogou.api.sem.v1.report.GetReportPathRequest }
	 * 
	 */
	public GetReportPathRequest createGetReportPathRequest() {
		return new GetReportPathRequest();
	}

	/**
	 * Create an instance of
	 * {@link com.sogou.api.sem.v1.report.GetReportStateRequest }
	 * 
	 */
	public GetReportStateRequest createGetReportStateRequest() {
		return new GetReportStateRequest();
	}

	/**
	 * Create an instance of
	 * {@link com.sogou.api.sem.v1.report.GetReportIdResponse }
	 * 
	 */
	public GetReportIdResponse createGetReportIdResponse() {
		return new GetReportIdResponse();
	}

	/**
	 * Create an instance of
	 * {@link com.sogou.api.sem.v1.report.GetReportStateResponse }
	 * 
	 */
	public GetReportStateResponse createGetReportStateResponse() {
		return new GetReportStateResponse();
	}

	/**
	 * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}
	 * {@link com.baidu.api.sem.common.v2.AuthHeader }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://api.sogou.com/sem/common/v1", name = "AuthHeader")
	public JAXBElement<AuthHeader> createAuthHeader(AuthHeader value) {
		return new JAXBElement<AuthHeader>(_AuthHeader_QNAME, AuthHeader.class, null, value);
	}

	/**
	 * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}
	 * {@link com.baidu.api.sem.common.v2.ResHeader }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://api.sogou.com/sem/common/v1", name = "ResHeader")
	public JAXBElement<ResHeader> createResHeader(ResHeader value) {
		return new JAXBElement<ResHeader>(_ResHeader_QNAME, ResHeader.class, null, value);
	}

	/**
	 * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}
	 * {@link com.baidu.api.sem.common.v2.OptType }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://api.sogou.com/sem/common/v1", name = "opt")
	public JAXBElement<OptType> createOpt(OptType value) {
		return new JAXBElement<OptType>(_Opt_QNAME, OptType.class, null, value);
	}

}
