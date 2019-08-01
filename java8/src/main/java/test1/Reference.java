package test1;

/**
 * 定义标准
 */
public enum Reference {
    excellent,//优秀
    pretty,//良好
    mid,//中等
    pass,//通过
    noPass;//不通过

    public static Reference reference(int a) {
        if(100>=a&&a>90){
           return Reference.excellent;
        }else  if(90>=a&&a>80){
            return Reference.pretty;
        }else if(80>=a&&a>70){
            return Reference.mid;
        }else if(70>=a&&a>=60){
            return Reference.pass;
        }else
        return Reference.noPass;
    }
}
