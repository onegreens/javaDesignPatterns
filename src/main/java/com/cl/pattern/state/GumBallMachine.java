package com.cl.pattern.state;

/**
 * Created by cl on 2017/7/28.
 */
public class GumBallMachine {

    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 2;

    int state = SOLD;
    int count;

    public GumBallMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("you can't insert anther quarter");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("you  insert a quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("you can't insert anther quarter,this quarter is sold out");
        } else if (state == SOLD) {
            System.out.println("please wait, we're ready to give you a gumball");
        }
    }

    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("quarter return");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("you haven't insert a quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("yichangixnxi wufa chuli ");

        } else if (state == SOLD) {
            System.out.println("ni jiying zhunbei huitui yingbi");
        }
    }

    public void turnCrank() {
        if (state == HAS_QUARTER) {
            System.out.println("zhuadnongliangci yebuhui huode ewai d tangguo ");
            state = SOLD;
            dispense();
        } else if (state == NO_QUARTER) {
            System.out.println("zhuandongle danshi meiyou yingbi ");
        } else if (state == SOLD_OUT) {
            System.out.println("zhuandongle danshi meiyou tangguo");
        } else if (state == SOLD) {
            System.out.println("wufa zhuandong liangci");

        }
    }

    public void dispense() {
        if (state == HAS_QUARTER) {
            System.out.println("yijgn maiwanle  ni maibudao trangguo d ");
        } else if (state == NO_QUARTER) {
            System.out.println("nixuyaoxianfuqian caineng maitangguo");
        } else if (state == SOLD_OUT) {
            System.out.println("douyijingmaiwanle ni hai mai sm ");
        } else if (state == SOLD) {
            System.out.println("zhengzia chuchou tangguo  ");
            count--;
            if (count == 0) {
                System.out.println("|tangguo maiwnale  ");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        }
    }

    public static int getSoldOut() {
        return SOLD_OUT;
    }

    public static int getNoQuarter() {
        return NO_QUARTER;
    }

    public static int getHasQuarter() {
        return HAS_QUARTER;
    }

    public static int getSOLD() {
        return SOLD;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GumBallMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
