
package test.mapper;

import java.util.Date;
import github.compile.mapper.test.Source;
import github.compile.mapper.test.Target;

public class BuildTestTreeComplex0level {

    public Source source;
    public Target target;

    public void map() {
        mapTarget0();
        mapTarget1();
        mapTarget2();
    }

    public Integer getValue0() {
        return  97;
    }

    public void mapTarget0() {
        Integer value;
        Integer decl;
        value = getValue0();
        decl = ((Integer) value);
        int[] declNewDelcare;
        declNewDelcare = target.getLevel0primitiveArray();
        if (declNewDelcare == null) {
            declNewDelcare = new int[ 12 ] ;
            target.setLevel0primitiveArray(declNewDelcare);
        }
        int[] newSizeArray;
        if (declNewDelcare.length<(12)) {
            newSizeArray = new int[ 12 ] ;
            target.setLevel0primitiveArray(newSizeArray);
            System.arraycopy(declNewDelcare, (0), newSizeArray, (0), (12));
        }
        declNewDelcare[(11)] = decl;
    }

    public String getValue1() {
        return "StringValueComplexLevel0";
    }

    public void mapTarget1() {
        String value;
        String decl;
        value = getValue1();
        decl = ((String) value);
        String[] declNewDelcare;
        declNewDelcare = target.getLevel0StriingArray();
        if (declNewDelcare == null) {
            declNewDelcare = new String[ 14 ] ;
            target.setLevel0StriingArray(declNewDelcare);
        }
        String[] newSizeArray;
        if (declNewDelcare.length<(14)) {
            newSizeArray = new String[ 14 ] ;
            target.setLevel0StriingArray(newSizeArray);
            System.arraycopy(declNewDelcare, (0), newSizeArray, (0), (14));
        } else {
            if (declNewDelcare[(13)] == null) {
                declNewDelcare[(13)] = new String();
            }
        }
        declNewDelcare[(13)] = decl;
    }

    public Date getValue2() {
        return new Date(1349964922000L);
    }

    public void mapTarget2() {
        Date value;
        Date decl;
        value = getValue2();
        decl = ((Date) value);
        Date[] declNewDelcare;
        declNewDelcare = target.getLevel0DateArray();
        if (declNewDelcare == null) {
            declNewDelcare = new Date[ 3 ] ;
            target.setLevel0DateArray(declNewDelcare);
        }
        Date[] newSizeArray;
        if (declNewDelcare.length<(3)) {
            newSizeArray = new Date[ 3 ] ;
            target.setLevel0DateArray(newSizeArray);
            System.arraycopy(declNewDelcare, (0), newSizeArray, (0), (3));
        } else {
            if (declNewDelcare[(2)] == null) {
                declNewDelcare[(2)] = new Date();
            }
        }
        declNewDelcare[(2)] = decl;
    }

}
