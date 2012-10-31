
package test.mapper;

import github.compile.mapper.source.InnerSourceClass1;
import github.compile.mapper.source.InnerSourceClass2;
import github.compile.mapper.source.InnerTargetClass1;
import github.compile.mapper.source.InnerTargetClass2;
import github.compile.mapper.source.SourceObject;
import github.compile.mapper.source.TargetObject;

public class GenerateMapperComplex1 {

    public SourceObject source;
    public TargetObject target;

    public void map() {
        map_target();
    }

    public Object getValue() {
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

    public void map_target() {
        InnerTargetClass1 innertargetclass10;
        innertargetclass10 = target.getTarget3();
        if (innertargetclass10 == null) {
            innertargetclass10 = new InnerTargetClass1();
            target.setTarget3(innertargetclass10);
        }
        InnerTargetClass2 innertargetclass21;
        innertargetclass21 = innertargetclass10 .getTg2();
        if (innertargetclass21 == null) {
            innertargetclass21 = new InnerTargetClass2();
            innertargetclass10 .setTg2(innertargetclass21);
        }
        Object value;
        String decl;
        value = getValue();
        decl = ((String) value);
        innertargetclass21 .setTg3(decl);
    }

}
