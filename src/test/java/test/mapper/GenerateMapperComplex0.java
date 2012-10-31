
package test.mapper;

import github.compile.mapper.source.InnerSourceClass1;
import github.compile.mapper.source.InnerSourceClass2;
import github.compile.mapper.source.InnerTargetClass1;
import github.compile.mapper.source.SourceObject;
import github.compile.mapper.source.TargetObject;

public class GenerateMapperComplex0 {

    public SourceObject source;
    public TargetObject target;

    public void map() {
        map_target0();
    }

    public Object getValue0() {
        InnerSourceClass1 innersourceclass10;
        innersourceclass10 = source.getSrc1();
        if ((innersourceclass10==null)) {
            return null;
        }
        InnerSourceClass2 innersourceclass21;
        InnerSourceClass2 [] varFromGetter;
        varFromGetter = innersourceclass10 .getTgArray();
        if (varFromGetter == null) {
            return null;
        }
        innersourceclass21 = varFromGetter[(0)];
        if ((innersourceclass21==null)) {
            return null;
        }
        String string2;
        string2 = innersourceclass21 .getSource();
        if ((string2==null)) {
            return null;
        }
        return string2;
    }

    public void map_target0() {
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
        String[] declNewDelcare;
        declNewDelcare = innertargetclass10 .getStringArray();
        if (declNewDelcare == null) {
            declNewDelcare = new String[ 3 ] ;
            innertargetclass10 .setStringArray(declNewDelcare);
        }
        String[] newSizeArray;
        if (declNewDelcare.length<(3)) {
            newSizeArray = new String[ 3 ] ;
            innertargetclass10 .setStringArray(newSizeArray);
            System.arraycopy(declNewDelcare, (0), newSizeArray, (0), (3));
        } else {
            if (declNewDelcare[(2)] == null) {
                declNewDelcare[(2)] = new String();
            }
        }
        declNewDelcare[(2)] = decl;
    }

}
