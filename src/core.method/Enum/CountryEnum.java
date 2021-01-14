package Enum;


import jdk.nashorn.internal.objects.annotations.Getter;

public enum  CountryEnum {
    ONE(1,"name","tel"),TWO(2,"wang","131"),THREE(3,"liu","121"),FOUR(4,"zhao","133"),FIVE(5,"zhou","159");

    public void setEnumKey(Integer enumKey) {
        this.enumKey = enumKey;
    }

    public void setNameMessage(String nameMessage) {
        this.nameMessage = nameMessage;
    }

    public void setTelMessage(String telMessage) {
        this.telMessage = telMessage;
    }

    public Integer getEnumKey() {
        return enumKey;
    }

    public String getNameMessage() {
        return nameMessage;
    }

    public String getTelMessage() {
        return telMessage;
    }

    private Integer enumKey;
    private String nameMessage;
    private String telMessage;

    CountryEnum(Integer enumKey, String nameMessage, String telMessage) {
        this.enumKey = enumKey;
        this.nameMessage = nameMessage;
        this.telMessage = telMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index){
        CountryEnum[] myArray = CountryEnum.values();
        for(CountryEnum element : myArray){
            if(index == element.getEnumKey()){
                return element;
            }
        }
        return null;
    }

    public static void main(String[] args){
        int n = 5;
        for(int i = 1;i <= n;i++){
            CountryEnum e = CountryEnum.forEach_CountryEnum(i);
            System.out.println(e+":键值:"+e.getEnumKey()+":姓名:"+e.getNameMessage()+":电话:"+e.getTelMessage());
        }
    }
}
