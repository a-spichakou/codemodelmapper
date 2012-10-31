
package test.tree;

import java.util.Date;

public class BuildTestTreeDefaultValue1level {

    public Source source;
    public Target target;

    public void map() {
        map_target0();
        map_target1();
        map_target2();
    }

    public Integer getValue0() {
        return  98;
    }

    public void map_target0() {
        TargetLevel1 targetlevel10;
        targetlevel10 = target.getLevel1();
        if (targetlevel10 == null) {
            targetlevel10 = new TargetLevel1();
            target.setLevel1(targetlevel10);
        }
        Integer value;
        Integer decl;
        value = getValue0();
        decl = ((Integer) value);
        targetlevel10 .setLevel1primitive(decl);
    }

    public String getValue1() {
        return "StringValueLevel1";
    }

    public void map_target1() {
        TargetLevel1 targetlevel10;
        targetlevel10 = target.getLevel1();
        if (targetlevel10 == null) {
            targetlevel10 = new TargetLevel1();
            target.setLevel1(targetlevel10);
        }
        String value;
        String decl;
        value = getValue1();
        decl = ((String) value);
        targetlevel10 .setLevel1String(decl);
    }

    public Date getValue2() {
        return new Date(1352988922000L);
    }

    public void map_target2() {
        TargetLevel1 targetlevel10;
        targetlevel10 = target.getLevel1();
        if (targetlevel10 == null) {
            targetlevel10 = new TargetLevel1();
            target.setLevel1(targetlevel10);
        }
        Date value;
        Date decl;
        value = getValue2();
        decl = ((Date) value);
        targetlevel10 .setLevel1Complex(decl);
    }

}
