
package test.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import github.compile.mapper.source.Utils;
import github.compile.mapper.test.Source;
import github.compile.mapper.test.Target;

public class BuildTestTreeSimple0level {

    public Source source;
    public Target target;

    public void map() {
        mapTarget0();
        mapTarget1();
        mapTarget2();
        mapTarget3();
        mapTarget4();
        mapTarget5();
    }

    public Object getValue0() {
        Integer integer0;
        integer0 = ((Integer) source.getLevel0primitive());
        if ((integer0==null)) {
            return null;
        }
        return integer0;
    }

    public void mapTarget0() {
        Object value;
        Integer decl;
        value = getValue0();
        decl = ((Integer) value);
        target.setLevel0primitive(decl);
    }

    public Object getValue1() {
        String string0;
        string0 = ((String) source.getLevel0String());
        if ((string0==null)) {
            return null;
        }
        return string0;
    }

    public void mapTarget1() {
        Object value;
        String decl;
        value = getValue1();
        decl = ((String) value);
        target.setLevel0String(decl);
    }

    public Object getValue2() {
        Date date0;
        date0 = ((Date) source.getLevel0Complex());
        if ((date0==null)) {
            return null;
        }
        return date0;
    }

    public void mapTarget2() {
        Object value;
        Date decl;
        value = getValue2();
        decl = ((Date) value);
        target.setLevel0Complex(decl);
    }

    public Object getValue3() {
        Integer integer0;
        int[] varFromGetter;
        varFromGetter = source.getLevel0primitiveArray();
        if (varFromGetter == null) {
            return null;
        }
        integer0 = ((Integer) varFromGetter[ 1 ]);
        if ((integer0==null)) {
            return null;
        }
        return integer0;
    }

    public void mapTarget3() {
        Object value;
        Integer decl;
        value = getValue3();
        decl = ((Integer) value);
        int[] declNewDelcare;
        declNewDelcare = target.getLevel0primitiveArray();
        if (declNewDelcare == null) {
            declNewDelcare = new int[ 3 ] ;
            target.setLevel0primitiveArray(declNewDelcare);
        }
        int[] newSizeArray;
        if (declNewDelcare.length<(3)) {
            newSizeArray = new int[ 3 ] ;
            target.setLevel0primitiveArray(newSizeArray);
            System.arraycopy(declNewDelcare, (0), newSizeArray, (0), (3));
        }
        declNewDelcare[(2)] = decl;
    }

    public Object getValue4() {
        String string0;
        ArrayList varFromGetter;
        varFromGetter = source.getLevel0List();
        string0 = ((String) varFromGetter.get(1));
        if ((string0==null)) {
            return null;
        }
        return string0;
    }

    public void mapTarget4() {
        Object value;
        String decl;
        value = getValue4();
        decl = ((String) value);
        ArrayList declNewDelcare;
        declNewDelcare = target.getLevel0List();
        if (declNewDelcare == null) {
            declNewDelcare = new ArrayList();
            target.setLevel0List(declNewDelcare);
        }
        ArrayList newSizeList;
        if (declNewDelcare.size()<(3)) {
            newSizeList = new ArrayList((3));
            Utils.initList(newSizeList, (3));
            target.setLevel0List(newSizeList);
            Collections.copy(newSizeList, declNewDelcare);
        } else {
            newSizeList = declNewDelcare;
            if (newSizeList.get((2)) == null) {
                newSizeList.add((2), new String());
            }
        }
        newSizeList.set((2), decl);
    }

    public Object getValue5() {
        String string0;
        HashMap varFromGetter;
        varFromGetter = source.getLevel0Map();
        string0 = ((String) varFromGetter.get("key1"));
        if ((string0==null)) {
            return null;
        }
        return string0;
    }

    public void mapTarget5() {
        Object value;
        String decl;
        value = getValue5();
        decl = ((String) value);
        HashMap declNewDelcare;
        declNewDelcare = target.getLevel0Map();
        if (declNewDelcare == null) {
            declNewDelcare = new HashMap();
            target.setLevel0Map(declNewDelcare);
        }
        if (declNewDelcare.get("key2") == null) {
            declNewDelcare.put("key2", new String());
        }
        declNewDelcare.put("key2", decl);
    }

}
