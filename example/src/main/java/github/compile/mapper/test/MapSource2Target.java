
package github.compile.mapper.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import github.compile.example.SampleConverter;
import github.compile.example.SampleLookup;
import github.compile.example.Source;
import github.compile.example.Target;
import github.compile.example.TargetLevel1;
import github.compile.mapper.source.Utils;

public class MapSource2Target {

    public Source source;
    public Target target;
    public SampleConverter converter0;
    public SampleLookup lookup2;

    public void map() {
        mapTarget00();
        mapTarget1();
        mapTarget22();
        mapTarget3();
    }

    public List mapTargetGetParam0() {
        List params = new ArrayList();
        params.add(new String("paramValue"));
        return params;
    }

    public int mapTargetConvert0() {
        if ((converter0==null)) {
            return new Integer((0));
        }
        Object value;
        value = getValueConvert0();
        Date valueCasted;
        valueCasted = ((Date) value);
        return converter0 .convert(valueCasted, mapTargetGetParam0());
    }

    public Object getValueConvert0() {
        Date date0;
        date0 = ((Date) source.getLevel0Complex());
        if ((date0==null)) {
            return null;
        }
        return date0;
    }

    public void mapTarget00() {
        TargetLevel1 targetlevel10;
        targetlevel10 = target.getLevel1();
        if (targetlevel10 == null) {
            targetlevel10 = new TargetLevel1();
            target.setLevel1(targetlevel10);
        }
        int value;
        Integer decl;
        value = mapTargetConvert0();
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
        return "dafultValue";
    }

    public void mapTarget1() {
        String value;
        String decl;
        value = getValue1();
        decl = ((String) value);
        target.setLevel0String(decl);
    }

    public String mapTargetLookup2() {
        if ((lookup2==null)) {
            return null;
        }
        Object value;
        value = getValueLookup2();
        String valueCasted;
        valueCasted = ((String) value);
        lookup2 .lookup(valueCasted);
        return lookup2 .lookup(valueCasted);
    }

    public Object getValueLookup2() {
        String string0;
        HashMap varFromGetter;
        varFromGetter = source.getLevel0Map();
        string0 = ((String) varFromGetter.get("key"));
        if ((string0==null)) {
            return null;
        }
        return string0;
    }

    public void mapTarget22() {
        String value;
        String decl;
        value = mapTargetLookup2();
        decl = ((String) value);
        ArrayList declNewDelcare;
        declNewDelcare = target.getLevel0List();
        if (declNewDelcare == null) {
            declNewDelcare = new ArrayList();
            target.setLevel0List(declNewDelcare);
        }
        ArrayList newSizeList;
        if (declNewDelcare.size()<(16)) {
            newSizeList = new ArrayList((16));
            Utils.initList(newSizeList, (16));
            target.setLevel0List(newSizeList);
            Collections.copy(newSizeList, declNewDelcare);
        } else {
            newSizeList = declNewDelcare;
            if (newSizeList.get((15)) == null) {
                newSizeList.add((15), new String());
            }
        }
        newSizeList.set((15), decl);
    }

    public Object getValue3() {
        Integer integer0;
        integer0 = ((Integer) source.getLevel0primitive());
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
        target.setLevel0primitive(decl);
    }

}
