package com.haowu.interest;


public class User {
    private Long id;
    private String name;
    private String idCard;
    private String sex;
    private Integer age;
    private Long number;
    private String address;
   
    private User() {
	}
    
    public Long getId() {
        id=System.currentTimeMillis();
        return id;
    }

    public String getName() {
        int fLength=Double.valueOf(Math.random()*Resource.FIRST_NAME.length()).intValue();
        int sLength=Double.valueOf(Math.random()*Resource.SECOND_NAME.length()).intValue();
        name=String.valueOf(Resource.FIRST_NAME.charAt(fLength));
        name+=String.valueOf(Resource.SECOND_NAME.charAt(sLength));
        if (Math.random()>0.5){
            int tLength=Double.valueOf(Math.random()*Resource.SECOND_NAME.length()).intValue();
            name+=String.valueOf(Resource.SECOND_NAME.charAt(tLength));
        }
        return name;
    }

    public String getIdCard() {
        idCard="";
        for (int i=0;i<17;i++){
            idCard+=String.valueOf(Resource.ID_CARD.charAt(Double.valueOf(Math.random()*Resource.ID_CARD.length()).intValue()));
        }
        if (Math.random()>0.96){
            idCard+="x";
        }else {
            idCard+=String.valueOf(Resource.ID_CARD.charAt(Double.valueOf(Math.random()*Resource.ID_CARD.length()).intValue()));
        }
        return idCard;
    }


    public String getSex() {
        if (Math.random()>0.52){
            sex="男";
        }else {
            sex="女";
        }
        return sex;
    }

    public Integer getAge() {
      while (true){
          age=(int)(Math.random()*100);
          if (age>16&&age<80){
              break;
          }
      }
        return age;
    }


    public Long getNumber() {
    	String num="1";
        for (int i=0;i<10;i++){
        	double a=Math.random()*Resource.ID_CARD.length();
        	int b=Double.valueOf(a).intValue();
            num+=Resource.ID_CARD.charAt(b);
        }
        number=new Long(num);
        return number;
    }


    public String getAddress() {
        address=Resource.CITY[Double.valueOf(Math.random()*Resource.CITY.length).intValue()];
        return address;
    }
  
    public void setId(Long id) {
		this.id = id;
	}

    public void setName(String name) {
		this.name = name;
	}

    public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

    public void setSex(String sex) {
		this.sex = sex;
	}

    public void setAge(Integer age) {
		this.age = age;
	}

    public void setNumber(Long number) {
		this.number = number;
	}

    public void setAddress(String address) {
		this.address = address;
	}
    
    public static User getUser() {
    	if (Resource.user==null) {
    		Resource.user=new User();
		}
    	//Resource.user.setId(Resource.user.getId());
    	Resource.user.setName(Resource.user.getName());
    	Resource.user.setSex(Resource.user.getSex());
    	Resource.user.setAge(Resource.user.getAge());
    	Resource.user.setIdCard(Resource.user.getIdCard());
    	Resource.user.setAddress(Resource.user.getAddress());
    	Resource.user.setNumber(Resource.user.getNumber());
		return Resource.user;
	}
    
    public static User build(){
    	if (Resource.user==null) {
    		Resource.user=new User();
		}
    	return Resource.user;
    }
    
    
    public String toString() {
        return "{user:[id : "+id+" , name : "+name+" , sex : "+sex+" , age : "+age+" , idCard : "+idCard+" , number : "+number+" , address : "+address+"]}";
    }
}
