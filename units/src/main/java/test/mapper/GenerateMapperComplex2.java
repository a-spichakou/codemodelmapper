
package test.mapper;

import java.util.ArrayList;
import java.util.Collections;
import github.compile.mapper.source.Utils;
import github.compile.mapper.test1.InnerSourceClass1;
import github.compile.mapper.test1.InnerSourceClass2;
import github.compile.mapper.test1.InnerTargetClass1;
import github.compile.mapper.test1.SourceObject;
import github.compile.mapper.test1.TargetObject;

public class GenerateMapperComplex2 {

    public SourceObject source;
    public TargetObject target;

    public void map() {
        mapTarget0();
    }

    public Object getValue0() {
        InnerSourceClass1 innersourceclass10;
        innersourceclass10 = ((InnerSourceClass1) source.getSrc1());
        if ((innersourceclass10==null)) {
            return null;
        }
        InnerSourceClass2 innersourceclass21;
        InnerSourceClass2 [] varFromGetter;
        varFromGetter = innersourceclass10 .getTgArray();
        if (varFromGetter == null) {
            return null;
        }
        innersourceclass21 = ((InnerSourceClass2) varFromGetter[ 0 ]);
        if ((innersourceclass21==null)) {
            return null;
        }
        String string2;
        string2 = ((String) innersourceclass21 .getSource());
        if ((string2==null)) {
            return null;
        }
        return string2;
    }

    public void mapTarget0() {
        InnerTargetClass1 innertargetclass10;
        innertargetclass10 = target.getTarget3();
        if (innertargetclass10 == null) {
            innertargetclass10 = new InnerTargetClass1();
            target.setTarget3(innertargetclass10);
        }
        Object value;
        String decl;
        value = getValue0();
        decl = ((String) value);
        ArrayList declNewDelcare;
        declNewDelcare = innertargetclass10 .getStringList();
        if (declNewDelcare == null) {
            declNewDelcare = new ArrayList();
            innertargetclass10 .setStringList(declNewDelcare);
        }
        ArrayList newSizeList;
        if (declNewDelcare.size()<(3)) {
            newSizeList = new ArrayList((3));
            Utils.initList(newSizeList, (3));
            innertargetclass10 .setStringList(newSizeList);
            Collections.copy(newSizeList, declNewDelcare);
        } else {
            newSizeList = declNewDelcare;
            if (newSizeList.get((2)) == null) {
                newSizeList.add((2), new String());
            }
        }
        newSizeList.set((2), decl);
    }

}
