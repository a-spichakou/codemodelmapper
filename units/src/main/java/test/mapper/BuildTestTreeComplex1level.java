
package test.mapper;

import github.compile.mapper.test.Source;
import github.compile.mapper.test.Target;
import github.compile.mapper.test.TargetLevel1;

public class BuildTestTreeComplex1level {

    public Source source;
    public Target target;

    public void map() {
        mapTarget0();
        mapTarget1();
    }

    public Integer getValue0() {
        return  96;
    }

    public void mapTarget0() {
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
        int[] declNewDelcare;
        declNewDelcare = targetlevel10 .getLevel1primitiveArray();
        if (declNewDelcare == null) {
            declNewDelcare = new int[ 3 ] ;
            targetlevel10 .setLevel1primitiveArray(declNewDelcare);
        }
        int[] newSizeArray;
        if (declNewDelcare.length<(3)) {
            newSizeArray = new int[ 3 ] ;
            targetlevel10 .setLevel1primitiveArray(newSizeArray);
            System.arraycopy(declNewDelcare, (0), newSizeArray, (0), (3));
        }
        declNewDelcare[(2)] = decl;
    }

    public String getValue1() {
        return "StringValueComplexLevel1";
    }

    public void mapTarget1() {
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
        String[] declNewDelcare;
        declNewDelcare = targetlevel10 .getLevel1StriingArray();
        if (declNewDelcare == null) {
            declNewDelcare = new String[ 2 ] ;
            targetlevel10 .setLevel1StriingArray(declNewDelcare);
        }
        String[] newSizeArray;
        if (declNewDelcare.length<(2)) {
            newSizeArray = new String[ 2 ] ;
            targetlevel10 .setLevel1StriingArray(newSizeArray);
            System.arraycopy(declNewDelcare, (0), newSizeArray, (0), (2));
        } else {
            if (declNewDelcare[(1)] == null) {
                declNewDelcare[(1)] = new String();
            }
        }
        declNewDelcare[(1)] = decl;
    }

}
