
package github.compile.mapper.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import github.compile.example.SampleConverter;
import github.compile.example.Source;
import github.compile.example.Target;
import github.compile.example.TargetLevel1;

public class MapSource2Target {

    public Source source;
    public Target target;
    public SampleConverter converter;

    public void map() {
        mapTarget00();
        mapTarget1();
        mapTarget2();
    }

    public List mapTargetGetParam() {
        List params = new ArrayList();
        params.add(new String("paramValue"));
        return params;
    }

    public int mapTargetConvert() {
        if ((converter==null)) {
            return new Integer((0));
        }
        Object value;
        value = getValue();
        Date valueCasted;
        valueCasted = ((Date) value);
        return converter.convert(valueCasted, mapTargetGetParam());
    }

    public Object getValue() {
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
        value = mapTargetConvert();
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

    public Object getValue2() {
        Integer integer0;
        integer0 = ((Integer) source.getLevel0primitive());
        if ((integer0==null)) {
            return null;
        }
        return integer0;
    }

    public void mapTarget2() {
        Object value;
        Integer decl;
        value = getValue2();
        decl = ((Integer) value);
        target.setLevel0primitive(decl);
    }

}
