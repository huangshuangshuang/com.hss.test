************************************************搜狗网盟API线上环境使用说明*****************************************************
发布介绍:

此客户端库基于Apache CXF 2.4.1创建。目前仅支持搜狗网盟API V1版本。源代码在src目录下。
客户可以新建工程后，导入lib包及src代码，配置文件包含sogou-api.properties和log4j.properties
使用示例请参考AccountServiceExamples.java。本客户端库旨在提供WebService调用封装以及代理类生成，并不提供客户端业务逻辑。

使用过程中如果遇到任何问题，请联系bizdev_nebula@sogou-inc.com并在标题注明《Sogou API Client V1使用过程问题求助》

注意事项:

1. 如何设置SOAP Header ?
	参见sogou-api.properties。您需要填写agentusername,agentpassword,username、password和token。请您填写这些信息后再尝试使用此客户端库。
	如果你不采用搜狗网盟API组提供的client包，你可以通过直接访问wsdl文件地址，参考开发文档《5.使用入门中的请求头信息的封装形式》，将各自的账户信息加密在soap header中，与我们完成用户认证和交互。
	在此期间，请妥善保管好你的账户密码和token，以防他人盗用。

2. 如何处理SOAP Response Header 数据 ?
	请通过ResHeaderUtil来获取。参见examples中AccountServiceExamples.java。

3. 如何访问沙盒环境
	请参见Sandbox.txt。

4. 如何设置List类型的参数？
	List类型的属性是没有set方法的，通过调用get方法获得对List类型的属性的引用，再调用List的add方法即可。如果属性是null，
	get方法会初始化属性为ArrayList。

5. 本客户端库的运行环境
	本客户端仅在JDK 1.6(21+)测试通过。
	
	
	
************************************************搜狗网盟API ChangeLog*****************************************************
v1.0.0	搜狗网盟API初始版本，提供基本的物料管理和查询功能；
v1.1.5	增加报告查询服务和定向词id查询等；