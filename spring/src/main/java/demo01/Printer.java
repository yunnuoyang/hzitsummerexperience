package demo01;

/**
 * 打印机
 */
public class Printer {
    private Ink ink;    //墨盒接口
    private Paper paper;//纸张接口
    public Printer(Ink ink,Paper paper){
        this.ink = ink;
        this.paper = paper;
    }
    public Printer(){
//        System.out.println("********Printer**********");
    }


    public void work(){
        if(ink == null){
            System.out.println("请安装墨盒！");
        }else{
            ink.print();
        }
        if (paper==null){
            System.out.println("没有纸张了，请放入纸张！");
        }else{
            paper.page();
        }
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
