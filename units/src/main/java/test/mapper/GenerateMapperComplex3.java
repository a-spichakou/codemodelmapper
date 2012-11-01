
package test.mapper;

import java.util.HashMap;
import github.compile.mapper.test1.InnerSourceClass1;
import github.compile.mapper.test1.InnerSourceClass2;
import github.compile.mapper.test1.InnerTargetClass1;
import github.compile.mapper.test1.SourceObject;
import github.compile.mapper.test1.TargetObject;

public class GenerateMapperComplex3 {

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
        HashMap declNewDelcare;
        declNewDelcare = innertargetclass10 .getStringMap();
        if (declNewDelcare == null) {
            declNewDelcare = new HashMap();
            innertargetclass10 .setStringMap(declNewDelcare);
        }
        if (declNewDelcare.get("2") == null) {
            declNewDelcare.put("2", new String());
        }
        declNewDelcare.put("2", decl);
    }

}
