
package test.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import github.compile.mapper.source.Utils;

public class BuildTestTreeSimple1level {

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
        SourceLevel1 sourcelevel10;
        sourcelevel10 = ((SourceLevel1) source.getLevel1());
        if ((sourcelevel10==null)) {
            return null;
        }
        Integer integer1;
        integer1 = ((Integer) sourcelevel10 .getLevel1primitive());
        if ((integer1==null)) {
            return null;
        }
        return integer1;
    }

    public void mapTarget0() {
        TargetLevel1 targetlevel10;
        targetlevel10 = target.getLevel1();
        if (targetlevel10 == null) {
            targetlevel10 = new TargetLevel1();
            target.setLevel1(targetlevel10);
        }
        Object value;
        Integer decl;
        value = getValue0();
        decl = ((Integer) value);
        targetlevel10 .setLevel1primitive(decl);
    }

    public Object getValue1() {
        SourceLevel1 sourcelevel10;
        sourcelevel10 = ((SourceLevel1) source.getLevel1());
        if ((sourcelevel10==null)) {
            return null;
        }
        String string1;
        string1 = ((String) sourcelevel10 .getLevel1String());
        if ((string1==null)) {
            return null;
        }
        return string1;
    }

    public void mapTarget1() {
        TargetLevel1 targetlevel10;
        targetlevel10 = target.getLevel1();
        if (targetlevel10 == null) {
            targetlevel10 = new TargetLevel1();
            target.setLevel1(targetlevel10);
        }
        Object value;
        String decl;
        value = getValue1();
        decl = ((String) value);
        targetlevel10 .setLevel1String(decl);
    }

    public Object getValue2() {
        SourceLevel1 sourcelevel10;
        sourcelevel10 = ((SourceLevel1) source.getLevel1());
        if ((sourcelevel10==null)) {
            return null;
        }
        Date date1;
        date1 = ((Date) sourcelevel10 .getLevel1Complex());
        if ((date1==null)) {
            return null;
        }
        return date1;
    }

    public void mapTarget2() {
        TargetLevel1 targetlevel10;
        targetlevel10 = target.getLevel1();
        if (targetlevel10 == null) {
            targetlevel10 = new TargetLevel1();
            target.setLevel1(targetlevel10);
        }
        Object value;
        Date decl;
        value = getValue2();
        decl = ((Date) value);
        targetlevel10 .setLevel1Complex(decl);
    }

    public Object getValue3() {
        SourceLevel1 sourcelevel10;
        sourcelevel10 = ((SourceLevel1) source.getLevel1());
        if ((sourcelevel10==null)) {
            return null;
        }
        Integer integer1;
        int[] varFromGetter;
        varFromGetter = sourcelevel10 .getLevel1primitiveArray();
        if (varFromGetter == null) {
            return null;
        }
        integer1 = ((Integer) varFromGetter[ 1 ]);
        if ((integer1==null)) {
            return null;
        }
        return integer1;
    }

    public void mapTarget3() {
        TargetLevel1 targetlevel10;
        targetlevel10 = target.getLevel1();
        if (targetlevel10 == null) {
            targetlevel10 = new TargetLevel1();
            target.setLevel1(targetlevel10);
        }
        Object value;
        Integer decl;
        value = getValue3();
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

    public Object getValue4() {
        SourceLevel1 sourcelevel10;
        sourcelevel10 = ((SourceLevel1) source.getLevel1());
        if ((sourcelevel10==null)) {
            return null;
        }
        String string1;
        ArrayList varFromGetter;
        varFromGetter = sourcelevel10 .getLevel1List();
        string1 = ((String) varFromGetter.get(1));
        if ((string1==null)) {
            return null;
        }
        return string1;
    }

    public void mapTarget4() {
        TargetLevel1 targetlevel10;
        targetlevel10 = target.getLevel1();
        if (targetlevel10 == null) {
            targetlevel10 = new TargetLevel1();
            target.setLevel1(targetlevel10);
        }
        Object value;
        String decl;
        value = getValue4();
        decl = ((String) value);
        ArrayList declNewDelcare;
        declNewDelcare = targetlevel10 .getLevel1List();
        if (declNewDelcare == null) {
            declNewDelcare = new ArrayList();
            targetlevel10 .setLevel1List(declNewDelcare);
        }
        ArrayList newSizeList;
        if (declNewDelcare.size()<(3)) {
            newSizeList = new ArrayList((3));
            Utils.initList(newSizeList, (3));
            targetlevel10 .setLevel1List(newSizeList);
            Collections.copy(newSizeList, declNewDelcare);
        } else {
            newSizeList = declNewDelcare;
            if (newSizeList.get((2)) == null) {
                newSizeList.add((2), new String());
            }
        }
        newSizeList.add((2), decl);
    }

    public Object getValue5() {
        SourceLevel1 sourcelevel10;
        sourcelevel10 = ((SourceLevel1) source.getLevel1());
        if ((sourcelevel10==null)) {
            return null;
        }
        String string1;
        HashMap varFromGetter;
        varFromGetter = sourcelevel10 .getLevel1Map();
        string1 = ((String) varFromGetter.get("key1"));
        if ((string1==null)) {
            return null;
        }
        return string1;
    }

    public void mapTarget5() {
        TargetLevel1 targetlevel10;
        targetlevel10 = target.getLevel1();
        if (targetlevel10 == null) {
            targetlevel10 = new TargetLevel1();
            target.setLevel1(targetlevel10);
        }
        Object value;
        String decl;
        value = getValue5();
        decl = ((String) value);
        HashMap declNewDelcare;
        declNewDelcare = targetlevel10 .getLevel1Map();
        if (declNewDelcare == null) {
            declNewDelcare = new HashMap();
            targetlevel10 .setLevel1Map(declNewDelcare);
        }
        if (declNewDelcare.get("key2") == null) {
            declNewDelcare.put("key2", new String());
        }
        declNewDelcare.put("key2", decl);
    }

}
